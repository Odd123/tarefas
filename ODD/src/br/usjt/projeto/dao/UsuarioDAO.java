package br.usjt.projeto.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.projeto.model.Usuario;

public class UsuarioDAO {

	private Connection conexao;
	
	public UsuarioDAO() {
		try {
			this.conexao = ConnectionFactory.conectar();
		}catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	public int cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario (id, nome, email, senha) " + " VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, usuario.getId());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSenha());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				int idUsuario = rs.getInt(1);
				return idUsuario;
			}
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
	}
	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, senha=?, WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());

			
			stm.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public void excluir(Usuario usuario) {
			String sqlDelete = "DELETE FROM usuario WHERE id = ?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, usuario.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}