package com.tijaarata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableCaching
@EnableWebSecurity
//@EnableJdbcHttpSession
public class Tijaarata extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Tijaarata.class, args);
	}

}
