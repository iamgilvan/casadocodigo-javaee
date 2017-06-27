package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

public class Book {
	
	Integer id;
	String title;
	String description;
	int numberOfPages;
	BigDecimal price;
	
	private Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}
	private String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	private int getNumberOfPages() {
		return numberOfPages;
	}
	private void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	private BigDecimal getPrice() {
		return price;
	}
	private void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", description=" + description + "]";
	}
	
	

}
