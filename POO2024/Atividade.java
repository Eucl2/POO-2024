import java.io.Serializable;
import java.time.LocalDate;

public abstract class Atividade implements Serializable 
{
    private int codigo;
    private String nome;
    private String descricao;
    private int duracao;
    private LocalDate data_realizada;
    private int freq_cardiaca_atividade;
    private double calorias_gastas_atividade;

    public Atividade() 
    {
        codigo = 0;
        nome= "";
        descricao= "";
        duracao= 0;
        data_realizada= null;
        freq_cardiaca_atividade = 0;
        calorias_gastas_atividade = 0;
    }

    public Atividade(int c, String n, String des, int dura, LocalDate data, 
            int freq_a, double cal) 
    {
        codigo = c;
        nome = n;
        descricao = des;
        duracao = dura;
        data_realizada= data;
        freq_cardiaca_atividade = freq_a;
        calorias_gastas_atividade = cal;
        
    }
    
    public Atividade(Atividade a) 
    {
        codigo = a.getCodigo();
        nome = a.getNome();
        descricao = a.getDescricao();
        duracao = a.getDuracao();
        data_realizada= a.getDataRealizada();
        freq_cardiaca_atividade = a.getFreqCardiaAtividade();
        calorias_gastas_atividade = a.getCaloriasGastasAtividade();
        
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
    
    public int getFreqCardiaAtividade()
    {
        return freq_cardiaca_atividade;
    }
    
    public double getCaloriasGastasAtividade()
    {
        return calorias_gastas_atividade;
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
    
    public void setFreqCardiaAtiviade(int freq)
    {
        this.freq_cardiaca_atividade = freq;
    }
    
    public void setCaloriasGastasAtividade(double cal)
    {
        this.calorias_gastas_atividade = cal;
    }
    
    public abstract Atividade clone();
    
    public abstract double calcularCalorias(Utilizador utilizador);
    
    public abstract String getTipoAtividade();

    public abstract String caracteristicasExtra();
    
    
    @Override
    public String toString() 
    {
        return  "Codigo:" + codigo + "\n" +
                "Nome:" + nome + "\n" +
                "Descricao:" + descricao + "\n" +
                "Duracao:" + duracao + "\n" +
                "Freq. Cardiaca durante Atividade:" + freq_cardiaca_atividade + "\n" +
                "Calorias Gastas:" + calorias_gastas_atividade + "\n" +
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
                && this.data_realizada.equals(atividade.getDataRealizada())
                && this.freq_cardiaca_atividade == atividade.getFreqCardiaAtividade()
                && this.calorias_gastas_atividade == atividade.getCaloriasGastasAtividade();
    }
}