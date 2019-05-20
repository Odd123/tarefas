package br.usjt.projeto.model;

public class Atividade {
	
	private int id;
	private Tema tema;
	private int numero;
	private String descricao;
	private String formato_entrega;
	private String dt_inicio;
	private String dt_fim;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFormato_entrega() {
		return formato_entrega;
	}
	public void setFormato_entrega(String formato_entrega) {
		this.formato_entrega = formato_entrega;
	}
	public String getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public String getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(String dt_fim) {
		this.dt_fim = dt_fim;
	}

}
