package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Avaliacao;
import br.usjt.projeto.model.Entrega;
import br.usjt.projeto.model.Turma_aluno;


public class AvaliacaoDAO {
	
	Connection conexao;
	 public void cadastrar (Avaliacao avaliacao) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO avaliacao (id, entrega_id, turma_aluno_id, nota, dt_avaliacao, comentarios)" + "VALUES (?, ?, ?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, avaliacao.getId());
			 ps.setInt(2, avaliacao.getEntrega().getId());
			 ps.setInt(3, avaliacao.getTurma_aluno().getId());
			 ps.setDouble(4, avaliacao.getNota());
			 ps.setString(5, avaliacao.getDt_avaliacao());
			 ps.setString(6, avaliacao.getComentarios());

			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
		 
	 }
	 
	 public void atualizar(Avaliacao avaliacao) {
			String sqlUpdate = "UPDATE avaliacao WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, avaliacao.getEntrega().getId());
				stm.setInt(2, avaliacao.getTurma_aluno().getId());
				stm.setDouble(3, avaliacao.getNota());
				stm.setString(4, avaliacao.getDt_avaliacao());
				stm.setString(5, avaliacao.getComentarios());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public void excluir(Avaliacao avaliacao) {
			String sqlDelete = "DELETE FROM avaliacao WHERE id = ?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, avaliacao.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Avaliacao> carregarlista() {
			ArrayList<Avaliacao> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, entrega_id, turma_aluno_id, nota, dt_avaliacao, comentarios FROM avaliacao";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Avaliacao avaliacao = new Avaliacao();
						avaliacao.setId(rs.getInt("Id"));
						
						Turma_aluno turma_aluno = new Turma_aluno();
						turma_aluno.setId(rs.getInt("Turma Aluno"));
						avaliacao.setTurma_aluno(turma_aluno);;
						
						avaliacao.setNota(rs.getDouble("Note"));
						avaliacao.setDt_avaliacao(rs.getString("data da avaliação"));
						avaliacao.setComentarios(rs.getString("comentario"));
						
						Entrega entrega = new Entrega();
						entrega.setId(rs.getInt("entrega"));
						avaliacao.setEntraga(entrega);
						
					
						lista.add(avaliacao);
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
