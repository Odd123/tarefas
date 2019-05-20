package br.usjt.projeto.service;

import br.usjt.projeto.dao.ProfessorDAO;
import br.usjt.projeto.model.Professor;

public class professorService {
	
	ProfessorDAO professorDAO;
	
	public professorService() {
		this.professorDAO = new ProfessorDAO();
	}
	public void cadastrar(Professor professor) {
		this.professorDAO.cadastrar(professor);
	}
	public void Atualizar(Professor professor) {
		this.professorDAO.atualizar(professor);
	}


}
