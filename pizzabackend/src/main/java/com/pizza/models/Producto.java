package com.pizza.models;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Producto {
	
	private String id;
	private String nombre;
	private int precio;
	private String descripcion;
	
}
