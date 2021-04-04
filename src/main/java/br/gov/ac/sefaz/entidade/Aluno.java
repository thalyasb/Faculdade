package br.gov.ac.sefaz.entidade;

public class Aluno extends Pessoa{
	
	private String email;
	private String telefone;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Aluno [email=" + email + ", telefone=" + telefone + ", id=" + id + ", nome=" + nome + "]";
	}
	public Aluno() {
		super();
		this.email = "";
		this.telefone = "";
	}
	public Aluno(String email, String telefone) {
		super();
		this.email = email;
		this.telefone = telefone;
	}

}
