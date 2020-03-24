package com.br.itsingular.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SOLICITA_REQUISICAO")
public class Requisicao implements Serializable {

	private static final long serialVersionUID = 5409745091354579153L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


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
	private Integer[] rhProcesso;
	
	@Column(name = "solicitanteProcesso")
	@NotNull(message = "Campo obrigatório")
	private Integer[] solicitanteProcesso;
	
	@Column(name = "clienteProcesso")
	@NotNull(message = "Campo obrigatório")
	private Integer[] clienteProcesso;
	
	@Column(name = "quaisTestes")
	@NotNull(message = "Campo obrigatório")
	private Integer[] quaisTestes;
	
	@Column(name = "localAplicacao")
	@NotNull(message = "Campo obrigatório")
	private String localAplicacao;

	@Column(name = "observacao")
	@NotNull(message = "Campo obrigatório")
	private String observacao;

	@Column(name = "requisitoObrigatorio")
	@NotNull(message = "Campo obrigatório")
	private Integer requisitoObrigatorio;
	
	@Column(name = "requisitoConhecimento")
	@NotNull(message = "Campo obrigatório")
	private Integer requisitoConhecimento;

	@Column(name = "requisitoTempo")
	@NotNull(message = "Campo obrigatório")
	private Integer requisitoTempo;

		
	public Requisicao() {}


	/**
	 * @param id
	 * @param nomeSolicitante
	 * @param dataSolicitacao
	 * @param cliente
	 * @param ramoAtividade
	 * @param endereco
	 * @param regiao
	 * @param pessoaContato
	 * @param cargo
	 * @param telCorporativo
	 * @param telCelular
	 * @param email
	 * @param perfil
	 * @param regiaoAtuacao
	 * @param vagas
	 * @param cargaHoraria
	 * @param previsaoInicio
	 * @param duracaoContrato
	 * @param renovacao
	 * @param formaContratacao
	 * @param valor
	 * @param por
	 * @param horaAberta
	 * @param quantidadeMinimaHoras
	 * @param rhProcesso
	 * @param solicitanteProcesso
	 * @param clienteProcesso
	 * @param quaisTestes
	 * @param localAplicacao
	 * @param observacao
	 * @param requisitoObrigatorio
	 * @param requisitoConhecimento
	 * @param requisitoTempo
	 */
	public Requisicao(long id, @NotBlank(message = "Campo obrigatório") String nomeSolicitante,
			@NotBlank(message = "Campo obrigatório") String dataSolicitacao,
			@NotBlank(message = "Campo obrigatório") String cliente,
			@NotBlank(message = "Campo obrigatório") String ramoAtividade,
			@NotBlank(message = "Campo obrigatório") String endereco,
			@NotBlank(message = "Campo obrigatório") String regiao,
			@NotBlank(message = "Campo obrigatório") String pessoaContato,
			@NotBlank(message = "Campo obrigatório") String cargo, String telCorporativo,
			@NotBlank(message = "Campo obrigatório") String telCelular,
			@NotBlank(message = "Campo obrigatório") @Email String email,
			@NotBlank(message = "Campo obrigatório") String perfil,
			@NotBlank(message = "Campo obrigatório") String regiaoAtuacao,
			@NotBlank(message = "Campo obrigatório") String vagas,
			@NotBlank(message = "Campo obrigatório") String cargaHoraria,
			@NotBlank(message = "Campo obrigatório") String previsaoInicio,
			@NotBlank(message = "Campo obrigatório") String duracaoContrato, String renovacao, String formaContratacao,
			@NotBlank(message = "Campo obrigatório") String valor, String por,
			@NotBlank(message = "Campo obrigatórioo") String horaAberta,
			@NotNull(message = "Campo obrigatório") Integer quantidadeMinimaHoras,
			@NotNull(message = "Campo obrigatório") Integer[] rhProcesso,
			@NotNull(message = "Campo obrigatório") Integer[] solicitanteProcesso,
			@NotNull(message = "Campo obrigatório") Integer[] clienteProcesso,
			@NotNull(message = "Campo obrigatório") Integer[] quaisTestes,
			@NotNull(message = "Campo obrigatório") String localAplicacao,
			@NotNull(message = "Campo obrigatório") String observacao,
			@NotNull(message = "Campo obrigatório") Integer requisitoObrigatorio,
			@NotNull(message = "Campo obrigatório") Integer requisitoConhecimento,
			@NotNull(message = "Campo obrigatório") Integer requisitoTempo) {
		super();
		this.id = id;
		this.nomeSolicitante = nomeSolicitante;
		this.dataSolicitacao = dataSolicitacao;
		this.cliente = cliente;
		this.ramoAtividade = ramoAtividade;
		this.endereco = endereco;
		this.regiao = regiao;
		this.pessoaContato = pessoaContato;
		this.cargo = cargo;
		this.telCorporativo = telCorporativo;
		this.telCelular = telCelular;
		this.email = email;
		this.perfil = perfil;
		this.regiaoAtuacao = regiaoAtuacao;
		this.vagas = vagas;
		this.cargaHoraria = cargaHoraria;
		this.previsaoInicio = previsaoInicio;
		this.duracaoContrato = duracaoContrato;
		this.renovacao = renovacao;
		this.formaContratacao = formaContratacao;
		this.valor = valor;
		this.por = por;
		this.horaAberta = horaAberta;
		this.quantidadeMinimaHoras = quantidadeMinimaHoras;
		this.rhProcesso = rhProcesso;
		this.solicitanteProcesso = solicitanteProcesso;
		this.clienteProcesso = clienteProcesso;
		this.quaisTestes = quaisTestes;
		this.localAplicacao = localAplicacao;
		this.observacao = observacao;
		this.requisitoObrigatorio = requisitoObrigatorio;
		this.requisitoConhecimento = requisitoConhecimento;
		this.requisitoTempo = requisitoTempo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeSolicitante() {
		return nomeSolicitante;
	}
	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}
	public String getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getPessoaContato() {
		return pessoaContato;
	}
	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTelCorporativo() {
		return telCorporativo;
	}
	public void setTelCorporativo(String telCorporativo) {
		this.telCorporativo = telCorporativo;
	}
	public String getTelCelular() {
		return telCelular;
	}
	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getRegiaoAtuacao() {
		return regiaoAtuacao;
	}
	public void setRegiaoAtuacao(String regiaoAtuacao) {
		this.regiaoAtuacao = regiaoAtuacao;
	}
	public String getVagas() {
		return vagas;
	}
	public void setVagas(String vagas) {
		this.vagas = vagas;
	}
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getPrevisaoInicio() {
		return previsaoInicio;
	}
	public void setPrevisaoInicio(String previsaoInicio) {
		this.previsaoInicio = previsaoInicio;
	}
	public String getDuracaoContrato() {
		return duracaoContrato;
	}
	public void setDuracaoContrato(String duracaoContrato) {
		this.duracaoContrato = duracaoContrato;
	}
	public String getRenovacao() {
		return renovacao;
	}
	public void setRenovacao(String renovacao) {
		this.renovacao = renovacao;
	}
	public String getFormaContratacao() {
		return formaContratacao;
	}
	public void setFormaContratacao(String formaContratacao) {
		this.formaContratacao = formaContratacao;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getPor() {
		return por;
	}
	public void setPor(String por) {
		this.por = por;
	}
	public String getHoraAberta() {
		return horaAberta;
	}
	public void setHoraAberta(String horaAberta) {
		this.horaAberta = horaAberta;
	}
	public Integer getQuantidadeMinimaHoras() {
		return quantidadeMinimaHoras;
	}
	public void setQuantidadeMinimaHoras(Integer quantidadeMinimaHoras) {
		this.quantidadeMinimaHoras = quantidadeMinimaHoras;
	}
	public Integer[] getRhProcesso() {
		return rhProcesso;
	}
	public void setRhProcesso(Integer[] rhProcesso) {
		this.rhProcesso = rhProcesso;
	}
	public Integer[] getSolicitanteProcesso() {
		return solicitanteProcesso;
	}
	public void setSolicitanteProcesso(Integer[] solicitanteProcesso) {
		this.solicitanteProcesso = solicitanteProcesso;
	}
	public Integer[] getClienteProcesso() {
		return clienteProcesso;
	}
	public void setClienteProcesso(Integer[] clienteProcesso) {
		this.clienteProcesso = clienteProcesso;
	}
	public Integer[] getQuaisTestes() {
		return quaisTestes;
	}
	public void setQuaisTestes(Integer[] quaisTestes) {
		this.quaisTestes = quaisTestes;
	}
	public String getLocalAplicacao() {
		return localAplicacao;
	}
	public void setLocalAplicacao(String localAplicacao) {
		this.localAplicacao = localAplicacao;
	}

	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getRequisitoObrigatorio() {
		return requisitoObrigatorio;
	}
	public void setRequisitoObrigatorio(Integer requisitoObrigatorio) {
		this.requisitoObrigatorio = requisitoObrigatorio;
	}
	public Integer getRequisitoConhecimento() {
		return requisitoConhecimento;
	}
	public void setRequisitoConhecimento(Integer requisitoConhecimento) {
		this.requisitoConhecimento = requisitoConhecimento;
	}
	public Integer getRequisitoTempo() {
		return requisitoTempo;
	}
	public void setRequisitoTempo(Integer requisitoTempo) {
		this.requisitoTempo = requisitoTempo;
	}

	@Override
	public String toString() {
		return "Requisicao [id=" + id + ", nomeSolicitante=" + nomeSolicitante + ", dataSolicitacao=" + dataSolicitacao
				+ ", cliente=" + cliente + ", ramoAtividade=" + ramoAtividade + ", endereco=" + endereco + ", regiao="
				+ regiao + ", pessoaContato=" + pessoaContato + ", cargo=" + cargo + ", telCorporativo="
				+ telCorporativo + ", telCelular=" + telCelular + ", email=" + email + ", perfil=" + perfil
				+ ", regiaoAtuacao=" + regiaoAtuacao + ", vagas=" + vagas + ", cargaHoraria=" + cargaHoraria
				+ ", previsaoInicio=" + previsaoInicio + ", duracaoContrato=" + duracaoContrato + ", renovacao="
				+ renovacao + ", formaContratacao=" + formaContratacao + ", valor=" + valor + ", por=" + por
				+ ", horaAberta=" + horaAberta + ", quantidadeMinimaHoras=" + quantidadeMinimaHoras + ", rhProcesso="
				+ Arrays.toString(rhProcesso) + ", solicitanteProcesso=" + Arrays.toString(solicitanteProcesso)
				+ ", clienteProcesso=" + Arrays.toString(clienteProcesso) + ", quaisTestes="
				+ Arrays.toString(quaisTestes) + ", localAplicacao=" + localAplicacao + ", observacao=" + observacao
				+ ", requisitoObrigatorio=" + requisitoObrigatorio + ", requisitoConhecimento=" + requisitoConhecimento
				+ ", requisitoTempo=" + requisitoTempo + "]";
	}
	
}
