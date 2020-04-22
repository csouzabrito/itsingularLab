package com.br.itsingular.configuration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class LdapConfig {
	@Value("${ldap.urls}")
	private String ldapUrls;
	@Value("${ldap.base.dn}")
	private String ldapBaseDn;

	public Boolean autenticacao(final String username, final String password) throws Exception {

		LdapTemplate ldapTemplate = new LdapTemplate(atribuirValorLdapContext(username, password));
		ldapTemplate.afterPropertiesSet();
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("userPrincipalName", username));
		return ldapTemplate.authenticate("", filter.toString(), password);
	}

	private LdapContextSource atribuirValorLdapContext(final String username, final String password) {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl(ldapUrls);
		contextSource.setBase(ldapBaseDn);
		contextSource.setUserDn(username);
		contextSource.setPassword(password);
		contextSource.afterPropertiesSet();
		return contextSource;
	}

	public List<String> searchName(String username, final String password) {
		LdapTemplate ldapTemplate = new LdapTemplate(atribuirValorLdapContext(username, password));
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("userPrincipalName", username));
		return ldapTemplate.
					search("", filter.toString(), (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
	}
}
