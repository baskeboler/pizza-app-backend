package com.pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.pizza.models.Producto;

@RepositoryRestResource(collectionResourceRel="productos", path="productos")
public interface ProductoRepository extends CrudRepository<Producto, String>{

}
