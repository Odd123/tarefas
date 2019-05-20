package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Tema;
import br.usjt.projeto.model.Turma;

public class TurmaDAO {
	
	Connection conexao;
	 public void cadastrar (Turma turma) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO turma (id, semestre_letivo, ano_letivo, sigla, tema_id)" + "VALUES (?, ?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, turma.getId());
			 ps.setInt(2, turma.getSem_letivo());
			 ps.setInt(3, turma.getAno_letivo());
			 ps.setString(4, turma.getSigla());
			 ps.setInt(5, turma.getTema().getId());
			 


			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 
		 
	 }
	 public void atualizar(Turma turma) {
			String sqlUpdate = "UPDATE turma SET semestre_letivo=?, ano_letivo=?, tema_id=?, WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, turma.getSem_letivo());
				stm.setInt(2, turma.getAno_letivo());
				stm.setInt(3, turma.getTema().getId());
				stm.setInt(4, turma.getId());

				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Turma> carregarlista() {
			ArrayList<Turma> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, semestre_letivo, ano_letivo, sigla, tema_id FROM turma ";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Turma turma = new Turma();
						turma.setId(rs.getInt("id"));
						turma.setSem_letivo(rs.getInt("Semestre"));
						turma.setAno_letivo(rs.getInt("Ano"));
						turma.setSigla(rs.getString("Sigla"));
						Tema tema = new Tema();
						tema.setId(rs.getInt("Tema"));
						turma.setTema(tema);
					
						lista.add(turma);
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
