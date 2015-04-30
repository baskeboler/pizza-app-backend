package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.controllers.resources.ClientesResources;
import com.pizza.models.Cliente;
import com.pizza.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	
	@Autowired
	ClienteRepository repo;
	
	@RequestMapping("/search/suggest")
	@ResponseBody
	public HttpEntity<ClientesResources> suggest(@RequestParam("q")String q) {
		List<Cliente> res = repo.suggest(q);
		ClientesResources resource = new ClientesResources(res);
		resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ClienteController.class).suggest(q)).withSelfRel());
		return new ResponseEntity<ClientesResources>(resource, HttpStatus.OK);
	}
}
