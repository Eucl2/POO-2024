import java.io.Serializable;
import java.io.*;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Amador extends Utilizador
{
    private String nivelExp;
    private String modalidade_favorita;
    
    public Amador() 
    {
        super();
        this.nivelExp = "";
        this.modalidade_favorita = "";
               
    }

    public Amador(String nick, String pass, String nome, String email, String genero,
    LocalDate data, double altura, double peso, int freq_cardiaca,
    String nivel, String mod_fav, double calorias,
    ArrayList<Atividade> historico, ArrayList<PlanoTreino> planos) 
    {
        super(nick, pass, nome, email, genero, data, altura, peso,
            freq_cardiaca, calorias, historico, planos);
        this.nivelExp = nivel;
        this.modalidade_favorita = mod_fav;
        setFatorMultiplicativo(this.calculaFator());
        
        
    }

    public Amador(Amador ama) 
    {
        super(ama);
        this.nivelExp = ama.getNivel();
        this.modalidade_favorita = ama.getModFavorita();
    }
    
    public String getNivel() 
    {
        return this.nivelExp;
    }

    public String getModFavorita() 
    {
        return this.modalidade_favorita;
    }
    
    public void setNivel(String n) 
    {
        this.nivelExp = n;
    }

    public void setModFavorita(String modal) 
    {
        this.modalidade_favorita = modal;
    }
    
    @Override
    public Utilizador clone() 
    {
        return new Amador(this);
    }
    
    //parser
    public static Amador parse(String linha) 
    {
      String[] campo = linha.split(",");
      if (campo.length != 11) 
      {
        throw new IllegalArgumentException("Input inválido.");
      }
      String[] data_nascimento = campo[5].split("-");
      
      return new Amador(campo[0], campo[1], campo[2], campo[3], 
      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
      Integer.parseInt(campo[8]), campo[9], campo[10], 0, new ArrayList<>() , new ArrayList<>());
    }
    
    public String getTipoUtilizador()
    {
        return("Amador");
    }
    
    public String caracteristicasUExtra()
    {
        return "Nivel Experiencia:" + getNivel() + "\n" +
                "Modalidade Favorita:" + getModFavorita();
    }
    
    public double calculaFator() 
    {
        double ufator = 0;
        double idade =  (double) ChronoUnit.YEARS.between(getDataNascimento(),LocalDate.now());
        String tipo = this.getNivel();
        
        if ("Avancado".equals(tipo))
        {
            ufator = (double) (idade + (double)  getPeso() + (double) getAltura()) * 0.7;
        }
        else
        {
            if ("Intermedio".equals(tipo))
            {
                ufator = (double) (idade + (double)  getPeso() + (double) getAltura()) * 0.5;
            }
            else
            {
               if ("Iniciante".equals(tipo))
                {
                    ufator = (double) (idade + (double)  getPeso() + (double) getAltura()) * 0.3;
                } 
                else
                {
                    ufator = 6666;
                }
            }
        }
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
        sb.append("\nAmador: ").append(super.toString()).append('\n').append("Nivel De Experiencia: ")
        .append(this.nivelExp).append('\n')
        .append("\nModalidade Favorita: ").append(this.modalidade_favorita).append('\n');
        
        return sb.toString();
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Amador amador = (Amador) obj;
        return this.getNivel().equals(amador.getNivel())
                && this.getModFavorita().equals(amador.getModFavorita());

    }
    
}
