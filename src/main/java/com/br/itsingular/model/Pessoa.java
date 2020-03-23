package com.br.itsingular.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "PESSOA")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	
	@Id
	private String id;
	
	private String nome;
	
	private String email;
	
	private List<Vaga> vagas;
}
