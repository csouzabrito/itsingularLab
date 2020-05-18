package com.br.itsingular.entity;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.itsingular.enums.DisponibilidadeEnum;
import com.br.itsingular.model.CursoModel;
import com.br.itsingular.model.EmpresaModel;
import com.br.itsingular.model.Formacao;
import com.br.itsingular.model.GraficoModel;
import com.br.itsingular.model.Idioma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "CANDIDADO_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class Candidado {
	
	@Id
	private String id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private DisponibilidadeEnum disponibilidade;
	
	@NotBlank(message = "Campo obrigatório")
	private String resumoQualificacao;
	
	private EmpresaModel empresa;
	
	private Formacao formacaoAcademica;
	
	private CursoModel curso;
	
	private Idioma idioma;
	
	private GraficoModel gafricoModel;
		
}
