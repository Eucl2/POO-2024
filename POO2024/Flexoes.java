 
import java.util.ArrayList;
import java.time.LocalDate;

public class Flexoes extends Atividade 
{
    private int repeticoes;
    
    public Flexoes() 
    {
        super();
        this.repeticoes = 0;

    }
    
    public Flexoes(int codigo, String nome, String descricao, int duracao,
    int repeticoes, LocalDate data_realizada) 
    {
        super(codigo, nome, descricao, duracao, data_realizada);
        this.repeticoes = repeticoes;

    }
    
    public Flexoes(Flexoes f) 
    {
        super(f);
        this.repeticoes = f.getRepeticoes();
    }

    public int getRepeticoes() 
    {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) 
    {
        this.repeticoes = repeticoes;
    }
    
    @Override
    public Atividade clone() 
    {
        return new Flexoes(this);
    }
    
    public static Flexoes parse(String input)
    {
        String[] campos = input.split(",");

        return new Flexoes(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),
        LocalDate.EPOCH);
    }
    
    public String getTipoAtividade()
    {
        return("Flexoes");
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
        Flexoes flexoes = (Flexoes) o;
        return Integer.compare(flexoes.getRepeticoes(), getRepeticoes()) == 0;
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFlexoes: ").append(super.toString()).append('\n').append("Repeticoes: ")
        .append(this.repeticoes).append('\n');
        
        return sb.toString();
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        double calorias = repeticoes*(utilizador.getPeso())*getDuracao();
        return calorias;
    }

}
