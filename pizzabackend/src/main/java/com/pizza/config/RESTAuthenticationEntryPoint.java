package com.pizza.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException e) throws IOException, ServletException {
		// TODO Auto-generated method stub
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
	}

}
