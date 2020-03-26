package com.br.itsingular.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "LOGIN")
public class Login {
	
	@Id
	private String id;
	
	private String name;
	
	private String username;
	
	private String password;
}
