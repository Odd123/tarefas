package br.usjt.projeto.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.usjt.projeto.model.Professor_banca;

public class Professor_bancaDAO {
	
	Connection conexao;
	 public void cadastrar (Professor_banca professor_banca) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO professor_banca (banca_id, Professor_id, id, avaliacao)" + "VALUES (?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, professor_banca.getId());
			 ps.setInt(2, professor_banca.getBanca().getId());
			 ps.setInt(3, professor_banca.getProfessor().getUsuario().getId());
			 ps.setDouble(4, professor_banca.getAvaliacao());


			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
	 }
	 public void atualizar(Professor_banca professor_banca) {
			String sqlUpdate = "UPDATE professor_banca SET Professor_id=?, banca_id=?, avaliacao=? WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, professor_banca.getProfessor().getUsuario().getId());
				stm.setInt(2, professor_banca.getBanca().getId());
				stm.setDouble(3, professor_banca.getAvaliacao());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public void excluir(Professor_banca professor_banca) {
			String sqlDelete = "DELETE * FROM professor_banca WHERE id = ?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, professor_banca.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
