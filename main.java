import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlunoRepository repo = new AlunoRepository();

        Aluno a = new Aluno("Ana Silva", "ana@gmail.com");
        repo.salvar(a);

        List<Aluno> alunos = repo.listarTodos();

        System.out.println("\n=== Lista de alunos ===");
        for (Aluno x : alunos) {
            System.out.println(x);
        }
    }
}
