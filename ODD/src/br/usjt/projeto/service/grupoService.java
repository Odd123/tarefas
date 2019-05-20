package br.usjt.projeto.service;

import br.usjt.projeto.dao.GrupoDAO;
import br.usjt.projeto.model.Grupo;

public class grupoService {
	
	GrupoDAO grupoDAO;
	
	public grupoService() {
		this.grupoDAO = new GrupoDAO();
	}
	public void cadastrar(Grupo grupo) {
		this.grupoDAO.cadastrar(grupo);
	}
	public void Atualizar(Grupo grupo) {
		this.grupoDAO.atualizar(grupo);
	}

}
