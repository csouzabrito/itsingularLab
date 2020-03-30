/**
 * 
 */
package com.br.itsingular.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Cursos;
import com.br.itsingular.services.CadastrarCursosServices;
import com.br.itsingular.utils.Utils;

/**
 * @author dcarneiro
 *
 */
@Controller
@RequestMapping(value = "/cadastrarCursos")
public class CadastrarCursosController {

	@Autowired
	private CadastrarCursosServices services;
	
	private List<Cursos> listCursos;
	
	@RequestMapping(path = "/listar")
	public ModelAndView inicio() {
		ModelAndView model = new ModelAndView("/CadastrarCursos");
		model.addObject("cursos", new Cursos());
		listCursos = services.findCursos();
		if(listCursos.isEmpty()) {
			return model;
		}
		model.addObject("listCursos",listCursos);
		return model;
	}
	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView insertCursos(@Valid Cursos cursos, BindingResult result) {
		ModelAndView model = new ModelAndView("/CadastrarCursos");
		try {
			if(result.hasErrors()) {
				model.addObject("cursos", new Cursos() );
				model.addObject("listCursos",listCursos);
				return model;
			}
			if(Utils.isEmptyOrNull(cursos.getId())) {
				services.insertCurso(complementar(cursos));
			}else {
				String aux = cursos.getId();
				cursos.setId(null);
				services.UpdateCursos(aux, complementar(cursos));
			}
			listCursos= services.findCursos();
			cursos.setCursos(listCursos);
			model.addObject("cursos", new Cursos() );
			model.addObject("listCursos",listCursos);
			model.addObject("message","Success");
		} catch (Exception e) {
			model.addObject("error",e.getMessage().toString());
		}
		return model;
		
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id")String id, Cursos cursos) {
		ModelAndView model = new ModelAndView("/CadastrarCursos");
		try {
			services.deleteCursos(id);
			listCursos= services.findCursos();
			cursos.setCursos(listCursos);
			model.addObject("cursos", new Cursos() );
			model.addObject("listCursos",listCursos);
			model.addObject("message","Success");
		} catch (Exception e) {
			model.addObject("error",e.getMessage().toString());
		}
		return model;
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id")String id) {
		ModelAndView model = new ModelAndView("/CadastrarCursos");
		Optional<Cursos> tst = services.findCursosById(id);
		Cursos cursos = new Cursos();
		cursos.setId(tst.get().getId());
		cursos.setNomeCurso(tst.get().getNomeCurso());
		cursos.setVersao(tst.get().getVersao());
		cursos.setDescricaoResumida(tst.get().getDescricaoResumida());
		cursos.setCursos(tst.get().getCursos());
		model.addObject("cursos", cursos );
		model.addObject("listCursos",services.findCursos());
		return model;
		
	}
	
	
	public Cursos complementar(Cursos cursos) {
		cursos.setDataInclOrManut(new Date());
		cursos.setUsuario("Usuário Logado");
		return cursos;
	}
	
	public List<Cursos> getListCursos() {
		return listCursos;
	}
	public void setListCursos(List<Cursos> listCursos) {
		this.listCursos = listCursos;
	}
	
	
}
