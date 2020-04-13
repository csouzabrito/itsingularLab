package com.br.itsingular.entity;

import java.io.Serializable;
import java.util.Date;

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
@Document(collection = "CADASTRAR_TECNOLOGIAS")
public class Tecnologias implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nomeCurso;
	
	@NotBlank(message = "Campo obrigatório")
	private String versao;
	
	@NotBlank(message = "Campo obrigatório")
	private String descricaoResumida;
	
	private Date dataInclOrManut;
	
	private String usuario;
	
}
