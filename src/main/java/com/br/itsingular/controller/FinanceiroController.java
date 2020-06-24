/**
 * 
 */
package com.br.itsingular.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Funcionarios;
import com.br.itsingular.services.FinanceiroService;

/**
 * @author dcarneiro
 *
 */
@Controller
@RequestMapping(path = "/financeiro")
public class FinanceiroController {

	@Autowired
	private FinanceiroService financeiroServices;
	
	@Autowired
	private HttpSession session;

	@GetMapping(path = "/pagamento")
	public ModelAndView init() {
		ModelAndView model = new ModelAndView("Pagamentos");
		model.addObject("listaFuncionariosPagamento", financeiroServices.findFuncionarios());
		model.addObject("login", session.getAttribute("login"));
		model.addObject("funcionarios", new Funcionarios());
		return model;
	}
}
