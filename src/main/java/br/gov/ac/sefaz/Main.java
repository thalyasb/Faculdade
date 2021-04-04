package br.gov.ac.sefaz;

import br.gov.ac.sefaz.DAO.AlunoDAO;
import br.gov.ac.sefaz.entidade.Aluno;

public class Main {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Fulano");
		
		AlunoDAO.create(aluno);
		
		Aluno aluno2 = AlunoDAO.readOne(1);
		
		System.out.println(aluno2.toString());
		
	}
}
