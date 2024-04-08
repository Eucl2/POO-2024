 
import java.util.ArrayList;

public class RepeticaoPeso extends Atividade 
{
    private int repeticoes;
    private double peso;

    public RepeticaoPeso(String nome, int duracao, int rep, double p) 
    {
        super(nome,duracao);
        repeticoes = rep;
        peso = p;

    }
    
    public RepeticaoPeso(RepeticaoPeso rp) 
    {
        super(rp);
        this.repeticoes = rp.getRepeticao();
        this.peso = rp.getPeso();
    }

    public int getRepeticao() 
    {
        return this.repeticoes;
    }

    public void setRepeticao(int repeticoes) 
    {
        this.repeticoes = repeticoes;
    }
    
    public double getPeso() 
    {
        return this.peso;
    }
    
    public void setPeso(double peso) 
    {
        this.peso = peso;
    }

    public RepeticaoPeso clone() 
    {
        return new RepeticaoPeso(this);
    }
    
    //to string da caracteristica da atividade
    public String extraCaracteristicas() {
        return "Repeticoes: " + getRepeticao() + "\n Peso: " + getPeso();
    }
    //nome do tipo de atividade 
    public String getTipoAtividade() {
        return ("Repeticao_Peso");
    }
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        RepeticaoPeso rp = (RepeticaoPeso) obj;
        return super.equals(rp);

    }
    
    @Override
    public int calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        // Fórmula para calcular calorias para corrida
        return 0;
    }

}
