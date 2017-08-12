package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class SystemRole implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	
	@Deprecated // apenas para o frameworks
	public SystemRole(){
		
	}
	
	public SystemRole(String name){
		this.name = name;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		SystemRole other = (SystemRole) obj;
		if (name == null){
			if(other.name != null) return false;
		} else if(!name.equals(other.name)) return false;
		
		return true;
	}

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	

}
