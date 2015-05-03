package com.pizza.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Producto;

@RepositoryRestResource(collectionResourceRel="productos", path="productos")
public interface ProductoRepository extends MongoRepository<Producto, String>{

}
