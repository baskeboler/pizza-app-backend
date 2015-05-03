package com.pizza.config;

import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.pizza.models.Cliente;
import com.pizza.models.Pedido;
import com.pizza.models.Producto;
import com.pizza.repositories.projections.ClienteProjection;

@Configuration
@Import(SpringBootRepositoryRestMvcConfiguration.class)
public class RepositoryRestConfig extends
		SpringBootRepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.setBaseUri("/api");
		config.setReturnBodyOnCreate(true);
		config.exposeIdsFor(Cliente.class, Pedido.class, Producto.class);
		config.projectionConfiguration().addProjection(ClienteProjection.class);
		super.configureRepositoryRestConfiguration(config);
	}
}
