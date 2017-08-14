package br.com.casadocodigo.loja.security;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class CurrentUser {
	
	@Inject
	private HttpServletRequest request;
	
	public boolean hasRole(String name){
		return request.isUserInRole(name);
	}
	
	public String getLogin(){
		return request.getUserPrincipal().getName();
	}

}
