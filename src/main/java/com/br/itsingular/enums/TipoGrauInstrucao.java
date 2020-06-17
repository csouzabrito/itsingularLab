package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum TipoGrauInstrucao {

	ENSINO_MÉDIO_COMPLETO("ENSINO MÉDIO COMPLETO"),
	ENSINO_SUPERIOR_COMPLETO("ENSINO SUPERIOR - COMPLETO"),
	ENSINO_SUPERIOR_INCOMPLETO("ENSINO SUPERIOR - INCOMPLETO"),
	MBA_CURSANDO("MBA - CURSANDO"),
	MBA_COMPLETO("MBA - COMPLETO"),
	ENSINO_SUPERIOR_INTERROMPIDO("ENSINO SUPERIOR - INTERROMPIDO"),
	PÓS_GRADUAÇÃO_COMPLETO("PÓS GRADUAÇÃO - COMPLETO"),
	PÓS_GRADUAÇÃO_INCOMPLETO("PÓS GRADUAÇÃO - INCOMPLETO");
	
	private String grauInstrucao;
}
