package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum StatusFuncionario {

	ATIVO("Ativo"),
	NOS_RESCINDIMOS("Nós rescindimos"),
	PEDIU_RECISAO("Pediu rescisão"),
	PEDIU_DEMISSAO("Pediu Demissão"),
	FIM_CONTRATO("Fim de contrato"),
	INTERNALIZADO_CLIENTE("Internalizado pelo cliente"),
	ABANDONO_EMPRESA("Abandono de emprego");

	private String statusFuncionario;
	
}
