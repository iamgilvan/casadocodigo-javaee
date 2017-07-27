package br.com.casadocodigo.loja.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
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

import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.services.PaymentGateway;

@Path("payment")
public class PaymentResource {
	
	private static ExecutorService executor = Executors.newFixedThreadPool(50);
	
	@Context
	private ServletContext ctx;

	@Inject
	private ShoppingCart cart;
	
	@Inject
	private PaymentGateway paymentGateway;
	
	@GET
	public void pay(@Suspended final AsyncResponse ar,@QueryParam("uuid") String uuid){
		String contextPath = ctx.getContextPath();	
		executor.submit(() -> {
			BigDecimal total = cart.getTotal();
			
			try {	
				
				paymentGateway.pay(total);
				
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
