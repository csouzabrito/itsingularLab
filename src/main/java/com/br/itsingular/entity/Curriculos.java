package com.br.itsingular.entity;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.Binary;
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
@Document(collection = "CADASTRAR_CURRICULOS")
public class Curriculos{
	
	@Id
	private CompositeKey key;
	
	private String[] tecnologiasAssociadas;
	
	private String nome;
	
	private Binary filePdf;

	private Binary fileWord;

	private Date dataNascimento;
	
	private String telCelular;
	
	private String email;

	@Getter
	@Setter
	static class CompositeKey implements Serializable{

		private static final long serialVersionUID = 1L;

		private String id;

		private String cpf;
	
	}
	
}
