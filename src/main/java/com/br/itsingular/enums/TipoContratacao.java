/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoContratacao {

	CLT(1,"CLT"), 
	PJ(2,"PJ"), 
	FLEX(3,"FLEX"), 
	IBRATI(4,"IBRATI"),
	COOPERATIVA(5,"COOPERATIVA"); 
	
	private Integer tipoContratacao;
	private String descricaoTipoContratacao;	
	
	private TipoContratacao(Integer tipoContratacao, String descricaoTipoContratacao) {
		this.tipoContratacao = tipoContratacao;
		this.descricaoTipoContratacao = descricaoTipoContratacao;
	}

	public Integer getTipoContratacao() {
		return tipoContratacao;
	}

	public void setTipoContratacao(Integer tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}

	public String getDescricaoTipoContratacao() {
		return descricaoTipoContratacao;
	}

	public void setDescricaoTipoContratacao(String descricaoTipoContratacao) {
		this.descricaoTipoContratacao = descricaoTipoContratacao;
	}

}
