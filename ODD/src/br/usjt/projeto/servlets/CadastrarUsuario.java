package br.usjt.projeto.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.projeto.model.Usuario;
//import br.usjt.projeto.service.UsuarioService;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet({"/CadastrarUsuario.do", "/CadastroUsuario.do"})
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		// set @@global.time_zone = '-3:00';
		
		/*UsuarioService usuarioService = new UsuarioService();
		usuarioService.cadastrar(usuario);*/
	}

}