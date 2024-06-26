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
    private boolean isHard;

    public Atividade() 
    {
        this.codigo = 0;
        this.nome= "";
        this.descricao= "";
        this.duracao= 0;
        this.data_realizada= null;
        this.freq_cardiaca_atividade = 0;
        this.calorias_gastas_atividade = 0;
        this.isHard = false;
    }

    public Atividade(int c, String n, String des, int dura, LocalDate data, 
            int freq_a, double cal, boolean hard) 
    {
        this.codigo = c;
        this.nome = n;
        this.descricao = des;
        this.duracao = dura;
        this.data_realizada= data;
        this.freq_cardiaca_atividade = freq_a;
        this.calorias_gastas_atividade = cal;
        this.isHard = hard;
        
    }
    
    public Atividade(Atividade a) 
    {
        this.codigo = a.getCodigo();
        this.nome = a.getNome();
        this.descricao = a.getDescricao();
        this.duracao = a.getDuracao();
        this.data_realizada= a.getDataRealizada();
        this.freq_cardiaca_atividade = a.getFreqCardiaAtividade();
        this.calorias_gastas_atividade = a.getCaloriasGastasAtividade();
        this.isHard = a.getIsHard();
        
    }
    
    public int getCodigo() 
    {
        return this.codigo;
    }

    public String getNome() 
    {
        return this.nome;
    }
    
    public String getDescricao() 
    {
        return this.descricao;
    }
    
    public int getDuracao() 
    {
        return this.duracao;
    }
    
    public LocalDate getDataRealizada()
    {
        return this.data_realizada;
    }
    
    public int getFreqCardiaAtividade()
    {
        return this.freq_cardiaca_atividade;
    }
    
    public double getCaloriasGastasAtividade()
    {
        return this.calorias_gastas_atividade;
    }
    
    public boolean getIsHard()
    {
        return this.isHard;
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
    
    public void setIsHard(boolean hard)
    {
        this.isHard = hard;
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
                "Data de Realizacao:" + data_realizada + "\n" +
                "Atividade Hard :" + isHard + "\n";
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
                && this.calorias_gastas_atividade == atividade.getCaloriasGastasAtividade()
                && this.isHard == atividade.getIsHard();
    }
}