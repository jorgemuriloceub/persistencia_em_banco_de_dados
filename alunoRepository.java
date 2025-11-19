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
