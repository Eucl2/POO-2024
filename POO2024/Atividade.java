
/**
 * Atividade
 */
public class Atividade {

    private String nome;
    private int duracao;
    private int calorias;

    public Atividade() {
    }

    public Atividade(String nome, int duracao, int calorias) {
        this.nome = nome;
        this.duracao = duracao;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", calorias=" + calorias +
                '}';
    }
}
