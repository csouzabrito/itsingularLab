package com.br.itsingular.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Login;
import com.br.itsingular.entity.TipagemArquivosUpload;
import com.br.itsingular.services.CadastrarCurriculosServices;
import com.br.itsingular.services.CadastrarTecnologiasServices;
import com.br.itsingular.utils.Utils;

@Controller
@RequestMapping(path = "/cadastrarCurriculos")
public class CadastrarCurriculosController {

	@Autowired
	private HttpSession session;

	@Autowired
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;

	@Autowired
	private CadastrarCurriculosServices cadastrarCurriculosServices;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = getAddModel("init", 1);
		return model;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView incluirCurriculos(@RequestParam("pdf") MultipartFile pdf,
			@RequestParam("word") MultipartFile word, @Valid Curriculos curriculos, BindingResult result, Login login)
			throws IOException {

		String mensagem = null;

		if (result.hasErrors()) {
			return getAddModel("result", 1);
		}

		if (!pdf.getContentType().equalsIgnoreCase("application/pdf")
				|| (!word.getContentType().contains("officedocument"))) {
			return getAddModel("upload", 1);
		}
		try {

			curriculos.setUploadDownloadPdf(new TipagemArquivosUpload(pdf.getOriginalFilename(), pdf.getName(),
					pdf.getContentType(), pdf.getBytes()));
			curriculos.setUploadDownloadWord(new TipagemArquivosUpload(word.getOriginalFilename(), word.getName(),
					word.getContentType(), word.getBytes()));

			if (Utils.isEmptyOrNull(curriculos.getCpf())) {
				cadastrarCurriculosServices.save(curriculos);
			} else {
				cadastrarCurriculosServices.removeAndInsertCurriculos(curriculos);
			}
			mensagem = "success";
		} catch (Exception e) {
			if (e.getMessage().contains(Utils.ERROR_DUPLICATE_KEY)) {
				mensagem = "duplicateInsert";
			} else {
				mensagem = "failed";
			}
		}
		return getAddModel(mensagem, 1);
	}

	@RequestMapping("/viewPdf/{cpf}")
	public void viewPdf(@PathVariable("cpf") String cpf, HttpServletRequest req, HttpServletResponse response)
			throws IOException {

		Optional<Curriculos> infoCandidato = Optional
				.ofNullable(cadastrarCurriculosServices.findCurriculoById(cpf).get());

		response.setContentType(infoCandidato.get().getUploadDownloadPdf().getType() + ";charset=UTF-8");
		response.setContentLength(infoCandidato.get().getUploadDownloadPdf().getBitesArquivo().length);
		response.setHeader("Content-Disposition", "attachment; charset=utf-8; filename=\""
				+ infoCandidato.get().getUploadDownloadPdf().getNameArquivo() + "\"");

		FileCopyUtils.copy(infoCandidato.get().getUploadDownloadPdf().getBitesArquivo(), response.getOutputStream());
		response.getOutputStream().flush();

	}

	@RequestMapping("/viewWord/{cpf}")
	public void viewWord(@PathVariable("cpf") String cpf, HttpServletRequest req, HttpServletResponse response)
			throws IOException {

		Optional<Curriculos> infoCandidato = Optional
				.ofNullable(cadastrarCurriculosServices.findCurriculoById(cpf).get());

		response.setContentType(infoCandidato.get().getUploadDownloadWord().getType() + ";charset=UTF-8");
		response.setContentLength(infoCandidato.get().getUploadDownloadWord().getBitesArquivo().length);
		response.setHeader("Content-Disposition", "attachment; charset=utf-8; filename=\""
				+ infoCandidato.get().getUploadDownloadWord().getNameArquivo() + "\"");

		FileCopyUtils.copy(infoCandidato.get().getUploadDownloadWord().getBitesArquivo(), response.getOutputStream());
		response.getOutputStream().flush();

	}

	@RequestMapping("/editar/{cpf}")
	public ModelAndView editar(@PathVariable("cpf") String cpf) {
		ModelAndView model = getAddModel("edit", 1);
		model.addObject("curriculos", Optional.ofNullable(cadastrarCurriculosServices.findCurriculoById(cpf).get()));
		return model;
	}

	private ModelAndView getAddModel(String mensagem, int page) {
		ModelAndView model = new ModelAndView("/CadastrarCurriculos");

		// Inicializacao do objeto Curriculos
		// Quando inicia a funcionalidade
		// Quando realizar uma operacao dos dados
		// Qquando realiza a paginacao
		if (mensagem.equals("success") || mensagem.equals("init") || mensagem.equals("paginacao")) {
			model.addObject("curriculos", new Curriculos());
		}
		model.addObject("listCursos", cadastrarTecnologiasServices.findTecnologias());
		PageRequest pageable = PageRequest.of(page - 1, 3);
		Page<Curriculos> listCurriculos = cadastrarCurriculosServices.findCurriculos(pageable);
		int totalPages = listCurriculos.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addObject("pageNumbers", pageNumbers);
		}
		model.addObject("listCurriculos", listCurriculos);
		model.addObject("login", session.getAttribute("login"));

		if (!mensagem.equals("init") && !mensagem.equals("paginacao")) {
			model.addObject("message", mensagem);
		}
		return model;
	}

	@RequestMapping("/paginacao/{page}")
	public ModelAndView listArticlesPageByPage(@PathVariable("page") String page) {
		return getAddModel("paginacao", Integer.valueOf(page.trim()));
	}

}
