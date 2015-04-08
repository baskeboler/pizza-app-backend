package com.pizza.models;

import org.springframework.data.annotation.Id;

public class Producto {
	
	@Id
	private String id;
	private String nombre;
	private int precio;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
