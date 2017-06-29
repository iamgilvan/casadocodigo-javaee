package br.com.casadocodigo.loja.managedbeans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

@Model
public class AdminBooksBean {
	
	private Book product = new Book();
	@Inject
	private BookDAO productDAO;

	@Transactional
	public void save(){
		productDAO.save(product);
	}
	
	public Book getProduct() {
		return product;
	}
	
}
