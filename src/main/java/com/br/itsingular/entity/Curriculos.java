package com.br.itsingular.entity;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.br.itsingular.enums.FerramentasBusca;
import com.br.itsingular.enums.TipoCargo;
import com.br.itsingular.enums.TipoNivel;
import com.br.itsingular.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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
	
	@NotNull(message = "Campo obrigatório")
	@Enumerated(EnumType.STRING)
	private FerramentasBusca tipoFerramentaBusca;
	
	private String linkedin;

	@LastModifiedDate
	private LocalDate dataUltimaAtualizacao;
	
	public String getDataNascimentoFormat() {
		return Utils.formatDate(this.getDataNascimento());
	}
	public String getTecnologiasAssociadas2() {
		return  Arrays.toString(tecnologiasAssociadas);
	}
}
