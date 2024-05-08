 
import java.util.ArrayList;
import java.time.LocalDate;

public class ExtensaoPernas extends Atividade 
{
    private int repeticoes;
    private double peso;
    
    public ExtensaoPernas() 
    {
        super();
        this.repeticoes = 0;
        this.peso = 0;
        

    }
    
    public ExtensaoPernas(int codigo, String nome, String descricao, int duracao,
    int repeticoes, double peso, LocalDate data_realizada, int freq_atv, double cal) 
    {
        super(codigo, nome, descricao, duracao, data_realizada, freq_atv, cal);
        this.repeticoes = repeticoes;
        this.peso = peso;

    }
    
    public ExtensaoPernas(ExtensaoPernas ex) 
    {
        super(ex);
        this.repeticoes = ex.getRepeticoes();
        this.peso = ex.getPeso();
    }

    public int getRepeticoes() 
    {
        return this.repeticoes;
    }
    
    public double getPeso() 
    {
        return this.peso;
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
        return new ExtensaoPernas(this);
    }
    
    public static ExtensaoPernas parse(String input)
    {
        String[] campos = input.split(",");

        return new ExtensaoPernas(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),
        Double.parseDouble(campos[5]),null, 0, 0);
    }
    
    public String getTipoAtividade()
    {
        return("ExtensaoPernas");
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
        ExtensaoPernas extensaopernas = (ExtensaoPernas) o;
        return Integer.compare(extensaopernas.getRepeticoes(), getRepeticoes()) == 0
                && Double.compare(extensaopernas.getPeso(), getPeso()) == 0;
    }
    
    @Override
    public String toString() 
    {
        return "---Extensao de Pernas---" + "\n" +
                super.toString() + 
                "Repeticoes:" + this.repeticoes + "\n" +
                "Peso:" + this.peso + "\n" ;
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador) {
        int freq_ativ = getFreqCardiaAtividade();
        double fator = utilizador.getFatorMultiplicativo();
        int freq_med = utilizador.getFreqCardiaca();
        int tempo = getDuracao();
        int rep = getRepeticoes();
        double pes = getPeso();
        
        
        double calorias = ((0.035 * fator) * (freq_med + (0.12 * freq_ativ)) * tempo / 60.0) + ((0.75 * rep)+ (0.25 * pes));
        
        return calorias;
    }

}
