 
import java.util.ArrayList;
import java.time.LocalDate;

public class Corrida extends Atividade 
{
    private double distancia;
    private double altimetria;
    private String percurso;
    
    public Corrida() 
    {
        super();
        this.distancia = 0;
        this.altimetria = 0;
        this.percurso = "";

    }
    
    public Corrida(int codigo, String nome, String descricao, int duracao,
    double distancia, double altimetria, String percurso, LocalDate data_realizada) 
    {
        super(codigo, nome, descricao, duracao, data_realizada);
        this.distancia = distancia;
        this.altimetria = altimetria;
        this.percurso = percurso;

    }
    
    public Corrida(Corrida c) 
    {
        super(c);
        this.distancia = c.getDistancia();
        this.altimetria = c.getAltimetria();
        this.percurso = c.getPercurso();
    }

    public double getDistancia() 
    {
        return distancia;
    }
    
    public double getAltimetria() 
    {
        return altimetria;
    }
    
    public String getPercurso() 
    {
        return percurso;
    }

    public void setDistancia(double distancia) 
    {
        this.distancia = distancia;
    }
    
    public void setAltimetria(double altimetria) 
    {
        this.altimetria = altimetria;
    }
    
    public void setPercurso(String percurso) 
    {
        this.percurso = percurso;
    }
    
    @Override
    public Atividade clone() 
    {
        return new Corrida(this);
    }
    
    public static Corrida parse(String input)
    {
        String[] campos = input.split(",");

        return new Corrida(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
        Double.parseDouble(campos[5]), campos[6], LocalDate.EPOCH);
    }
    
    public String getTipoAtividade()
    {
        return("Corrida");
    }

    public String caracteristicasExtra()
    {
        return "Distancia:" + getDistancia() + "\n" +
                "Altimetria:" + getAltimetria() + "\n" +
                "Percurso:" + getPercurso();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Corrida corrida = (Corrida) o;
        return Double.compare(corrida.getDistancia(), getDistancia()) == 0
                && Double.compare(corrida.getAltimetria(), getAltimetria()) == 0
                && this.getPercurso().equals(corrida.getPercurso());
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCorrida: ").append(super.toString()).append('\n').append("Distancia: ")
        .append(this.distancia).append('\n').append("\nAltimetria: ").append(this.altimetria)
        .append('\n').append("\nPercurso: ").append(this.percurso).append('\n');
        
        return sb.toString();
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        double calorias = distancia*(utilizador.getPeso())*getDuracao();
        return calorias;
    }

}
