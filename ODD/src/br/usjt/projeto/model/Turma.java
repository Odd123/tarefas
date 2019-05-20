package br.usjt.projeto.model;

public class Turma {
	
	private int id;
	private int sem_letivo;
	private int ano_letivo;
	private String sigla;
	private Tema tema;
	
	
	
	public Turma() {

	}
	public Turma(int id, int sem_letivo, int ano_letivo, String sigla, Tema tema) {

		this.id = id;
		this.sem_letivo = sem_letivo;
		this.ano_letivo = ano_letivo;
		this.sigla = sigla;
		this.tema = tema;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSem_letivo() {
		return sem_letivo;
	}
	public void setSem_letivo(int sem_letivo) {
		this.sem_letivo = sem_letivo;
	}
	public int getAno_letivo() {
		return ano_letivo;
	}
	public void setAno_letivo(int ano_letivo) {
		this.ano_letivo = ano_letivo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
