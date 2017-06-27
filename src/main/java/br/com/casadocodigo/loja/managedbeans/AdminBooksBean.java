package br.com.casadocodigo.loja.managedbeans;

import javax.enterprise.inject.Model;

@Model
public class AdminBooksBean {
	
	public void save(){
		System.out.println("Precisamos salvar livros!!");
	}

}
