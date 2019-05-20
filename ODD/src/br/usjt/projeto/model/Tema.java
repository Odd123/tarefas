package br.usjt.projeto.model;

public class Tema {
	
	private int id;
	private String dt_cadastro;
	private String titulo;
	private String introducao;
	private String requisitos;
	
	
	public Tema() {

	}
	public Tema(int id, String dt_cadastro, String titulo, String introducao, String requisitos) {

		this.id = id;
		this.dt_cadastro = dt_cadastro;
		this.titulo = titulo;
		this.introducao = introducao;
		this.requisitos = requisitos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(String dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIntroducao() {
		return introducao;
	}
	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

}
