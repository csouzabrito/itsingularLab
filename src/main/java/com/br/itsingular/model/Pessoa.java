package com.br.itsingular.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PESSOA")
public class Pessoa {
	
	@Id
	private String id;
	
	@NotBlank(message = "Campo obrigatório")
	private String telefone;
	
	@NotBlank(message = "Campo obrigatório")
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	private String slack;
	
}
