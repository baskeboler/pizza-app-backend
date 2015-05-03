package com.pizza.test.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unquietcode.tools.flapi.Descriptor;
import unquietcode.tools.flapi.DescriptorMaker;
import unquietcode.tools.flapi.Flapi;

import com.pizza.Application;
import com.pizza.models.Cliente;
import com.pizza.models.builders.Cliente.ClienteFactory;
import com.pizza.models.helpers.AnnotatedClienteHelper;
import com.pizza.repositories.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ClienteRepoTest implements DescriptorMaker {

	@Autowired
	private ClienteRepository repo;
	@Autowired
	private ClienteFactory clienteFactory;

	@Before
	public void setUp() {
		repo.deleteAll();

		Cliente c1 = clienteFactory.builder().direccion("dir 1")
				.email("asdas@sdsad").telefono("6546544").nombre("victor").build();
		c1 = repo.save(c1);
		
		c1 = clienteFactory.builder().direccion("dir 2")
				.email("asd22@sdsad").telefono("6546544").nombre("martin").build();
		c1 = repo.save(c1); 
	}

	@Test
	public void testFind() {

		List<Cliente> clientes = repo.findAll();
		Assert.assertNotNull(clientes);
	}

	public void testSave() {
		Cliente cliente = new Cliente();
		// cliente.set

	}

	@Override
	public Descriptor descriptor() {
		// TODO Auto-generated method stub
		return Flapi.create(AnnotatedClienteHelper.class)
				.setPackage("com.pizza.model.builder")
				.setStartingMethodName("builder").build();
	}
}
