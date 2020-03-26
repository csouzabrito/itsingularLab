package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.model.Login;
import com.br.itsingular.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	public Login salvarUsuario(final Login login) {
		
		Login usuario = this.repository.save(login);
		
		return usuario;
	}

	public Login findUser(final Login login) {
			
		Login user = this.repository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		
		return user;
		
	}
	
}
