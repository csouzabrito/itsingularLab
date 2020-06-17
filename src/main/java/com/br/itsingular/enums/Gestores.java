package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum Gestores {

		GUILHERME("Guilherme"),
		LUCAS("Lucas"),
		HARLEI("Harlei"),
		NADIA("Nádia"),
		JESUS("Jesus"),
		PAULO("Paulo"),
		JOAO("João"),
		LOPES("Lopes"),
		DIEGO("Diego");
		
	private String gestor;		
}
