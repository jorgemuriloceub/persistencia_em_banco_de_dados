public class Curso {
    private int id;
    private String nome;
    private int duracaoHoras;

    public Curso(String nome, int duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(int id, String nome, int duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getDuracaoHoras() { return duracaoHoras; }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + duracaoHoras + " horas)";
    }
}
