import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanoTreino
{
    private String nome_plano;
    private ArrayList<Atividade> lista_atividades;
    private ArrayList<Recorrencia> recorrencia;
    private int minimo_calorias;
    

    public PlanoTreino() 
    {
        nome_plano = "";
        lista_atividades = new ArrayList<>();
        recorrencia = new ArrayList<>();
        minimo_calorias = 0;
    }

    public PlanoTreino(String nome, ArrayList<Atividade> lista_atividades, ArrayList<Recorrencia> recorencia, int mincalorias) 
    {
        nome_plano = nome;
        lista_atividades = lista_atividades;
        recorrencia = recorrencia;
        minimo_calorias = mincalorias;
    }
    
    public PlanoTreino(PlanoTreino pt) 
    {
        nome_plano = pt.getNomePlano();
        lista_atividades = pt.getListaAtividades();
        recorrencia = pt.getRecorrencia();
        minimo_calorias = pt.getMinimoCalorias();
    }
    
    public String getNomePlano()
    {
        return nome_plano;
    }
    
    public void setNomePlano(String nome_plano)
    {
        this.nome_plano = nome_plano;
    }
    
    public ArrayList<Recorrencia> getRecorrencia() 
    {
        return recorrencia;
    }

    public void setRecorrencia(ArrayList<Recorrencia> recorrencia) 
    {
        this.recorrencia = recorrencia;
    }
    
    public ArrayList<Atividade> getListaAtividades() 
    {
        return lista_atividades;
    }

    public void setListaAtividades(ArrayList<Atividade> lista_atividades) 
    {
        this.lista_atividades = lista_atividades;
    }
    
    public int getMinimoCalorias()
    {
        return minimo_calorias;
    }
    
    public void setMinimoCalorias(int minimo_calorias)
    {
        this.minimo_calorias= minimo_calorias;
    }
    
    public PlanoTreino clone()
    {
        return new PlanoTreino(this);
    }


    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPlano de Treino: ").append(this.nome_plano).append('\n').append("Atividades: ").append(this.lista_atividades.toString())
                .append('\n').append("Recorrencia: ").append(this.recorrencia.toString()).append('\n').append("Calorias Minimas: ")
                .append(this.minimo_calorias).append('\n');
        
        return sb.toString();
    }
}