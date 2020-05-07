package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum TipoNivel {

	ESTAGIARIO,
	JUNIOR,
	PLENO,
	SENIOR,
	ESPECIALISTA;
	
	private String tipoNivel;
	
}
