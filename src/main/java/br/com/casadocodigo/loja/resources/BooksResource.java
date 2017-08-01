package br.com.casadocodigo.loja.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

@Path("books")
public class BooksResource {
	
	@Inject
	private BookDAO bookDAO;
	
	//Pode ser acessado via requisição GET
	@GET
	//Método suporta devlver resposta no formato JSON
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	//Endereço base
	//@Path("json")
	@Wrapped(element="books")
	public List<Book> lastBooksJson(){
		return bookDAO.lastReleases();
	}

}
