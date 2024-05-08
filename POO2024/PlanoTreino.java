import java.util.ArrayList;
import java.io.*;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;

public class PlanoTreino implements Serializable
{
    
    private String nome;
    private LocalDate data;
    private Map<Integer, Atividade> atividades;
    private int n_iteracoes;
    

    public PlanoTreino() 
    {
        this.nome = "";
        this.data = null;
        this.atividades = new HashMap<>();
        this.n_iteracoes = 0;
    }

    public PlanoTreino(String n, LocalDate data_executar, int it) 
    {
        this.nome = n;
        this.data = data_executar;
        this.atividades = new HashMap<>();
        this.n_iteracoes = it;
    }
    
    public PlanoTreino(PlanoTreino pt) 
    {
        this.nome = pt.getNomePlano();
        this.data = pt.getData();
        this.atividades= pt.getAtividades();
        this.n_iteracoes = pt.getIteracoes();
    }
    
    public String getNomePlano()
    {
        return this.nome;
    }
    
    public LocalDate getData()
    {
        return this.data;
    }
    
    public Map<Integer, Atividade> getAtividades()
    {
        return this.atividades.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),
                    e->e.getValue().clone()));
        //return this.atividades.values().stream().collect(Collectors.toMap(pt -> pt.getCodigo(), pt -> pt.clone()));
    }
    
    public int getIteracoes()
    {
        return this.n_iteracoes;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setData(LocalDate data)
    {
        this.data = data;
    }
    
    public void setAtividades(Map<Integer, Atividade> nAtividades)
    {
        this.atividades = nAtividades.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),
                            e->e.getValue().clone()));
        //this.atividades = nAtividades.values().stream()
                //.collect(Collectors.toMap(pt -> pt.getCodigo(), pt -> pt.clone()));
    }
    
    public void setIteracoes(int iteracoes)
    {
        this.n_iteracoes = iteracoes;
    }
      
    public void insereAtividade(Atividade a)
    {
        this.atividades.put(a.getCodigo(),a.clone());
        
    }
    
    //pode vir a ser necessario futuramente 
    /*
    public void setAtividade(Atividade a) throws AtividadeNaoExisteException
    {
        if(this.atividades.containsKey(a.getCodigo()))
            throw new AtividadeNaoExisteException("Nao existe atividade com esse codigo");
        else
            this.atividades.put(a.getCodigo(), a.clone());
    }
    */
    /*
     * Sem utilidade ainda 
    public void removeAtividade(Atividade a) throws AtividadeNaoExisteException
    {
        int n = a.getCodigo();
        if (!this.atividades.containsKey(n))
            throw new AtividadeNaoExisteException("Atividade nao existe");
        else{
            this.atividades.remove(n);
        }
    }
    */
    
    public String toString() {
        /*
        String r = "Plano de treino:" + nome + "\n" +
        "Data:" + data + "\n" + "Numero de Iteracoes:" + n_iteracoes + "\n";
        // String r = "\n";
        */
        String r = "\n";
        for (Atividade a : atividades.values()) {
            r += a.toString2() ;
        }
        return r;
    }
    
    public String toString2() {
        return nome + " " + "\n";
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
        return pt.getNomePlano().equals(this.nome)
        && pt.getData().equals(this.data)
        && pt.getAtividades().equals(this.atividades)
        && pt.getIteracoes() == (this.n_iteracoes);

    }
    
    public static PlanoTreino parse(String input) {
        String[] campos = input.split(",");
        String[] data_execucao = campos[1].split("-");
        return new PlanoTreino(campos[0], LocalDate.of(Integer.parseInt(data_execucao[0]), Integer.parseInt(data_execucao[1]), 
      Integer.parseInt(data_execucao[2])), Integer.parseInt(campos[2]));
    }
}