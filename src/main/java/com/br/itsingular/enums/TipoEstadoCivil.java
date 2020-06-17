package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum TipoEstadoCivil {

	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");
	
	private String estadoCivil;
}
