package com.br.itsingular.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.br.itsingular.enums.TipoProcessoSeletivo;
import com.br.itsingular.enums.TipoQualificacaoTestes;
import com.br.itsingular.enums.TipoRequisicao;
import com.br.itsingular.enums.TipoRequisito;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "SOLICITA_REQUISICAO")
public class Requisicao implements Serializable {

	private static final long serialVersionUID = 5409745091354579153L;

	@Id
	private String id;

	@NotBlank(message = "Campo obrigatório")
	private String nomeSolicitante;

	private LocalDate dataSolicitacao;

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

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Campo obrigatório")
	private LocalDate previsaoInicio;

	@NotBlank(message = "Campo obrigatório")
	private String duracaoContrato;

	@NotBlank(message = "Campo obrigatório")
	private String renovacao;

	@NotBlank(message = "Campo obrigatório")
	private String formaContratacao;

	@NotBlank(message = "Campo obrigatório")
	private String valor;

	@NotBlank(message = "Campo obrigatório")
	private String por;

	@NotBlank(message = "Campo obrigatórioo")
	private String horaAberta;

	@NotNull(message = "Campo obrigatório")
	private Integer quantidadeMinimaHoras;
	
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoProcessoSeletivo.class)
	@Enumerated(EnumType.STRING)
	private List<TipoProcessoSeletivo> rhProcesso;
	
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoProcessoSeletivo.class)
	@Enumerated(EnumType.STRING)
	private List<TipoProcessoSeletivo> solicitanteProcesso;
	
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoProcessoSeletivo.class)
	@Enumerated(EnumType.STRING)
	private List<TipoProcessoSeletivo> clienteProcesso;
	
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoQualificacaoTestes.class)
	@Enumerated(EnumType.STRING)
	private List<TipoQualificacaoTestes> quaisTestes;
	
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoRequisito.class)
	@Enumerated(EnumType.STRING)
	private TipoRequisicao tipoRequisicao;
	
	@NotBlank(message = "Campo obrigatório")
	private String localAplicacao;

	@NotBlank(message = "Campo obrigatório")
	private String observacao;

	@NotNull(message = "Campo obrigatório")
	private String[] requisitoObrigatorio;
	
	private Integer sla;

	@NotNull(message = "Campo obrigatório")
	private String[] requisitoConhecimento;

	private String status;
	
}
