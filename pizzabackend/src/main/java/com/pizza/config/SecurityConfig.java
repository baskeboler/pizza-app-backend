package com.pizza.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.session.ExpiringSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.session.web.http.SessionRepositoryFilter;

@EnableWebMvcSecurity
@EnableWebSecurity(debug = true)
@Configuration
@Order
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SessionRepository<? extends ExpiringSession> sessionRepository;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user")
				.roles("USER").and().withUser("admin").password("admin")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		SessionRepositoryFilter<ExpiringSession> sessionRepositoryFilter = new SessionRepositoryFilter(
				sessionRepository);
		sessionRepositoryFilter
				.setHttpSessionStrategy(new HeaderHttpSessionStrategy());
		http.addFilterBefore(sessionRepositoryFilter,
				ChannelProcessingFilter.class).csrf().disable();

		http.sessionManagement().sessionCreationPolicy(
				SessionCreationPolicy.IF_REQUIRED);
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasRole("USER");

		/*
		 * http .authorizeRequests() .anyRequest().authenticated() .and()
		 * .requestCache() .requestCache(new NullRequestCache()) .and()
		 * .httpBasic();
		 */
	}


	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public SessionRepository<? extends ExpiringSession> sessionRepo() {
		MapSessionRepository repo = new MapSessionRepository();
		repo.setDefaultMaxInactiveInterval(60*30);
		return repo;
	}

	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy(); // <4>
	}

}
