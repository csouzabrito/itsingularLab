package com.br.itsingular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Tecnologias;
import com.br.itsingular.repository.FiltrarCandidatosRepository;

@Service
public class FiltrarCandidatosService {

	@Autowired
	private FiltrarCandidatosRepository filtrarCandidatosReposository;

	@Autowired
	private CadastrarTecnologiasServices tecnologiasServices;

	public List<Curriculos> getCandidatos() {
		List<Curriculos> listaCurriculos = filtrarCandidatosReposository.findAll();
		for (int i = 0; i < listaCurriculos.size(); i++) {
			String[] put = new String[listaCurriculos.get(i).getTecnologiasAssociadas().length];
			for (int k = 0; k < listaCurriculos.get(i).getTecnologiasAssociadas().length; k++) {
				Optional<Tecnologias> findTecnologiasById = 
						tecnologiasServices.findTecnologiasById(listaCurriculos.get(i).getTecnologiasAssociadas()[k]);
				put[k] = findTecnologiasById.get().getNomeCurso();
			}
			listaCurriculos.get(i).setTecnologiasAssociadas(put);
			put = new String[listaCurriculos.get(i).getTecnologiasAssociadas().length];
		}

		return listaCurriculos;

	}

}
