package com.pizza.models.helpers;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import unquietcode.tools.flapi.runtime.Supplier;

import com.pizza.models.Cliente;
import com.pizza.models.builders.Cliente.ClienteBuilder;
import com.pizza.models.builders.Cliente.ClienteFactory;
import com.pizza.models.builders.Cliente.ClienteGenerator;

@Component
public class ClienteHelperImpl implements AnnotatedClienteHelper, ClienteBuilder<Cliente>{
	private final Cliente cliente; 
	
	@Bean
	public static ClienteFactory clienteFactory() {
		return ClienteGenerator.factory(new Supplier<AnnotatedClienteHelper>() {

			@Override
			public AnnotatedClienteHelper get() {
				// TODO Auto-generated method stub
				return new ClienteHelperImpl();
			}
			
		});
	}
	
	public ClienteHelperImpl() {
		cliente= new Cliente();
	}
	
	@Override
	public void nombre(String nombre) {
		// TODO Auto-generated method stub
		cliente.setNombre(nombre);
	}

	@Override
	public void direccion(String direccion) {
		// TODO Auto-generated method stub
		cliente.setDireccion(direccion);
	}

	@Override
	public void telefono(String telefono) {
		// TODO Auto-generated method stub
		cliente.setTelefono(telefono);
	}

	@Override
	public void email(String email) {
		// TODO Auto-generated method stub
		cliente.setEmail(email);
		
	}

	@Override
	public void id(String id) {
		// TODO Auto-generated method stub
		cliente.setId(id);
	}

	@Override
	public Cliente build() {
		// TODO Auto-generated method stub
		return cliente;
	}

}
