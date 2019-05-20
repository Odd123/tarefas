package br.usjt.projeto.service;

import br.usjt.projeto.dao.TurmaDAO;
import br.usjt.projeto.model.Turma;

public class turmaService {
	
	TurmaDAO turmaDAO;
	
	public turmaService() {
		this.turmaDAO = new TurmaDAO();
	}
	public void cadastrar(Turma turma) {
		this.turmaDAO.cadastrar(turma);
	}
	public void Atualizar(Turma turma) {
		this.turmaDAO.atualizar(turma);
	}


}
