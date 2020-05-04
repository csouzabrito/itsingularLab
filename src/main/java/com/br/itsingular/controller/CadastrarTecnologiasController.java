/**
 * 
 */
package com.br.itsingular.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Login;
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
	private HttpSession session;

	@Autowired
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;

	@Getter
	private List<Tecnologias> listTecnologias;

	@RequestMapping(path = "/listar")
	public ModelAndView init() {
		ModelAndView model = new ModelAndView("CadastrarTecnologias");
		model.addObject("tecnologias", new Tecnologias());
		listTecnologias = cadastrarTecnologiasServices.findTecnologias();
		if (listTecnologias.isEmpty()) {
			return model;
		}
		model.addObject("login",session.getAttribute("login"));
		model.addObject("listTecnologias", listTecnologias);
		return model;
	}

	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView insertTecnologias(@Valid Tecnologias tec, BindingResult result) {
		ModelAndView model = new ModelAndView("CadastrarTecnologias");
		model.addObject("login", session.getAttribute("login"));
		String mensagem = null;
		try {
			if (result.hasErrors()) {
				model.addObject("tecnologias", new Tecnologias());
				model.addObject("listTecnologias", cadastrarTecnologiasServices.findTecnologias());
				return model;
			}
			if (Utils.isEmptyOrNull(tec.getId())) {
				tec.setId(null);
				cadastrarTecnologiasServices.insertTecnologias(tec);
				mensagem = "Success";
			} else {
				cadastrarTecnologiasServices.updateTecnologias(tec.getId(), tec);
				mensagem = "Edit";
			}
			mensagem = "Success";
		} catch (Exception e) {
			mensagem = "Failed";
		}
		model.addObject("tecnologias", new Tecnologias());
		model.addObject("listTecnologias", cadastrarTecnologiasServices.findTecnologias());
		model.addObject("message", mensagem);
		return model;

	}

	@RequestMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") String id, Tecnologias cursos, Login login) {
		ModelAndView model = new ModelAndView("CadastrarTecnologias");
		model.addObject("login", session.getAttribute("login"));
		model.addObject("tecnologias", new Tecnologias());
		String mensagem = null;
		try {
			cadastrarTecnologiasServices.deleteTecnologias(id);
			listTecnologias = cadastrarTecnologiasServices.findTecnologias();
			mensagem = "Delete";
		} catch (Exception e) {
			mensagem = "Failed";
		}
		model.addObject("listTecnologias", listTecnologias);
		model.addObject("message", mensagem);
		return model;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		ModelAndView model = new ModelAndView("CadastrarTecnologias");
		Optional<Tecnologias> tst = cadastrarTecnologiasServices.findTecnologiasById(id);
		model.addObject("tecnologias", new Tecnologias(tst.get().getId(), tst.get().getNomeCurso(),
				tst.get().getVersao(), tst.get().getDescricaoResumida(), null, null));
		listTecnologias = cadastrarTecnologiasServices.findTecnologias();
		model.addObject("listTecnologias", listTecnologias);
		model.addObject("login", session.getAttribute("login"));
		return model;
	}
}
