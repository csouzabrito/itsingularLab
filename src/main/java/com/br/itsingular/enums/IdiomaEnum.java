package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IdiomaEnum {
	
	INGLES("Inglês"),
	ESPANHOL("Espanhol"),
	PORTUGUES("Português"),
	ALEMAO("Alemão"),
	FRANCES("Francês");
	
	private String descricao;
	
}
