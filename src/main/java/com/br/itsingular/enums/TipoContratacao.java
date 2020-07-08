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
public enum TipoContratacao {

	CLT(1,"CLT"), 
	PJ(2,"PJ"), 
	FLEX(3,"FLEX"), 
	COOPERATIVA(4,"COOPERATIVA"), 
	ESTAGIO(5,"ESTÁGIO");
	
	private Integer tipoContratacao;
	private String descricaoTipoContratacao;	
	
}
