package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NivelIdioma {
	
	BASICO("Básico"),
	INTERMEDIARIO("Intermediário"),
	AVANCADO("Avançado"),
	FLUENTE("Fluente");
	
	private String descricao;
	
}
