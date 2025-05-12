package com.spring.boot.security.proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // spring make this for config
@EnableWebSecurity // for change the flow of the authentication flow need this
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	// @Bean If you define a SecurityFilterChain bean → Spring disables the default
	// filter chain
	// and uses your custom chain instead.
	// That’s why declaring it as a @Bean is mandatory for custom security setups.
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf().disable() // Disable CSRF protection
				.authorizeHttpRequests(
						request -> request.requestMatchers("loginuser").permitAll().anyRequest().authenticated() // Every
																													// request
																													// must
																													// be
				// authenticated
				).formLogin(Customizer.withDefaults()) // Enable default form login
				.httpBasic(Customizer.withDefaults()) // Enable HTTP Basic Authentication
				.build(); // Build the SecurityFilterChain

		/*
		 * Meaning:
		 * 
		 * CSRF disabled: You're not protecting against CSRF attacks. (Typically fine
		 * for APIs, but dangerous for web apps unless handled otherwise.)
		 * 
		 * Authorization: Any HTTP request needs to be authenticated.
		 * 
		 * Authentication methods:
		 * 
		 * Form login (browser will show a login page)
		 * 
		 * HTTP Basic Auth (good for APIs and tools like Postman)
		 * 
		 * Customizer.withDefaults() just uses Spring Security's default settings for
		 * form login and basic auth.
		 */

		// ---------------------------------------------------------------------------------------------------------------------------------
		// lets implement the log in with database integrated

	}

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);

		return daoAuthenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
