import java.io.Serializable;
import java.time.LocalDate;

public abstract class Atividade implements Serializable 
{
    private int codigo;
    private String nome;
    private String descricao;
    private int duracao;
    private LocalDate data_realizada;

    public Atividade() 
    {
        codigo = 0;
        nome= "";
        descricao= "";
        duracao= 0;
        data_realizada= LocalDate.EPOCH;
    }

    public Atividade(int c, String n, String des, int dura, LocalDate data) 
    {
        codigo = c;
        nome = n;
        descricao = des;
        duracao = dura;
        data_realizada= data;
        
    }
    
    public Atividade(Atividade a) 
    {
        codigo = a.getCodigo();
        nome = a.getNome();
        descricao = a.getDescricao();
        duracao = a.getDuracao();
        data_realizada= a.getDataRealizada();
        
    }
    
    public int getCodigo() 
    {
        return codigo;
    }

    public String getNome() 
    {
        return nome;
    }
    
    public String getDescricao() 
    {
        return descricao;
    }
    
    public int getDuracao() 
    {
        return duracao;
    }
    
    public LocalDate getDataRealizada()
    {
        return data_realizada;
    }

    public void setCodigo(int cod) 
    {
        this.codigo = cod;
    }
    
    public void setNome(String n) 
    {
        this.nome = n;
    }
    
    public void setDescricao(String des) 
    {
        this.descricao = des;
    }
    
    public void setDurcacao(int dura) 
    {
        this.duracao= dura;
    }
    
    public void setDataRealizada(LocalDate data)
    {
        this.data_realizada = data;
    }
    
    public abstract Atividade clone();
    
    public abstract double calcularCalorias(Utilizador utilizador, int freq_cardiaca_atividade);
    
    public abstract String getTipoAtividade();

    public abstract String caracteristicasExtra();
    
    
    @Override
    public String toString() 
    {
        return "Atividade:" + "\n" +
                "Codigo:" + codigo + "\n" +
                "Nome:" + nome + "\n" +
                "Descricao:" + descricao + "\n" +
                "Duracao:" + duracao + "\n" +
                caracteristicasExtra() + "\n" +
                "Data de Realizacao:" + data_realizada + "\n";
    }
    
    public String toString2() {
        return codigo + " " + nome + "\n";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return this.duracao == atividade.getDuracao()
                && this.codigo == atividade.getCodigo()
                && this.descricao.equals(atividade.getDescricao())
                && this.nome.equals(atividade.getNome())
                && this.data_realizada.equals(atividade.getDataRealizada());
    }
}