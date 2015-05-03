package com.pizza.controllers;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityController {

	@RequestMapping(value = "/api/identity", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> identity(Principal identity, HttpServletRequest request) {
		
		Map<String, Object> map = new LinkedHashMap<>();
		if (identity == null)
			return map;
		map.put("name", identity.getName());
		map.put("roles", AuthorityUtils
				.authorityListToSet(((Authentication) identity)
						.getAuthorities()));
		HttpSession session = request.getSession();
		if (session != null) {
			map.put("token", session.getId());
		}
		return map;
	}
	
}
