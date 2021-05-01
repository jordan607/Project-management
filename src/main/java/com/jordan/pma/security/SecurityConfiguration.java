package com.jordan.pma.security;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		auth.jdbcAuthentication().dataSource(dataSource)
//			.withDefaultSchema()
//				.withUser("vishal")
//				.password("123")
//				.roles("USER")
//			.and()
//				.withUser("jordan")
//				.password("123")
//				.roles("USER")
//			.and()
//				.withUser("admin")
//				.password("123")
//				.roles("ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled "
					+ "from user_accounts where username = ?")
			.authoritiesByUsernameQuery("select username, role "
					+ "from user_accounts where username = ?")
			.passwordEncoder(bCryptEncoder);
			
	}
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/projects/new").hasAuthority("ADMIN")
			.antMatchers("/employee/new").hasAuthority("ADMIN")
			.antMatchers("/employee/save").hasAuthority("ADMIN")
			.antMatchers("/projects/save").hasAuthority("ADMIN")
			.antMatchers("/","/**").permitAll()
			.and()
			.formLogin();
//			.antMatchers("h2_console/**").permitAll()
//			.antMatchers("/").authenticated().and().formLogin();
			
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
		
	}
	
	
}
