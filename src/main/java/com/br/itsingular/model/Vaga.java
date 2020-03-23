package com.br.itsingular.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "VAGA")
@AllArgsConstructor
@NoArgsConstructor
public class Vaga {
	
	@Id
	private String id;
	
	private Pessoa pessoa;
	
	private String descricao;
	
	private Integer quantidade;
}
