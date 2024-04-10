import java.util.ArrayList;
import java.io.*;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.*;

public class PlanoTreino implements Serializable
{
    private String nome_plano;
    private Map<String, Atividade> atividades;
    private Map<Integer, Atividade> repeticao_atividade;
    private ArrayList<Recorrencia> recorrencia;
    private int minimo_calorias;
    

    public PlanoTreino() 
    {
        this.nome_plano = "";
        this.atividades = new HashMap<>();
        this.repeticao_atividade = new HashMap<>();
        this.recorrencia = new ArrayList<>();
        this.minimo_calorias = 0;
    }

    public PlanoTreino(String nome_plano) 
    {
        this.nome_plano = nome_plano;
        this.atividades = new HashMap<>();
        this.repeticao_atividade = new HashMap<>();
        this.recorrencia = new ArrayList<>();
        this.minimo_calorias = 0;
    }
    
    public PlanoTreino(PlanoTreino pt) 
    {
        this.nome_plano = pt.getNomePlano();
        this.atividades = pt.getAtividades();
        this.repeticao_atividade = pt.getRepeticaoAtividade();
        this.recorrencia = pt.getRecorrencia();
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
    
    public Map<String, Atividade> getAtividades()
    {
        return this.atividades.values().stream().collect(Collectors.toMap(pt -> pt.getNomeAtividade(), pt -> pt.clone()));
    }
    
    public void setAtividades(Map<String, Atividade> nAtividades)
    {
        this.atividades = nAtividades.values().stream().collect(Collectors.toMap(pt -> pt.getNomeAtividade(), pt -> pt.clone()));
                
    }
    
    public Map<Atividade, Integer> getRepeticaoAtividade()
    {
        return this.repeticao_atividade.values().stream().collect(Collectors.toMap(pt -> pt.clone(), pt -> pt.getNumeroAtividade()));
    }
    
    public void setAtividades(Map<String, Atividade> nAtividades)
    {
        this.atividades = nAtividades.values().stream().collect(Collectors.toMap(pt -> pt.getNomeAtividade(), pt -> pt.clone()));
                
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