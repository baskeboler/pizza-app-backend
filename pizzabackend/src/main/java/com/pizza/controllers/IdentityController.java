package com.pizza.controllers;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityController {

	@RequestMapping("/identity")
	public @ResponseBody Map<String, Object> identity(Principal identity) {
		
		Map<String, Object> map = new LinkedHashMap<>();
		if (identity == null)
			return map;
		map.put("name", identity.getName());
		map.put("roles", AuthorityUtils
				.authorityListToSet(((Authentication) identity)
						.getAuthorities()));
		return map;
	}
	
}
