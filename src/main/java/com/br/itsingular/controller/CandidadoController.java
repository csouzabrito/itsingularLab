package com.br.itsingular.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Candidado;
import com.br.itsingular.enums.DisponibilidadeEnum;
import com.br.itsingular.enums.IdiomaEnum;
import com.br.itsingular.enums.NivelIdioma;
import com.br.itsingular.repository.CandidatoRepository;

@Controller
@RequestMapping(value = "/candidatos")
public class CandidadoController {
	
	@Autowired
	private CandidatoRepository repository;
	
	@RequestMapping("/informacoes")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView("Candidatos");
		view.addObject("candidato", new Candidado());
		return view;
	}
	
	@PostMapping("/salvar-informacoes")
	public ModelAndView criar(@Validated Candidado candidado, BindingResult result){
		
		if(result.hasErrors()){
			return new ModelAndView("Candidatos");
		}
		try{
			ModelAndView view = new ModelAndView("Candidatos");
			Candidado save = this.repository.save(candidado);
			view.addObject("message","Success");
			view.addObject("candidato", new Candidado());
			return view;
		}catch(IllegalArgumentException e){
			throw new RuntimeException("Erro ao salvar as informacoes{}", e) ;
		}
	}
	
	@ModelAttribute("allStatusDisponibilidade")
	public List<DisponibilidadeEnum> statusDisponibilidade(){
		return Arrays.asList(DisponibilidadeEnum.values());
	}
	
	@ModelAttribute("allStatusIdioma")
	public List<IdiomaEnum> statusIdioma(){
		return Arrays.asList(IdiomaEnum.values());
	}
	
	@ModelAttribute("allNivelIdioma")
	public List<NivelIdioma> niveisIdioma(){
		return Arrays.asList(NivelIdioma.values());
	}

}
