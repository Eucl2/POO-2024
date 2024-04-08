/**
 * Atividade
 */
public abstract class Atividade 
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
        nome = getNome();
        duracao = getDuracao();
        
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