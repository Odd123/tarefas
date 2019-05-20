package br.usjt.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.projeto.model.Atividade;
import br.usjt.projeto.model.Tema;

public class AtividadeDAO {
	
	Connection conexao;
	 public void cadastrar (Atividade atividade) {
		 
		 try {
			 this.conexao = ConnectionFactory.conectar();
			 String sql = "INSERT INTO atividade (id, tema_id, numero, descricao, formato_entrega, dt_inicio, dt_fim)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
			 
			 PreparedStatement ps = this.conexao.prepareStatement(sql);
			 ps.setInt(1, atividade.getId());
			 ps.setInt(2, atividade.getTema().getId());
			 ps.setInt(3, atividade.getNumero());
			 ps.setString(4, atividade.getDescricao());
			 ps.setString(5, atividade.getFormato_entrega());
			 ps.setString(6, atividade.getDt_inicio());
			 ps.setString(7, atividade.getDt_fim());
			 
			 ps.execute();
			 ps.close();

		 
		 }catch (SQLException ex) {
			 ex.printStackTrace();
		 }
	 }
	 
	 public void atualizar(Atividade atividade) {
			String sqlUpdate = "UPDATE atividade WHERE id=?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, atividade.getNumero());
				stm.setString(2, atividade.getDescricao());
				stm.setString(3, atividade.getDt_fim());
				stm.setString(4, atividade.getDt_inicio());
				stm.setString(4, atividade.getFormato_entrega());
				
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public void excluir(Atividade atividade) {
			String sqlDelete = "DELETE FROM atividade WHERE id = ?";
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, atividade.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 public ArrayList<Atividade> carregarlista() {
			ArrayList<Atividade> lista = new ArrayList<>();
			String sqlSelect = "SELECT aluno_id,ra FROM aluno";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.conectar();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						Atividade atividade = new Atividade();
						atividade.setDescricao(rs.getString("Descrição"));
						atividade.setDt_inicio(rs.getString("data inicial"));
						atividade.setDt_fim(rs.getString("data final"));
						atividade.setNumero(rs.getInt("Numero"));
						Tema tema = new Tema();
						tema.setTitulo(rs.getString("Tema"));
						atividade.setTema(tema);
						
					
						lista.add(atividade);
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
