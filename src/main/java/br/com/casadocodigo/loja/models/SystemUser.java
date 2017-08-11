package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.casadocodigo.loja.models.validation.groups.BuyerGroup;
import br.com.casadocodigo.loja.security.AllowedRoles;

@Entity
public class SystemUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank(groups=BuyerGroup.class)
	private String firstName;

	@NotBlank(groups=BuyerGroup.class)
	private String lastName;

	@NotBlank(groups=BuyerGroup.class)
	@Column(unique = true)
	private String socialId;

	@NotBlank(groups=BuyerGroup.class)
	private String address;

	@NotBlank(groups=BuyerGroup.class)
	private String city;

	@NotBlank(groups=BuyerGroup.class)
	private String state;

	@NotBlank(groups=BuyerGroup.class)
	private String postalCode;

	@NotBlank(groups=BuyerGroup.class)
	private String phone;

	@NotBlank(groups=BuyerGroup.class)
	private String country;
	private String password;
	
	@Column(unique=true)
	private String uuid;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<SystemRole> roles = new ArrayList<>();
	
	public void add(SystemRole role){
		this.roles.add(role);
	}
	
	@PrePersist
	public void prePersist(){
		this.uuid = UUID.randomUUID().toString();
		if(StringUtils.isBlank(password)){
			this.password = new BCryptPasswordEncoder().encode("123456");
			this.roles.add(new SystemRole(AllowedRoles.ROLE_COMPRADOR.name()));
		}
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSocialId() {
		return socialId;
	}
	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}

	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}




	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
