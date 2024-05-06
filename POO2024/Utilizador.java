import java.io.Serializable;
import java.io.*;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;

public abstract class  Utilizador implements Serializable 
{
    private String nickname;
    private String password;
    private String nomeUtilizador;
    private String emailUtilizador;
    private String generoUtilizador;
    private LocalDate data_nascimento;
    private double alturaUtilizador;
    private double pesoUtilizador;
    private int frequencia_cardiaca_media;
    private double fator_multiplicativo;
    private double total_calorias;
    private List<Atividade> historico_atividades;
    private Map<String, PlanoTreino> planos_treino;

    public Utilizador() 
    {
        this.nickname = "";
        this.password = "";
        this.nomeUtilizador = "";
        this.emailUtilizador = "";
        this.generoUtilizador = "";
        this.data_nascimento = LocalDate.EPOCH;
        this.alturaUtilizador = 0;
        this.pesoUtilizador = 0;
        this.frequencia_cardiaca_media = 0;
        this.fator_multiplicativo = 0;
        this.total_calorias =0;
        this.historico_atividades = new ArrayList<>();
        this.planos_treino = new HashMap<>();
        
        
    }

    public Utilizador(String nick, String pass, String nome, String email, String genero,
    LocalDate data, double altura, double peso, int freq_cardiaca, double calorias, ArrayList<Atividade> historico, HashMap<String,PlanoTreino> planos) 
    {
        nickname = nick;
        password = pass;
        nomeUtilizador = nome;
        emailUtilizador = email;
        generoUtilizador = genero;
        data_nascimento = data;
        alturaUtilizador = altura;
        pesoUtilizador = peso;
        frequencia_cardiaca_media = freq_cardiaca;
        fator_multiplicativo = this.calculaFator();
        total_calorias = calorias;
        this.historico_atividades = historico;
        this.planos_treino = planos;
        
        
    }

    public Utilizador(Utilizador u) 
    {
        nickname = u.getNick();
        password = u.getPassword();
        nomeUtilizador = u.getNome();
        emailUtilizador = u.getEmail();
        generoUtilizador = u.getGenero();
        data_nascimento = u.getDataNascimento();
        alturaUtilizador = u.getAltura();
        pesoUtilizador = u.getPeso();
        frequencia_cardiaca_media = u.getFreqCardiaca();
        fator_multiplicativo = u.getFatorMultiplicativo();
        total_calorias = u.getTotalCalorias();
        historico_atividades = u.getHistorico();
        planos_treino = u.getPlanosTreino();
    }
    
    //calcular fator
    public abstract double calculaFator();
    
    public String getNick() 
    {
        return nickname;
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
    
    public double getFatorMultiplicativo()
    {
        return this.fator_multiplicativo;
    }
    
    public double getTotalCalorias() 
    {
        return total_calorias;
    }
    
    public List<Atividade> getHistorico() 
    {
       return historico_atividades;
    }
    
    public Map<String, PlanoTreino> getPlanosTreino() 
    {
        return this.planos_treino.values().stream().collect(Collectors.toMap(u -> u.getNomePlano(), u -> u.clone()));

    }
    
    public void setNick(String nick) 
    {
        this.nickname = nick;
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
    
    public void setPeso(double peso) 
    {
        this.pesoUtilizador = peso;
    }
    
    public void setFreqCardiaca(int freq) 
    {
        this.frequencia_cardiaca_media = freq;
    }
    
    //rever
    public void setFatorMultiplicativo(double fm)
    {
        this.fator_multiplicativo = fm;
    }
    
    public void setCaloriasGastas(double calorias)
    {
        this.total_calorias  = calorias;
    }
    
    //rever, mas tem base no ficheiro do store
    public void addCaloriasGastas(double calorias) 
    {
        this.total_calorias += calorias;
    }
    
    public void setHistorico(List<Atividade> historico) 
    {
        this.historico_atividades = historico;
    }
    
    public void setPlanosTreino(Map<String, PlanoTreino> planos_treino) 
    {
        this.planos_treino = planos_treino.values().stream()
                .collect(Collectors.toMap(u -> u.getNomePlano(), u -> u.clone()));
                //rever
    }
    
    public abstract Utilizador clone();
    
    public abstract String getTipoUtilizador();

    public abstract String caracteristicasUExtra();
    
    //eu nao sei se a parte de mudar a data é aceitavel
    public abstract void realizaAtividade(Atividade a, Utilizador u, LocalDate d, int freq_atv);
    /*
    {
        this.historico_atividades.add(a.clone());
    
        if (this.historico_atividades.containsKey(a.getCodigo()))
        {
            this.historico_atividades.get(a.getCodigo()).setDataRealizada(d);
        }
        
        //alterar a data
        //this.historico_atividades.get(a.getCodigo()).setDataRealizada(d);
    */   
    public abstract void adicionaPlanoTreino(PlanoTreino pt) throws PlanoTreinoExisteException;    
    /*
    public void adicionaPlanoTreino(PlanoTreino pt) throws PlanoTreinoExisteException {
        if (this.planos_treino.containsKey(pt.getNomePlano()))
            throw new PlanoTreinoExisteException("Plano de Treino ja adicionado");
        else
            this.planos_treino.put(pt.getNomePlano(), pt.clone());

    }
    */
    // verificar se é necessaria
    /*
    public void setPlanoTreino(PlanoTreino pt) throws PlanoTreinoExisteException {
        if (this.planos_treino.containsKey(pt.getNomePlano()))
            throw new PlanoTreinoExisteException("Plano de Treino ja adicionado");
        else
            this.planos_treino.put(pt.getNomePlano(), pt.clone());
    }
    */
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
    /*
    public static Utilizador parse(String linha) 
    {
      String[] campo = linha.split(",");
      if (campo.length != 9) 
      {
        throw new IllegalArgumentException("Input inválido.");
      }
      String[] data_nascimento = campo[5].split("-");
      
      return new Utilizador(Integer.parseInt(campo[0]), campo[1], campo[2], campo[3], 
      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
      Integer.parseInt(campo[8]));
    }
    */
    @Override
    public String toString() 
    {
        String r =  "NickName:" + nickname + "\n" +
                    "Password:" + password + "\n" +
                    "Nome:" + nomeUtilizador + "\n" +
                    "Email:" + emailUtilizador + "\n" +
                    "Genero:" + generoUtilizador + "\n" +
                    "Data de Nascimento:" + data_nascimento + "\n" + 
                    "Altura:" + alturaUtilizador + "\n" +
                    "Peso:" + pesoUtilizador + "\n" +
                    "Frequencia Cardiaca Media:" + frequencia_cardiaca_media+ "\n" +
                    "Fator Multiplicativo: " + fator_multiplicativo + "\n" +
                    caracteristicasUExtra() + "\n" +
                    "Total de Calorias: "+ total_calorias + "\n" ;
                    
        /*          
                    "Historico:" + "\n" ;
        for(Atividade a : historico_atividades)
        {
            r += a.toString();
        }
        r += "Planos de Treino:" + "\n";
        for(PlanoTreino pt : planos_treino.values())
        {
            r += pt.toString();
        }
        */    
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
        for(Atividade a : historico_atividades)
        {
            r += a.toString() + "\n";
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Utilizador u = (Utilizador) obj;
        return u.getNick() == (this.nickname) && u.getPassword().equals(this.password) 
            && u.getNome().equals(this.nomeUtilizador) && u.getEmail().equals(this.emailUtilizador)
            && u.getGenero().equals(this.generoUtilizador) && u.getDataNascimento().equals(this.data_nascimento)
            && u.getAltura() == (this.alturaUtilizador) && u.getPeso() == (this.pesoUtilizador)
            && u.getFreqCardiaca() == (this.frequencia_cardiaca_media)
            && u.getFatorMultiplicativo() == (this.fator_multiplicativo)
            && u.getTotalCalorias() == (this.total_calorias) 
            && u.getHistorico().equals(this.historico_atividades)
            && u.getPlanosTreino().equals(this.planos_treino);

    }
    
}