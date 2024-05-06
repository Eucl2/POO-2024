 
import java.util.ArrayList;
import java.time.LocalDate;

public class LevantaPeso extends Atividade 
{
    private int repeticoes;
    private double peso;
    
    public LevantaPeso() 
    {
        super();
        this.repeticoes = 0;
        this.peso = 0;
        

    }
    
    public LevantaPeso(int codigo, String nome, String descricao, int duracao,
    int repeticoes, double peso, LocalDate data_realizada, int freq_atv, double cal) 
    {
        super(codigo, nome, descricao, duracao, data_realizada, freq_atv, cal);
        this.repeticoes = repeticoes;
        this.peso = peso;

    }
    
    public LevantaPeso(LevantaPeso lp) 
    {
        super(lp);
        this.repeticoes = lp.getRepeticoes();
        this.peso = lp.getPeso();
    }

    public int getRepeticoes() 
    {
        return repeticoes;
    }
    
    public double getPeso() 
    {
        return peso;
    }

    public void setRepeticoes(int repeticoes) 
    {
        this.repeticoes = repeticoes;
    }
    
    public void setPeso(double peso) 
    {
        this.peso = peso;
    }
    
    @Override
    public Atividade clone() 
    {
        return new LevantaPeso(this);
    }
    
    public static LevantaPeso parse(String input)
    {
        String[] campos = input.split(",");

        return new LevantaPeso(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),
        Double.parseDouble(campos[5]),null, 0, 0);
    }
    
    public String getTipoAtividade()
    {
        return("LevantaPeso");
    }

    public String caracteristicasExtra()
    {
        return "Repeticoes:" + getRepeticoes() + "\n" +
                "Peso:" + getPeso();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LevantaPeso levantapeso = (LevantaPeso) o;
        return Integer.compare(levantapeso.getRepeticoes(), getRepeticoes()) == 0
                && Double.compare(levantapeso.getPeso(), getPeso()) == 0;
    }
    
    @Override
    public String toString() 
    {
        return "---Levantamento Peso---" + "\n" +
                super.toString() + 
                "Repeticoes:" + this.repeticoes + "\n" +
                "Peso:" + this.peso + "\n" ;
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador) {
        int freq_ativ = super.getFreqCardiaAtividade();
        double fator = utilizador.getFatorMultiplicativo();
        int freq_med = utilizador.getFreqCardiaca();
        int tempo = super.getDuracao();
        int rep = getRepeticoes();
        double pes = getPeso();
        
        
        double calorias = ((0.035 * fator) * (freq_med + (0.12 * freq_ativ)) * tempo / 60.0) + ((0.75 * rep)+ (0.25 * pes));
        
        return calorias;
    }

}
