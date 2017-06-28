package br.com.casadocodigo.loja.managedbeans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

@Model
public class AdminBooksBean {
	
	private Book product = new Book();
	
	@Inject
	private BookDAO bookDAO;
	
	public void save(){
		bookDAO.save(product);
	}
	
	public Book getProduct() {
		return product;
	}
}
