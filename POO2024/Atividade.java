import java.io.Serializable;

public abstract class Atividade implements Serializable 
{

    private String nome;
    private double duracao;

    public Atividade() 
    {
        nome="";
        duracao=0;
    }

    public Atividade(String nome, double duracao) 
    {
        nome = nome;
        duracao = duracao;
        
    }
    
    public Atividade(Atividade a) 
    {
        nome = getNomeAtividade();
        duracao = getDuracaoAtividade();
        
    }

    public String getNomeAtividade() 
    {
        return nome;
    }

    public void setNomeAtividade(String nome) 
    {
        this.nome = nome;
    }

    public double getDuracaoAtividade() 
    {
        return duracao;
    }

    public void setDuracaoAtividade(double duracao) 
    {
        this.duracao = duracao;
    }
    
    public abstract Atividade clone();
    
    
    public abstract int calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade);
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAtividade: ").append(this.nome).append('\n').append("Duracao: ").append(this.duracao).append('\n');
        
        return sb.toString();
    }
}