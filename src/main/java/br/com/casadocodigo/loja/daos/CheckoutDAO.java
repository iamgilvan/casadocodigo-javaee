package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Checkout;

public class CheckoutDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Checkout checkout){
		entityManager.persist(checkout);
	}

}
