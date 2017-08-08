package br.com.casadocodigo.loja.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

@Path("books")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BooksResource {
	
	@Inject
	private BookDAO bookDAO;
	
	//Pode ser acessado via requisição GET
	@GET
	@Wrapped(element="books")
	public List<Book> lastBooks(){
		return bookDAO.lastReleases();
	}
	
	/*@Path("{id}")
	@GET
	public Response find(@PathParam("id") Integer id){
		Book book = bookDAO.findById(id);
		Link buyerLink = Link.fromMethod(BooksResource.class, "buyers").rel("buyers").build(id);
		Link otherOrdersLink = Link.fromMethod(BooksResource.class, "otherOrders").rel("orders").build(id);
		return Response.ok(book).links(buyerLink,otherOrdersLink).build();
	}*/
	
	@Path("{id}/buyers")
	@GET
	public Response buyers(@PathParam("id") Integer bookId){
		return Response.ok("achou").build();
	}
	
	@Path("{id}/buyers/other/orders")
	@GET
	public Response otherOrders(@PathParam("id") Integer bookId){
		return Response.ok("outros compradores").build();
	}

}
