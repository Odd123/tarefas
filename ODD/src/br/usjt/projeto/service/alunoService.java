package br.usjt.projeto.service;

import br.usjt.projeto.dao.AlunoDAO;
import br.usjt.projeto.model.Aluno;

public class alunoService {
	AlunoDAO alunoDAO;
	
	public alunoService() {
		this.alunoDAO = new AlunoDAO();
	}
	
	public void cadastrar(Aluno aluno) {
		this.alunoDAO.cadastrar(aluno);
	}
	public void atualizar(Aluno aluno) {
		this.alunoDAO.atualizar(aluno);
	}
	public void excluir(Aluno aluno) {
		this.alunoDAO.excluir(aluno);
	}

}
