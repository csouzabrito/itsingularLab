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
public enum TipoRequisito {

	OBRIGATÓRIO(1, "OBRIGATÓRIO"),
	DESEJÁVEL(2 , "DESEJÁVEL");
	
	private Integer tipoRequisito;
	private String descricaoTipoRequisito;
	
}
