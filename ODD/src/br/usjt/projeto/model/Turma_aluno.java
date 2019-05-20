package br.usjt.projeto.model;

public class Turma_aluno {
	
	private Aluno aluno;
	private Turma turma;
	private Grupo grupo;
	private int id;
	
	
	
	public Turma_aluno() {
		
	}
	public Turma_aluno(Aluno aluno, Turma turma, Grupo grupo, int id) {
		
		this.aluno = aluno;
		this.turma = turma;
		this.grupo = grupo;
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
