package br.usjt.projeto.model;

public class Entrega {
	
	private Grupo grupo_id;
	private Atividade atividade;
	private int id;
	private String dt_cadastro;
	
	public Grupo getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(Grupo grupo_id) {
		this.grupo_id = grupo_id;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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

}
