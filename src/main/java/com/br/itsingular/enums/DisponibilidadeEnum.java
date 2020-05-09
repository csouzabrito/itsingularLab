package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DisponibilidadeEnum {

	DISPONIBILIDADE_5(5),
	DISPONIBILIDADE_10(10),
	DISPONIBILIDADE_15(15),
	DISPONIBILIDADE_20(20),
	DISPONIBILIDADE_25(25),
	DISPONIBILIDADE_30(30);
	
	private int descricao;
	
}
