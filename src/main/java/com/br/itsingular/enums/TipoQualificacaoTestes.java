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
public enum TipoQualificacaoTestes {

	ADT(1, "ADT"),
	FTP(2, "FTP"),
	RAC_LÓGICO(3, "RAC_LÓGICO"),
	REDAÇÃO(4, "REDAÇÃO"),
	TÉCNICO(5, "TÉCNICO"),
	OUTROS(6, "OUTROS");
	
	private Integer tipoQualificacaoTestes;
	private String descricaotipoQualificacaoTestes;
}
