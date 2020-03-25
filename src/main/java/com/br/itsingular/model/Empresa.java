package com.br.itsingular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1764081334527695609L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@Column(name = "razaoSocial")
	@NotBlank(message = "Campo obrigatório")
	private String razaoSocial;

	@Column(name="cnpj")
	@CNPJ
	@NotBlank(message = "Campo obrigatório")
	private String cnpj;

	@Column(name = "fantasia")
	@NotBlank(message = "Campo obrigatório")
	private String fantasia;

	@Column(name = "ramoAtividade")
	@NotBlank(message = "Campo obrigatório")
	private String ramoAtividade;

	@Column(name = "endereco")
	@NotBlank(message = "Campo obrigatório")
	private String endereco;

	@Column(name = "pessoaContato")
	@NotBlank(message = "Campo obrigatório")
	private String pessoaContato;

	@Column(name = "cargo")
	@NotBlank(message = "Campo obrigatório")
	private String cargo;

	@Column(name = "telCorporativo")
	private String telCorporativo;

	@Column(name = "telCelular")
	private String telCelular;

	@Column(name = "emailContato")
	@NotBlank(message = "Campo obrigatório")
	@Email
	private String emailContato;

	@Column(name = "emailFinanceiro")
	@NotBlank(message = "Campo obrigatório")
	private String emailFinanceiro;



	
	public Empresa() {}

	/**
	* @param razaoSocial
	* @param cnpj
	* @param fantasia
	* @param ramoAtividade
	* @param endereco
	* @param pessoaContato
	* @param cargo
	* @param telCorporativo
	* @param telCelular
	* @param emailContato
	* @param emailFinanceiro
	 */
	public Empresa(long id, @NotBlank(message = "Campo obrigatório") String razaoSocial,
			@NotBlank(message = "Campo obrigatório") String cnpj,
			@NotBlank(message = "Campo obrigatório") String fantasia,
			@NotBlank(message = "Campo obrigatório") String ramoAtividade,
			@NotBlank(message = "Campo obrigatório") String endereco,
			@NotBlank(message = "Campo obrigatório") String pessoaContato,
			@NotBlank(message = "Campo obrigatório") String cargo,
			@NotBlank(message = "Campo obrigatório") String telCelular,
			@NotBlank(message = "Campo obrigatório") String emailContato,
			@NotBlank(message = "Campo obrigatório") String emailFinanceiro) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.fantasia = fantasia;
		this.ramoAtividade = ramoAtividade;
		this.endereco = endereco;
		this.pessoaContato = pessoaContato;
		this.cargo = cargo;
		this.telCelular = telCelular;
		this.emailContato = emailContato;
		this.emailFinanceiro = emailFinanceiro;

	}
	
	// getters e setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
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

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getEmailFinanceiro() {
		return emailFinanceiro;
	}

	public void setEmailFinanceiro(String emailFinanceiro) {
		this.emailFinanceiro = emailFinanceiro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
