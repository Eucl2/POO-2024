
import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
Classe que tem acesso a todos os elementos das classes 
 */
public class FitnessApp implements Serializable
{
    private Map<String, Utilizador> utilizadores;
    private Map<Integer, Atividade> atividades;
    private Map<String,PlanoTreino> planos_treino;
    private LocalDate dia_atual;
    
    
    public FitnessApp()
    {
        this.planos_treino = new HashMap<>();
        this.utilizadores = new HashMap<>();
        this.atividades = new HashMap<>();
        this.dia_atual = LocalDate.now();
    }
    
    public FitnessApp(Map<String, Utilizador> nutilizadores, Map<Integer, Atividade> natividades,
    Map<String,PlanoTreino> nplanos_treino)
    {
        //!
        /*
        this.utilizadores = nutilizadores.values().stream().collect(Collectors.toMap(u -> u.getNick(), u -> u.clone()));
        this.atividades = natividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
        this.planos_treino = nplanos_treino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
        */
        this.utilizadores = nutilizadores.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().clone()));
        this.atividades = natividades.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().clone()));
        this.planos_treino = nplanos_treino.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().clone()));
        this.dia_atual = LocalDate.now();
    }
    
    public FitnessApp(FitnessApp ap)
    {
        this(ap.getUtilizadores(), ap.getAtividades(), ap.getPlanosTreino());
    }
    
    public Utilizador getUtilizador(String ni) throws UtilizadorNaoExisteException 
    {
        //!
        Utilizador utilizador = this.utilizadores.get(ni);
        if (utilizador == null )
        {
            throw new UtilizadorNaoExisteException("Utilizador nao existe ");
        }
        else
        {
            return utilizador.clone();
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
    //!
    public Map<String, Utilizador> getUtilizadores()
    {
        return this.utilizadores.values().stream().collect(Collectors.toMap(u -> u.getNick(), u -> u.clone()));
    }
    //!
    public Map<Integer, Atividade> getAtividades()
    {
        return this.atividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
    }
    //!
    public Map<String , PlanoTreino> getPlanosTreino()
    {
        return this.planos_treino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
    }
    //!
    public void setUtilizadores(Map<String, Utilizador> nutilizadores) {
        this.utilizadores = nutilizadores.values().stream().collect(Collectors.toMap(u -> u.getNick(), u -> u.clone()));
    }
    //!
    public void setAtividades(Map<Integer, Atividade> natividades) {
        this.atividades = natividades.values().stream().collect(Collectors.toMap(a -> a.getCodigo(), a -> a.clone()));
    }
    //!
    public void setPlanosTreino(Map<String, PlanoTreino> nplanostreino) {
        this.planos_treino = nplanostreino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
    }
    
    public void insereUtilizador(Utilizador utilizador) throws UtilizadorExisteException 
    {
        if (this.utilizadores.containsKey(utilizador.getNick()))
            throw new UtilizadorExisteException("Utilizador ja existe");
        else 
            this.utilizadores.put(utilizador.getNick(),utilizador.clone());
    
    }
    
    public void insereAtividade(Atividade atividade) throws AtividadeExisteException 
    {
        if (this.atividades.containsKey(atividade.getCodigo()))
            throw new AtividadeExisteException("Atividade ja existe");
        else 
            this.atividades.put(atividade.getCodigo(),atividade.clone());
    
    }
    
    public void inserePlanoTreino(PlanoTreino plano_treino) throws PlanoTreinoExisteException 
    {
        if (this.planos_treino.containsKey(plano_treino.getNomePlano()))
            throw new PlanoTreinoExisteException("Plano de Treino ja existe");
        else 
            this.planos_treino.put(plano_treino.getNomePlano(),plano_treino.clone());
    
    }
    
    //rever porque pode sim existe planos repetidos 
    public void inserePlanoTreinoNoUtilizador(String nickUtilizador, PlanoTreino pt)
            throws PlanoTreinoExisteException {

        if (this.planos_treino.containsKey(pt.getNomePlano())) {
            this.utilizadores.get(nickUtilizador).addPlanoU(pt);

        } else
            throw new PlanoTreinoExisteException("Plano Treino ja adicionado");
        ;// exemption
    }
    
    //registar atividade realizada
    public void insereAtividadeNoHistoricoUtilizador(Utilizador u, Atividade a, int freq_atv, LocalDate d, int dur)
            throws UtilizadorNaoExisteException, AtividadeNaoExisteException {

        if (this.utilizadores.containsKey(u.getNick())) {
            this.utilizadores.get(u.getNick()).realizaAtividade(a,u,d,freq_atv,dur);

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
    
    public LocalDate getDiaAtual()
    {
        return this.dia_atual;
    }
    
    public void setDiaAtual(LocalDate data)
    {
        this.dia_atual = data;
    }
    
    //metodo para "viajar no tempo"
    public void viajarNoTempo(LocalDate data_final)
    {
        /*
        long n_dias =  ChronoUnit.DAYS.between(LocalDate.now(),
                data_final);
        */
       Random rand = new Random(); 
        
        // a frequencia cardiaca media diz respeito a uma media de repouso + ao longo do dia + durante exercicio 
        // a frequencia cardiaca da atividade diz respeito a um valor dentro de um range de frequencia media e frequencia maxima( 220 - idade)
        //!        
        for (Utilizador u : utilizadores.values())
        {
            int idade =  (int) ChronoUnit.YEARS.between(u.getDataNascimento(),LocalDate.now());
            
            int freq_media = u.getFreqCardiaca();
            
            for( PlanoTreino pt : u.getPlanosTreino())
            {
                int contador = 0;
                while( contador < pt.getIteracoes())
                {
                    for (Atividade a : pt.getAtividades().values())
                    {
                        //valor random para freq_atividade
                        int freq_atividade = rand.nextInt((220-idade) - freq_media + 1) + freq_media;
                        
                        //valor random para duracao
                        int dur = rand.nextInt(180 - 10 + 1) + 10;
                        //verificar se posso usar o CompareTo
                        
                        if ( (pt.getData()).compareTo(dia_atual) >= 0 && 
                        (pt.getData()).compareTo(data_final) <= 0)
                        {
                            //insereAtividadeNoHistoricoUtilizador(u,a,90,pt.getData());
                            this.utilizadores.get(u.getNick()).realizaAtividade(a,u,pt.getData(),freq_atividade,dur);
                        }
                        
                    }
                    contador++;
                } 
            }
        }
        
        // Adiciona 1 dia a data_final antes de definir dia_atual
        LocalDate novoDiaAtual = data_final.plusDays(1);
        setDiaAtual(novoDiaAtual);

    }
    
    // Estatisticas 
    
    //1 - qual é o utilizador que mais calorias dispendeu desde sempre 
    public Utilizador maisCaloriasDespendidasSempre()
    {
        Utilizador vencedor = null;
        for( Utilizador u : utilizadores.values())
        {
            if ( vencedor == null || vencedor.getTotalCalorias() <= u.getTotalCalorias())
            {
                vencedor = u.clone();
            }
        }
        
        return vencedor;
    }
    //1 - qual é o utilizador que mais calorias dispendeu num periodo de tempo
    public Utilizador maisCaloriasDespendidasPeriodo(LocalDate inicio, LocalDate fim)
    {
        Utilizador vencedor = null;
        double maximo = 0;
        double sumatorio;
        
        for( Utilizador u : utilizadores.values())
        {
            sumatorio = 0;
            for ( Atividade a : u.getHistorico())
            {
                if ( (a.getDataRealizada()).compareTo(inicio) >= 0 && (a.getDataRealizada()).compareTo(fim) <= 0)
                {
                    sumatorio += a.getCaloriasGastasAtividade();
                }
            }
            if ( sumatorio >= maximo)
            {
                maximo = sumatorio;
                vencedor = u.clone();
            }
        }
        
        return vencedor;
    }
    
    //2 - qual o utilizador que mais actividades realizou desde sempre 
    public Utilizador maisAtividadesSempre()
    {
        Utilizador vencedor = null;
        double max = 0;
        for( Utilizador u : utilizadores.values())
        {
            if ( u.getHistorico().size() >= max)
            {
                max = u.getHistorico().size();
                vencedor = u.clone();
            }
        }
        
        return vencedor;
    }
    //2 - qual o utilizador que mais actividades realizou num periodo de tempo
    public Utilizador maisAtividadesPeriodo(LocalDate inicio, LocalDate fim)
    {
        Utilizador vencedor = null;
        double maximo = 0;
        double sumatorio;
        
        for( Utilizador u : utilizadores.values())
        {
            sumatorio = 0;
            for ( Atividade a : u.getHistorico())
            {
                if ( (a.getDataRealizada()).compareTo(inicio) >= 0 && (a.getDataRealizada()).compareTo(fim) <= 0)
                {
                    sumatorio += 1;
                }
            }
            if ( sumatorio >= maximo)
            {
                maximo = sumatorio;
                vencedor = u.clone();
            }
        }
        
        return vencedor;
    }
    
    //3 - qual o tipo de actividade mais realizada
    public String maisRealizada()
    {
        Map<String,Integer> contadorAtividades = new HashMap<>();
        
        for (Utilizador u : utilizadores.values()) {
            for (Atividade a : u.getHistorico()) {
                String tipoAtividade = a.getTipoAtividade();

                if (contadorAtividades.containsKey(tipoAtividade)) {
                    contadorAtividades.put(tipoAtividade, contadorAtividades.get(tipoAtividade) + 1);
                } else {
                    contadorAtividades.put(tipoAtividade, 1);
                }
            }
        }

        // Encontra o tipo de atividade com o maior contador
        String atividadeMaisRealizada = "";
        int maxContagem = 0;
        
        //!
        for (Map.Entry<String, Integer> entry : contadorAtividades.entrySet()) {
            String tipoAtividade = entry.getKey();
            int contagem = entry.getValue();

            // Verifica se esta atividade tem a contagem mais alta até agora
            if (contagem > maxContagem) {
                maxContagem = contagem;
                atividadeMaisRealizada = tipoAtividade;
            }
        }

        // Retorna o tipo de atividade mais realizada
        return atividadeMaisRealizada;
    }
    
    //4 - quantos kms é que um utilizdor realizou desde sempre
    public double quantoKmsUtilizadorSempre(Utilizador u)
    {
        //!
        double maxkms = 0;
        for ( Atividade a : u.getHistorico())
        {
            if (a instanceof Corrida)
            {
                Corrida c  = (Corrida) a;
                maxkms += c.getDistancia();
            }
            else if (a instanceof Patinagem)
            {
                Patinagem p = (Patinagem) a;
                maxkms += p.getDistancia();
            }
            else if ( a instanceof Remo)
            {
                Remo r = (Remo) a;
                maxkms += r.getDistancia();
            }
            else if( a instanceof Bicicleta)
            {
                Bicicleta b = (Bicicleta) a;
                maxkms += b.getDistancia();
            }
        }
        
        return maxkms;
    }
    
    //4 - quantos kms é que um utilizdor realizou num período 
    public double quantoKmsUtilizadorPeriodo(Utilizador u, LocalDate inicio, LocalDate fim )
    {
        //!
        double maxkms = 0;
        for ( Atividade a : u.getHistorico())
        {
            if ( (a.getDataRealizada()).compareTo(inicio) >= 0 && (a.getDataRealizada()).compareTo(fim) <= 0)
            {
                if (a instanceof Corrida)
                {
                    Corrida c  = (Corrida) a;
                    maxkms += c.getDistancia();
                }
                else if (a instanceof Patinagem)
                {
                    Patinagem p = (Patinagem) a;
                    maxkms += p.getDistancia();
                }
                else if ( a instanceof Remo)
                {
                    Remo r = (Remo) a;
                    maxkms += r.getDistancia();
                }
                else if( a instanceof Bicicleta)
                {
                    Bicicleta b = (Bicicleta) a;
                    maxkms += b.getDistancia();
                }
            }
        }
        
        return maxkms;
    }
    
    //5- quantos metros de altimetria é que um utilizar totalizou desde sempre
    public double quantoAltUtilizadorSempre(Utilizador u)
    {
        //!
        double maxalt = 0;
        for ( Atividade a : u.getHistorico())
        {
            if (a instanceof Corrida)
            {
                Corrida c  = (Corrida) a;
                maxalt += c.getAltimetria();
            }
            if( a instanceof Bicicleta)
            {
                Bicicleta b = (Bicicleta) a;
                maxalt += b.getAltimetria();
            }
        }
        
        return maxalt;
    }
    
    //5- quantos metros de altimetria é que um utilizar totalizou num período 
    public double quantoAltUtilizadorPeriodo(Utilizador u, LocalDate inicio, LocalDate fim)
    {
        //!
        double maxalt = 0;
        for ( Atividade a : u.getHistorico())
        {
            if ( (a.getDataRealizada()).compareTo(inicio) >= 0 && (a.getDataRealizada()).compareTo(fim) <= 0)
            {
                if (a instanceof Corrida)
                {
                    Corrida c  = (Corrida) a;
                    maxalt += c.getAltimetria();
                }
                if( a instanceof Bicicleta)
                {
                    Bicicleta b = (Bicicleta) a;
                    maxalt += b.getAltimetria();
                }
            }
        }
        
        return maxalt;
    }
    
    // 6 - qual o plano de treino mais exigente em função do dispêndio de calorias proposto
    public PlanoTreino qualMaisExigente()
    {
        PlanoTreino plano = null;
        double maximo = 0;
        
        for( PlanoTreino pt : planos_treino.values())
        {
            if(pt.getCalorias() >= maximo)
            {
                plano = pt.clone();
                maximo  = pt.getCalorias();
            }
        }
        
        return plano;
    }
    
    // 7 - listar as actividades de um utilizador ( dentro do utilizador)
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
    //! uma outra fomra seria simplesmente mostrar todas as atividades com o ishard na frente como tem em Cima e depois na altura de escolher nao seria possivel usar as Hard
    public String toStringAtividadesSelecionadas(String tipo, int f)
    {
        String r = "\n";
        for (Atividade a : atividades.values()) {
            if(f == 0)
            {
                if(a.getTipoAtividade().equals(tipo) && a.getIsHard() == false)
                {
                    r += a.getCodigo() + " " + a.getNome() + "\n";
                }
            }else
            {
                if(a.getTipoAtividade().equals(tipo))
                {
                    r += a.getCodigo() + " " + a.getNome() + "\n";
                }
            }
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
    
    //!
    public void save() throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("FitnessApp.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    
    //!
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("FitnessApp.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        FitnessApp ap = (FitnessApp) ois.readObject();
        ois.close();
        this.utilizadores = ap.utilizadores;
        this.atividades = ap.atividades;
        this.planos_treino = ap.planos_treino;
    }
    
    
    
    
}
