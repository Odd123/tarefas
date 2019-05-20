package br.usjt.projeto.service;

import br.usjt.projeto.dao.BancaDAO;
import br.usjt.projeto.model.Banca;

public class bancaService {
	
	BancaDAO bancaDAO;
	
	public bancaService() {
		this.bancaDAO = new BancaDAO();
		
	}
	
	public void cadastrar(Banca banca) {
		this.bancaDAO.cadastrar(banca);
	}
	
	public void Atualizar(Banca banca) {
		this.bancaDAO.atualizar(banca);
	}
	public void excluir(Banca banca) {
		this.bancaDAO.excluir(banca);
	}



}
