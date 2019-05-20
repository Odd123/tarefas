package br.usjt.projeto.service;

import br.usjt.projeto.dao.UsuarioDAO;
import br.usjt.projeto.model.Usuario;

public class usuarioService {
	
	UsuarioDAO usuarioDAO;
	
	public usuarioService() {
		this.usuarioDAO = new UsuarioDAO();
		
	}
	
	public void cadastrar(Usuario usuario) {
		this.usuarioDAO.cadastrar(usuario);
	}
	
	public void Atualizar(Usuario usuario) {
		this.usuarioDAO.atualizar(usuario);
	}
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}


}
