/**
 * 
 */
package com.br.itsingular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Cursos;
import com.br.itsingular.repository.CadastrarCursosRepository;

/**
 * @author dcarneiro
 *
 */
@Service
public class CadastrarCursosServices {

	@Autowired
	private CadastrarCursosRepository cadCursos;

	/**
	 * 
	 * @param cursos
	 */
	public void insertCurso(Cursos cursos) {
		try {
			cadCursos.insert(cursos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public List<Cursos> findCursos() {
		try {
			return cadCursos.findAll();
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public Optional<Cursos> findCursosById(String id) {
		try {
			return cadCursos.findById(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public void deleteCursos(String id) {
		try {
			cadCursos.deleteById(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public void UpdateCursos(String id, Cursos cursos) {
		try {
			deleteCursos(id);
			insertCurso(cursos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
