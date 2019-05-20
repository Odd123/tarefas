package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Aluno;
import br.usjt.projeto.model.Grupo;
import br.usjt.projeto.model.Turma;
import br.usjt.projeto.model.Turma_aluno;
import br.usjt.projeto.model.Usuario;

public class Turma_alunoDAO {
	
	Connection conexao;
	 public void cadastrar (Turma_aluno turma_aluno) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO entrega (Aluno_id, turma_id, grupo_id, id)" + "VALUES (?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, turma_aluno.getId());
			 ps.setInt(2, turma_aluno.getAluno().getUsuario().getId());
			 ps.setInt(3, turma_aluno.getTurma().getId());
			 ps.setInt(4, turma_aluno.getGrupo().getId());
			 

			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
	 }
	 public void atualizar(Turma_aluno turma_aluno) {
			String sqlUpdate = "UPDATE tema SET Aluno_id=?, turma_id=?, grupo_id=? WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, turma_aluno.getAluno().getUsuario().getId());
				stm.setInt(2, turma_aluno.getTurma().getId());
				stm.setInt(3, turma_aluno.getGrupo().getId());
								
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Turma_aluno> carregarlista() {
			ArrayList<Turma_aluno> lista = new ArrayList<>();
			String sqlSelect = "SELECT Aluno_id, turma_id, grupo_id, id FROM tema ";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Turma_aluno turma_aluno = new Turma_aluno();
						turma_aluno.setId(rs.getInt("id"));
						
						Grupo grupo = new Grupo();
						grupo.setId(rs.getInt("grupos"));
						turma_aluno.setGrupo(grupo);
						
						Turma turma = new Turma();
						turma.setId(rs.getInt("requisito"));
						turma_aluno.setTurma(turma);
						
						Usuario usuario = new Usuario();
						Aluno aluno = new Aluno();
						usuario.setId(rs.getInt("id"));
						aluno.setUsuario(usuario);
						turma_aluno.setAluno(aluno);
					
						lista.add(turma_aluno);
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
