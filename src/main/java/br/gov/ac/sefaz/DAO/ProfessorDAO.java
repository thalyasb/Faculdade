package br.gov.ac.sefaz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.gov.ac.sefaz.entidade.Professor;
import br.gov.ac.sefaz.modelo.Connexao;

public class ProfessorDAO {
	 
	private static Connection conn;

	public static void create(Professor professor) {
		try {
			conn = Connexao.criarConexao();

			String sql = "INSERT INTO `faculdade`.`professor` ( `NOME`, `EMAIL`, `TELEFONE`)" + 
					"VALUES" + 
					"  ( ?, ?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getEmail());
			ps.setString(3, professor.getTelefone());

			ps.execute();

			System.out.println("Professor Inserido com Sucesso => [" + professor.toString() + "]");

		} catch (Exception e) {
			System.out.println("Error na Inserção do Professor => " + professor.getNome() + ":");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}
	}

	public static List<Professor> read() {

		List<Professor> professores = new ArrayList<Professor>();

		try {
			conn = Connexao.criarConexao();

			String sql = "SELECT" + 
					"  `ID`," + 
					"  `NOME`," + 
					"  `EMAIL`," + 
					"  `TELEFONE`" + 
					"FROM" + 
					"  `faculdade`.`professor`" + 
					"LIMIT 0, 1000;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Professor professor = new Professor();

				professor.setEmail(rs.getString("email"));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setId(rs.getInt("id"));

				professores.add(professor);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na Busca de Professores:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

		return professores;

	}

	public static Professor readOne(int id) {

		Professor professor = new Professor();

		try {
			conn = Connexao.criarConexao();

			String sql = "SELECT" + 
					"  `ID`," + 
					"  `NOME`," + 
					"  `EMAIL`," + 
					"  `TELEFONE`" + 
					"FROM" + 
					"  `faculdade`.`professor`" + 
					" WHERE `ID` = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				professor.setEmail(rs.getString("email"));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setId(rs.getInt("id"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na Busca de Alunos:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

		return professor;

	}

	public static void update(Professor professor) {

		try {

			conn = Connexao.criarConexao();

			String sql = "UPDATE" + 
					"  `faculdade`.`professor`" + 
					"SET" + 
					"  `NOME` = ?'," + 
					"  `EMAIL` = ?," + 
					"  `TELEFONE` = ?" + 
					"WHERE `ID` = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getEmail());
			ps.setString(3, professor.getTelefone());
			ps.setInt(4, professor.getId());

			ps.executeUpdate();

			System.out.println("Update Professor com Sucesso => [" + professor.toString() + "]");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Update Professor => [" + professor.toString() + "]:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

	}

	public static void delete(int id) {

		try {
			conn = Connexao.criarConexao();

			String sql = "DELETE" + 
					"FROM" + 
					"  `faculdade`.`professor`" + 
					"WHERE `ID` = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			
			ps.execute();
			
			System.out.println("Delete Professor com Sucesso => id = " + id);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Delete Professor:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

	}


}
