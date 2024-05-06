import java.io.Serializable;
import java.io.*;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.text.DecimalFormat;

public class Profissional extends Utilizador
{
    private String especialidade;
    private double experiencia;
    
    public Profissional() 
    {
        super();
        this.especialidade= "";
        this.experiencia= 0;
               
    }

    public Profissional(String nick, String pass, String nome, String email, String genero,
    LocalDate data, double altura, double peso, int freq_cardiaca,
    double anose, String especi, double calorias,
    ArrayList<Atividade> historico, HashMap<String,PlanoTreino> planos) 
    {
        super(nick, pass, nome, email, genero, data, altura, peso,
            freq_cardiaca, calorias, historico, planos);
        this.experiencia = anose;
        this.especialidade = especi;
        super.setFatorMultiplicativo(this.calculaFator());
        
        
    }
    

    public Profissional(Profissional pro) 
    {
        super(pro);
        this.experiencia = pro.getAnosExp();
        this.especialidade= pro.getEspecialidade();
    }
    
    public String getEspecialidade() 
    {
        return especialidade;
    }

    public double getAnosExp() 
    {
        return experiencia;
    }
    
    public void setEspecialidade(String es) 
    {
        this.especialidade = es;
    }

    public void setAnosExp(double an) 
    {
        this.experiencia = an;
    }
    
    @Override
    public Utilizador clone() 
    {
        return new Profissional(this);
    }
    
    //parser
    public static Profissional parse(String linha) 
    {
      String[] campo = linha.split(",");
      if (campo.length != 11) 
      {
        throw new IllegalArgumentException("Input inválido.");
      }
      String[] data_nascimento = campo[5].split("-");
      
      return new Profissional(campo[0], campo[1], campo[2], campo[3], 
      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
      Integer.parseInt(campo[8]), Double.parseDouble(campo[9]), campo[10], 0, new ArrayList<>() , new HashMap<>());
    }
    
    public String getTipoUtilizador()
    {
        return("Profissional");
    }
    
    public String caracteristicasUExtra()
    {
        return "Especialidade :" + getEspecialidade() + "\n" +
                "Anos de Experiencia :" + getAnosExp();
    }
    
    public double calculaFator() 
    {
        double ufator = 0;
        long idade =  ChronoUnit.YEARS.between(LocalDate.now(),
                super.getDataNascimento());
        if ( idade <= 50)
        {
            ufator =  ((double) idade +  super.getPeso() +  super.getAltura() +  this.getAnosExp()) * 1.6;
        }
        else
        {
            ufator =  ((double) idade +  super.getPeso() +  super.getAltura() + this.getAnosExp()) * 1.2;
            
        }
        /*
        DecimalFormat df = new DecimalFormat("#.##");
        ufator = Double.parseDouble(df.format(ufator));
        */
        return ufator;
    }
    
    public void adicionaPlanoTreino(PlanoTreino pt) throws PlanoTreinoExisteException {
        if (super.getPlanosTreino().containsKey(pt.getNomePlano()))
            throw new PlanoTreinoExisteException("Plano de Treino ja adicionado");
        else
            super.getPlanosTreino().put(pt.getNomePlano(), pt.clone());

    }
    
    //eu nao sei se a parte de mudar a data é aceitavel
    public void realizaAtividade(Atividade a, Utilizador u, LocalDate d, int freq_atv)
    {   
        //adiciona data e frequencia atividade à atividade
        a.setDataRealizada(d);
        a.setFreqCardiaAtiviade(freq_atv);
        a.setCaloriasGastasAtividade(a.calcularCalorias(u));
        super.addCaloriasGastas(a.getCaloriasGastasAtividade());
        //adiciona ao historico
        super.getHistorico().add(a.clone());
        
    }
    
    /* 
     * Ainda nao utilizadada
    public void removePlanoTreino(PlanoTreino pt) throws PlanoTreinoNaoExisteException {
        String n = pt.getNomePlano();
        if (!this.planos_treino.containsKey(n))
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");
        else {

            this.planos_treino.remove(n);
        }
    }
    */
    
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nProfissional: ").append(super.toString()).append('\n').append("Especialidade: ")
        .append(this.especialidade).append('\n')
        .append("\nAnos de Experiencia: ").append(this.experiencia).append('\n');
        
        return sb.toString();
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Profissional profissional = (Profissional) obj;
        return this.getEspecialidade().equals(profissional.getEspecialidade())
                && this.getAnosExp() == profissional.getAnosExp();

    }
    
}
