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
    private List<PlanoTreino> planos_treino;

    public Utilizador() 
    {
        this.nickname = "";
        this.password = "";
        this.nomeUtilizador = "";
        this.emailUtilizador = "";
        this.generoUtilizador = "";
        this.data_nascimento = null;
        this.alturaUtilizador = 0;
        this.pesoUtilizador = 0;
        this.frequencia_cardiaca_media = 0;
        this.fator_multiplicativo = 0;
        this.total_calorias =0;
        this.historico_atividades = new ArrayList<>();
        this.planos_treino = new ArrayList<>();
    }

    public Utilizador(String nick, String pass, String nome, String email, String genero,
    LocalDate data, double altura, double peso, int freq_cardiaca, double calorias, List<Atividade> historico, List<PlanoTreino> planos) 
    {
        this.nickname = nick;
        this.password = pass;
        this.nomeUtilizador = nome;
        this.emailUtilizador = email;
        this.generoUtilizador = genero;
        this.data_nascimento = data;
        this.alturaUtilizador = altura;
        this.pesoUtilizador = peso;
        this.frequencia_cardiaca_media = freq_cardiaca;
        this.fator_multiplicativo = this.calculaFator();
        this.total_calorias = calorias;
        this.historico_atividades = historico;
        this.planos_treino = planos;
        
    }

    public Utilizador(Utilizador u) 
    {
        this.nickname = u.getNick();
        this.password = u.getPassword();
        this.nomeUtilizador = u.getNome();
        this.emailUtilizador = u.getEmail();
        this.generoUtilizador = u.getGenero();
        this.data_nascimento = u.getDataNascimento();
        this.alturaUtilizador = u.getAltura();
        this.pesoUtilizador = u.getPeso();
        this.frequencia_cardiaca_media = u.getFreqCardiaca();
        this.fator_multiplicativo = u.getFatorMultiplicativo();
        this.total_calorias = u.getTotalCalorias();
        this.historico_atividades = u.getHistorico();
        this.planos_treino = u.getPlanosTreino();

    }
    
    //calcular fator
    public abstract double calculaFator();
    
    public String getNick() 
    {
        return this.nickname;
    }

    public String getPassword() 
    {
        return this.password;
    }
    
    public String getNome() 
    {
        return this.nomeUtilizador;
    }
    
    public String getEmail() 
    {
        return this.emailUtilizador;
    }
    
    public String getGenero() 
    {
        return this.generoUtilizador;
    }
    
    public LocalDate getDataNascimento() 
    {
        return this.data_nascimento;
    }
    
    public double getAltura() 
    {
        return this.alturaUtilizador;
    }
    
    public double getPeso() 
    {
        return this.pesoUtilizador;
    }
    
    public int getFreqCardiaca() 
    {
        return this.frequencia_cardiaca_media;
    }
    
    public double getFatorMultiplicativo()
    {
        return this.fator_multiplicativo;
    }
    
    public double getTotalCalorias() 
    {
        return this.total_calorias;
    }
    
    
    public List<Atividade> getHistorico() 
    {
        return this.historico_atividades.stream().map(Atividade::clone)
                                     .collect(Collectors.toList());
    }
    
    public List<PlanoTreino> getPlanosTreino() 
    {
        return this.planos_treino.stream().map(PlanoTreino::clone)
                                     .collect(Collectors.toList());
        //return planos_treino;
        /*
        planos_treino.values().stream()
                .collect(Collectors.toMap(u -> u.getNomePlano(), u -> u.clone()));
        */
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
    
    public void setFatorMultiplicativo(double fm)
    {
        this.fator_multiplicativo = fm;
    }
    
    public void setCaloriasGastas(double calorias)
    {
        this.total_calorias  = calorias;
    }
    
    public void addCaloriasGastas(double calorias) 
    {
        this.total_calorias += calorias;
    }
    
    public void setHistorico(List<Atividade> historico) 
    {
        this.historico_atividades = historico.stream().map(Atividade::clone)
                                     .collect(Collectors.toList());
    }
    
    public void setPlanosTreino(List<PlanoTreino> planos) 
    {
        this.planos_treino = planos.stream().map(PlanoTreino::clone)
                                     .collect(Collectors.toList());
                
    }
    
    public void addPlanoU(PlanoTreino pt)
    {
        this.planos_treino.add(pt.clone());
    }
    
    public void addHistoricoU(Atividade ar)
    {
        this.historico_atividades.add(ar.clone());
    }
    
    public abstract void realizaAtividade(Atividade a, Utilizador u, LocalDate d, int freq_atv, int dura);
    
    public abstract Utilizador clone();
    
    public abstract String getTipoUtilizador();

    public abstract String caracteristicasUExtra();
    
    
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
                    "Total de Calorias: "+ total_calorias + "\n" ;  
        return r;
    }
    
    public String toStringHistorico()
    {
        String r = "\n";
        for(Atividade a : historico_atividades)
        {
            r += a.toString() + "\n";
        }
        return r;
    }
    
    public String toStringPlanosTreinoU()
    {
        String r = "\n";
        for(PlanoTreino pt : planos_treino)
        {
            r += pt.toString2() + "\n";
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