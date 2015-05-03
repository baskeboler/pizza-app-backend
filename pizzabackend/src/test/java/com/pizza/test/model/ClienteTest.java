package com.pizza.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pizza.Application;
import com.pizza.models.Cliente;
import com.pizza.models.builders.Cliente.ClienteFactory;

@SpringApplicationConfiguration(classes = Application.class, inheritInitializers = true, inheritLocations = true)
@RunWith(value = SpringJUnit4ClassRunner.class)
public class ClienteTest {
	@Autowired
	private ApplicationContext applicationContext;
	
	private Cliente cliente;
	private static String DIRECCION = "dir";
	private static String DIRECCION2 = "dir2";
	private static String ID = "id";
	private static String ID2 = "id2";
	private static String EMAIL= "email";
	private static String EMAIL2= "email2";
	private static String TELEFONO = "telefono";
	private static String TELEFONO2 = "telefono2";
	private static String NOMBRE = "nommbre gege";
	private static String NOMBRE2 = "nommbre gege2";
	@Before
	public void setUp() throws Exception {
		ClienteFactory clienteFactory = (ClienteFactory) applicationContext.getBean("clienteFactory");
		this.cliente = clienteFactory.builder().direccion(DIRECCION).email(EMAIL)
				.id(ID).nombre(NOMBRE).telefono(TELEFONO).build();
	}

	@Test
	public void testGetId() {
		assertEquals(cliente.getId(), ID);

	}

	@Test
	public void testGetNombre() {
		assertEquals(cliente.getNombre(), NOMBRE);
	}

	@Test
	public void testGetEmail() {
		String mail = cliente.getEmail();
		assertEquals(EMAIL, mail);
	}

	@Test
	public void testGetDireccion() {
		assertEquals(DIRECCION, cliente.getDireccion());
	}

	@Test
	public void testGetTelefono() {
		assertEquals(cliente.getTelefono(), TELEFONO);
	}

	@Test
	public void testSetId() {
		cliente.setId(ID2);
		assertEquals(cliente.getId(), ID2);
	}

	@Test
	public void testSetNombre() {
		cliente.setNombre(NOMBRE2);
		assertEquals(cliente.getNombre(), NOMBRE2);
	}

	@Test
	public void testSetEmail() {
		cliente.setEmail(EMAIL2);
		assertEquals(cliente.getEmail(), EMAIL2);
	}

	@Test
	public void testSetDireccion() {
		cliente.setDireccion(DIRECCION2);
		assertEquals(cliente.getDireccion(), DIRECCION2);
	}

	@Test
	public void testSetTelefono() {
		cliente.setTelefono(TELEFONO2);
		assertEquals(cliente.getTelefono(), TELEFONO2);
	}

}
