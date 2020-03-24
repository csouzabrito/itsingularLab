/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoProcessoSeletivo {

	ENTREVISTA_PRESENCIAL(1,"ENTREVISTA-PRESENCIAL"),
	ENTREVISTA_REMOTA(2,"ENTREVISTA-REMOTA"),
	CONFERIR_DADOS(3,"CONFERIR-DADOS"),
	APLICACAO_TESTES(4,"APLICAÇÃO-TESTES");
	
	private Integer tipoProcessoSeletivo;
	private String descricaoProcessoSeletivo;
	
	TipoProcessoSeletivo(Integer tipoProcessoSeletivo, String descricaoProcessoSeletivo){
		this.tipoProcessoSeletivo = tipoProcessoSeletivo;
		this.descricaoProcessoSeletivo = descricaoProcessoSeletivo;
	}
	public Integer getTipoProcessoSeletivo() {
		return tipoProcessoSeletivo;
	}
	public void setTipoProcessoSeletivo(Integer tipoProcessoSeletivo) {
		this.tipoProcessoSeletivo = tipoProcessoSeletivo;
	}
	public String getDescricaoProcessoSeletivo() {
		return descricaoProcessoSeletivo;
	}
	public void setDescricaoProcessoSeletivo(String descricaoProcessoSeletivo) {
		this.descricaoProcessoSeletivo = descricaoProcessoSeletivo;
	}
}
