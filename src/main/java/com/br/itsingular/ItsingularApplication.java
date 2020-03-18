package com.br.itsingular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "com.br.itsingular.*")
@EntityScan(basePackages = "com.br.itsingular.model")
@EnableJpaRepositories(basePackages = "com.br.itsingular.services")
@EnableTransactionManagement
public class ItsingularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsingularApplication.class, args);
	}

}
