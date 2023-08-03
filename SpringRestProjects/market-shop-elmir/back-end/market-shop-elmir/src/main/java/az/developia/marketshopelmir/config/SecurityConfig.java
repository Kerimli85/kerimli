package az.developia.marketshopelmir.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers(HttpMethod.POST, "/users").hasAuthority("admin")
		.antMatchers(HttpMethod.GET, "/users").hasAuthority("admin")
		.antMatchers(HttpMethod.POST, "/products").hasAuthority("admin")
		.antMatchers(HttpMethod.DELETE, "/products/{id}").hasAuthority("admin")
		.antMatchers(HttpMethod.PUT, "/products").hasAuthority("admin")
		.antMatchers(HttpMethod.POST, "/products/sell").hasAuthority("cashier")
		
		.anyRequest().authenticated().and().httpBasic(); 
		
		
		//h2 security session deaktiv etmek
		http.headers().frameOptions().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource);
	} 

}
