package com.br.itsingular.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequisicaoModel {

	@NotBlank(message = "Campo obrigatório")
	private String nomeSolicitante;

	@NotBlank(message = "Campo obrigatório")
	private String dataSolicitacao;

	@NotBlank(message = "Campo obrigatório")
	private String cliente;

	@NotBlank(message = "Campo obrigatório")
	private String ramoAtividade;

	@NotBlank(message = "Campo obrigatório")
	private String endereco;

	@NotBlank(message = "Campo obrigatório")
	private String regiao;

	@NotBlank(message = "Campo obrigatório")
	private String pessoaContato;

	@NotBlank(message = "Campo obrigatório")
	private String cargo;

	@SuppressWarnings("unused")
	private String telCorporativo;

	@NotBlank(message = "Campo obrigatório")
	private String telCelular;

	@NotBlank(message = "Campo obrigatório")
	@Email
	private String email;

	@NotBlank(message = "Campo obrigatório")
	private String perfil;

	@NotBlank(message = "Campo obrigatório")
	private String regiaoAtuacao;
	
	@NotBlank(message = "Campo obrigatório")
	private String vagas;

	@NotBlank(message = "Campo obrigatório")
	private String cargaHoraria;

	@NotBlank(message = "Campo obrigatório")
	private String previsaoInicio;

	@NotBlank(message = "Campo obrigatório")
	private String duracaoContrato;
	
	@SuppressWarnings("unused")
	private String renovacao;
	
	@SuppressWarnings("unused")
	private String formaContratacao;

	@NotBlank(message = "Campo obrigatório")
	private String valor;

	@SuppressWarnings("unused")
	private String por;

	@NotBlank(message = "Campo obrigatórioo")
	private String horaAberta;

	@NotNull(message = "Campo obrigatório")
	private Integer quantidadeMinimaHoras;
	
	@NotNull(message = "Campo obrigatório")
	private Integer[] rhProcesso;
	
	@NotNull(message = "Campo obrigatório")
	private Integer[] solicitanteProcesso;
	
	@NotNull(message = "Campo obrigatório")
	private Integer[] clienteProcesso;
	
	@NotNull(message = "Campo obrigatório")
	private Integer[] quaisTestes;
	
	@NotNull(message = "Campo obrigatório")
	private String localAplicacao;

	@NotNull(message = "Campo obrigatório")
	private String observacao;

	@NotNull(message = "Campo obrigatório")
	private Integer requisitoObrigatorio;
	
	@NotNull(message = "Campo obrigatório")
	private Integer requisitoConhecimento;

	@NotNull(message = "Campo obrigatório")
	private Integer requisitoTempo;
	
	

}
