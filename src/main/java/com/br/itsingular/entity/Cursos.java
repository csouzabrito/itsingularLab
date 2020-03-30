package com.br.itsingular.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Document(collection = "CADASTRO_CURSOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cursos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nomeCurso;
	
	@NotBlank(message = "Campo obrigatório")
	private String versao;
	
	@NotBlank(message = "Campo obrigatório")
	private String descricaoResumida;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataInclOrManut;
	
	private String usuario;
	
	@Transient
	private List<Cursos> cursos;
	
}
