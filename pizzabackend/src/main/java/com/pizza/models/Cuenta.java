package com.pizza.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Cuenta {
	@Id
	private String usuario;
	private String password;

	enum Role {
		USER,
		ADMIN
	};
	
	private Role role;


	


	public Cuenta(String usuario, String password, Role role) {
		this.usuario = usuario;
		this.password = password;
		this.role = role;
	}
	
	public Cuenta(String usuario, String password) {
		this(usuario, password, Role.USER);
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
