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
public enum TipoLocalAplicacaoTestes {

	ITSINGULAR(1,"ITSINGULAR"),
	CLIENTE(2,"CLIENTE");
	
	private Integer tipoLocalAplicacaoTestes;
	private String descricaoLocalAplicacaoTestes;
	
	
}
