package com.br.itsingular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.itsingular.model.Login;
import com.br.itsingular.services.LoginService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	
	@Autowired
	private LoginService service;
	
	@PostMapping("/registrar")
	public Login save(@Validated @RequestBody final Login login){
		return this.service.salvarUsuario(login);
	}
}
