package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Checkout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private SystemUser buyer;
	private BigDecimal value;
	private String jsonCart;
	
	//contrutor para ser usado pelos frameworks
	protected Checkout(){
		
	}
	
	public Checkout(SystemUser user, ShoppingCart cart){
		this.buyer = user;
		this.value = cart.getTotal();
		this.jsonCart = cart.toJson();
	}

}
