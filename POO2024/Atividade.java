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

    public Atividade(int codigo, String nome, String descricao, double duracao, LocalDate data_realizada) 
    {
        codigo = codigo;
        nome = nome;
        descricao = descricao;
        duracao = duracao;
        data_realizada= data_realizada;
        
    }
    
    public Atividade(Atividade a) 
    {
        codigo = getCodigo();
        nome = getNome();
        descricao = getDescricao();
        duracao = getDuracao();
        data_realizada= getDataRealizada();
        
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

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }
    
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    
    public void setDurcacao(int duracao) 
    {
        this.duracao= duracao;
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
        StringBuilder sb = new StringBuilder();
        sb.append("\nAtividade: ").append(this.nome).append('\n').append("Codigo: ")
        .append(this.codigo).append('\n').append("\nDescricao: ").append(this.descricao)
        .append('\n').append("\nDuracao: ").append(this.duracao).append('\n')
        .append('\n').append("\nData Realizada: ").append(this.data_realizada).append('\n');
        
        return sb.toString();
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