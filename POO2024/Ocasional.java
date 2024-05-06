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
    ArrayList<Atividade> historico, HashMap<String,PlanoTreino> planos) 
    {
        super(nick, pass, nome, email, genero, data, altura, peso,
            freq_cardiaca, calorias, historico, planos);
        this.frequencia_pratica = freq_p;
        this.motivacao = moti;
        super.setFatorMultiplicativo(this.calculaFator());
        
        
    }

    public Ocasional(Ocasional oc) 
    {
        super(oc);
        this.frequencia_pratica= oc.getFreqPratica();
        this.motivacao= oc.getMotivacao();
    }
    
    public int getFreqPratica() 
    {
        return frequencia_pratica;
    }

    public String getMotivacao() 
    {
        return motivacao;
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
      Integer.parseInt(campo[8]), Integer.parseInt(campo[9]), campo[10], 0, new ArrayList<>() , new HashMap<>());
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
                super.getDataNascimento());
        ufator = (double) (idade + (double)  super.getPeso() + (double) super.getAltura() + this.getFreqPratica()) * 0.1;
        
        
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
