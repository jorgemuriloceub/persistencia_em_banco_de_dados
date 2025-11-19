import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    // Método para salvar um aluno
    public void salvar(Aluno aluno) {
        if (aluno == null || aluno.getNome() == null || aluno.getEmail() == null) {
            throw new IllegalArgumentException("Dados do aluno inválidos.");
        }

        String sql = "INSERT INTO aluno (nome, email, idade) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setInt(3, aluno.getIdade());

            stmt.executeUpdate();
            System.out.println("Aluno salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar aluno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para listar todos os alunos
    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT id, nome, email, idade FROM aluno";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int idade = rs.getInt("idade");

                lista.add(new Aluno(id, nome, email, idade));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar alunos: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    // Método para deletar um aluno por ID
    public void deletarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno com ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum aluno encontrado com ID " + id + ".");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar aluno: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para buscar um aluno por ID
    public Aluno buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Aluno aluno = null;
        String sql = "SELECT id, nome, email, idade FROM aluno WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    int idade = rs.getInt("idade");

                    aluno = new Aluno(id, nome, email, idade);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno: " + e.getMessage());
            e.printStackTrace();
        }

        return aluno;
    }
}
