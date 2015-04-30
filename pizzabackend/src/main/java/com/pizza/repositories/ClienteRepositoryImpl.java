package com.pizza.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.pizza.models.Cliente;


public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

	@Autowired
	ClienteRepository repo;

	@Override
	public List<Cliente> suggest(@Param("q")String term) {
		List<Cliente> res = Collections.synchronizedList(new ArrayList<>());
		List<Cliente> todos = repo.findAll();
		String query = term.toLowerCase();
		Stream<Cliente> stream = todos.stream();
		Predicate<Cliente> pred1 = c -> c.getNombre() != null, pred2 = c -> c
				.getDireccion() != null, pred3 = c -> c.getEmail() != null, pred4 = c -> c
				.getTelefono() != null;
		pred1 = pred1.and(c -> c.getNombre().toLowerCase().contains(query));
		pred2 = pred2.and(c -> c.getDireccion().toLowerCase().contains(query));
		pred3 = pred3.and(c -> c.getEmail().toLowerCase().contains(query));
		pred4 = pred4.and(c -> c.getTelefono().toLowerCase().contains(query));
		stream.filter(pred1.or(pred2).or(pred3).or(pred4)).limit(10)
				.forEach(c -> res.add(c));
		return res;
	}

}
