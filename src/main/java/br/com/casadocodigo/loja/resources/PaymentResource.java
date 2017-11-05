package br.com.casadocodigo.loja.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.amazonaws.services.simpleemail.model.Destination;

import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.models.BroadcastCheckout;
import br.com.casadocodigo.loja.models.Checkout;
import br.com.casadocodigo.loja.services.PaymentGateway;

@Path("payment")
public class PaymentResource {
	
	@Context
	private ServletContext ctx;

	@Inject
	private CheckoutDAO checkoutDAO; 
	
	@Inject
	private PaymentGateway paymentGateway;
	
	@Inject
 	private JMSContext jmsContext;
 	@Resource(name = "java:/jms/topics/checkoutsTopic")

 	private Destination checkoutsTopic;
 	@Resource(name = "java:comp/DefaultManagedExecutorService")
	private ManagedExecutorService managedExecutorService;
	
	@GET
	public void pay(@Suspended final AsyncResponse ar,@QueryParam("uuid") String uuid){
		String contextPath = ctx.getContextPath();
		Checkout checkout = checkoutDAO.findByUuid(uuid);
		JMSProducer producer = jmsContext.createProducer();
		
		managedExecutorService.submit(() -> {
			BigDecimal total = checkout.getValue();
			
			try {	
				
				paymentGateway.pay(total);
				
				producer.send((javax.jms.Destination) checkoutsTopic, checkout.getUuid());
				
				URI redirectURI = UriBuilder.fromUri(contextPath+"/site/index.xhtml").queryParam("msg", "Compra realizada com sucesso").build();
				Response response = Response.seeOther(redirectURI).build();
				
				ar.resume(response);
			} catch (Exception e) {
				// TODO: handle exception
				ar.resume(new WebApplicationException(e));
			}
		});
	}
}
