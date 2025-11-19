import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlunoRepository repoAluno = new AlunoRepository();
        CursoRepository repoCurso = new CursoRepository();

        // 1. Testando Salvar Aluno com Idade
        Aluno a = new Aluno("Ana Silva", "ana@gmail.com", 25);
        Aluno b = new Aluno("Bruno Costa", "bruno@hotmail.com", 30);
        repoAluno.salvar(a);
        repoAluno.salvar(b);
        
        // 2. Testando Listar Todos os Alunos
        List<Aluno> alunos = repoAluno.listarTodos();

        System.out.println("\n=== Lista de Alunos ===");
        for (Aluno x : alunos) {
            System.out.println(x);
        }
        
        // 3. Testando Buscar Aluno por ID (usando o ID do segundo aluno salvo)
        if (!alunos.isEmpty()) {
            int idParaBuscar = alunos.get(alunos.size() - 1).getId(); 
            Aluno alunoBuscado = repoAluno.buscarPorId(idParaBuscar);
            System.out.println("\n=== Aluno Buscado por ID " + idParaBuscar + " ===");
            System.out.println(alunoBuscado != null ? alunoBuscado : "Aluno não encontrado.");
        }
        
        // 4. Testando Deletar Aluno por ID (deletando o primeiro aluno salvo)
        if (!alunos.isEmpty()) {
            int idParaDeletar = alunos.get(0).getId();
            System.out.println("\n=== Deletando Aluno com ID " + idParaDeletar + " ===");
            repoAluno.deletarPorId(idParaDeletar);
            
            // Verifica a lista após a exclusão
            System.out.println("\n=== Lista de Alunos Após Deletar ===");
            repoAluno.listarTodos().forEach(System.out::println);
        }
        
        // --- Testes da Classe Curso ---
        
        // 5. Testando Salvar Cursos
        Curso c1 = new Curso("Desenvolvimento Java", 400);
        Curso c2 = new Curso("Banco de Dados SQL", 80);
        repoCurso.salvar(c1);
        repoCurso.salvar(c2);
        
        // 6. Testando Listar Todos os Cursos
        List<Curso> cursos = repoCurso.listarTodos();

        System.out.println("\n=== Lista de Cursos ===");
        for (Curso c : cursos) {
            System.out.println(c);
        }
    }
}
