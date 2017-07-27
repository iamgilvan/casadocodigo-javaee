package br.com.casadocodigo.loja.models;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Cacheable
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String name;
	
	public Author(){
		
	}
	public Author(Integer id){
		this.id = id;
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
