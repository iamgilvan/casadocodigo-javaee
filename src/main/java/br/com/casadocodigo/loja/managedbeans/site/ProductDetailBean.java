package br.com.casadocodigo.loja.managedbeans.site;

import javax.enterprise.inject.Model;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

@Model
public class ProductDetailBean {
	
	private BookDAO bookDAO;
	private Book book;
	private Integer id;
	
	public void loadBook(){
		this.book = bookDAO.findById(id);
	}
	
	public Book getBook(){
		return book;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
