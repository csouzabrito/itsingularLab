/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoRenovacao {

	ALTA("ALTA"),
	BAIXA("BAIXA"),
	INEXISTENTE("INEXISTENTE");
	
	private String tipoRenovacao;

	private TipoRenovacao(String tipoRenovacao) {
		this.tipoRenovacao = tipoRenovacao;
		
	}	
	public String getTipoRenovacao() {
		return tipoRenovacao;
	}
	public void setTipoRenovacao(String tipoRenovacao) {
		this.tipoRenovacao = tipoRenovacao;
	}	
}
