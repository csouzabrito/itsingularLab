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
import com.br.itsingular.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/cadastrar-funcionarios")
public class CadastrarFuncionarios {

	@Autowired
	private FuncionariosServices funcionarioServices;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(path = "/init")
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
			return model;
		}
		try {
			if(!Utils.isEmptyOrNull(funcionarios.getId())) {
				update(funcionarios);
				model.addObject("message", "update");
			}else {
				funcionarioServices.insert(funcionarios);
				model.addObject("message", "insert");
			}
			model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
			model.addObject("funcionarios", new Funcionarios());
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
//	@ResponseBody
//	@RequestMapping("/consultarCep/cep")
//	public ResponseEntity<String> consultarCep(@PathParam("cep") String cep) {
//		log.debug("=================="+cep);
//		RestTemplate restTemplate = new RestTemplate(); //1
//		String url = "https://viacep.com.br/ws/'"+cep+"'/json/"; //2
//		return restTemplate.getForEntity(url, String.class);
//	}
	
	
	private void update(Funcionarios funcionarios) {
		try {
			funcionarioServices.update(funcionarios);
		} catch (Exception e) {
			log.debug("Error -- " +  e.getMessage());
		}
	}
}
