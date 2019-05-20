package br.usjt.projeto.model;

public class Professor {
	
	private Usuario usuario;//CPF
	private boolean adm;
	private String RA;
	
	public Professor() {
		super();
	}
	public Professor(Usuario usuario, boolean adm, String RA) {
		super();
		this.usuario = usuario;
		this.adm = adm;
		this.RA = RA;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean getAdm() {
		return adm;
	}
	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	public String getRA() {
		return RA;
	}
	public void setRA(String RA) {
		this.RA = RA;
	} 

}
