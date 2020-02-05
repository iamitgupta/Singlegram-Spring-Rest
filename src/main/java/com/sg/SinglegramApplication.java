package com.sg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

@EnableJpaRepositories(basePackages = "com.sg.dao")
@SpringBootApplication
public class SinglegramApplication {
	public static void main(String[] args) {
		SpringApplication.run(SinglegramApplication.class, args);
	}
	public void run(String... args) throws Exception{
		
	}

}
