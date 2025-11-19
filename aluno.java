public class Aluno {
    private int id;
    private String nome;
    private String email;
    private int idade; // Novo campo

    public Aluno(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Aluno(int id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getIdade() { return idade; } // Novo getter

    @Override
    public String toString() {
        return id + " - " + nome + " (" + email + "), Idade: " + idade;
    }
}
