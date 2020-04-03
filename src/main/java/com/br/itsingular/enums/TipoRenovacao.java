/**
 * 
 */
package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dcarneiro
 *
 */
@Getter
@AllArgsConstructor
public enum TipoRenovacao {

	ALTA(1,"ALTA"),
	BAIXA(2,"BAIXA"),
	INEXISTENTE(3,"INEXISTENTE");
	
	private Integer tipoRenovacao;
	private String descricaoTipoRenovacao;
	
}
