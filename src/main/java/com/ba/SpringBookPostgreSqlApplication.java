package com.ba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBookPostgreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookPostgreSqlApplication.class, args);
	}

}
