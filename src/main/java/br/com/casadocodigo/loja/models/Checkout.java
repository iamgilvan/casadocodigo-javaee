package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Checkout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private SystemUser buyer;
	private BigDecimal value;
	private String jsonCart;
	private String uuid;
	
	//contrutor para ser usado pelos frameworks
	protected Checkout(){
		
	}
	
	public Checkout(SystemUser user, ShoppingCart cart){
		this.buyer = user;
		this.value = cart.getTotal();
		this.jsonCart = cart.toJson();
	}
	
	
	
	public SystemUser getBuyer() {
		return buyer;
	}
	
	public String getJsonCart() {
		return jsonCart;
	}

	public BigDecimal getValue() {
		return value;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@PrePersist
	private void prePersist(){
		this.uuid = UUID.randomUUID().toString();
	}

}
