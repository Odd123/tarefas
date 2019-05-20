package br.usjt.projeto.service;

import br.usjt.projeto.dao.Professor_bancaDAO;
import br.usjt.projeto.model.Professor_banca;

public class profBancaService {
	
	Professor_bancaDAO professor_bancaDAO;
	
	public profBancaService() {
		this.professor_bancaDAO = new Professor_bancaDAO();
	}
	public void cadastrar(Professor_banca professor_banca) {
		this.professor_bancaDAO.cadastrar(professor_banca);
	}
	public void Atualizar(Professor_banca professor_banca) {
		this.professor_bancaDAO.atualizar(professor_banca);
	}

}
