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
public enum TipoProjeto {

	HORA(1,"HORA"),
	MES(2,"MES"),
	PROJETO(3,"PROJETO");
		
	private Integer tipoProjeto;
	private String descricaoTipoProjeto;

}
