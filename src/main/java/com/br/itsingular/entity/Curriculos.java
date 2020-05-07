package com.br.itsingular.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.br.itsingular.enums.TipoCargo;
import com.br.itsingular.enums.TipoNivel;
import com.br.itsingular.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "CADASTRAR_CURRICULOS")
public class Curriculos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "Campo obrigatório")
	private String cpf;
	
	private String[] tecnologiasAssociadas;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Campo obrigatório")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "Campo obrigatório")
	private String telCelular;
	
	@NotBlank(message = "Campo obrigatório")
	private String email;

	private String telCelularSecundario;

	@Email
	private String emailSecundario;
	
	@NotBlank(message = "Campo obrigatório")
	private String formaContratacaoPrimaria;
	
	@NotBlank(message = "Campo obrigatório")
	private String valorContratacaoPrimaria;
	
	private String formaContratacaoSecundaria;
	
	private String valorContratacaoSecundaria;
	
    private TipagemArquivosUpload uploadDownloadPdf;
	
    private TipagemArquivosUpload uploadDownloadWord;
    
	@NotNull(message = "Campo obrigatório")
	@Enumerated(EnumType.STRING)
    private TipoCargo tipoCargo;
	
	@NotNull(message = "Campo obrigatório")
	@Enumerated(EnumType.STRING)
    private TipoNivel tipoNivel;

	@Transient
	private MultipartFile pdf;
	
	@Transient
	private MultipartFile word;
	

	public String getDataNascimentoFormat() {
		return Utils.formatDate(this.getDataNascimento());
	}
	
}
