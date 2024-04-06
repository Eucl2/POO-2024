import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanoDeTreinos 
{

    private Date data;
    private List<Atividade> listaAtividades;

    public PlanoDeTreinos() 
    {
        this.data = new Date();
        this.listaAtividades = new ArrayList<>();
    }

    public PlanoDeTreinos(Date data, List<Atividade> listaAtividades) 
    {
        this.data = data;
        this.listaAtividades = listaAtividades;
    }

    public Date getData() 
    {
        return data;
    }

    public void setData(Date data) 
    {
        this.data = data;
    }

    public List<Atividade> getListaAtividades() 
    {
        return listaAtividades;
    }

    public void setListaAtividades(List<Atividade> listaAtividades) 
    {
        this.listaAtividades = listaAtividades;
    }

    public void adicionarAtividade(Atividade atividade) 
    {
        this.listaAtividades.add(atividade);
    }

    public void removerAtividade(Atividade atividade) 
    {
        this.listaAtividades.remove(atividade);
    }

    @Override
    public String toString() 
    {
        return "Plano de Treinos{" +
                "data=" + data +
                ", listaAtividades=" + listaAtividades +
                '}';
    }
}