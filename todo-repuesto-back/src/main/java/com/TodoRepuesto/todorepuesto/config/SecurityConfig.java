package com.TodoRepuesto.todorepuesto.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration

public class SecurityConfig {
    @Bean
     public UserDetailsService userDetailsService() throws Exception {
 		// ensure the passwords are encoded properly
  		User.UserBuilder users = User.withDefaultPasswordEncoder();
 		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 		manager.createUser(users.username("user").password("password").roles("USER").build());
 		manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
 		return manager;
     }
     @Bean
     @Order(1)
     public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                    			.securityMatcher("/api/**")
                    		.authorizeHttpRequests(authorize -> authorize
                    			.anyRequest().hasRole("ADMIN")
                    		)
                    		.httpBasic(withDefaults());
  		return http.build();
   }

             @Bean
             public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
 	                           http
                    			.authorizeHttpRequests(authorize -> authorize
                    			.anyRequest().authenticated()
                    		)
                    			.formLogin(withDefaults());
 		return http.build();
     }
  }
    /**@Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.headers().cacheControl().and()
                .contentSecurityPolicy("default-src 'self'; script-src 'self'; object-src 'self'; frame-ancestors 'self'; form-action 'self';")
                .and()
                .frameOptions()
                .deny();
        http.csrf().disable().authorizeHttpRequests().requestMatchers("health").permitAll().and().authorizeHttpRequests()
                .and().authorizeHttpRequests().requestMatchers("/api/**")
                //.authenticated()
                .permitAll().anyRequest().permitAll();
        //  http.addFilterBefore(awsCognitoJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().ignoringRequestMatchers("health").disable();
        return http.build();
    }**/


/**
 * @Configuration
 * @EnableWebSecurity
 * public class MultiHttpSecurityConfig {
 *        @Bean
 *    public UserDetailsService userDetailsService() throws Exception {
 * 		// ensure the passwords are encoded properly
 * 		UserBuilder users = User.withDefaultPasswordEncoder();
 * 		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 * 		manager.createUser(users.username("user").password("password").roles("USER").build());
 * 		manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
 * 		return manager;
 *    }
 *
 *    @Bean
 *    @Order(1)
 *    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
 * 		http
 * 			.securityMatcher("/api/**")
 * 			.authorizeHttpRequests(authorize -> authorize
 * 				.anyRequest().hasRole("ADMIN")
 * 			)
 * 			.httpBasic(withDefaults());
 * 		return http.build();
 *    }
 *
 *    @Bean
 *    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
 * 		http
 * 			.authorizeHttpRequests(authorize -> authorize
 * 				.anyRequest().authenticated()
 * 			)
 * 			.formLogin(withDefaults());
 * 		return http.build();
 *    }
 * }
 *
 * */
