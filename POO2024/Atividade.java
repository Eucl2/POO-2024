/**
 * Atividade
 */
public class Atividade 
{

    private String nome;
    private double duracao;
    private int calorias;

    public Atividade() 
    {
        duracao=0;
    }

    public Atividade(String nome, double duracao) 
    {
        nome = nome;
        duracao = duracao;
        
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public double getDuracao() 
    {
        return duracao;
    }

    public void setDuracao(double duracao) 
    {
        this.duracao = duracao;
    }

    public int getCalorias() 
    {
        return calorias;
    }

    public void setCalorias(int calorias) 
    {
        this.calorias = calorias;
    }
    
    //a funçao nao esta a ser chamada 
    public int calculoCalorias(Atividade atividade, Utilizador utilizador)
    {
        double peso_utilizador = utilizador.getPesoUtilizador();
        int freq_cardiaca_utilizador = utilizador.getFreqCardiacaUtilizador();
        double factor_utilizador = utilizador.getFactorUtilizador();
        double duracao_atividade = atividade.getDuracao();
        
        double calorias = (peso_utilizador * duracao_atividade) * (freq_cardiaca_utilizador / 100) * factor_utilizador;
        
        return (int) calorias;
        
    
    }  
    
    @Override
    public String toString() 
    {
        return "Atividade{" +
                "Nome='" + nome + '\'' +
                ", Duracao=" + duracao +
                ", Calorias=" + calorias +
                '}';
    }
}