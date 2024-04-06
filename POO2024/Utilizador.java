
import java.io.Serializable;
import java.util.ArrayList;

public class Utilizador {

    private String nome_utilizador;
    private int id_utilizador;
    private int idade_utilizador;
    private String morada_utilizador;
    private int freq_cardiaca_utilizador;
    private String email_utilizador;
    private String tipo_utilizador;
    private double factor_utilizador;
    private double peso_utilizador;
    private ArrayList<Atividade> historico_atividade;

    public Utilizador() {
        nome_utilizador = "";
        id_utilizador = 0;
        idade_utilizador = 0;
        morada_utilizador = "";
        freq_cardiaca_utilizador = 0;
        email_utilizador = "";
        tipo_utilizador = "";
        factor_utilizador =0;
        peso_utilizador=0;
        historico_atividade = new ArrayList<>();
    }

    public Utilizador(String nome_u, int id_u, int idade_u, String morada_u, 
        int freq_card_u, String email_u, String tipo_u, double factor_u, double peso_u, ArrayList<Atividade> historico_ati) {
        nome_utilizador = nome_u;
        id_utilizador = id_u;
        idade_utilizador = idade_u;
        morada_utilizador = morada_u;
        freq_cardiaca_utilizador = freq_card_u;
        email_utilizador = email_u;
        tipo_utilizador = tipo_u;
        factor_utilizador = factor_u;
        peso_utilizador = peso_u;
        historico_atividade = historico_ati;
    }

    public Utilizador(Utilizador u) {
        nome_utilizador = u.getNomeUtilizador();
        id_utilizador = u.getIdUtilizador();
        idade_utilizador = u.getIdadeUtilizador();
        morada_utilizador = u.getMoradaUtilizador();
        freq_cardiaca_utilizador = u.getFreqCardiacaUtilizador();
        email_utilizador = u.getEmailUtilizador();
        tipo_utilizador = u.getTipoUtilizador();
        factor_utilizador = u.getFactorUtilizador();
        peso_utilizador = u.getPesoUtilizador();
        historico_atividade = u.getHistoricoAtividade();
    }

    public String getNomeUtilizador() {
        return nome_utilizador;
    }

    public void setNomeUtilizador(String nome_utilizador) {
        this.nome_utilizador = nome_utilizador;
    }

    public int getIdUtilizador() {
        return id_utilizador;
    }

    public void setIdUtilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public int getIdadeUtilizador() {
        return idade_utilizador;
    }

    public void setIdadeUtilizador(int idade_utilizador) {
        this.idade_utilizador= idade_utilizador;
    }

    public String getMoradaUtilizador() {
        return morada_utilizador;
    }

    public void setMoradaUtilizador(String morada_utilizador) {
        this.morada_utilizador = morada_utilizador;
    }

    public int getFreqCardiacaUtilizador() {
        return freq_cardiaca_utilizador;
    }

    public void setFreqCardiacaUtilizador(int freq_cardiaca_utilizador) {
        this.freq_cardiaca_utilizador= freq_cardiaca_utilizador;
    }

    public String getEmailUtilizador() {
        return email_utilizador;
    }

    public void setEmailUtilizador(String email_utilizador) {
        this.email_utilizador = email_utilizador;
    }

    public String getTipoUtilizador() {
        return tipo_utilizador;
    }

    public void setTipoUtilizador(String tipo_utilizador) {
        this.tipo_utilizador = tipo_utilizador;
    }

    public double getFactorUtilizador() {
        return factor_utilizador;
    }

    public void setFactorUtilizador(double factor_utilizador) {
        this.factor_utilizador = factor_utilizador;
    }
    
    public double getPesoUtilizador() {
        return peso_utilizador;
    }
    
    public void setPesoUtilizador(double peso_utilizador) {
        this.peso_utilizador= peso_utilizador;
    }
    
    public ArrayList<Atividade> getHistoricoAtividade() {
        return historico_atividade;
    }
    
    public void setHistoricoAtividade(ArrayList<Atividade> historico_atividade) {
        this.historico_atividade = historico_atividade;
    }

    public Utilizador clone(){
        return new Utilizador(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ").append(this.nome_utilizador).append('\n').append("Id: ").append(this.id_utilizador)
                .append('\n').append("Idade: ").append(this.idade_utilizador).append('\n').append("Morada: ")
                .append(this.morada_utilizador).append('\n').append("Frequencia Cardiaca: ").append(this.freq_cardiaca_utilizador).append('\n')
                .append("Email: ").append(this.email_utilizador ).append('\n').append("Tipo: ").append(this.tipo_utilizador)
                .append('\n').append("Factor: ").append(this.factor_utilizador).append('\n').append("Historico de Atividade: ")
                .append(this.historico_atividade.toString()).append('\n');
        
        return sb.toString();

    }
}