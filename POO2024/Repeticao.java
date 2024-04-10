 
import java.util.ArrayList;

public class Repeticao extends Atividade 
{
    private int repeticoes;

    public Repeticao(String nome, double duracao, int rep) 
    {
        super(nome,duracao);
        repeticoes = rep;

    }
    
    public Repeticao(Repeticao r) 
    {
        super(r);
        this.repeticoes = r.getRepeticao();
    }

    public int getRepeticao() 
    {
        return this.repeticoes;
    }

    public void setRepeticao(int repeticoes) 
    {
        this.repeticoes = repeticoes;
    }

    public Repeticao clone() 
    {
        return new Repeticao(this);
    }
    
    //to string da caracteristica da atividade
    public String extraCaracteristicas() {
        return "Repeticoes: " + getRepeticao();
    }
    //nome do tipo de atividade 
    public String getTipoAtividade() {
        return ("Repeticao");
    }
    
    public static Repeticao parse(String input)
    {
        String[] campos = input.split(",");
        return new Repeticao(campos[0], Double.parseDouble(campos[1]), Integer.parseInt(campos[2]));
    }
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Repeticao r = (Repeticao) obj;
        return super.equals(r);

    }
    
    @Override
    public int calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        // Fórmula para calcular calorias para corrida
        return 0;
    }

}
