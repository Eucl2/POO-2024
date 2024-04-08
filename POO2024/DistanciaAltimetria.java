 
import java.util.ArrayList;

public class DistanciaAltimetria extends Atividade 
{
    private double distancia;
    private double altura;
    
    public DistanciaAltimetria(String nome, double duracao, double dist, double alt) 
    {
        super(nome,duracao);
        distancia = dist;
        altura = alt;

    }
    
    public DistanciaAltimetria(DistanciaAltimetria da) 
    {
        super(da);
        this.distancia = da.getDistancia();
        this.altura = da.getAltura();
    }

    public double getDistancia() 
    {
        return this.distancia;
    }

    public void setDistancia(double distancia) 
    {
        this.distancia = distancia;
    }
    
    public double getAltura() {
        return this.altura;
    }
    
    public void setAltura(double altura) 
    {
        this.altura= altura;
    }

    public DistanciaAltimetria clone() 
    {
        return new DistanciaAltimetria(this);
    }
    
    //to string da caracteristica da atividade
    public String extraCaracteristicas() {
        return "Distancia: " + getDistancia() + "\n Altimetria: " + getAltura();
    }
    //nome do tipo de atividade 
    public String getTipoAtividade() {
        return ("Distancia_Altimetria");
    }
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        DistanciaAltimetria da = (DistanciaAltimetria) obj;
        return super.equals(da);

    }
    
    @Override
    public int calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade) {
        // Fórmula para calcular calorias para corrida
        return 0;
    }
}
