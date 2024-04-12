import java.io.Serializable;
import java.util.*;

public class Utilizador implements Serializable 
{
    private int id_utilizador;
    private String nome_utilizador;
    private int idade_utilizador;
    private double peso_utilizador;
    private String morada_utilizador;
    private String email_utilizador;
    private int freq_cardiaca_media;
    private TipoAtleta tipo_atleta;
    private ArrayList<PlanoTreino> planos_de_treino;
    private ArrayList<AtividadeRealizada> historico;

    public Utilizador() 
    {
        id_utilizador = 0;
        nome_utilizador = "";
        idade_utilizador = 0;
        peso_utilizador = 0;
        morada_utilizador = "";
        email_utilizador = "";
        freq_cardiaca_media = 0;
        tipo_atleta = null;
        planos_de_treino = new ArrayList<>();
        historico = new ArrayList<>();
        
        
    }

    public Utilizador(
    int id_u, String nome_u, int idade_u, double peso_u,
    String morada_u, String email_u, 
    int freq_card_m, TipoAtleta tipo_a) 
    {
        id_utilizador = id_u;
        nome_utilizador = nome_u;
        idade_utilizador = idade_u;
        peso_utilizador = peso_u;
        morada_utilizador = morada_u;
        email_utilizador = email_u;
        freq_cardiaca_media = freq_card_m;
        tipo_atleta = tipo_a;
        planos_de_treino = new ArrayList<>();
        historico = new ArrayList<>();
    }

    public Utilizador(Utilizador u) 
    {
        id_utilizador = u.getIdUtilizador();
        nome_utilizador = u.getNomeUtilizador();
        idade_utilizador = u.getIdadeUtilizador();
        peso_utilizador = u.getPesoUtilizador();
        morada_utilizador = u.getMoradaUtilizador();
        email_utilizador = u.getEmailUtilizador();
        freq_cardiaca_media = u.getFreqCardiacaMedia();
        tipo_atleta = u.getTipoAtleta();
        planos_de_treino = u.getPlanosTreino();
        historico = u.getHistorico();
    }
    
    public int getIdUtilizador() 
    {
        return id_utilizador;
    }

    public void setIdUtilizador(int id_utilizador) 
    {
        this.id_utilizador = id_utilizador;
    }

    public String getNomeUtilizador() 
    {
        return nome_utilizador;
    }

    public void setNomeUtilizador(String nome_utilizador) 
    {
        this.nome_utilizador = nome_utilizador;
    }

    public int getIdadeUtilizador() 
    {
        return idade_utilizador;
    }

    public void setIdadeUtilizador(int idade_utilizador) 
    {
        this.idade_utilizador = idade_utilizador;
    }
    
    public double getPesoUtilizador() 
    {
        return peso_utilizador;
    }

    public void setPesoUtilizador(double peso_utilizador) 
    {
        this.peso_utilizador = peso_utilizador;
    }

    public String getMoradaUtilizador() 
    {
        return morada_utilizador;
    }

    public void setMoradaUtilizador(String morada_utilizador) 
    {
        this.morada_utilizador = morada_utilizador;
    }
    
    public String getEmailUtilizador() 
    {
        return email_utilizador;
    }

    public void setEmailUtilizador(String email_utilizador) 
    {
        this.email_utilizador = email_utilizador;
    }

    public int getFreqCardiacaMedia() 
    {
        return freq_cardiaca_media;
    }

    public void setFreqCardiacaMedia(int freq_cardiaca_media) 
    {
        this.freq_cardiaca_media = freq_cardiaca_media;
    }

    public TipoAtleta getTipoAtleta() 
    {
        return tipo_atleta;
    }

    public void setTipoAtleta(TipoAtleta tipo_atleta) 
    {
        this.tipo_atleta = tipo_atleta;
    }
    
    public ArrayList<PlanoTreino> getPlanosTreino() 
    {
        return planos_de_treino;
    }
    
    public void setPlanosTreino(ArrayList<PlanoTreino> planos_de_treino) 
    {
        this.planos_de_treino = planos_de_treino;
    }
    
    public ArrayList<AtividadeRealizada> getHistorico() 
    {
        return historico;
    }
    
    public void setHistorico(ArrayList<AtividadeRealizada> atividade_realizada) 
    {
        this.historico = atividade_realizada;
    }
    
    public Utilizador clone()
    {
        return new Utilizador(this);
    }
    
    public static Utilizador parse(String linha) 
    {
      String[] campo = linha.split(",");
      if (campo.length != 7) 
      {
        throw new IllegalArgumentException("Input inválido.");
      }
    
      int id = Integer.parseInt(campo[0]);
      String nome = campo[1];
      int idade = Integer.parseInt(campo[2]);
      String email = campo[3];
      String morada = campo[4];
      int freq_cardiaca = Integer.parseInt(campo[5]);
      TipoAtleta tipo = TipoAtleta.valueOf(campo[6]); 
      double peso = Double.parseDouble(campo[7]);
    
      //ArrayList t = null; //to change
      //ArrayList u = null; //to change
    
      return new Utilizador(id, nome, idade, peso, morada, email, freq_cardiaca, tipo); //to change
    }
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nId: ").append(this.id_utilizador).append('\n').append("Nome: ").append(this.nome_utilizador)
                .append('\n').append("Idade: ").append(this.idade_utilizador).append('\n').append("Peso: ").append(this.peso_utilizador)
                .append('\n').append("Morada: ").append(this.morada_utilizador).append('\n').append("Email: ")
                .append(this.email_utilizador ).append('\n').append("Frequencia Cardiaca Media: ").append(this.freq_cardiaca_media).append('\n')
                .append("Tipo de Atleta: ").append(this.tipo_atleta).append('\n').append("Planos de Treino: ")
                .append(this.planos_de_treino.toString()).append('\n').append("Historico de Atividade: ")
                .append(this.historico.toString()).append('\n');
        
        return sb.toString();

    }
}