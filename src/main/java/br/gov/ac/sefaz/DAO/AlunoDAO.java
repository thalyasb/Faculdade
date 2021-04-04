package br.gov.ac.sefaz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.gov.ac.sefaz.entidade.Aluno;
import br.gov.ac.sefaz.modelo.Connexao;

public class AlunoDAO {

		private static Connection conn;

		public static void create(Aluno aluno) {
			try {
				conn = Connexao.criarConexao();

				String sql = "INSERT INTO `faculdade`.`aluno` ( `NOME`, `EMAIL`, `TELEFONE`)\r\n" + 
						"VALUES\r\n" + 
						"  ( ?, ?, ?);";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, aluno.getNome());
				ps.setString(2, aluno.getEmail());
				ps.setString(3, aluno.getTelefone());

				ps.execute();

				System.out.println("Aluno Inserido com Sucesso => [" + aluno.toString() + "]");

			} catch (Exception e) {
				System.out.println("Error na Inserção do Aluno => " + aluno.getNome() + ":");
				e.printStackTrace();
			} finally {
				Connexao.fecharConexao(conn);
			}
		}

		public static List<Aluno> read() {

			List<Aluno> alunos = new ArrayList<Aluno>();

			try {
				conn = Connexao.criarConexao();

				String sql = "SELECT\r\n" + 
						"  `ID`,\r\n" + 
						"  `NOME`,\r\n" + 
						"  `EMAIL`,\r\n" + 
						"  `TELEFONE`\r\n" + 
						"FROM\r\n" + 
						"  `faculdade`.`aluno`;";

				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Aluno aluno = new Aluno();

					aluno.setEmail(rs.getString("email"));
					aluno.setNome(rs.getString("nome"));
					aluno.setTelefone(rs.getString("telefone"));
					aluno.setId(rs.getInt("id"));

					alunos.add(aluno);
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro na Busca de Alunos:");
				e.printStackTrace();
			} finally {
				Connexao.fecharConexao(conn);
			}

			return alunos;

		}

		public static Aluno readOne(int id) {

			Aluno aluno = new Aluno();

			try {
				conn = Connexao.criarConexao();

				String sql = "SELECT\r\n" + 
						"  `ID`,\r\n" + 
						"  `NOME`,\r\n" + 
						"  `EMAIL`,\r\n" + 
						"  `TELEFONE`\r\n" + 
						"FROM\r\n" + 
						"  `faculdade`.`aluno` where id = ?;";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, id);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					aluno.setEmail(rs.getString("email"));
					aluno.setNome(rs.getString("nome"));
					aluno.setTelefone(rs.getString("telefone"));
					aluno.setId(rs.getInt("id"));

				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro na Busca de Alunos:");
				e.printStackTrace();
			} finally {
				Connexao.fecharConexao(conn);
			}

			return aluno;

		}

		public static void update(Aluno aluno) {

			try {

				conn = Connexao.criarConexao();

				String sql = "UPDATE\r\n" + 
						"  `faculdade`.`aluno`\r\n" + 
						"SET\r\n" + 
						"  `NOME` = ?,\r\n" + 
						"  `EMAIL` = ?,\r\n" + 
						"  `TELEFONE` = ?\r\n" + 
						"WHERE `ID` = ?;";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, aluno.getNome());
				ps.setString(2, aluno.getEmail());
				ps.setString(3, aluno.getTelefone());
				ps.setInt(4, aluno.getId());

				ps.executeUpdate();

				System.out.println("Update Aluno com Sucesso => [" + aluno.toString() + "]");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Update Aluno => [" + aluno.toString() + "]:");
				e.printStackTrace();
			} finally {
				Connexao.fecharConexao(conn);
			}

		}

		public static void delete(int id) {

			try {
				conn = Connexao.criarConexao();

				String sql = "DELETE\r\n" + 
						"FROM\r\n" + 
						"  `faculdade`.`aluno`\r\n" + 
						"WHERE `ID` = ?;\r\n" + 
						"";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, id);
				
				ps.execute();
				
				System.out.println("Delete Aluno com Sucesso => id = " + id);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error Delete Aluno:");
				e.printStackTrace();
			} finally {
				Connexao.fecharConexao(conn);
			}

		}

		
}
