package br.usjt.projeto.dao;


import java.sql.Connection;
import java.sql.SQLException;

import br.usjt.projeto.model.Professor;
import br.usjt.projeto.model.Professor_banca;
import br.usjt.projeto.model.Usuario;
import br.usjt.projeto.service.alunoService;
import br.usjt.projeto.service.professorService;
import br.usjt.projeto.service.usuarioService;

public class Teste {

   public static void main(String[] args) {
      Connection conn = null;
      usuarioService us; 
      professorService ps;
      alunoService as;

      
      try {
      	// obtem conexao com o banco
         ConnectionFactory bd = new ConnectionFactory();
         conn = bd.conectar();
         
         us = new usuarioService();
         as.atualizar(new Aluno())
         us.cadastrar(new Usuario(101, "oi", "oi@gmail.com", "123"));
         us.excluir(new Usuario(101, "oi", "oi@gmail.com", "123"));
         
      } 
      catch (Exception e) {
         e.printStackTrace();
         if (conn != null) {
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      } 
      finally {
         if (conn != null) {
            try {
               conn.close();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
            System.out.println("oi");
         }
      }
   }
}
