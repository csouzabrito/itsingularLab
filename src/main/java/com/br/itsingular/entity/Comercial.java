package com.br.itsingular.entity;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "COMERCIAL")
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {
	
	@Id
	private String id;
	
	@NotBlank(message = "Campo obrigatório")
	private String telefone;
	
	@NotBlank(message = "Campo obrigatório")
	@Email
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	private String slack;
	
}
