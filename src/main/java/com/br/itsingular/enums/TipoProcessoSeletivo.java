/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoProcessoSeletivo {

	ENTREVISTA_PRESENCIAL(1, "ENTREVISTA PRESENCIAL"),
	ENTREVISTA_REMOTA(2 ,"ENTREVISTA REMOTA"),
	CONFERIR_DADOS(3,"CONFERIR DADOS"),
	APLICACAO_TESTES(4, "APLICACAO_TESTES");
	
	private Integer tipoProcessoSeletivo;
	private String descricaotipoProcessoSeletivo;
	
	private TipoProcessoSeletivo(Integer tipoProcessoSeletivo, String descricaotipoProcessoSeletivo){
		this.tipoProcessoSeletivo = tipoProcessoSeletivo;
		this.descricaotipoProcessoSeletivo = descricaotipoProcessoSeletivo;
	}
	public String getDescricaotipoProcessoSeletivo() {
		return descricaotipoProcessoSeletivo;
	}
	public void setDescricaotipoProcessoSeletivo(String descricaotipoProcessoSeletivo) {
		this.descricaotipoProcessoSeletivo = descricaotipoProcessoSeletivo;
	}
	public void setTipoProcessoSeletivo(Integer tipoProcessoSeletivo) {
		this.tipoProcessoSeletivo = tipoProcessoSeletivo;
	}
	public Integer getTipoProcessoSeletivo() {
		return tipoProcessoSeletivo;
	}
	
}
