package com.pizza.models;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Cliente {
	@Id 
	private String id;
	
	private String nombre;
	
	private String email;
	private String direccion;
	private String telefono;
	
}
