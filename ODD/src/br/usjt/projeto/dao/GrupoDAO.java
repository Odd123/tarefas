package br.usjt.projeto.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Grupo;

public class GrupoDAO {
	
	Connection conexao;
	 public void cadastrar (Grupo grupo) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO entrega (id, orientador_id, numero, nome)" + "VALUES (?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, grupo.getId());
			 ps.setInt(2, grupo.getProfessor().getUsuario().getId());
			 ps.setInt(3, grupo.getNumero());
			 ps.setString(4, grupo.getNome());

			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }

	 }
	 public void atualizar(Grupo grupo) {
			String sqlUpdate = "UPDATE grupo SET orientador_id=?, numero=?, nome=? WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, grupo.getProfessor().getUsuario().getId());
				stm.setInt(2, grupo.getNumero());
				stm.setString(3, grupo.getNome());
				stm.setInt(4, grupo.getId());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public void excluir(Grupo grupo) {
			String sqlDelete = "DELETE FROM grupo WHERE id = ?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, grupo.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Grupo> carregarlista() {
			ArrayList<Grupo> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, orientador_id, numero, nome FROM grupo";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Grupo grupo = new Grupo();
						grupo.setId(rs.getInt("Id"));
						//grupo.setProfessor();
						grupo.setNumero(rs.getInt("numero"));
						grupo.setNome(rs.getString("Nome"));
						
					
						lista.add(grupo);
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
