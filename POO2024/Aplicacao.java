
import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
/**
Classe que tem acesso a todos os elementos das classes 
 */
public class Aplicacao
{
    private Map<String,PlanoTreino> planos_treino;
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<Atividade> atividades;
    
    public Aplicacao()
    {
        this.planos_treino = new HashMap<>();
        this.utilizadores = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }
    
    public Aplicacao(Map<String,PlanoTreino> planos_treino , ArrayList<Utilizador> utilizadores, ArrayList<Atividade> atividades)
    {
        this.planos_treino = planos_treino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
        this.utilizadores = utilizadores.stream().collect(Collectors.toList());
        this.atividades = atividades.stream().collect(Collectors.toList());
    }
    
    public PlanoTreino getPlanoTreino(String nome) throws PlanoTreinoNaoExisteException 
    {
        PlanoTreino plano_treino = this.planos_treino.get(nome);
        if (plano_treino == null)
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");
        else
            return plano_treino.clone();
    }
    
    public Map<String , PlanoTreino> getPlanoTreino()
    {
        return this.planostreino.values().stream().collect(Collectors.toMap(pt -> pt.getNome(), pt -> pt.clone()));
    }
    
    public void inserePlanoTreino(PlanoTreino plano_treino) throws PlanoTreinoNaoExisteException 
    {
        if (this.plano_treinos.containsKey(plano_treino.getNome()))
            throw new PlanoTreinoNaoExisteException("Plano de Treino ja existe");
        else 
            this.plano_treinos.put(plano_treino.getNome(),plano_treino.clone());
    
    }
    
}
