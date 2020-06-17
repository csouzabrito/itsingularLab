package com.br.itsingular.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Funcionarios;
import com.br.itsingular.entity.Login;
import com.br.itsingular.services.FuncionariosServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/cadastrar-funcionarios")
public class CadastrarFuncionarios {

	@Autowired
	private FuncionariosServices funcionarioServices;
	
	private HttpSession session;
	
	public ModelAndView init() {
		Login login = (Login)session.getAttribute("login");
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
		model.addObject("login", login);
		model.addObject("funcionarios", new Funcionarios());
		return model;
	
	}
	@RequestMapping(path = "/addFuncionario")
	public ModelAndView add(@Valid Funcionarios funcionarios, BindingResult resul) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", (Login)session.getAttribute("login"));
		if(resul.hasErrors()) {
			model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
		}
		try {
			funcionarioServices.insert(funcionarios);
			model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
			model.addObject("funcionarios", new Funcionarios());
			model.addObject("message", "insert");
		} catch (Exception e) {
			model.addObject("message", "error");
			log.debug("Error -- " +  e.getMessage());
		}
		return model;
	}
	
	@RequestMapping(path="/findById/{id}")
	public ModelAndView findById(@PathVariable("id") String id) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", (Login)session.getAttribute("login"));
		
		Optional<Funcionarios> funcionarios = funcionarioServices.findFuncionariosById(id);
		if(funcionarios.isPresent()) {
			model.addObject("funcionarios", funcionarios);
		}		
		return model;
	}
	
	public ModelAndView update(@Valid Funcionarios funcionarios, BindingResult resul) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", (Login)session.getAttribute("login"));
		
		try {
			if(resul.hasErrors()) {
				return 	model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
			}
			funcionarioServices.update(funcionarios);
			model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
			model.addObject("message", "update");
		} catch (Exception e) {
			model.addObject("message", "error");
			log.debug("Error -- " +  e.getMessage());
		}
		return model;
	}
}
