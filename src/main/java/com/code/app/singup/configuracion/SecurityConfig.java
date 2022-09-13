package com.code.app.singup.configuracion;

import com.code.app.singup.seguridad.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

	@Autowired
	private CustomUserDetailService userDetailService;


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
/**
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		User admin = (User) User.withUsername("admin")
				.password(encoder.encode("admin"))
				.roles("ADMIN").build();
		return new InMemoryUserDetailsManager(admin);
	}
**/
	@Bean
	public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder bCryptPasswordEncoder, CustomUserDetailService userDetailService)
			throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailService)
				.passwordEncoder(bCryptPasswordEncoder)
				.and()
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
