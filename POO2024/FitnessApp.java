
import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

/**
Classe que tem acesso a todos os elementos das classes 
 */
public class FitnessApp implements Serializable
{
    private Map<String, Utilizador> utilizadores;
    private Map<Integer, Atividade> atividades;
    private Map<String,PlanoTreino> planos_treino;
    
    public FitnessApp()
    {
        this.planos_treino = new HashMap<>();
        this.utilizadores = new HashMap<>();
        this.atividades = new HashMap<>();
    }
    
    public FitnessApp(Map<String, Utilizador> nutilizadores, Map<Integer, Atividade> natividades,
    Map<String,PlanoTreino> nplanos_treino)
    {
        this.utilizadores = nutilizadores.values().stream().collect(Collectors.toMap(u -> u.getNick(), u -> u.clone()));
        this.atividades = natividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
        this.planos_treino = nplanos_treino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
    }
    
    public Utilizador getUtilizador(String ni, String pass) throws UtilizadorNaoExisteException 
    {
        Utilizador utilizador = this.utilizadores.get(ni);
        if (utilizador == null )
            throw new UtilizadorNaoExisteException("Utilizador nao existe ");
    
        else
        {
            if(utilizador.getPassword().equals(pass))
                return utilizador.clone();
            else
                throw new UtilizadorNaoExisteException("A password esta errada" );
        }
    }
    
    public Atividade getAtividade(int codigo) throws AtividadeNaoExisteException 
    {
        Atividade atividade = this.atividades.get(codigo);
        if (atividade == null)
            throw new AtividadeNaoExisteException("Atividade nao existe");
        else
            return atividade.clone();
    }
    
    public PlanoTreino getPlanoTreino(String nome) throws PlanoTreinoNaoExisteException 
    {
        PlanoTreino plano_treino= this.planos_treino.get(nome);
        if (plano_treino == null)
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");
        else
            return plano_treino.clone();
    }
    
    public Map<String, Utilizador> getUtilizadores()
    {
        return this.utilizadores.values().stream().collect(Collectors.toMap(u -> u.getNick(), u -> u.clone()));
    }
    
    public Map<Integer, Atividade> getAtividades()
    {
        return this.atividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
    }
    
    public Map<String , PlanoTreino> getPlanosTreino()
    {
        return this.planos_treino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
    }
    
    public void setUtilizadores(Map<String, Utilizador> nutilizadores) {
        this.utilizadores = nutilizadores.values().stream().collect(Collectors.toMap(u -> u.getNick(), u -> u.clone()));
    }
    
    public void setAtividades(Map<Integer, Atividade> natividades) {
        this.atividades = natividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
    }
    
    public void setPlanosTreino(Map<String, PlanoTreino> nplanostreino) {
        this.planos_treino = nplanostreino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
    }
    
    public void insereUtilizador(Utilizador utilizador) throws UtilizadorNaoExisteException 
    {
        if (this.utilizadores.containsKey(utilizador.getNick()))
            throw new UtilizadorNaoExisteException("Utilizador ja existe");
        else 
            this.utilizadores.put(utilizador.getNick(),utilizador.clone());
    
    }
    
    public void insereAtividade(Atividade atividade) throws AtividadeNaoExisteException 
    {
        if (this.atividades.containsKey(atividade.getCodigo()))
            throw new AtividadeNaoExisteException("Atividade ja existe");
        else 
            this.atividades.put(atividade.getCodigo(),atividade.clone());
    
    }
    
    public void inserePlanoTreino(PlanoTreino plano_treino) throws PlanoTreinoNaoExisteException 
    {
        if (this.planos_treino.containsKey(plano_treino.getNomePlano()))
            throw new PlanoTreinoNaoExisteException("Plano de Treino ja existe");
        else 
            this.planos_treino.put(plano_treino.getNomePlano(),plano_treino.clone());
    
    }
    
    //rever porque pode sim existe planos repetidos 
    public void inserePlanoTreinoNoUtilizador(String nickUtilizador, PlanoTreino pt)
            throws PlanoTreinoExisteException {

        if (this.planos_treino.containsKey(pt.getNomePlano())) {
            this.utilizadores.get(nickUtilizador).adicionaPlanoTreino(pt);

        } else
            throw new PlanoTreinoExisteException("Plano Treino ja adicionado");
        ;// exemption
    }
    
    //registar atividade realizada
    public void insereAtividadeNoHistoricoUtilizador(Utilizador u, Atividade a, int freq_atv, LocalDate d)
            throws UtilizadorNaoExisteException, AtividadeNaoExisteException {

        if (this.utilizadores.containsKey(u.getNick())) {
            this.utilizadores.get(u.getNick()).realizaAtividade(a,u,d,freq_atv);

        } else
            throw new UtilizadorNaoExisteException("Utilizador nao existe");
        ;// exemption
    }
    
    public void insereAtiviadeNoPlanoTreino(String nomePlano, Atividade a)
            throws AtividadeNaoExisteException, PlanoTreinoNaoExisteException {

        if (this.planos_treino.containsKey(nomePlano)) {
            this.planos_treino.get(nomePlano).insereAtividade(a);

        } else
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");
        ;// exemption
    }
    /*
     * Ainda nao tem utilidade por enquanto
    public void removePlanoTreinoDoUtilizador(int idUtilizador, PlanoTreino pt)
            throws UtilizadorNaoExisteException, PlanoTreinoNaoExisteException {
        if (this.utilizadores.containsKey(idUtilizador)) {
            this.utilizadores.get(idUtilizador).removePlanoTreino(pt);

        } else
            throw new UtilizadorNaoExisteException("Utilizador nao existe");// exemption
    }
    
    public void removeAtividadeDePlanoTreino(String nomePlano, Atividade a)
            throws AtividadeNaoExisteException, PlanoTreinoNaoExisteException {
        if (this.planos_treino.containsKey(nomePlano)) {
            this.planos_treino.get(nomePlano).removeAtividade(a);

        } else
            throw new PlanoTreinoNaoExisteException("Plano de Treino nao existe");// exemption
    }
    
    public void removePlanoTreino(PlanoTreino plano_treino) throws PlanoTreinoNaoExisteException {
        if (this.planos_treino.containsKey(plano_treino.getNomePlano())) {
            this.planos_treino.remove(plano_treino.getNomePlano());

        } else
            throw new PlanoTreinoNaoExisteException("PlanoTreino nao existe"); // exemption
    }
    
    public void removeUtilziador(Utilizador utilizador) throws UtilizadorNaoExisteException {
        if (this.utilizadores.containsKey(utilizador.getId())) {
            this.utilizadores.remove(utilizador.getId());

        } else
            throw new UtilizadorNaoExisteException("Utilizador nao existe"); // exemption
    }
    
    public void removeAtividade(Atividade atividade) throws AtividadeNaoExisteException {
        if (this.atividades.containsKey(atividade.getCodigo())) {
            this.atividades.remove(atividade.getCodigo());

        } else
            throw new AtividadeNaoExisteException("Atividade nao existe"); // exemption
    }
    */
    public String toString() {
        String r = "\n";
        for (Utilizador u : utilizadores.values()) {
            r += u.toString();
        }
        for (Atividade a : atividades.values()) {
            r += a.toString();
        }
        for (PlanoTreino pt : planos_treino.values()) {
            r += pt.toString();
        }
        return r;
    }
    
    public String toStringAtividades()
    {
        String r = "\n";
        for (Atividade a : atividades.values()) {
            r += a.getCodigo() + " " + a.getNome() + "\n";
        }
        return r;
    }
    
    public String toStringPlanosTreino()
    {
        String r = "\n";
        for (PlanoTreino pt : planos_treino.values()) {
            r += pt.getNomePlano() + "\n";
        }
        return r;
    }
    
    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FitnessApp.obj"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    
    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FitnessApp.obj"));
        FitnessApp ap = (FitnessApp) ois.readObject();
        ois.close();
        this.utilizadores = ap.utilizadores;
        this.atividades = ap.atividades;
        this.planos_treino = ap.planos_treino;
    }
    
    
    
    
}
