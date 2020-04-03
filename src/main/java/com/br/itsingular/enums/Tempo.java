package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Tempo {

	UM(    1, "1-ANO"),
	DOIS(  2, "2-ANOS" ),
	TRES(  3, "3-ANOS"),
	QUATRO(4, "4-ANOS" ),
	CINCO( 5, "5-ANOS"),
	SEIS(  6, "6-ANOS" ),
	SETE(  7, "7-ANOS"),
	OITO(  8, "8-ANOS" ),
	NOVE(  9, "9-ANOS"),
	DEZ(  10, "10-ANOS" );
	
	private Integer tempo;
	private String descricaoTempo;
	
}
