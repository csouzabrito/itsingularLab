package com.br.itsingular.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.br.itsingular.enums.TipoProcessoSeletivo;
import com.br.itsingular.enums.TipoQualificacaoTestes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Document(collection = "SOLICITA_REQUISICAO")
public class Requisicao implements Serializable {

	private static final long serialVersionUID = 5409745091354579153L;

	@Id
	private String id;

	@Column(name = "nomeSolicitante")
	@NotBlank(message = "Campo obrigatório")
	private String nomeSolicitante;

	@Column(name="dataSolicitacao")
	@NotBlank(message = "Campo obrigatório")
	private String dataSolicitacao;

	@Column(name = "cliente")
	@NotBlank(message = "Campo obrigatório")
	private String cliente;

	@Column(name = "ramoAtividade")
	@NotBlank(message = "Campo obrigatório")
	private String ramoAtividade;

	@Column(name = "endereco")
	@NotBlank(message = "Campo obrigatório")
	private String endereco;

	@Column(name = "regiao")
	@NotBlank(message = "Campo obrigatório")
	private String regiao;

	@Column(name = "pessoaContato")
	@NotBlank(message = "Campo obrigatório")
	private String pessoaContato;

	@Column(name = "cargo")
	@NotBlank(message = "Campo obrigatório")
	private String cargo;

	@Column(name = "telCorporativo")
	private String telCorporativo;

	@Column(name = "telCelular")
	@NotBlank(message = "Campo obrigatório")
	private String telCelular;

	@Column(name = "email")
	@NotBlank(message = "Campo obrigatório")
	@Email
	private String email;

	@Column(name = "perfil")
	@NotBlank(message = "Campo obrigatório")
	private String perfil;

	@Column(name = "regiaoAtuacao")
	@NotBlank(message = "Campo obrigatório")
	private String regiaoAtuacao;

	@Column(name = "vagas")
	@NotBlank(message = "Campo obrigatório")
	private String vagas;

	@Column(name = "cargaHoraria")
	@NotBlank(message = "Campo obrigatório")
	private String cargaHoraria;

	@Column(name = "previsaoInicio")
	@NotBlank(message = "Campo obrigatório")
	private String previsaoInicio;

	@Column(name = "duracaoContrato")
	@NotBlank(message = "Campo obrigatório")
	private String duracaoContrato;

	@Column(name = "renovacao")
	private String renovacao;

	@Column(name = "formaContratacao")
	private String formaContratacao;

	@Column(name = "valor")
	@NotBlank(message = "Campo obrigatório")
	private String valor;

	@Column(name = "por")
	private String por;

	@Column(name = "horaAberta")
	@NotBlank(message = "Campo obrigatórioo")
	private String horaAberta;

	@Column(name = "quantidadeMinimaHoras")
	@NotNull(message = "Campo obrigatório")
	private Integer quantidadeMinimaHoras;
	
	@Column(name = "rhProcesso")
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoProcessoSeletivo.class)
	@Enumerated(EnumType.STRING)
	private List<TipoProcessoSeletivo> rhProcesso;
	
	@Column(name = "solicitanteProcesso")
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoProcessoSeletivo.class)
	@Enumerated(EnumType.STRING)
	private List<TipoProcessoSeletivo> solicitanteProcesso;
	
	@Column(name = "clienteProcesso")
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoProcessoSeletivo.class)
	@Enumerated(EnumType.STRING)
	private List<TipoProcessoSeletivo> clienteProcesso;
	
	@Column(name = "quaisTestes")
	@NotNull(message = "Campo obrigatório")
	@ElementCollection(targetClass = TipoQualificacaoTestes.class)
	@Enumerated(EnumType.STRING)
	private List<TipoQualificacaoTestes> quaisTestes;
	
	@Column(name = "localAplicacao")
	@NotNull(message = "Campo obrigatório")
	private String localAplicacao;

	@Column(name = "observacao")
	@NotBlank(message = "Campo obrigatório")
	private String observacao;

	@Transient
	private String requisitoObrigatorio;
	
	@Transient
	private String requisitoConhecimento;

	@Transient
	private String requisitoTempo;
	
	@OneToMany(mappedBy = "requisicao")
	private List<Requisitos> requisitos;

	
}
