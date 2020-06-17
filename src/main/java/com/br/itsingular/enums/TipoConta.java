package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum TipoConta {

	CONTA_JURIDICA("Conta Jurídica"),
	CONTA_CORRENTE("Conta Corrente"),
	CONTA_POUPANÇA("Conta Poupança"),
	CONTA_SALARIO("Conta Salário");
	
	private String tipoConta;
		
}
