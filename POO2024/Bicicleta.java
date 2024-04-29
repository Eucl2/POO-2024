 
import java.util.ArrayList;
import java.time.LocalDate;

public class Bicicleta extends Atividade 
{
    private double distancia;
    private double altimetria;
    private String percurso;
    
    public Bicicleta() 
    {
        super();
        this.distancia = 0;
        this.altimetria = 0;
        this.percurso = "";

    }
    
    public Bicicleta(int codigo, String nome, String descricao, int duracao,
    double distancia, double altimetria, String percurso, LocalDate data_realizada) 
    {
        super(codigo, nome, descricao, duracao, data_realizada);
        this.distancia = distancia;
        this.altimetria = altimetria;
        this.percurso = percurso;

    }
    
    public Bicicleta(Bicicleta b) 
    {
        super(b);
        this.distancia = b.getDistancia();
        this.altimetria = b.getAltimetria();
        this.percurso = b.getPercurso();
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
        return new Bicicleta(this);
    }
    
    public static Bicicleta parse(String input)
    {
        String[] campos = input.split(",");

        return new Bicicleta(Integer.parseInt(campos[0]),campos[1],
        campos[2],Integer.parseInt(campos[3]),Double.parseDouble(campos[4]),
        Double.parseDouble(campos[5]), campos[6], LocalDate.EPOCH);
    }
    
    public String getTipoAtividade()
    {
        return("Bicicleta");
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
        Bicicleta bicicleta = (Bicicleta) o;
        return Double.compare(bicicleta.getDistancia(), getDistancia()) == 0
                && Double.compare(bicicleta.getAltimetria(), getAltimetria()) == 0
                && this.getPercurso().equals(bicicleta.getPercurso());
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nBicicleta: ").append(super.toString()).append('\n').append("Distancia: ")
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