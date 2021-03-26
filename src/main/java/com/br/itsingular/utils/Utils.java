/**
 * 
 */
package com.br.itsingular.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * @author dcarneiro
 *
 */
public class Utils {

	public static final String EMPTY = "";
	public static final String ERROR_DUPLICATE_KEY = "11000";
	public static final String EMAIL_RH = "dcarneiro@itsingular.com.br";
	public static final String EMAIL_LIDER_RH = "ymorais@itsingular.com.br";
	public static final String EMAIL_RESP_TECNICO = "suporte@itsingular.com.br";
	public static final String EMAIL_DIRETORIA = "gdmingues@itsingular.com.br";
	//public static final String EMAIL_DIRETORIA = "gdomingues@itsingular.com.br";	
	public static final String ASSUNTO_REQUISICAO_VAGA = "REQUISIÇÃO DE VAGAS";
	public static final String ASSUNTO_NOVO_FUNCIONARIO = "NOVO FUNCIONÁRIO";
	public static final String ASSUNTO_NOVO_FUNCIONARIO_AREA_TECNICA = "NOVO FUNCIONÁRIO - ANALISE TÉCNICA";


	public static <S> Boolean isEmptyOrNull(S entity) {
		return entity == null || entity.equals(EMPTY);
	}

	public static String formatDate(LocalDate d) {
		if (Optional.ofNullable(d).isPresent()) {
			return d.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
		}
		return "<S/D>";
	}

	public static String toLocalDateFormat(LocalDate date) {
		if (Optional.ofNullable(date).isPresent()) {
			return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		return "<S/D>";
	}

	public static <T> Page<T> toPageable(final List<T> list) {
		final Page<T> pageble = new PageImpl<>(list);
		return pageble;
	}

	public static String descriptografiaBase64Decoder(String valorCriptografado) {
		return new String(new Base64().decode(valorCriptografado));
	}

	public static String criptografiaBase64Encoder(String valor) {
		return new Base64().encodeToString(valor.getBytes());
	}
}