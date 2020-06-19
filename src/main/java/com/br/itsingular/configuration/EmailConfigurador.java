/**
 * 
 */
package com.br.itsingular.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.br.itsingular.utils.Utils;

/**
 * @author dcarneiro
 *
 */
@Configuration
public class EmailConfigurador {

	@Autowired
	private Environment env;

	@Bean("gmail")
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(env.getProperty("spring.mail.host"));
		mailSender.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));
		mailSender.setUsername(env.getProperty("spring.mail.username"));
		mailSender.setPassword(Utils.descriptografiaBase64Decoder(env.getProperty("spring.mail.password")));
		mailSender.setDefaultEncoding("utf-8");

		Properties javaMailProperties = new Properties();
		
		javaMailProperties.put("mail.smtp.starttls.enable", "false");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");
		javaMailProperties.put("mail.smtp.socketFactory.port", Integer.valueOf(env.getProperty("spring.mail.port")));
		javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		javaMailProperties.put("mail.smtp.auth", true);


		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
}
