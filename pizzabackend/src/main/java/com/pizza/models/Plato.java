package com.pizza.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Plato extends Producto{

	
	public Plato(String nombre, int precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}
	
	public Plato(String id, String nombre, int precio, String desc) {
		super(id, nombre, precio, desc);
	}
	
	public Plato() {
		super("", 0);
	}

}
