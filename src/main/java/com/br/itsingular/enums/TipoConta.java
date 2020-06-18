package com.br.itsingular.enums;

import lombok.Getter;

@Getter
public enum TipoConta {

	CONTA_JURIDICA,
	CONTA_CORRENTE,
	CONTA_POUPANÇA,
	CONTA_SALARIO;
	
	private String tipoConta;
		
}
