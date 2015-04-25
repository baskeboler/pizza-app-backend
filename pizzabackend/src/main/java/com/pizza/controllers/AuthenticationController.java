package com.pizza.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.controllers.dto.AuthenticationRequest;
import com.pizza.controllers.dto.AuthenticationToken;

@RestController
public class AuthenticationController {
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;

	@Autowired
	public AuthenticationController(AuthenticationManager am,
			UserDetailsService uds) {
		this.authenticationManager = am;
		this.userDetailsService = uds;
	}

	@RequestMapping(value="/authenticate", method= {RequestMethod.POST})
	public AuthenticationToken authorize(
			@RequestBody AuthenticationRequest authenticationRequest,
			HttpServletRequest request) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(),
				authenticationRequest.getPassword());
		Authentication authentication = authenticationManager
				.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		HttpSession session = request.getSession(true);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		UserDetails details = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final Map<String, Boolean> roles = new HashMap<>();
		for (GrantedAuthority authority: details.getAuthorities()) {
			roles.put(authority.toString(), Boolean.TRUE);
		}
		AuthenticationToken ret = new AuthenticationToken();
		ret.setRoles(roles);
		ret.setToken(session.getId());
		ret.setUsername(details.getUsername());
		return ret;
	}

}
