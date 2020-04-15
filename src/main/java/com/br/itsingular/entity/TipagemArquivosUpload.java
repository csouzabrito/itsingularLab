package com.br.itsingular.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipagemArquivosUpload {
	
	public String nameArquivo;

	public String desConteudoArquivo;
	
	public String type;
	
	public byte[] bitesArquivo;

}