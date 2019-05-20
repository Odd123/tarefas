package br.usjt.projeto.model;

public class Avaliacao {
	
	private int id;
	private Entrega entrega;
	private Turma_aluno turma_aluno;
	private double nota;
	private String dt_avaliacao;
	private String comentarios;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntraga(Entrega entraga) {
		this.entrega = entraga;
	}
	public Turma_aluno getTurma_aluno() {
		return turma_aluno;
	}
	public void setTurma_aluno(Turma_aluno turma_aluno) {
		this.turma_aluno = turma_aluno;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getDt_avaliacao() {
		return dt_avaliacao;
	}
	public void setDt_avaliacao(String dt_avaliacao) {
		this.dt_avaliacao = dt_avaliacao;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
