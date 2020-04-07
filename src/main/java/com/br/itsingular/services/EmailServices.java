/**
 * 
 */
package com.br.itsingular.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.br.itsingular.utils.TemplateEmailUtils;
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
	
	public void enviarEmail(final int quantidadeVagas,final String dataAbertura, 
							final String requisitante, final String cliente) throws MessagingException {
		try {
			MimeMessage mm = emailSend.createMimeMessage();
			String mensagemHtml = TemplateEmailUtils.criarTemplateEmail(quantidadeVagas,dataAbertura,requisitante,cliente);
			//mm.setContent(mensagemHtml, "text/html");
			MimeMessageHelper helper = new MimeMessageHelper(mm, false, "utf-8");
			helper.setTo(Utils.EMAIL_RH);
			helper.setFrom(Utils.EMAIL_RH);
			helper.setSubject(Utils.ASSUNTO_REQUISICAO_VAGA);
			helper.setText(mensagemHtml, true);
			emailSend.send(helper.getMimeMessage());
		} catch (MailException e) {
			throw e;
		}
				
	}
}
