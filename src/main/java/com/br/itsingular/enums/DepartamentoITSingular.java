package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum DepartamentoITSingular {

	TI("TI"),
	RH("RH"),
	CONCILIACAO("Conciliação"),
	COMERCIAL("Comercial");
	
	private String tipoDepartamento;
}
