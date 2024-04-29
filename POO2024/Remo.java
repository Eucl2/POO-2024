 
import java.util.ArrayList;
import java.time.LocalDate;

public class Remo extends Atividade 
{
    private double distancia;
    private String percurso;
    
    public Remo() 
    {
        super();
        this.distancia = 0;
        this.percurso = "";

    }
    
    public Remo(int codigo, String nome, String descricao, int duracao,
    double distancia, String percurso, LocalDate data_realizada) 
    {
        super(codigo, nome, descricao, duracao , data_realizada);
        this.distancia = distancia;
        this.percurso = percurso;

    }
    
    public Remo(Remo r) 
    {
        super(r);
        this.distancia = r.getDistancia();
        this.percurso = r.getPercurso();
    }

    public double getDistancia() 
    {
        return distancia;
    }
    
    public String getPercurso() 
    {
        return percurso;
    }

    public void setDistancia(double distancia) 
    {
        this.distancia = distancia;
    }
    
    public void setPercurso(String percurso) 
    {
        this.percurso = percurso;
    }
    
    @Override
    public Atividade clone() 
    {
        return new Remo(this);
    }
    
    public static Remo parse(String input)
    {
        String[] campos = input.split(",");

        return new Remo(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
        campos[5], LocalDate.EPOCH);
    }
    
    public String getTipoAtividade()
    {
        return("Remo");
    }

    public String caracteristicasExtra()
    {
        return "Distancia:" + getDistancia() + "\n" +
                "Percurso:" + getPercurso();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Remo remo = (Remo) o;
        return Double.compare(remo.getDistancia(), getDistancia()) == 0
                && this.getPercurso().equals(remo.getPercurso());
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nRemo: ").append(super.toString()).append('\n').append("Distancia: ")
        .append(this.distancia).append('\n')
        .append("\nPercurso: ").append(this.percurso).append('\n');
        
        return sb.toString();
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        double calorias = distancia*(utilizador.getPeso())*getDuracao();
        return calorias;
    }

}
