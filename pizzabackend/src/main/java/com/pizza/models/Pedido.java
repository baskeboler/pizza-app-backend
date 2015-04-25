package com.pizza.models;

import java.util.Date;
import java.util.List;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
@Data
public class Pedido {
	@Id
	private String id;
	private Cliente cliente;
	
	
	private List<ItemPedido> items;
	private String direccion;
	private EstadoPedido estado;
	
	@DateTimeFormat(style="S-")
	private Date fecha;
	

	public Pedido() {
		estado = new EstadoPedido();
		fecha = new Date();
	}
	
		
}
