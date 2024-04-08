import java.time.LocalDate;

/**
 * AtividadeRealizada
 */


public class AtividadeRealizada 
{

    private LocalDate data;
    private Utilizador utilizador;
    private Atividade atividade;
    private int freq_cardiaca_atividade;
    private int calorias;

    public AtividadeRealizada() 
    {
        data=null;
        utilizador=null;
        atividade=null;
        freq_cardiaca_atividade=0;
        calorias=0;
        
        
    }
    
    public AtividadeRealizada(LocalDate data, Utilizador utilizador, Atividade atividade , int freq_cardiaca_atividade) 
    {
        data = data;
        utilizador = utilizador;
        atividade = atividade;
        freq_cardiaca_atividade = freq_cardiaca_atividade;
        calorias = atividade.calcularCalorias(utilizador, freq_cardiaca_atividade);
        
    }
    
    public AtividadeRealizada(AtividadeRealizada ar) 
    {
        data = ar.getData();
        utilizador = ar.getUtilizador();
        atividade = ar.getAtividade();
        freq_cardiaca_atividade = ar.getFrequenciaCardiacaAtividade();
        calorias = ar.getCalorias();
    }

    public LocalDate getData() 
    {
        return data;
    }

    public void setData(LocalDate data) 
    {
        this.data = data;
    }

    public Utilizador getUtilizador() 
    {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) 
    {
        this.utilizador = utilizador;
    }
    
    public Atividade getAtividade() 
    {
        return atividade;
    }

    public void setAtividade(Atividade atividade) 
    {
        this.atividade = atividade;
    }
    
    public int getFrequenciaCardiacaAtividade() 
    {
        return freq_cardiaca_atividade;
    }

    public void setFrequenciaCardiacaAtividade(int freq_cardiaca_atividade) 
    {
        this.freq_cardiaca_atividade = freq_cardiaca_atividade;
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
    /**
    public int calculoCalorias(AtividadeRealizada atividade, Utilizador utilizador)
    {
        double peso_utilizador = utilizador.getPesoUtilizador();
        int freq_cardiaca_utilizador = utilizador.getFreqCardiacaUtilizador();
        double factor_utilizador = utilizador.getFactorUtilizador();
        double duracao_atividade = atividade.getDuracao();
        
        double calorias = (peso_utilizador * duracao_atividade) * (freq_cardiaca_utilizador / 100) * factor_utilizador;
        
        return (int) calorias;
        
    
    }
    */
    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nData: ").append(this.data).append('\n').append("Utilizador: ").append(this.utilizador.toString())
                .append('\n').append("Atividade: ").append(this.atividade.toString()).append('\n').append("Frequencia Cardiaca d/Atividade: ")
                .append(this.freq_cardiaca_atividade).append('\n').append("Calorias Gastas: ")
                .append(this.calorias).append('\n');
        
        return sb.toString();
    }
}
