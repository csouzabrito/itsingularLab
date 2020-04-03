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
public enum TipoProcessoSeletivo {

	ENTREVISTA_PRESENCIAL(1, "ENTREVISTA PRESENCIAL"),
	ENTREVISTA_REMOTA(2 ,"ENTREVISTA REMOTA"),
	CONFERIR_DADOS(3,"CONFERIR DADOS"),
	APLICACAO_TESTES(4, "APLICACAO_TESTES");
	
	private Integer tipoProcessoSeletivo;
	private String descricaotipoProcessoSeletivo;
	
}
