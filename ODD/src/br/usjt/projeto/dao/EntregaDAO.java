package br.usjt.projeto.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.usjt.projeto.model.Entrega;

public class EntregaDAO {
	
	Connection conexao;
	 public void cadastrar (Entrega entrega) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO entrega (grupo_id, atividade_id, id, dt_cadastro)" + "VALUES (?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, entrega.getId());
			 ps.setInt(2, entrega.getGrupo_id().getId());
			 ps.setInt(3, entrega.getAtividade().getId());
			 ps.setString(4, entrega.getDt_cadastro());

			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
	 }
	 public void atualizar(Entrega entrega) {
			String sqlUpdate = "UPDATE entrega WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, entrega.getGrupo_id().getId());
				stm.setInt(2, entrega.getAtividade().getId());
				stm.setString(3, entrega.getDt_cadastro());

				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 

}
