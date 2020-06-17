package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum TipoAtuacao {

	EXTERNA("Externa"),
	INTERNA("Interna");
	
	private String tipoAtuacao;
	
}
