package com.construction.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Allow

						.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout"))
				.httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.builder().username("jayesh").password(passwordEncoder.encode("jayesh@123"))
				.roles("ADMIN").build();

		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
