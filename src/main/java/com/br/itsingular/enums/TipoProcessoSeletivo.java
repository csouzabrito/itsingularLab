/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoProcessoSeletivo {

	ENTREVISTA_PRESENCIAL("1"),
	ENTREVISTA_REMOTA("2"),
	CONFERIR_DADOS("3"),
	APLICACAO_TESTES("4");
	
	private String tipoProcessoSeletivo;
	
	private TipoProcessoSeletivo(String tipoProcessoSeletivo){
		this.tipoProcessoSeletivo = tipoProcessoSeletivo;
	
	}
	public String getTipoProcessoSeletivo() {
		return tipoProcessoSeletivo;
	}
	public void setTipoProcessoSeletivo(String tipoProcessoSeletivo) {
		this.tipoProcessoSeletivo = tipoProcessoSeletivo;
	}
	
}
