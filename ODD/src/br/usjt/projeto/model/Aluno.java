package br.usjt.projeto.model;

public class Aluno {
	// alterar Id 
	private Usuario usuario;//CPF
	private String ra;	
	
	public Aluno() {
		
	}
	
	public Aluno(Usuario usuario, String ra) {
		this.usuario = usuario;
		this.ra = ra;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
}