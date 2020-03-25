package com.br.itsingular.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoDto implements Serializable{
	
	private static final long serialVersionUID = -9168855776219849566L;

	private String id;
	
	private String nomeSolicitante;

	private String dataSolicitacao;

	private String cliente;

	private String ramoAtividade;

	private String endereco;

	private String regiao;

	private String pessoaContato;

	private String cargo;

	private String telCorporativo;

	private String telCelular;

	private String email;

	private String perfil;

	private String regiaoAtuacao;

	private String vagas;

	private String cargaHoraria;

	private String previsaoInicio;

	private String duracaoContrato;

	private String renovacao;

	private String formaContratacao;

	private String valor;

	private String por;

	private String horaAberta;

	private Integer quantidadeMinimaHoras;
	
	private Integer[] rhProcesso;
	
	private Integer[] solicitanteProcesso;
	
	private Integer[] clienteProcesso;
	
	private Integer[] quaisTestes;
	
	private String localAplicacao;

	private String observacao;

}
