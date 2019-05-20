package br.usjt.projeto.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Tema;

public class TemaDAO {
	
	Connection conexao;
	 public void cadastrar (Tema tema) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO cliente (id, dt_cadastro, titulo, introducao, requisito)" + "VALUES (?, ?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, tema.getId());
			 ps.setString(2, tema.getDt_cadastro());
			 ps.setString(3, tema.getTitulo());
			 ps.setString(4, tema.getIntroducao());
			 ps.setString(5, tema.getRequisitos());
			 
			 ps.execute();
			 ps.close();

			 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 
	 }
	 
	 public void atualizar(Tema tema) {
			String sqlUpdate = "UPDATE tema SET titulo=?, introducao=?, requisito=? WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, tema.getTitulo());
				stm.setString(2, tema.getIntroducao());
				stm.setString(3, tema.getRequisitos());
				stm.setInt(4, tema.getId());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Tema> carregarlista() {
			ArrayList<Tema> lista = new ArrayList<>();
			String sqlSelect = "SELECT id,titulo, introducao, requisito FROM tema ";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Tema tema = new Tema();
						tema.setId(rs.getInt("id"));
						tema.setTitulo(rs.getString("titulo"));
						tema.setIntroducao(rs.getString("introducao"));
						tema.setRequisitos(rs.getString("requisito"));
					
						lista.add(tema);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista;
		}

}
