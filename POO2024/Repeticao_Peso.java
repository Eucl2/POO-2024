 
import java.util.ArrayList;

public class Repeticao_Peso extends Atividade {
    private int repeticoes;
    private double peso;

    public Repeticao_Peso(String nome, int duracao, int rep, double p) {
        super(nome,duracao);
        repeticoes = rep;
        peso = p;

    }
    
    public Repeticao_Peso(Repeticao_Peso r) {
        super(r.getNome(), r.getDuracao());
        this.repeticoes = r.getRepeticao();
        this.peso = r.getPeso();
    }

    public int getRepeticao() {
        return this.repeticoes;
    }

    public void setRepeticao(int repeticoes) {
        this.repeticoes = repeticoes;
    }
    
    public double getPeso() {
        return this.peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    

    public Repeticao_Peso clone() {
        return new Repeticao_Peso(this);
    }

}
