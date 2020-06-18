package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
public enum TipoGrauInstrucao {

	ENSINO_MÉDIO_COMPLETO,
	ENSINO_SUPERIOR_COMPLETO,
	ENSINO_SUPERIOR_INCOMPLETO,
	MBA_CURSANDO,
	MBA_COMPLETO,
	ENSINO_SUPERIOR_INTERROMPIDO,
	PÓS_GRADUAÇÃO_COMPLETO,
	PÓS_GRADUAÇÃO_INCOMPLETO;
	
	private String grauInstrucao;
}
