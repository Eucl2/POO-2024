import java.util.ArrayList;
import java.io.*;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.*;

public class PlanoTreino implements Serializable
{
    /*
    private String nome_plano;
    private Map<Recorrencia, ArrayList<Tuple>> atividades_por_dia;
    private int minimo_calorias;
    

    public PlanoTreino() 
    {
        this.nome_plano = "";
        this.atividades_por_dia = new HashMap<>();
        this.minimo_calorias = 0;
    }

    public PlanoTreino(String nome_plano) 
    {
        this.nome_plano = nome_plano;
        this.atividades_por_dia = new HashMap<>();
        this.minimo_calorias = 0;
    }
    
    public PlanoTreino(PlanoTreino pt) 
    {
        this.nome_plano = pt.getNomePlano();
        this.atividades_por_dia = pt.getAtividades();
        this.minimo_calorias = pt.getMinimoCalorias();
    }
    
    public String getNomePlano()
    {
        return nome_plano;
    }
    
    public void setNomePlano(String nome_plano)
    {
        this.nome_plano = nome_plano;
    }
    
    //ainda nao esta a funcionar 
    
    public Map<Recorrencia, ArrayList<Tuple>> getAtividadesPorDia()
    {
        return this.atividades_por_dia.values().stream().collect(Collectors.toMap(pt -> pt.getDiaDaSemana(), pt -> );
    }

   
    public void setAtividades(Map<String, Atividade> nAtividades)
    {
        this.atividades = nAtividades.values().stream().collect(Collectors.toMap(pt -> pt.getNomeAtividade(), pt -> pt.clone()));
                
    }
    
   
    public int getMinimoCalorias()
    {
        return minimo_calorias;
    }
    
    public void setMinimoCalorias(int minimo_calorias)
    {
        this.minimo_calorias= minimo_calorias;
    }
    
    public void insereAtividade(Atividade a)
    {
        this.atividades.put(a.getNomeAtividade(),a.clone());
        //a.insereHistoricoDePlanos(this.getNomeAtividade());
    }
    
    public void setAtividade(Atividade a) throws AtividadeNaoExisteException
    {
        if(this.atividades.containsKey(a.getNomeAtividade()))
            throw new AtividadeNaoExisteException("Nao existe atividade com esse nome");
        else
            this.atividades.put(a.getNomeAtividade(), a.clone());
    }
    
    public void removeAtividade(Atividade a) throws AtividadeNaoExisteException
    {
        String n = a.getNomeAtividade();
        if (!this.atividades.containsKey(n))
            throw new AtividadeNaoExisteException("Atividade nao existe");
        else{
            this.atividades.remove(n);
        }
    }
    
    public String toString() {
        String r = "Plano de treino:" + nome_plano + "\n";
        // String r = "\n";
        for (Atividade a : atividades.values()) {
            r += a.toString();
        }
        return r;
    }
    
    public PlanoTreino clone()
    {
        return new PlanoTreino(this);
    }
    
    
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        PlanoTreino pt = (PlanoTreino) obj;
        return pt.getNomePlano().equals(this.nome_plano) && pt.getAtividades() == (this.atividades);

    }
    
    public static PlanoTreino parse(String input) {
        String[] campos = input.split(",");
        return new PlanoTreino(campos[0]);
    }
    
    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PlanoTreinoSave.obj"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    /*
    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PlanoTreinoSave.obj"));
        PlanoTreino pt = (PlanoTreino) ois.readObject();
        ois.close();
        this.nome_plano = pt.nome_plano;
        this.atividades = pt.atividades;

    }
    */
   
}