package com.pizza.config;

import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.pizza.models.Cliente;
import com.pizza.models.Pedido;

@Configuration
@Import(SpringBootRepositoryRestMvcConfiguration.class)
public class RepositoryRestConfig extends
		SpringBootRepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.setBaseUri("/api");
		config.setReturnBodyOnCreate(true);
		config.exposeIdsFor(Cliente.class, Pedido.class);
		super.configureRepositoryRestConfiguration(config);
	}
}
