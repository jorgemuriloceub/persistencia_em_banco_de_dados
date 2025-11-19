import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

    public void salvar(Curso curso) {
        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO curso (nome, duracao_horas) VALUES ('"
                    + curso.getNome() + "', " + curso.getDuracaoHoras() + ")";

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            System.out.println("Curso salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listarTodos() {
        List<Curso> lista = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT id, nome, duracao_horas FROM curso";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");

                lista.add(new Curso(id, nome, duracaoHoras));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public Curso buscarPorId(int id) {
        Curso curso = null;

        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "SELECT id, nome, duracao_horas FROM curso WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");

                curso = new Curso(id, nome, duracaoHoras);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return curso;
    }

    public void deletarPorId(int id) {
        try {
            Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM curso WHERE id = " + id;

            int linhasAfetadas = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            if (linhasAfetadas > 0) {
                System.out.println("Curso com ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum curso encontrado com ID " + id + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
