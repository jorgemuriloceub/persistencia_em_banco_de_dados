import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    public void salvar(Aluno aluno) {
        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO aluno (nome, email) VALUES ('"
                    + aluno.getNome() + "', '" + aluno.getEmail() + "')";

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            System.out.println("Aluno salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT id, nome, email FROM aluno";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                lista.add(new Aluno(id, nome, email));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
// ... imports

public class AlunoRepository {

    public void salvar(Aluno aluno) {
        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            // SQL ajustado para incluir 'idade'
            String sql = "INSERT INTO aluno (nome, email, idade) VALUES ('"
                    + aluno.getNome() + "', '" + aluno.getEmail() + "', " + aluno.getIdade() + ")";

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            System.out.println("Aluno salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            // SQL ajustado para selecionar 'idade'
            String sql = "SELECT id, nome, email, idade FROM aluno";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int idade = rs.getInt("idade"); // Resgata a idade

                // Construtor ajustado
                lista.add(new Aluno(id, nome, email, idade)); 
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ... (Novos métodos a seguir)
}
// ... no final da classe AlunoRepository

    public void deletarPorId(int id) {
        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM aluno WHERE id = " + id;

            int linhasAfetadas = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno com ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum aluno encontrado com ID " + id + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// ... no final da classe AlunoRepository

    public Aluno buscarPorId(int id) {
        Aluno aluno = null;

        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            // SQL ajustado para selecionar 'idade'
            String sql = "SELECT id, nome, email, idade FROM aluno WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) { // Move para a primeira linha (e única)
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int idade = rs.getInt("idade");

                // Instancia e retorna o Aluno encontrado
                aluno = new Aluno(id, nome, email, idade); 
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return aluno;
    }
