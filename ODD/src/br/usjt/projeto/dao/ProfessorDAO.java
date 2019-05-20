package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Professor;
import br.usjt.projeto.model.Usuario;

public class ProfessorDAO {
	
	Connection conexao;
	 public void cadastrar (Professor professor) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO professor (professor_id, administrador, matricula)"
			 + "VALUES (?,?,?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, professor.getUsuario().getId());
			 ps.setBoolean(2, professor.getAdm());
			 ps.setString(3, professor.getRA());
			 
			 ps.execute();
			 ps.close();


		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 
	 }
	 public void atualizar(Professor professor) {
			String sqlUpdate = "UPDATE professor SET administrador=? WHERE professor_id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setBoolean(1, professor.getAdm());
				stm.setInt(4, professor.getUsuario().getId());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Professor> carregarlista() {
			ArrayList<Professor> lista = new ArrayList<>();
			String sqlSelect = "SELECT * FROM tema ";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Professor professor = new Professor();
						Usuario usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						professor.setUsuario(usuario);
						
						professor.setAdm(rs.getBoolean("adm"));
						professor.setRA(rs.getString("Matricula"));
					
						lista.add(professor);
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
