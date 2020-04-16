/**
 * 
 */
package com.br.itsingular.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Tecnologias;
import com.br.itsingular.services.CadastrarTecnologiasServices;
import com.br.itsingular.utils.Utils;

import lombok.Getter;

/**
 * @author dcarneiro
 *
 */
@Controller
@RequestMapping(value = "/cadastrarTecnologias")
public class CadastrarTecnologiasController {

	@Autowired
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;

	@Getter
	private List<Tecnologias> listTecnologias;

	@RequestMapping(path = "/listar")
	@Cacheable(value = "listarTecnologias")
	public ModelAndView init() {
		ModelAndView model = new ModelAndView("/CadastrarTecnologias");
		model.addObject("tecnologias", new Tecnologias());
		listTecnologias = cadastrarTecnologiasServices.findTecnologias();
		if (listTecnologias.isEmpty()) {
			return model;
		}
		model.addObject("listTecnologias", listTecnologias);
		return model;
	}

	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	@CacheEvict(allEntries = true, value = "listarTecnologias")
	public ModelAndView insertTecnologias(@Valid Tecnologias tec, BindingResult result) {
		ModelAndView model = new ModelAndView("/CadastrarTecnologias");
		try {
			if (result.hasErrors()) {
				model.addObject("tecnologias", new Tecnologias());
				model.addObject("listTecnologias", listTecnologias);
				return model;
			}
			if (Utils.isEmptyOrNull(tec.getId())) {
				tec.setId(null);
				cadastrarTecnologiasServices.insertTecnologias(tec);
			} else {
				cadastrarTecnologiasServices.updateTecnologias(tec.getId(), tec);
			}
			model.addObject("tecnologias", new Tecnologias());
			model.addObject("listTecnologias", 
								cadastrarTecnologiasServices.findTecnologias());
			model.addObject("message", "Success");
		} catch (Exception e) {
			model.addObject("error", e.getMessage().toString());
		}
		return model;

	}

	@RequestMapping("/delete/{id}")
	@CacheEvict(allEntries = true, value = "listarTecnologias")
	public ModelAndView excluir(@PathVariable("id") String id, Tecnologias cursos) {
		ModelAndView model = new ModelAndView("/CadastrarTecnologias");
		try {
			cadastrarTecnologiasServices.deleteTecnologias(id);
			listTecnologias = cadastrarTecnologiasServices.findTecnologias();
			model.addObject("tecnologias", new Tecnologias());
			model.addObject("listTecnologias", listTecnologias);
			model.addObject("message", "Success");
		} catch (Exception e) {
			model.addObject("error", e.getMessage().toString());
		}
		return model;

	}

	@RequestMapping("/edit/{id}")
	@CacheEvict(allEntries = true, value = "listarTecnologias")
	public ModelAndView edit(@PathVariable("id") String id) {
		ModelAndView model = new ModelAndView("/CadastrarTecnologias");
		Optional<Tecnologias> tst = cadastrarTecnologiasServices.findTecnologiasById(id);
		model.addObject("tecnologias", new Tecnologias(tst.get().getId(), tst.get().getNomeCurso(),
				tst.get().getVersao(), tst.get().getDescricaoResumida(),null,null));
		listTecnologias = cadastrarTecnologiasServices.findTecnologias();
		model.addObject("listTecnologias", listTecnologias);
		return model;
	}

}
