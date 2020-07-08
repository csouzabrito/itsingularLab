package com.br.itsingular.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Funcionarios;
import com.br.itsingular.services.EmailServices;
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

	@Autowired
	private EmailServices emailServices;

	@RequestMapping(path = "/init")
	public ModelAndView init() {
		ModelAndView model = new ModelAndView("ListarProfissionais");
		model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
		model.addObject("login", session.getAttribute("login"));
		model.addObject("funcionarios", new Funcionarios());
		return model;

	}

	@RequestMapping(path = "/cadastrar-atualizar-Funcionario")
	public ModelAndView cadastrarAtualizarFuncionario(@Valid Funcionarios funcionarios, BindingResult resul) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", session.getAttribute("login"));
		if (resul.hasErrors()) {
			model.addObject("listarFuncionarios", funcionarioServices.findFuncionarios());
			return model;
		}
		try {
			if (!Utils.isEmptyOrNull(funcionarios.getId())) {
				update(funcionarios);
				model.addObject("message", "update");
			} else {
				funcionarios.setId(null);
				funcionarioServices.insert(funcionarios);
				enviarEmails(funcionarios);
				model.addObject("message", "insert");
			}
			
			model.addObject("funcionarios", new Funcionarios());
		} catch (Exception e) {
			model.addObject("message", "error");
			log.debug("Error -- " + e.getMessage());
		}
		return model;
	}

	@RequestMapping(path = "/findById/{id}")
	public ModelAndView findById(@PathVariable("id") String id) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", session.getAttribute("login"));

		Optional<Funcionarios> funcionarios = funcionarioServices.findFuncionariosById(id);
		if (funcionarios.isPresent()) {
			model.addObject("funcionarios", funcionarios);
		}
		return model;
	}

	private void update(Funcionarios funcionarios) {
		try {
			funcionarioServices.update(funcionarios);
		} catch (Exception e) {
			log.debug("Error -- " + e.getMessage());
		}
	}

	@RequestMapping(path = "/editar/{id}")
	public ModelAndView editar(@PathVariable("id") String id) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", session.getAttribute("login"));
		Optional<Funcionarios> funcionarios = funcionarioServices.findFuncionariosById(id);
		model.addObject("funcionarios", funcionarios);
		return model;
	}

	@RequestMapping(path = "/direcionarTelaCadastro")
	public ModelAndView direcionandoTelaCadastro(@Valid Funcionarios funcionarios, BindingResult resul) {
		ModelAndView model = new ModelAndView("CadastrarFuncionarios");
		model.addObject("login", session.getAttribute("login"));
		model.addObject("funcionarios", new Funcionarios());
		return model;
	}
	private void enviarEmails(Funcionarios funcionarios) {
		try {
			
			enviarEmailCadastroFuncionario(funcionarios.getNome()
					, funcionarios.getDepartamento().name()
					, funcionarios.getGestores().name()
					, funcionarios.getClienteParceiros().name()
					, funcionarios.getDataContratacao());
			
			enviarEmailParaAreaTecnica(funcionarios);
		} catch (Exception e) {
			log.debug("Error -- " + e.getMessage());
		}
		
	
	}
	private void enviarEmailCadastroFuncionario(String nome, String departamento, String gestor, String cliente,
			LocalDate dataInicio) throws MessagingException {
		emailServices.enviarEmailNovaContratacao(nome, departamento, gestor, cliente, dataInicio);
	}
	private void enviarEmailParaAreaTecnica(Funcionarios funcionarios) throws MessagingException {
		emailServices.enviarEmailParaAreaTecnica(funcionarios);
	}
}
