/**
 * 
 */
package com.br.itsingular.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Login;
import com.br.itsingular.entity.Tecnologias;
import com.br.itsingular.services.CadastrarTecnologiasServices;
import com.br.itsingular.utils.PageWrapper;
import com.br.itsingular.utils.Utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dcarneiro
 *
 */
@Slf4j
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
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarTecnologias / init");
		ModelAndView model = new ModelAndView("CadastrarTecnologias");
		model.addObject("login",session.getAttribute("login"));
		model.addObject("tecnologias", new Tecnologias());
		model = getListagem(model, 0,0);
		return model;
	}
	private ModelAndView getListagem(final ModelAndView model, final int page, final int size) {
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarTecnologias / getListagem");
		Page<Tecnologias> listTecnologias = cadastrarTecnologiasServices.findTecnologias(page, size==0?5:size);
		PageWrapper<Tecnologias> curriculosPage = new PageWrapper<Tecnologias>(listTecnologias, "/cadastrarTecnologias/listar?page="+page+"/size="+size);
		model.addObject("listTecnologias", listTecnologias) ;
		model.addObject("page", curriculosPage);
		log.info("------ Rastrabilidade. Finalizando funcionalidade de CadastrarTecnologias / getListagem");
		return model;
		
	}
	@RequestMapping("/paginacao/{page}/{size}")
	public ModelAndView listArticlesPageByPage(@PathVariable("page") int page, 
												@PathVariable("size") int size, 
												ModelAndView model) {
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarTecnologias / listArticlesPageByPage");
		model= new ModelAndView("CadastrarTecnologias");
		model.addObject("login", session.getAttribute("login"));
		model.addObject("tecnologias", new Tecnologias());
		return getListagem(model, page, size);
	}
	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView insertTecnologias(@Valid Tecnologias tec, BindingResult result) {
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarTecnologias / insertTecnologias");
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
			log.error("###### -- FALHA! Cause:" + e.getCause() + "--> Mensagem" + e.getMessage());
			mensagem = "Failed";
		}
		model.addObject("tecnologias", new Tecnologias());
		model = getListagem(model, 0,0);
		model.addObject("message", mensagem);
		return model;

	}

	@RequestMapping("/delete/{id}")
	public ModelAndView excluir(@PathVariable("id") String id, Tecnologias cursos, Login login) {
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarTecnologias / excluir");
		ModelAndView model = new ModelAndView("CadastrarTecnologias");
		model.addObject("login", session.getAttribute("login"));
		model.addObject("tecnologias", new Tecnologias());
		String mensagem = null;
		try {
			cadastrarTecnologiasServices.deleteTecnologias(id);
			listTecnologias = cadastrarTecnologiasServices.findTecnologias();
			mensagem = "Delete";
		} catch (Exception e) {
			log.error("###### -- FALHA! Cause:" + e.getCause() + "--> Mensagem" + e.getMessage());
			mensagem = "Failed";
		}
		model.addObject("listTecnologias", listTecnologias);
		model.addObject("message", mensagem);
		model = getListagem(model, 0,0);
		return model;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarTecnologias / edit");
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
