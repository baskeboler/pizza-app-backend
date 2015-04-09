package com.pizza.models;

import java.util.List;

public class Menu extends Producto {
	public Menu(String nombre, int precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}
	private List<Plato> platos;
	private List<Bebida> bebidas;
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	public List<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
}
