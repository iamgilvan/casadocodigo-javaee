package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

public class ShoppingItem {
	
	private Book book;
	//Apenas para ficar mais fácil de gerar
	//o hashcode e equals
	
	private Integer bookId;
	
	public ShoppingItem(Book book){
		this.book = book;
		this.bookId = book.getId(); 
	}
	
	public Book getBook(){
		return book;
	}
	
	public BigDecimal getPrice(){
		return book.getPrice();
	}
	
	public Integer getBookId(){
		return bookId;
	}
	
	public BigDecimal getTotal(Integer quantity){
		return getPrice().multiply(new BigDecimal(quantity));
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null ) ? 0 : bookId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		
		if(obj == null) return false;
		
		if(getClass() != obj.getClass()) return false;
		
		ShoppingItem other = (ShoppingItem) obj;
		
		if(bookId == null){
			if (other.bookId != null) return true;
		}else if (!bookId.equals(other.bookId)) {
			return false;
		}
		
		return true;
	}

}
