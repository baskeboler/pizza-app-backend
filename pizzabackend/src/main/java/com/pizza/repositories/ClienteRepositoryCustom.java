package com.pizza.repositories;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pizza.models.Cliente;

public interface ClienteRepositoryCustom {
	public List<Cliente> suggest(@Param("q") String term);
}
