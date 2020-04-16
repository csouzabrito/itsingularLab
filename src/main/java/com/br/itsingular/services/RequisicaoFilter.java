package com.br.itsingular.services;

import java.time.LocalDate;

import com.br.itsingular.enums.StatusRequisicao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoFilter {
	
	private String descricao;
	
	private LocalDate dataSolicitacao;
	
	private String cliente;
	
	private String solicitante;
	
	private String ramoAtividade;
	
	private Integer sla;
	
	private StatusRequisicao status;
}
