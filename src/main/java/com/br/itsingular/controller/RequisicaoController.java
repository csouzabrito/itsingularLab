package com.br.itsingular.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Cursos;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.services.CadastrarCursosServices;
import com.br.itsingular.services.RequisicaoServices;
import com.br.itsingular.utils.Utils;

@Controller
@RequestMapping(value = "/requisicao")
public class RequisicaoController {
	
	@Autowired
	private RequisicaoServices requisicaoServices;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private CadastrarCursosServices cursosServices;

	@RequestMapping(value = "/abrir", method = RequestMethod.GET)
	public ModelAndView main( Requisicao requisicao) {
		
		ModelAndView modelAndView = new ModelAndView("RequisicaoVagas");
		
		Object username = session.getAttribute("email");
		
		if(!Utils.isEmptyOrNull(requisicao)) { 
			requisicao = new Requisicao();
			
			requisicao.setNomeSolicitante(String.valueOf(username));
			requisicao.setDataSolicitacao(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			modelAndView.addObject("requisicao", requisicao);
		}
		modelAndView.addObject("listCursos",  listCursos());
		return modelAndView;
	}
	
	@RequestMapping(path = "/addRequisicao", method = RequestMethod.POST)
	public ModelAndView addRequisicao(@Valid Requisicao requisicao, BindingResult result) {
		
		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("RequisicaoVagas");
		modelAndView.addObject("listCursos",  listCursos());
		if (!Utils.isEmptyOrNull(requisicaoServices.salvarRequisicao(requisicao))) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("requisicao", new Requisicao());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Cursos> listCursos(){
		return cursosServices.findCursos();
	}
}
