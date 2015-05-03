package com.pizza.models;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document
@Data
public class Cliente {
	@Id 
	private String id;
	
	@TextIndexed
	private String nombre;
	@TextIndexed
	private String email;
	@TextIndexed
	private String direccion;
	@TextIndexed
	private String telefono;
	
	
}
