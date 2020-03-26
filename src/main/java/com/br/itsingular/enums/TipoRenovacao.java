/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoRenovacao {

	ALTA(1,"ALTA"),
	BAIXA(2,"BAIXA"),
	INEXISTENTE(3,"INEXISTENTE");
	
	private Integer tipoRenovacao;
	private String descricaoTipoRenovacao;

	private TipoRenovacao(Integer tipoRenovacao, String descricaoTipoRenovacao) {
		this.tipoRenovacao = tipoRenovacao;
		this.descricaoTipoRenovacao = descricaoTipoRenovacao;
		
	}

	public Integer getTipoRenovacao() {
		return tipoRenovacao;
	}

	public void setTipoRenovacao(Integer tipoRenovacao) {
		this.tipoRenovacao = tipoRenovacao;
	}

	public String getDescricaoTipoRenovacao() {
		return descricaoTipoRenovacao;
	}

	public void setDescricaoTipoRenovacao(String descricaoTipoRenovacao) {
		this.descricaoTipoRenovacao = descricaoTipoRenovacao;
	}	
	
}
