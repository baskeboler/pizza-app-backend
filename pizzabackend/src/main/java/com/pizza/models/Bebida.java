package com.pizza.models;

public class Bebida extends Producto{

	public Bebida(String nombre, int precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}
	
	public Bebida(String id, String nombre, int precio, String desc) {
		super(id, nombre, precio, desc);
	}
	
	public Bebida() {
		super("", 0);
	}
}
