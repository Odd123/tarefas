package br.usjt.projeto.service;

import br.usjt.projeto.dao.AtividadeDAO;
import br.usjt.projeto.model.Atividade;

public class atividadeService {
	
	AtividadeDAO atividadeDAO;
	
	public atividadeService() {
		this.atividadeDAO = new AtividadeDAO();
		
	}
	
	public void cadastrar(Atividade atividade) {
		this.atividadeDAO.cadastrar(atividade);
	}
	
	public void Atualizar(Atividade atividade) {
		this.atividadeDAO.atualizar(atividade);
	}
	public void excluir(Atividade atividade) {
		this.atividadeDAO.excluir(atividade);
	}


}
