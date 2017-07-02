package br.com.casadocodigo.loja.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

//Só é necessária uma instância do Faces...
@ApplicationScoped
public class FacesContextProducer {
	
	//utilizado para um processo não padrão e quando um objeto não é gerenciado pela cdi
	@Produces
	//deve ser chamado uma vez a cada request
	@RequestScoped
	public FacesContext get(){
		return FacesContext.getCurrentInstance();
	}

}
