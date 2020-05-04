package com.br.itsingular.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.itsingular.configuration.LdapConfig;
import com.br.itsingular.entity.Login;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private LdapConfig autentication;

	@Autowired
	private HttpSession session;

	@RequestMapping("/view")
	public ModelAndView view(Login login){
		ModelAndView view = new ModelAndView("Login");
		view.addObject("login", new Login());
		return view;
	}
	
	@PostMapping("/users")
	public String login(@Validated Login login, RedirectAttributes attributes) throws Exception {
		String mensagem = null;
		try {
			if (autentication.autenticacao(login.getUsername(), login.getPassword())) {
				login.setName(autentication.searchName(login.getUsername(), login.getPassword()).get(0));
				session.setAttribute("email", login.getUsername());
				session.setAttribute("login", login);
				return "redirect:/login/home";
			}
			mensagem = "errorLogin";
		} catch (Exception e) {
			if (e.getCause().getMessage().contains("data 52e")) { // data 52e quer dizer que não existe o usuário no AD
				mensagem = "usuarioNExiste";
			} else {
				mensagem = "problemaLogin";
			}
		}
		attributes.addFlashAttribute("message", mensagem);
		return "redirect:/login/view";
	}

	@GetMapping("/logout")
	public String logout(@Validated Login login, RedirectAttributes attributes) {
		session.invalidate();
		return "redirect:/login/view";
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView home = new ModelAndView("Home");
		home.addObject("login", session.getAttribute("login"));
		return home;
	}

}
