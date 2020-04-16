package com.br.itsingular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.br.itsingular")
@EnableJpaRepositories(basePackages = "{com.br.itsingular.repository}")
public class ItsingularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsingularApplication.class, args);
	}

}
