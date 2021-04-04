package br.gov.ac.sefaz.entidade;

public class Disciplina {
	
	private String Nome;
	private String Descricao;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Disciplina() {
		super();
		Nome = "";
		Descricao = "";
	}
	public Disciplina(String nome, String descricao) {
		super();
		Nome = nome;
		Descricao = descricao;
	}
	@Override
	public String toString() {
		return "Disciplina [Nome=" + Nome + ", Descricao=" + Descricao + "]";
	}
	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
