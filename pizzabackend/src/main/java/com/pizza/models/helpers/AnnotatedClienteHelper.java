package com.pizza.models.helpers;

import unquietcode.tools.flapi.annotations.AtMost;
import unquietcode.tools.flapi.annotations.Block;
import unquietcode.tools.flapi.annotations.Exactly;
import unquietcode.tools.flapi.annotations.Last;

import com.pizza.models.Cliente;

@Block(name="Cliente")
public interface AnnotatedClienteHelper {
	@Exactly(1) void nombre(String nombre);
	@Exactly(1) void direccion(String direccion);
	@AtMost(1) void telefono(String telefono);
	@AtMost(1) void email(String email);
	@AtMost(1) void id(String id);
	@Last Cliente build();
}
