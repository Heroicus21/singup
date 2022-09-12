package com.code.app.singup.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain appSecurity(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests().antMatchers(HttpMethod.POST,"/auth/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		User admin = (User) User.withUsername("admin")
				.password(encoder.encode("password"))
				.roles("USER").build();
		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
