 
import java.util.ArrayList;

public class Distancia extends Atividade 
{
    private double distancia;
    
    public Distancia(String nome, double duracao, double dist) 
    {
        super(nome,duracao);
        distancia = dist;

    }
    
    public Distancia(Distancia d) 
    {
        super(d);
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
    //to string da caracteristica da atividade
    public String extraCaracteristicas() {
        return "Distancia: " + getDistancia();
    }
    //nome do tipo de atividade 
    public String getTipoAtividade() {
        return ("Distancia");
    }
    
    public static Distancia parse(String input)
    {
        String[] campos = input.split(",");
        return new Distancia(campos[0], Double.parseDouble(campos[1]), Double.parseDouble(campos[2]));
    }
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Distancia d = (Distancia) obj;
        return super.equals(d);

    }
    
    @Override
    public int calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        // Fórmula para calcular calorias para corrida
        return 0;
    }

}
