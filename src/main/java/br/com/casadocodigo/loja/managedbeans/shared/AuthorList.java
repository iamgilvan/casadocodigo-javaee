package br.com.casadocodigo.loja.managedbeans.shared;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.AuthorDAO;
import br.com.casadocodigo.loja.models.Author;

@Model
public class AuthorList {
	
	@Inject
	private AuthorDAO authorDAO;
	private List<Author> authors = new ArrayList<Author>();
	
	public List<Author> getAuthors(){
		return authors;
	}
	
	//Carregar autores depois do @Inject
	@PostConstruct
	private void loadObjects() {
		this.authors = authorDAO.list();
	}

}
