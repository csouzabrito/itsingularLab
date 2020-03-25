package com.br.itsingular.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;


@ToString
@Entity
@Document(collection = "SOLICITA_REQUISICAO")
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
	private String[] rhProcesso;
	
	@Column(name = "solicitanteProcesso")
	@NotNull(message = "Campo obrigatório")
	private String[] solicitanteProcesso;
	
	@Column(name = "clienteProcesso")
	@NotNull(message = "Campo obrigatório")
	private String[] clienteProcesso;
	
	@Column(name = "quaisTestes")
	@NotNull(message = "Campo obrigatório")
	private String[] quaisTestes;
	
	@Column(name = "localAplicacao")
	@NotNull(message = "Campo obrigatório")
	private String localAplicacao;

	@Column(name = "observacao")
	@NotNull(message = "Campo obrigatório")
	private String observacao;

	@Column(name = "requisitoObrigatorio")
	private Integer requisitoObrigatorio;
	
	@Column(name = "requisitoConhecimento")
	private Integer requisitoConhecimento;

	@Column(name = "requisitoTempo")
	private Integer requisitoTempo;
	
	@OneToMany(mappedBy = "requisicao")
	private List<Requisitos> requisitos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String[] getRhProcesso() {
		return rhProcesso;
	}

	public void setRhProcesso(String[] rhProcesso) {
		this.rhProcesso = rhProcesso;
	}

	public String[] getSolicitanteProcesso() {
		return solicitanteProcesso;
	}

	public void setSolicitanteProcesso(String[] solicitanteProcesso) {
		this.solicitanteProcesso = solicitanteProcesso;
	}

	public String[] getClienteProcesso() {
		return clienteProcesso;
	}

	public void setClienteProcesso(String[] clienteProcesso) {
		this.clienteProcesso = clienteProcesso;
	}

	public String[] getQuaisTestes() {
		return quaisTestes;
	}

	public void setQuaisTestes(String[] quaisTestes) {
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

	public List<Requisitos> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Requisitos> requisitos) {
		this.requisitos = requisitos;
	}

	
}
