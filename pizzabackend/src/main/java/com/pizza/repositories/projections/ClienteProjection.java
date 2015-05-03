package com.pizza.repositories.projections;

import lombok.Data;

import org.springframework.data.rest.core.config.Projection;

import com.pizza.models.Cliente;

@Projection(types= {Cliente.class})
@Data
public class ClienteProjection {
	private String nombre;
	private String telefono;
	private String email;
	private String direccion;
}
