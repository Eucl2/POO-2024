 
import java.util.ArrayList;

public class Repeticao extends Atividade 
{
    private int repeticoes;

    public Repeticao(String nome, int duracao, int rep) 
    {
        super(nome,duracao);
        repeticoes = rep;

    }
    
    public Repeticao(Repeticao r) 
    {
        super(r.getNome(), r.getDuracao());
        this.repeticoes = r.getRepeticao();
    }

    public int getRepeticao() 
    {
        return this.repeticoes;
    }

    public void setRepeticao(int repeticoes) 
    {
        this.repeticoes = repeticoes;
    }

    public Repeticao clone() 
    {
        return new Repeticao(this);
    }

}
