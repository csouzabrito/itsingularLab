package com.br.itsingular.controller;

import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.entity.Tecnologias;
import com.br.itsingular.services.CadastrarTecnologiasServices;
import com.br.itsingular.services.EmailServices;
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
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;
	
	@Autowired
	private EmailServices emailServices;

	@RequestMapping(value = "/abrir", method = RequestMethod.GET)
	public ModelAndView main( Requisicao requisicao) {
		
		ModelAndView modelAndView = new ModelAndView("/RequisicaoVagas");
		
		Object username = session.getAttribute("email");
		
		if(!Utils.isEmptyOrNull(requisicao)) { 
			requisicao = new Requisicao();
			
			requisicao.setNomeSolicitante(String.valueOf(username));
			requisicao.setDataSolicitacao(LocalDate.now());
			modelAndView.addObject("requisicao", requisicao);
		}
		modelAndView.addObject("listTecnologias",  listTecnologias());
		return modelAndView;
	}
	
	@RequestMapping(path = "/addRequisicao", method = RequestMethod.POST)
	public ModelAndView addRequisicao(@Valid Requisicao requisicao, BindingResult result) {
		
		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("/RequisicaoVagas");
		modelAndView.addObject("listTecnologias",  listTecnologias());
		if (!Utils.isEmptyOrNull(requisicaoServices.salvarRequisicao(requisicao))) {
			modelAndView.addObject("message","Success");
			//EnviarEmail 
			try {
				enviarEmailPosRequisicao(Integer.valueOf(requisicao.getVagas()),requisicao.getNomeSolicitante(), 
						requisicao.getCliente(),requisicao.getDataSolicitacao());
				modelAndView.addObject("requisicao", new Requisicao());
				modelAndView.addObject("message","emailSuccess");
			} catch (Exception e) {
				modelAndView.addObject("message","emailErro");
			}
			return modelAndView;
		}
		
		modelAndView.addObject("message","error");
		return modelAndView;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Tecnologias> listTecnologias(){
		return cadastrarTecnologiasServices.findTecnologias();
	}
	/**
	 * @throws MessagingException 
	 * 
	 */
	public void enviarEmailPosRequisicao(int quantidadeVagas, String requisitante, String cliente, LocalDate dataAbertura) throws MessagingException {
		emailServices.enviarEmail(quantidadeVagas, dataAbertura, requisitante, cliente);
	}
}
