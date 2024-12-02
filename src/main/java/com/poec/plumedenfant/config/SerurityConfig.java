package com.poec.plumedenfant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Configuration// Recommandé par Spring
@Component
@EnableMethodSecurity
@AllArgsConstructor
public class SerurityConfig {
	
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// car methode csrf depracated
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((auth) -> auth
				.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults());
		
		http.exceptionHandling( exception -> exception
				.authenticationEntryPoint(authenticationEntryPoint));
		
		//http.addFilterBefore(, null)
		
		
		return http.build();
	}
	
	
}
