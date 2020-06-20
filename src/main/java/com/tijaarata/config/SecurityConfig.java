/**
 * 
 */
package com.tijaarata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * @author User
 *
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthManager authenticationProvider;

	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic();
//		http.authorizeRequests().antMatchers("**/public/**").permitAll();
//		http.authorizeRequests().antMatchers("**/private/**").authenticated();
		http.authorizeRequests().antMatchers("**/api/users/authenticateUser").permitAll();
		http.authorizeRequests().anyRequest().authenticated();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1)
				.expiredUrl("/logout").and().invalidSessionUrl("/invalidateSessionUrl");
		
		http.sessionManagement()
		  .sessionFixation().migrateSession();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

}
