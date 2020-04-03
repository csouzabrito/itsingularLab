package com.br.itsingular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.itsingular.entity.Login;
import com.br.itsingular.services.LoginService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	
	@Autowired
	private LoginService service;
	
	@PostMapping("/registrar")
	public Login save( final Login login){
		Login l = Login.builder()
				.name("itSingular")
				.username("itsingular@it.com.br")
				.password("1234").build();
			
		return this.service.salvarUsuario(l);
	}
}
