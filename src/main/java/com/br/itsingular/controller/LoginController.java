package com.br.itsingular.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.itsingular.entity.Login;
import com.br.itsingular.messages.Messages;
import com.br.itsingular.services.LoginService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/view")
	public ModelAndView novo(Login login){
		ModelAndView view = new ModelAndView("Login");
		view.addObject("login", new Login());
		return view;
	}
	
	@PostMapping("/users")
	public String login(@Validated Login login, RedirectAttributes attributes, HttpSession session){
		
		final String page = "Login";
		
		Login user = this.service.findUser(login);
		
		if(Objects.nonNull(user)) {
			 session.setAttribute("name", user.getName());
			 session.setAttribute("email", user.getUsername());
			 return "redirect:/requisicao/abrir";
		}else {
			Messages.setMessage(attributes, "message", "Erro ao logar, tente novamente");
		}
		
		return page;
	}
	
	@PostMapping("/logout")
	public String logout(@Validated Login login, RedirectAttributes attributes, HttpSession session) {
		session.invalidate();
		return "redirect:/login/view";
	}
}
