import java.io.Serializable;
import java.io.*;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ocasional extends Utilizador
{
    private int frequencia_pratica;
    private String motivacao;
    
    public Ocasional() 
    {
        super();
        this.frequencia_pratica= 0;
        this.motivacao= "";
               
    }

    public Ocasional(String nick, String pass, String nome, String email, String genero,
    LocalDate data, double altura, double peso, int freq_cardiaca,
    int freq_p, String moti, double calorias,
    ArrayList<Atividade> historico, ArrayList<PlanoTreino> planos) 
    {
        super(nick, pass, nome, email, genero, data, altura, peso,
            freq_cardiaca, calorias, historico, planos);
        this.frequencia_pratica = freq_p;
        this.motivacao = moti;
        setFatorMultiplicativo(this.calculaFator());
        
        
    }

    public Ocasional(Ocasional oc) 
    {
        super(oc);
        this.frequencia_pratica= oc.getFreqPratica();
        this.motivacao= oc.getMotivacao();
    }
    
    public int getFreqPratica() 
    {
        return this.frequencia_pratica;
    }

    public String getMotivacao() 
    {
        return this.motivacao;
    }
    
    public void setFreqPratica(int fre) 
    {
        this.frequencia_pratica = fre;
    }

    public void setMotivacao(String moti) 
    {
        this.motivacao = moti;
    }
    
    @Override
    public Utilizador clone() 
    {
        return new Ocasional(this);
    }
    
    //parser
    public static Ocasional parse(String linha) 
    {
      String[] campo = linha.split(",");
      if (campo.length != 11) 
      {
        throw new IllegalArgumentException("Input inválido.");
      }
      String[] data_nascimento = campo[5].split("-");
      
      return new Ocasional(campo[0], campo[1], campo[2], campo[3], 
      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
      Integer.parseInt(campo[8]), Integer.parseInt(campo[9]), campo[10], 0, new ArrayList<>() , new ArrayList<>());
    }
    
    public String getTipoUtilizador()
    {
        return("Ocasional");
    }
    
    public String caracteristicasUExtra()
    {
        return "Frequencia de Pratica :" + getFreqPratica() + "\n" +
                "Motivacao :" + getMotivacao();
    }
    
    public double calculaFator() 
    {
        double ufator = 0;
        long idade =  ChronoUnit.YEARS.between(LocalDate.now(),
                getDataNascimento());
        ufator = (double) (idade + (double)  getPeso() + (double) getAltura() + this.getFreqPratica()) * 0.1;
        
        
        return ufator;
    }
    
    //!
    public void realizaAtividade(Atividade a, Utilizador u, LocalDate d, int freq_atv)
    {   
        //adiciona data e frequencia atividade à atividade
        a.setDataRealizada(d);
        a.setFreqCardiaAtiviade(freq_atv);
        a.setCaloriasGastasAtividade(a.calcularCalorias(u));
        
        //adiciona ao contador de calorias do utilizador as calorias da atividade
        addCaloriasGastas(a.getCaloriasGastasAtividade());
        
        //adiciona ao historico
        addHistoricoU(a);
    
        
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nOcasional: ").append(super.toString()).append('\n').append("Frequencia Pratica: ")
        .append(this.frequencia_pratica).append('\n')
        .append("\nMotivacao: ").append(this.motivacao).append('\n');
        
        return sb.toString();
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Ocasional ocasional = (Ocasional) obj;
        return this.getFreqPratica() == (ocasional.getFreqPratica())
                && this.getMotivacao().equals(ocasional.getMotivacao());

    }
    
}
