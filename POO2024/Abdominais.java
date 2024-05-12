 
import java.util.ArrayList;
import java.time.LocalDate;

public class Abdominais extends Atividade 
{
    private int repeticoes;
    
    public Abdominais() 
    {
        super();
        this.repeticoes = 0;

    }
    
    public Abdominais(int codigo, String nome, String descricao, int duracao,
    int repeticoes, LocalDate data_realizada, int freq_atv, double cal, boolean hard) 
    {
        super(codigo, nome, descricao, duracao, data_realizada, freq_atv, cal, hard);
        this.repeticoes = repeticoes;

    }
    
    public Abdominais(Abdominais ab) 
    {
        super(ab);
        this.repeticoes = ab.getRepeticoes();
    }

    public int getRepeticoes() 
    {
        return this.repeticoes;
    }

    public void setRepeticoes(int repeticoes) 
    {
        this.repeticoes = repeticoes;
    }
    
    @Override
    public Atividade clone() 
    {
        return new Abdominais(this);
    }
    
    public static Abdominais parse(String input)
    {
        String[] campos = input.split(",");

        return new Abdominais(Integer.parseInt(campos[0]),campos[1],
        campos[2],0,Integer.parseInt(campos[3]),
        null, 0 , 0, Boolean.parseBoolean(campos[4]));
    }
    
    public String getTipoAtividade()
    {
        return("Abdominais");
    }

    public String caracteristicasExtra()
    {
        return "Repeticoes:" + getRepeticoes();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Abdominais abdominais = (Abdominais) o;
        return Integer.compare(abdominais.getRepeticoes(), getRepeticoes()) == 0;
    }
    
    @Override
    public String toString() 
    {
        return "---Abdominais---" + "\n" +
                super.toString() + 
                "Repeticoes:" + this.repeticoes + "\n";
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador) {
        int freq_ativ = getFreqCardiaAtividade();
        double fator = utilizador.getFatorMultiplicativo();
        int freq_med = utilizador.getFreqCardiaca();
        int tempo = getDuracao();
        int rep = getRepeticoes();
        
        
        double calorias = ((0.035 * fator) * (freq_med + (0.12 * freq_ativ)) * tempo / 60.0) + ((0.75 * rep));
        
        return calorias;
    }

}
