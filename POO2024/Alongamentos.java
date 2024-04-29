 
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
    int repeticoes, LocalDate data_realizada) 
    {
        super(codigo, nome, descricao, duracao, data_realizada);
        this.repeticoes = repeticoes;

    }
    
    public Alongamentos(Alongamentos al) 
    {
        super(al);
        this.repeticoes = al.getRepeticoes();
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
        return new Alongamentos(this);
    }
    
    public static Alongamentos parse(String input)
    {
        String[] campos = input.split(",");

        return new Alongamentos(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Integer.parseInt(campos[4]),
        LocalDate.EPOCH);
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
        StringBuilder sb = new StringBuilder();
        sb.append("\nAlongamentos: ").append(super.toString()).append('\n').append("Repeticoes: ")
        .append(this.repeticoes).append('\n');
        
        return sb.toString();
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        double calorias = repeticoes*(utilizador.getPeso())*getDuracao();
        return calorias;
    }

}
