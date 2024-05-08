 
import java.util.ArrayList;
import java.time.LocalDate;

public class Alongamentos extends Atividade 
{
    private int repeticoes;
    
    public Alongamentos() 
    {
        super();
        this.repeticoes = 0;

    }
    
    public Alongamentos(int codigo, String nome, String descricao, int duracao,
    int repeticoes, LocalDate data_realizada, int freq_atv, double cal) 
    {
        super(codigo, nome, descricao, duracao, data_realizada, freq_atv, cal);
        this.repeticoes = repeticoes;

    }
    
    public Alongamentos(Alongamentos al) 
    {
        super(al);
        this.repeticoes = al.getRepeticoes();
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
        return new Alongamentos(this);
    }
    
    public static Alongamentos parse(String input)
    {
        String[] campos = input.split(",");

        return new Alongamentos(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),
        null, 0 ,0);
    }
    
    public String getTipoAtividade()
    {
        return("Alongamentos");
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
        Alongamentos alongamentos = (Alongamentos) o;
        return Integer.compare(alongamentos.getRepeticoes(), getRepeticoes()) == 0;
    }
    
    @Override
    public String toString() 
    {
        return "---Alongamentos---" + "\n" +
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
