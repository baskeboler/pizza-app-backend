package com.pizza.controllers.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pizza.models.Cliente;

public class ClientesResources extends ResourceSupport{
	private Map<String, List<Cliente>> embedded; 
	
	@JsonCreator
	public ClientesResources(@JsonProperty("_embedded")List<Cliente> clientes) {
		this.embedded = new HashMap<>();
		embedded.put("clientes", clientes);
		
	}
	
	public Map<String, List<Cliente>> get_embedded() {
		return embedded;
	}
}
