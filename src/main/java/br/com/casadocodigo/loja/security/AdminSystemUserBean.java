package br.com.casadocodigo.loja.security;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.casadocodigo.loja.models.SystemRole;
import br.com.casadocodigo.loja.models.SystemUser;

@Model
public class AdminSystemUserBean {
	
	private SystemUser systemUser = new SystemUser();
	
	@PersistenceContext
	private EntityManager entityManager;
	private String rawPassword;
	
	@Transactional
	public void save(){
		systemUser.setPassword(new BCryptPasswordEncoder().encode(rawPassword));
		systemUser.add(new SystemRole(AllowedRoles.ROLE_ADMIN.name()));
		entityManager.persist(systemUser);
	}
	
	public SystemUser getSystemUser() {
		return systemUser;
	}
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
	public String getRawPassword() {
		return rawPassword;
	}
	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}
	
	

}
