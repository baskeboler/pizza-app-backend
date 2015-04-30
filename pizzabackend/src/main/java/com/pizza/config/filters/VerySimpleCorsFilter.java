package com.pizza.config.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class VerySimpleCorsFilter implements Filter {

	private static Logger LOGGER = Logger.getLogger(VerySimpleCorsFilter.class);


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		String origin = ((HttpServletRequest) req).getHeader("ORIGIN");
		response.addHeader("Access-Control-Allow-Origin", origin);
		response.addHeader("Access-Control-Allow-Methods",
				"GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"x-auth-token, accept, accept-encoding, "
				+ "accept-language, connection, dnt, host, "
				+ "origin, referer, user-agent, content-type, "
				+ "x-requested-with");
		response.addHeader("Access-Control-Expose-Headers", "x-auth-token, location");

		if (!((HttpServletRequest) req).getMethod().equals("OPTIONS")) {
			chain.doFilter(req, res);
		}
		LOGGER.debug("running filter");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
