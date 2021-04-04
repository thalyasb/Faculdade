package br.gov.ac.sefaz.entidade;

public class Professor extends Pessoa {
	
	private String email;
	private String telefone;
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Professor() {
		super();
		this.email = "";
		this.telefone = "";
	}
	public Professor(String email, String telefone) {
		super();
		this.email = email;
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Professor [email=" + email + ", telefone=" + telefone + ", id=" + id + ", nome=" + nome + "]";
	}

	

}
