package com.br.itsingular.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaModel implements Serializable{
	
	private static final long serialVersionUID = -3195310536639744515L;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private LocalDate dataInicio;
	
	@NotBlank(message = "Campo obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private LocalDate dataFim;
	
	@NotBlank(message = "Campo obrigatório")
	private String atividades;
}
