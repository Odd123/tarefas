package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Banca;
import br.usjt.projeto.model.Grupo;

public class BancaDAO {
	
	Connection conexao;
	 public void cadastrar (Banca banca) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO banca (id, grupo_id, data, sala)" + "VALUES (?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, banca.getId());
			 ps.setInt(2, banca.getGrupo().getId());
			 ps.setString(3, banca.getData());
			 ps.setString(4, banca.getSala());


			 
			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 
	 }
	 public void atualizar(Banca banca) {
			String sqlUpdate = "UPDATE banca WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, banca.getSala());
				stm.setString(2, banca.getData());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public void excluir(Banca banca) {
			String sqlDelete = "DELETE FROM banca WHERE id = ?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, banca.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Banca> carregarlista() {
			ArrayList<Banca> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, grupo_id, data, sala FROM banca";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Banca banca = new Banca();
						banca.setId(rs.getInt("Id"));
						
						Grupo grupo = new Grupo();
						grupo.setId(rs.getInt("Grupo"));
						banca.setGrupo(grupo);
						banca.setSala(rs.getString("Sala"));
						banca.setData(rs.getString("Data"));
						
					
						lista.add(banca);
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
