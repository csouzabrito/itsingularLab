/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoLocalAplicacaoTestes {

	ITSINGULAR(1,"ITSINGULAR"),
	CLIENTE(2,"CLIENTE");
	
	private Integer tipoLocalAplicacaoTestes;
	private String descricaoLocalAplicacaoTestes;
	
	TipoLocalAplicacaoTestes(Integer tipoLocalAplicaoTestes, String descricaoTipoLocalAplicacaoTestes) {
		this.tipoLocalAplicacaoTestes = tipoLocalAplicaoTestes;
		this.descricaoLocalAplicacaoTestes = descricaoTipoLocalAplicacaoTestes;
	}
	public Integer getTipoLocalAplicacaoTestes() {
		return tipoLocalAplicacaoTestes;
	}
	public void setTipoLocalAplicacaoTestes(Integer tipoLocalAplicacaoTestes) {
		this.tipoLocalAplicacaoTestes = tipoLocalAplicacaoTestes;
	}
	public String getDescricaoLocalAplicacaoTestes() {
		return descricaoLocalAplicacaoTestes;
	}
	public void setDescricaoLocalAplicacaoTestes(String descricaoLocalAplicacaoTestes) {
		this.descricaoLocalAplicacaoTestes = descricaoLocalAplicacaoTestes;
	}
}
