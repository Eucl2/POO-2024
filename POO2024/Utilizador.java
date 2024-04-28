import java.io.Serializable;
import java.io.*;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;

public class Utilizador implements Serializable 
{
    private int id;
    private String password;
    private String nome;
    private String email;
    private String genero;
    private LocalDate data_nascimento;
    private double altura;
    private double peso;
    private int frequencia_cardiaca_media;
    private TipoAtleta tipo_atleta;
    private Map<Integer, Atividade> historico_atividades;
    private Map<String, PlanoTreino> planos_treino;

    public Utilizador() 
    {
        id = 0;
        password = "";
        nome = "";
        email = "";
        genero = "";
        data_nascimento = LocalDate.EPOCH;
        altura = 0;
        peso = 0;
        frequencia_cardiaca_media = 0;
        tipo_atleta = null;
        historico_atividades = new HashMap<>();
        planos_treino = new HashMap<>();
        
        
    }

    public Utilizador(int id, String pass, String nome, String email, String genero,
    LocalDate data_nascimento, double altura, double peso, int freq_cardiaca,
    TipoAtleta atleta) 
    {
        id = id;
        password = pass;
        nome = nome;
        email = email;
        genero = genero;
        data_nascimento = data_nascimento;
        altura = altura;
        peso = peso;
        frequencia_cardiaca_media = freq_cardiaca;
        tipo_atleta = atleta;
        historico_atividades = new HashMap<>();
        planos_treino = new HashMap<>();
        
        
    }

    public Utilizador(Utilizador u) 
    {
        id = getId();
        password = getPassword();
        nome = getNome();
        email = getEmail();
        genero = getGenero();
        data_nascimento = getDataNascimento();
        altura = getAltura();
        peso = getPeso();
        frequencia_cardiaca_media = getFreqCardiaca();
        tipo_atleta = getAtleta();
        historico_atividades = getHistorico();
        planos_treino = getPlanosTreino();
    }
    
    public int getId() 
    {
        return id;
    }

    public String getPassword() 
    {
        return password;
    }
    
    public String getNome() 
    {
        return nome;
    }
    
    public String getEmail() 
    {
        return email;
    }
    
    public String getGenero() 
    {
        return genero;
    }
    
    public LocalDate getDataNascimento() 
    {
        return data_nascimento;
    }
    
    public double getAltura() 
    {
        return altura;
    }
    
    public double getPeso() 
    {
        return peso;
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
       return this.historico_atividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
    }
    
    public Map<String, PlanoTreino> getPlanosTreino() 
    {
        return this.planos_treino.values().stream().collect(Collectors.toMap(pt -> pt.getNome(), pt -> pt.clone()));

    }
    
    public void setId(int id) 
    {
        this.id = id;
    }

    public void setPassword(String pass) 
    {
        this.password = pass;
    }
    
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public void setEmail(String email) 
    {
        this.email = email;
    }
    
    public void setGenero(String genero) 
    {
        this.genero = genero;
    }
    
    public void setDataNascimento(LocalDate data) 
    {
        this.data_nascimento = data;
    }
    
    public void setAltura(double altura) 
    {
        this.altura = altura;
    }
    
    public void getPeso(double peso) 
    {
        this.peso = peso;
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
                .collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
    }
    
    public void setPlanosTreino(Map<String, PlanoTreino> planos_treino) 
    {
        this.planos_treino = planos_treino.values().stream()
                .collect(Collectors.toMap(pt -> pt.getNome(), pt -> pt.clone()));
    }
    
    public Utilizador clone()
    {
        return new Utilizador(this);
    }
    
    //eu nao sei se a parte de mudar a data é aceitavel
    public void realizaAtividade(Atividade a, LocalDate d)
    {
        this.historico_atividades.put(a.getCodigo(), a.clone());
        if (this.historico_atividades.containsKey(a.getCodigo()))
        {
            this.historico_atividades.get(a.getCodigo()).setDataRealizada(d);
        }
        
        
    }
    
    public void adicionaPlanoTreino(PlanoTreino pt) {
        this.planos_treino.put(pt.getNome(), pt.clone());

    }
    // verificar se é necessaria
    public void setPlanoTreino(PlanoTreino pt) throws PlanoTreinoExisteException {
        if (this.planos_treino.containsKey(pt.getNome()))
            throw new PlanoTreinoExisteException("Plano de Treino ja adicionado");
        else
            this.planos_treino.put(pt.getNome(), pt.clone());
    }

    public void removePlanoTreino(PlanoTreino pt) throws PlanoTreinoNaoExisteException {
        String n = pt.getNome();
        if (!this.planos_treino.containsKey(n))
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");
        else {

            this.planos_treino.remove(n);
        }
    }
    
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
      Integer.parseInt(campo[8]), TipoAtleta.valueOf(campo[9]));
    }
    
    @Override
    public String toString() 
    {
        String r =  "Id:" + id + "\n" +
                    "Password:" + password + "\n" +
                    "Nome:" + nome + "\n" +
                    "Email:" + email + "\n" +
                    "Genero:" + genero + "\n" +
                    "Data de Nascimento:" + data_nascimento + "\n" + 
                    "Altura:" + altura + "\n" +
                    "Peso:" + peso + "\n" +
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
    
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Utilizador u = (Utilizador) obj;
        return u.getId() == (this.id) && u.getPassword().equals(this.password) 
            && u.getNome().equals(this.nome) && u.getEmail().equals(this.email)
            && u.getGenero().equals(this.genero) && u.getDataNascimento().equals(this.data_nascimento)
            && u.getAltura() == (this.altura) && u.getPeso() == (this.peso)
            && u.getFreqCardiaca() == (this.frequencia_cardiaca_media)
            && u.getAtleta().equals(this.tipo_atleta) && u.getHistorico().equals(this.historico_atividades)
            && u.getPlanosTreino().equals(this.planos_treino);

    }
    
}