 
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
    double distancia, double altimetria, String percurso, LocalDate data_realizada,
    int freq_atv, double cal) 
    {
        super(codigo, nome, descricao, duracao, data_realizada, freq_atv, cal);
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
        Double.parseDouble(campos[5]), campos[6], null, 0, 0);
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
        return "---Corrida---" + "\n" +
                super.toString() + 
                "Distancia:" + this.distancia + "\n" +
                "Altimetria:" + this.altimetria + "\n" +
                "Percurso:" + this.percurso + "\n";
    }

    
    @Override
    public double calcularCalorias(Utilizador utilizador) {
        int freq_ativ = super.getFreqCardiaAtividade();
        double fator = utilizador.getFatorMultiplicativo();
        int freq_med = utilizador.getFreqCardiaca();
        int tempo = super.getDuracao();
        double dist = getDistancia();
        double alt  = getAltimetria();
        
        
        double calorias = ((0.035 * fator) * (freq_med + (0.12 * freq_ativ)) * tempo / 60.0) + ((0.75 * dist) + (0.25 * alt));
        
        return calorias;
    }

}
