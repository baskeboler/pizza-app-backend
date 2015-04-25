package com.pizza.controllers.dto;

import java.util.Map;

import lombok.Data;

@Data
public class AuthenticationToken {
	private String username;
	private Map<String, Boolean> roles;
	private String token;
}
