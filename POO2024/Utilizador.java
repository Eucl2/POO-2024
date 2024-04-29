import java.io.Serializable;
import java.io.*;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;

public class Utilizador implements Serializable 
{
    private int idUtilizador;
    private String password;
    private String nomeUtilizador;
    private String emailUtilizador;
    private String generoUtilizador;
    private LocalDate data_nascimento;
    private double alturaUtilizador;
    private double pesoUtilizador;
    private int frequencia_cardiaca_media;
    private TipoAtleta tipo_atleta;
    private Map<Integer, Atividade> historico_atividades;
    private Map<String, PlanoTreino> planos_treino;

    public Utilizador() 
    {
        idUtilizador = 0;
        password = "";
        nomeUtilizador = "";
        emailUtilizador = "";
        generoUtilizador = "";
        data_nascimento = LocalDate.EPOCH;
        alturaUtilizador = 0;
        pesoUtilizador = 0;
        frequencia_cardiaca_media = 0;
        tipo_atleta = null;
        historico_atividades = new HashMap<>();
        planos_treino = new HashMap<>();
        
        
    }

    public Utilizador(int id, String pass, String nome, String email, String genero,
    LocalDate data, double altura, double peso, int freq_cardiaca,
    TipoAtleta atleta) 
    {
        idUtilizador = id;
        password = pass;
        nomeUtilizador = nome;
        emailUtilizador = email;
        generoUtilizador = genero;
        data_nascimento = data;
        alturaUtilizador = altura;
        pesoUtilizador = peso;
        frequencia_cardiaca_media = freq_cardiaca;
        tipo_atleta = atleta;
        historico_atividades = new HashMap<>();
        planos_treino = new HashMap<>();
        
        
    }

    public Utilizador(Utilizador u) 
    {
        idUtilizador = u.getId();
        password = u.getPassword();
        nomeUtilizador = u.getNome();
        emailUtilizador = u.getEmail();
        generoUtilizador = u.getGenero();
        data_nascimento = u.getDataNascimento();
        alturaUtilizador = u.getAltura();
        pesoUtilizador = u.getPeso();
        frequencia_cardiaca_media = u.getFreqCardiaca();
        tipo_atleta = u.getAtleta();
        historico_atividades = u.getHistorico();
        planos_treino = u.getPlanosTreino();
    }
    
    public int getId() 
    {
        return idUtilizador;
    }

    public String getPassword() 
    {
        return password;
    }
    
    public String getNome() 
    {
        return nomeUtilizador;
    }
    
    public String getEmail() 
    {
        return emailUtilizador;
    }
    
    public String getGenero() 
    {
        return generoUtilizador;
    }
    
    public LocalDate getDataNascimento() 
    {
        return data_nascimento;
    }
    
    public double getAltura() 
    {
        return alturaUtilizador;
    }
    
    public double getPeso() 
    {
        return pesoUtilizador;
    }
    
    public int getFreqCardiaca() 
    {
        return frequencia_cardiaca_media;
    }
    
    public TipoAtleta getAtleta() 
    {
        return tipo_atleta;
    }
    
    public Map<Integer, Atividade> getHistorico() 
    {
       return this.historico_atividades.values().stream().collect(Collectors.toMap(u -> u.getCodigo(), u -> u.clone()));
    }
    
    public Map<String, PlanoTreino> getPlanosTreino() 
    {
        return this.planos_treino.values().stream().collect(Collectors.toMap(u -> u.getNomePlano(), u -> u.clone()));

    }
    
    public void setId(int id) 
    {
        this.idUtilizador = id;
    }

    public void setPassword(String pass) 
    {
        this.password = pass;
    }
    
    public void setNome(String nome) 
    {
        this.nomeUtilizador = nome;
    }
    
    public void setEmail(String email) 
    {
        this.emailUtilizador = email;
    }
    
    public void setGenero(String genero) 
    {
        this.generoUtilizador = genero;
    }
    
    public void setDataNascimento(LocalDate data) 
    {
        this.data_nascimento = data;
    }
    
    public void setAltura(double altura) 
    {
        this.alturaUtilizador = altura;
    }
    
    public void getPeso(double peso) 
    {
        this.pesoUtilizador = peso;
    }
    
    public void getFreqCardiaca(int freq) 
    {
        this.frequencia_cardiaca_media = freq;
    }
    
    public void setAtleta(TipoAtleta atleta) 
    {
        this.tipo_atleta = atleta;
    }
    
    public void setHistorico(Map<Integer, Atividade> historico) 
    {
        this.historico_atividades = historico.values().stream()
                .collect(Collectors.toMap(u -> u.getCodigo(), u -> u.clone()));
                //rever
    }
    
    public void setPlanosTreino(Map<String, PlanoTreino> planos_treino) 
    {
        this.planos_treino = planos_treino.values().stream()
                .collect(Collectors.toMap(u -> u.getNomePlano(), u -> u.clone()));
                //rever
    }
    
    public Utilizador clone()
    {
        return new Utilizador(this);
    }
    
    //eu nao sei se a parte de mudar a data é aceitavel
    public void realizaAtividade(Atividade a, LocalDate d)
    {
        this.historico_atividades.put(a.getCodigo(), a.clone());
        /*
        if (this.historico_atividades.containsKey(a.getCodigo()))
        {
            this.historico_atividades.get(a.getCodigo()).setDataRealizada(d);
        }
        */
        //alterar a data
        this.historico_atividades.get(a.getCodigo()).setDataRealizada(d);
        
        
    }
    
    public void adicionaPlanoTreino(PlanoTreino pt) {
        this.planos_treino.put(pt.getNomePlano(), pt.clone());

    }
    // verificar se é necessaria
    public void setPlanoTreino(PlanoTreino pt) throws PlanoTreinoExisteException {
        if (this.planos_treino.containsKey(pt.getNomePlano()))
            throw new PlanoTreinoExisteException("Plano de Treino ja adicionado");
        else
            this.planos_treino.put(pt.getNomePlano(), pt.clone());
    }

    public void removePlanoTreino(PlanoTreino pt) throws PlanoTreinoNaoExisteException {
        String n = pt.getNomePlano();
        if (!this.planos_treino.containsKey(n))
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");
        else {

            this.planos_treino.remove(n);
        }
    }
    
    public static Utilizador parse(String linha) 
    {
      String[] campo = linha.split(",");
      if (campo.length != 10) 
      {
        throw new IllegalArgumentException("Input inválido.");
      }
      String[] data_nascimento = campo[5].split("-");
      
      return new Utilizador(Integer.parseInt(campo[0]), campo[1], campo[2], campo[3], 
      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
      Integer.parseInt(campo[8]), TipoAtleta.valueOf(campo[9]));
    }
    
    @Override
    public String toString() 
    {
        String r =  "Id:" + idUtilizador + "\n" +
                    "Password:" + password + "\n" +
                    "Nome:" + nomeUtilizador + "\n" +
                    "Email:" + emailUtilizador + "\n" +
                    "Genero:" + generoUtilizador + "\n" +
                    "Data de Nascimento:" + data_nascimento + "\n" + 
                    "Altura:" + alturaUtilizador + "\n" +
                    "Peso:" + pesoUtilizador + "\n" +
                    "Frequencia Cardiaca Media:" + frequencia_cardiaca_media+ "\n" +
                    "Tipo de Atleta:" + tipo_atleta + "\n" +
                    
                    
                    "Historico:" + "\n" ;
        for(Atividade a : historico_atividades.values())
        {
            r += a.toString();
        }
        r += "Planos de Treino:" + "\n";
        for(PlanoTreino pt : planos_treino.values())
        {
            r += pt.toString();
        }
               
        return r;
    }
    
    public String toStringHistorico()
    {
        /*
        String r = "Id:" + idUtilizador + "\n" +
        "Nome:" + nomeUtilizador + "\n" + "Tipo de Atleta:" + tipo_atleta + "\n" +
        "Historico de Atividades:" + "\n";
        */
        String r = "\n";
        for(Atividade a : historico_atividades.values())
        {
            r += a.toString2() + "\n";
        }
        return r;
    }
    
    public String toStringPlanosTreinoU()
    {
        /*
        String r = "Id:" + idUtilizador + "\n" +
        "Nome:" + nomeUtilizador + "\n" + "Tipo de Atleta:" + tipo_atleta + "\n" +
        "Planos de Treino:" + "\n";
        */
        String r = "\n";
        for(PlanoTreino pt : planos_treino.values())
        {
            r += pt.toString() + "\n";
        }
        return r;
    }
    
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Utilizador u = (Utilizador) obj;
        return u.getId() == (this.idUtilizador) && u.getPassword().equals(this.password) 
            && u.getNome().equals(this.nomeUtilizador) && u.getEmail().equals(this.emailUtilizador)
            && u.getGenero().equals(this.generoUtilizador) && u.getDataNascimento().equals(this.data_nascimento)
            && u.getAltura() == (this.alturaUtilizador) && u.getPeso() == (this.pesoUtilizador)
            && u.getFreqCardiaca() == (this.frequencia_cardiaca_media)
            && u.getAtleta().equals(this.tipo_atleta) && u.getHistorico().equals(this.historico_atividades)
            && u.getPlanosTreino().equals(this.planos_treino);

    }
    
}