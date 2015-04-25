package com.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.models.EstadoPedido;
import com.pizza.models.Pedido;
import com.pizza.repositories.PedidosRepository;

@RestController
@RequestMapping("/api/pedidos/{idPedido}/estado")
public class PedidosController {

	@Autowired
	private PedidosRepository repo;
	
	@RequestMapping(method=RequestMethod.GET)
	public Pedido siguienteEstado(@PathVariable String idPedido) {
		// TODO Auto-generated method stub
		Pedido p = repo.findOne(idPedido);
		p.setEstado(new EstadoPedido(p.getEstado().getId().next()));
		p = repo.save(p);
		return p;
	}
}
