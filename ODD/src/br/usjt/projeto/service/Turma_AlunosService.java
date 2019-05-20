package br.usjt.projeto.service;

import br.usjt.projeto.dao.Turma_alunoDAO;
import br.usjt.projeto.model.Turma_aluno;

public class Turma_AlunosService {

	Turma_alunoDAO turma_alunoDAO;
		
		public Turma_AlunosService() {
			this.turma_alunoDAO = new Turma_alunoDAO();
		}
		
		public void cadastrar(Turma_aluno turma_aluno) {
			this.turma_alunoDAO.cadastrar(turma_aluno);
		}
		public void Atualizar(Turma_aluno turma_aluno) {
			this.turma_alunoDAO.atualizar(turma_aluno);
		}

}
