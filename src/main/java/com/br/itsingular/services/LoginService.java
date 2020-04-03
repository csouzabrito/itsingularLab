package com.br.itsingular.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Login;
import com.br.itsingular.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	@Transactional
	public Login salvarUsuario(final Login login) {
		return this.repository.save(login);
	}

	public Login findUser(final Login login) {
			
		Login user = this.repository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		
		return user;
		
	}
	
}
