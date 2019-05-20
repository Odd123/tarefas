package br.usjt.projeto.service;

import br.usjt.projeto.dao.EntregaDAO;
import br.usjt.projeto.model.Entrega;

public class entregaService {
	
		EntregaDAO entregaDAO;
		
		public entregaService() {
			this.entregaDAO = new EntregaDAO();
		}
		
		public void cadastrar(Entrega entrega) {
			this.entregaDAO.cadastrar(entrega);
		}
		public void Atualizar(Entrega entrega) {
			this.entregaDAO.atualizar(entrega);
		}
}
