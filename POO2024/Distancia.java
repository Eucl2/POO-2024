 
import java.util.ArrayList;

public class Distancia extends Atividade 
{
    private double distancia;
    
    public Distancia(String nome, int duracao, double dist) 
    {
        super(nome,duracao);
        distancia = dist;

    }
    
    public Distancia(Distancia d) 
    {
        super(d.getNome(), d.getDuracao());
        this.distancia = d.getDistancia();
    }

    public double getDistancia() 
    {
        return this.distancia;
    }

    public void setDistancia(double distancia) 
    {
        this.distancia = distancia;
    }

    public Distancia clone() 
    {
        return new Distancia(this);
    }

}
