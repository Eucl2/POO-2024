 
import java.util.ArrayList;

public class Distancia_Altimetria extends Atividade {
    private double distancia;
    private double altura;
    
    public Distancia_Altimetria(String nome, int duracao, double dist, double alt) {
        super(nome,duracao);
        distancia = dist;
        altura = alt;

    }
    
    public Distancia_Altimetria(Distancia_Altimetria d) {
        super(d.getNome(), d.getDuracao());
        this.distancia = d.getDistancia();
        this.altura = d.getAltura();
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public double getAltura() {
        return this.altura;
    }
    
    public void setAltura(double altura) {
        this.altura= altura;
    }

    public Distancia_Altimetria clone() {
        return new Distancia_Altimetria(this);
    }

}
