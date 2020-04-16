package com.br.itsingular.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusRequisicao {

	PENDENTE("Pendente"),
	EM_ABERTO("Em aberto"),
	EM_ANDAMENTO("Em andamento"),
	AGUARDANDO_REPOSTA("Aguardando Resposta");
	
	private String descricao;
}
