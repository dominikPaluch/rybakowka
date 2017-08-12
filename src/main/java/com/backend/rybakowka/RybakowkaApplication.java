package com.backend.rybakowka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableCaching
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class RybakowkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RybakowkaApplication.class, args);
	}
}
