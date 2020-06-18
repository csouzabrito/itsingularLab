package com.br.itsingular.enums;

import lombok.Getter;

@Getter
public enum StatusFuncionario {

	ATIVO,
	NOS_RESCINDIMOS,
	PEDIU_RECISAO,
	PEDIU_DEMISSAO,
	FIM_CONTRATO,
	INTERNALIZADO_CLIENTE,
	ABANDONO_EMPRESA;

	private String statusFuncionario;
	
}
