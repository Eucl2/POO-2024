 
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
    int repeticoes, double peso, LocalDate data_realizada) 
    {
        super(codigo, nome, descricao, duracao, data_realizada);
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
        return new ExtensaoPernas(this);
    }
    
    public static ExtensaoPernas parse(String input)
    {
        String[] campos = input.split(",");

        return new ExtensaoPernas(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),
        Double.parseDouble(campos[5]),LocalDate.EPOCH);
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
        StringBuilder sb = new StringBuilder();
        sb.append("\nExtensaoPernas: ").append(super.toString()).append('\n').append("Repeticoes: ")
        .append(this.repeticoes).append('\n').append("\nPeso: ").append(this.peso)
        .append('\n');
        
        return sb.toString();
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        double calorias = repeticoes*(utilizador.getPeso())*getDuracao();
        return calorias;
    }

}
