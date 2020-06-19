/**
 * 
 */
package com.br.itsingular.services;

import java.time.LocalDate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.br.itsingular.utils.TemplateEmailNovaContratacao;
import com.br.itsingular.utils.TemplateEmailRequisicao;
import com.br.itsingular.utils.Utils;

/**
 * @author dcarneiro
 *
 */
@Component
public class EmailServices {

	@Autowired
	@Qualifier("gmail")
	private JavaMailSender emailSend;

	public void enviarEmailRequisicao(final int quantidadeVagas, final LocalDate dataAbertura,
			final String requisitante, final String cliente) throws MessagingException {
		try {
			MimeMessage mm = emailSend.createMimeMessage();
			String mensagemHtml = TemplateEmailRequisicao.criarTemplateEmail(quantidadeVagas, dataAbertura,
					requisitante, cliente);
			// mm.setContent(mensagemHtml, "text/html");
			MimeMessageHelper helper = new MimeMessageHelper(mm, false, "utf-8");
			helper.setTo(Utils.EMAIL_RH);
			helper.setCc(Utils.EMAIL_LIDER_RH);
			helper.setSubject(Utils.ASSUNTO_REQUISICAO_VAGA);
			helper.setText(mensagemHtml, true);
			emailSend.send(helper.getMimeMessage());
		} catch (MailException e) {
			throw e;
		}
	}

	public void enviarEmailNovaContratacao(final String nome, final String departamento, final String gestor,
			final String cliente, final LocalDate dataInicio) throws MessagingException {
		try {
			 String mensagemHtml = TemplateEmailNovaContratacao.criarTemplateEmail(nome, departamento, gestor, cliente,
						dataInicio);
			MimeMessage mm = emailSend.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mm, true, "utf-8");
			helper.setTo(Utils.EMAIL_RH);
			helper.setCc(Utils.EMAIL_LIDER_RH);
			helper.setSubject(Utils.ASSUNTO_NOVO_FUNCIONARIO);
			helper.setText(mensagemHtml, true);

			emailSend.send(helper.getMimeMessage());
		} catch (MailException e) {
			throw e;
		}
	}
}
