import java.util.*;
import java.io.IOException;
import java.time.LocalDate;

public class Controller 
{
    

    public static void run() throws IOException, ClassNotFoundException 
    {
        
        FitnessApp ap = new FitnessApp();
        //PlanoTreino novo_plano = new PlanoTreino();
        
        String[] s = { "Log In", "Sign In", "Estatisitica", "Administrador", "Salto Temporal",
            "Carregar Ficheiro Inicial", "Save", "Load" };
        Menu menu = new Menu(s);
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        String line2;
        String[] campo;
        String[] data_nascimento;
        Utilizador novoU = null;
        int op= -1;
        while (op != 0)
        {
           menu.executa();
           op = menu.getOpcao();
           System.out.println(op); 
           
           switch (op) {
                case 1:
                    view.msg("Insira o seu Nickname e Password :D");
                    view.msg("Nickname: ");
                    line = sc.nextLine();
                    view.msg("Password: ");
                    line2 = sc.nextLine();
                    try {
                        Utilizador u = ap.getUtilizador(line, line2);
                        menuUtilizador(ap,u);
                    } catch (UtilizadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    }
                    
                    //menuCriar(l, criacao);
                    break;
                case 2:
                    view.msg("O novo Utilizador considera-se..");
                    view.msg("Amador, Ocasional, Profissional");
                    line = sc.nextLine();
                    switch (line.toLowerCase())
                    {
                        case "amador":
                            view.msg("Siga os passos para criar a sua conta :D");
                            view.msg("nickname,password,nome,email,genero,data nacimento(ano-mes-dia),altura,peso,frequencia cardica media,nivel de experiencia(Avancado,Intermedio,Iniciante),modalidade favorita");
                            line2 = sc.nextLine();
                            campo = line2.split(",");
                            data_nascimento = campo[5].split("-");
                            
                            novoU = new Amador(campo[0], campo[1], campo[2], campo[3], 
                                      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
                                      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
                                      Integer.parseInt(campo[8]), campo[9], campo[10], 0, new ArrayList<>() , new HashMap<>());
                            
                            try {
                                ap.insereUtilizador(novoU);
                                view.printCriacaoUtilizador(novoU.getNick(), novoU.getPassword(),
                                            novoU.getNome(),novoU.getEmail(),novoU.getGenero(),
                                            novoU.getDataNascimento(),novoU.getAltura(),
                                            novoU.getPeso(),novoU.getFreqCardiaca(),
                                            novoU.getFatorMultiplicativo(),novoU.caracteristicasUExtra(),
                                            novoU.getTotalCalorias());
                            } catch (UtilizadorNaoExisteException e) {
                                view.msg(e.getMessage());
                            }
                            break;
                            
                        case "profissional":
                            view.msg("Siga os passos para criar a sua conta :D");
                            view.msg("nickname,password,nome,email,genero,data nacimento(ano-mes-dia),altura,peso,frequencia cardica media,especialidade,anos de experiencia");
                            line2 = sc.nextLine();
                            campo = line2.split(",");
                            data_nascimento = campo[5].split("-");
                            
                            novoU = new Profissional(campo[0], campo[1], campo[2], campo[3], 
                                      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
                                      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
                                      Integer.parseInt(campo[8]), Double.parseDouble(campo[9]), campo[10], 0, new ArrayList<>() , new HashMap<>());
                            
                            try {
                                ap.insereUtilizador(novoU);
                                view.printCriacaoUtilizador(novoU.getNick(), novoU.getPassword(),
                                            novoU.getNome(),novoU.getEmail(),novoU.getGenero(),
                                            novoU.getDataNascimento(),novoU.getAltura(),
                                            novoU.getPeso(),novoU.getFreqCardiaca(),
                                            novoU.getFatorMultiplicativo(),novoU.caracteristicasUExtra(),
                                            novoU.getTotalCalorias());
                            } catch (UtilizadorNaoExisteException e) {
                                view.msg(e.getMessage());
                            }
                            break;
                        
                        case "ocasional":
                            view.msg("Siga os passos para criar a sua conta :D");
                            view.msg("nickname,password,nome,email,genero,data nacimento(ano-mes-dia),altura,peso,frequencia cardica media,frequencia de pratica (nº de vezes por mes),motivacao");
                            line2 = sc.nextLine();
                            campo = line2.split(",");
                            data_nascimento = campo[5].split("-");
                            
                            novoU = new Ocasional(campo[0], campo[1], campo[2], campo[3], 
                                          campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
                                          Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
                                          Integer.parseInt(campo[8]), Integer.parseInt(campo[9]), campo[10], 0, new ArrayList<>() , new HashMap<>());
                            
                            try {
                                ap.insereUtilizador(novoU);
                                view.printCriacaoUtilizador(novoU.getNick(), novoU.getPassword(),
                                            novoU.getNome(),novoU.getEmail(),novoU.getGenero(),
                                            novoU.getDataNascimento(),novoU.getAltura(),
                                            novoU.getPeso(),novoU.getFreqCardiaca(),
                                            novoU.getFatorMultiplicativo(),novoU.caracteristicasUExtra(),
                                            novoU.getTotalCalorias());
                            } catch (UtilizadorNaoExisteException e) {
                                view.msg(e.getMessage());
                            }
                            break;
                        
                        
                    }
                    break;
                case 3:
                    menuEstatistica(ap);
                    break;
                case 4:
                    menuAdministrador(ap);
                    break;
                case 5:
                    SaltoTemporal(ap);
                    break;
                case 6:
                    menuFicheiro(ap);
                    break;
                case 7:
                    save(ap);
                    break;
                case 8:
                    load(ap);
                    break;
                case 0:
                    break;
            }
        }
    }
    
    public static void save(FitnessApp ap) throws IOException {

        View view = new View();
        ap.save();
        view.msg("-------------Saved------------");

    }

    public static void load(FitnessApp ap) throws IOException, ClassNotFoundException {
        View view = new View();
        ap.load();
        view.msg("-------------Loaded------------");

    }
    
    public static void menuUtilizador(FitnessApp ap, Utilizador u) {
        String[] s = { "Ver Atividades", "Ver Planos Treino", "Pesquisar Atividade", "Pesquisar Plano", "Registar Atividade Realizada",
                "Escolher Plano de Treino", "Historico de Ativiades Realizadas", "Os Meus Planos Treino", " O Meu Prefil"};
        Menu menuCriar = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        String line2;
        String line3;
        Utilizador up = null;

        while (op != 0) {
            menuCriar.executa();
            op = menuCriar.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:
                    view.msg("Estas sao as atividades existentes :D");
                    view.printAtividades(ap.toStringAtividades());
     
                    break;
                case 2:

                    view.msg("Estes sao todos os Planos existentes :D");
                    view.printPlanosTreino(ap.toStringPlanosTreino());

                    break;
                case 3:
                    view.msg("Codigo da Atividade?");
                    line = sc.nextLine();
                    //metodo questionavel
                    //char first = line.charAt(0);
                    try {
                        Atividade a = ap.getAtividade(Integer.valueOf(line));
    
                        view.printAtividade(a.getCodigo(),a.getNome(),
                        a.getDescricao(),a.getDuracao(),a.caracteristicasExtra(),
                        a.getFreqCardiaAtividade(), a.getCaloriasGastasAtividade(),
                        a.getDataRealizada());
                        
                        //falta adicionar cada coisa para dar print,
                        //as toSring extras de cada atividade nas atividades
                    } catch (AtividadeNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;
                case 4:
                    view.msg("Nome do Plano de Treino?");
                    line = sc.nextLine();
                    try {
                        PlanoTreino pt = ap.getPlanoTreino(line);
                        view.printPlanoTreino(pt.getNomePlano(), pt.getData(),
                        pt.getIteracoes(), pt.toString());
                        //verificar outra vez o toString2 de pt
                    } catch (PlanoTreinoNaoExisteException e) {
                        view.msg(e.getMessage());
                    }

                    break;
                case 5:
                    view.msg("Qual e o codigo atividade que realizou? :D");
                    line = sc.nextLine();
                    view.msg("Qual é o dia em que realizou (ano-mes-dia)? :D");
                    line2 = sc.nextLine();
                    String[] data = line2.split("-");
                    LocalDate dia = LocalDate.of(Integer.parseInt(data[0]),
                                    Integer.parseInt(data[1]), 
                                    Integer.parseInt(data[2]));
                    view.msg("Que frequencia Cardiaca teve durante a Atividade? :D");
                    line3 = sc.nextLine();
                    try 
                    {
                        Atividade a = ap.getAtividade(Integer.valueOf(line));
                        ap.insereAtividadeNoHistoricoUtilizador(u,a,Integer.valueOf(line3),dia);
                        view.printAtividadeRealizada(u.getNome(), dia, 
                            a.getCodigo(), a.getNome());
                    } 
                    catch (AtividadeNaoExisteException | UtilizadorNaoExisteException e) 
                    {
                        view.msg(e.getMessage());
                    }
                    

                    break;
                case 6:
                    view.msg("Qual e o nome do plano de treino a adicionar? :D");
                    line = sc.nextLine();
                    try 
                    {
                        PlanoTreino pt2 = ap.getPlanoTreino(line);
                        ap.inserePlanoTreinoNoUtilizador(u.getNick(),pt2);
                        view.printPlanoTreinoEscolhido(u.getNome(), pt2.getNomePlano());
                    } 
                    catch (PlanoTreinoExisteException | PlanoTreinoNaoExisteException e) 
                    {
                        view.msg(e.getMessage());
                    }
                    

                    break;
                case 7:
                    try
                    {
                        up = ap.getUtilizador(u.getNick(),u.getPassword());
                        view.printHistoricoUtilizador(up.getNick(), up.getNome(),
                        up.getTipoUtilizador(), up.toStringHistorico());
                    }
                    catch (UtilizadorNaoExisteException e)
                    {
                        view.msg(e.getMessage());
                    }
                    break;
                case 8:
                    try
                    {
                        up = ap.getUtilizador(u.getNick(),u.getPassword());
                        view.printPlanosTreinoUtilizador(up.getNick(), up.getNome(),
                        up.getTipoUtilizador(), up.toStringPlanosTreinoU());
                    }
                    catch (UtilizadorNaoExisteException e)
                    {
                        view.msg(e.getMessage());
                    }
                    break;
                case 9:
                    try
                    {
                        up = ap.getUtilizador(u.getNick(),u.getPassword());
                        view.printUtilizador(up.getNick(), up.getPassword(), up.getNome(),
                        up.getEmail(), up.getGenero(),up.getDataNascimento(),
                        up.getAltura(), up.getPeso(), up.getFreqCardiaca(),
                        up.getFatorMultiplicativo(),up.caracteristicasUExtra(),
                        up.getTotalCalorias());
                    }
                    catch (UtilizadorNaoExisteException e)
                    {
                        view.msg(e.getMessage());
                    }
                
                    break;
            }
        }
    }
    
    public static void menuEstatistica(FitnessApp ap) {
        String[] s = { "Estatisticas"};
        Menu menuVer = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        while (op != 0) {
            menuVer.executa();
            op = menuVer.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:
                    break;
                
            }

        }

    }
    
    public static void menuAdministrador(FitnessApp ap) {
        String[] s = { "Criar Atividade", "Criar Plano", "Sair"};
        Menu menuVer = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        String[] all;
        Atividade atividade_nova = null;
        PlanoTreino planoTreino_novo = null;
        while (op != 0) {
            menuVer.executa();
            op = menuVer.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:
                
                    view.msg("Qual o tipo de atividade? :D");
                    view.msg("Patinagem, Remo, Corrida, Bicicleta, Abdominais, Alongamentos, LevantaPeso, ExtensaoPernas, Flexoes");
                    line = sc.nextLine();
                    switch (line.toLowerCase())
                    {
                        case "patinagem":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Distancia,Percurso");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Patinagem(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Double.parseDouble(all[4]),
                                                        all[5], null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "remo":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Distancia,Percurso");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Remo(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Double.parseDouble(all[4]),
                                                        all[5], null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "corrida":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Distancia,Altimetria,Percurso");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Corrida(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Double.parseDouble(all[4]),
                                                        Double.parseDouble(all[5]),all[6], null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "bicicleta":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Distancia,Altimetria,Percurso");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Bicicleta(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Double.parseDouble(all[4]),
                                                        Double.parseDouble(all[5]),all[6], null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "abdominais":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Repeticoes");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Abdominais(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Integer.parseInt(all[4]),
                                                        null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "alongamentos":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Repeticoes");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Alongamentos(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Integer.parseInt(all[4]),
                                                        null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "flexoes":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Repeticoes");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Flexoes(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Integer.parseInt(all[4]),
                                                        null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "levantapeso":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Repeticoes,Peso");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new LevantaPeso(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Integer.parseInt(all[4]),
                                                        Double.parseDouble(all[5]),null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "extensaopernas":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Duracao,Repeticoes,Peso");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new ExtensaoPernas(Integer.parseInt(all[0]),all[1],
                                                        all[2],Integer.parseInt(all[3]),Integer.parseInt(all[4]),
                                                        Double.parseDouble(all[5]),null, 0, 0);
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),atividade_nova.getDuracao(),
                                    atividade_nova.caracteristicasExtra(),atividade_nova.getDataRealizada());

                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        
                    }
                    break;
                    
                case 2:
                    view.msg("Siga os passos para criar o Plano de Treino :D");
                    view.msg("Nome,Data de Execucao(ano-mes-dia),Iteracoes das Atividades");
                    line = sc.nextLine();
                    all = line.split(",");
                    String[] data_execucao = all[1].split("-");
                    planoTreino_novo = new PlanoTreino(all[0], LocalDate.of(Integer.parseInt(data_execucao[0]), Integer.parseInt(data_execucao[1]), 
                                          Integer.parseInt(data_execucao[2])), Integer.parseInt(all[2]));
                    try {
                            ap.inserePlanoTreino(planoTreino_novo);
                            view.printPlanoTreinoCriado(planoTreino_novo.getNomePlano(), 
                    planoTreino_novo.getData(),planoTreino_novo.getIteracoes());
                        } catch (PlanoTreinoNaoExisteException e) {
                            view.msg(e.getMessage());
                        }
                    view.msg("Lista Atividades: ");
                    view.printAtividades(ap.toStringAtividades());
                    view.msg("Que atividades quer no Novo Plano ?:D");
                    view.msg("Codgido da Atividade1,Codigo da Atividade2...");
                    line = sc.nextLine();
                    all = line.split(",");
                    for (int i=0; i<all.length; i++)
                    {
                        try {
                            Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                            ap.insereAtiviadeNoPlanoTreino(planoTreino_novo.getNomePlano(),a);
                            view.printAtividadeAdicionada(a.toString2());
                        } catch (AtividadeNaoExisteException | PlanoTreinoNaoExisteException e) {
                            view.msg(e.getMessage());
                        }
                    }
                    
                    break;
                    
                case 3:
                    view.msg("Sair do modo Admin:D");
                    break;
            }

        }

    }
    
    public static void SaltoTemporal(FitnessApp ap) {
        String[] s = { "Salto Para dia"};
        Menu menuVer = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        while (op != 0) {
            menuVer.executa();
            op = menuVer.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:
                    break;
                
            }

        }
    }
    
    public static void menuFicheiro(FitnessApp ap) {
        Parser p = new Parser();
        View view = new View();
        try {
            p.parse();
            ap.setUtilizadores(p.getUtilizadores());
            ap.setAtividades(p.getAtividades());
            ap.setPlanosTreino(p.getPlanosTreino());
        } catch (LinhaIncorretaException e) {
            view.msg(e.getMessage());
        }
        
    }
    
}
