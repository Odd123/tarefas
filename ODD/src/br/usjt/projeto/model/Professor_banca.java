package br.usjt.projeto.model;

public class Professor_banca {
	
	private Banca banca;
	private Professor professor;
	private int id;
	private double avaliacao;
	
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

}
