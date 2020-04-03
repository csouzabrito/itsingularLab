package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusRequisicao {

	PENDENTE("Pendente"),
	EM_PROCESSO("Em processo");
	
	private String descricao;
}
