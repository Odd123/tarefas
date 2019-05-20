package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Aluno;
import br.usjt.projeto.model.Usuario;

public class AlunoDAO {

		private Connection conexao;
		
		public AlunoDAO() {
			try {
				this.conexao = ConnectionFactory.conectar();
			}catch (SQLException ex) {
					ex.printStackTrace();
				}
			
		}

		public int cadastrar(Aluno aluno) {
			String sql = "INSERT INTO aluno (aluno_id, ra) " + " VALUES (?, ?)";
			
			try {
				PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, aluno.getUsuario().getId());
				ps.setString(2, aluno.getRa());
				
				
				ps.execute();
				
				ResultSet rs = ps.getGeneratedKeys();
				
				if (rs.next()) {
					int aluno_ra = rs.getInt(1);
					return aluno_ra;
				}
				
				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
			return -1;
		}
		
		 public void atualizar(Aluno aluno) {
				String sqlUpdate = "UPDATE aluno WHERE id=?";
				try (Connection conn = ConnectionFactory.conectar();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setInt(1, aluno.getUsuario().getId());
					stm.setString(2, aluno.getRa());
					
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 
		 public void excluir(Aluno aluno) {
				String sqlDelete = "DELETE FROM aluno WHERE id = ?";
				try (Connection conn = ConnectionFactory.conectar();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, aluno.getUsuario().getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 public ArrayList<Aluno> carregarlista() {
				ArrayList<Aluno> lista = new ArrayList<>();
				String sqlSelect = "SELECT aluno_id,ra FROM aluno";
				try (Connection conn = ConnectionFactory.conectar();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					
					try (ResultSet rs = stm.executeQuery();) {
						while (rs.next()) {
							Aluno aluno = new Aluno();
							aluno.setRa(rs.getString("RA"));
							Usuario usuario = new Usuario();
							usuario.setId(rs.getInt("Id"));
							aluno.setUsuario(usuario);

						
							lista.add(aluno);
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
