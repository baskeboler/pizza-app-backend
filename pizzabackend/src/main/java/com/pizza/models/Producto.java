package com.pizza.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor(onConstructor=@__(@PersistenceConstructor))
@Document
public class Producto {
	
	private final String id;
	private final String nombre;
	private final int precio;
	private final String descripcion;
	
	public Producto() {
		this(null, "", 0, "");
	}
	
	public Producto(String nombre, int precio) {
		this(null, nombre, precio, "");
	}
}
