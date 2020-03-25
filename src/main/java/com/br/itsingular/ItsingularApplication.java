package com.br.itsingular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "{com.br.itsingular.repository}")
public class ItsingularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsingularApplication.class, args);
	}

}
