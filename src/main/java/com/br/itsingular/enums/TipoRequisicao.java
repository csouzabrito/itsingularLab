
package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum TipoRequisicao {

	CONTRATACAO_PROJETOS(1,"CONTRATAÇÃO PROJETOS"),
	CONTRATACAO_HUNTING(2, "CONTRATAÇÃO HUNTING");
	
	private Integer tipoRequisicao;
	private String descricaoRequisicao;
	
}
