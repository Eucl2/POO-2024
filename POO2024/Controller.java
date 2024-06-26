import java.util.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.DayOfWeek;

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
                        Utilizador u = ap.getUtilizador(line);
                        if(u.getPassword().equals(line2))
                        {
                           menuUtilizador(ap,u.getNick()); 
                        }
                        else
                        {
                            view.msg("Password errada :(");
                        }
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
                                      Integer.parseInt(campo[8]), campo[9], campo[10], 0, new ArrayList<>() , new ArrayList<>());
                            
                            try {
                                ap.insereUtilizador(novoU);
                                view.printCriacaoUtilizador(novoU.getNick(), novoU.getPassword(),
                                            novoU.getNome(),novoU.getEmail(),novoU.getGenero(),
                                            novoU.getDataNascimento(),novoU.getAltura(),
                                            novoU.getPeso(),novoU.getFreqCardiaca(),
                                            novoU.getFatorMultiplicativo(),novoU.caracteristicasUExtra(),
                                            novoU.getTotalCalorias());
                            } catch (UtilizadorExisteException e) {
                                view.msg(e.getMessage());
                            }
                            break;
                            
                        case "profissional":
                            view.msg("Siga os passos para criar a sua conta :D");
                            view.msg("nickname,password,nome,email,genero,data nacimento(ano-mes-dia),altura,peso,frequencia cardica media,anos de experiencia,especialidade");
                            line2 = sc.nextLine();
                            campo = line2.split(",");
                            data_nascimento = campo[5].split("-");
                            
                            novoU = new Profissional(campo[0], campo[1], campo[2], campo[3], 
                                      campo[4], LocalDate.of(Integer.parseInt(data_nascimento[0]), Integer.parseInt(data_nascimento[1]), 
                                      Integer.parseInt(data_nascimento[2])),Double.parseDouble(campo[6]), Double.parseDouble(campo[7]), 
                                      Integer.parseInt(campo[8]), Double.parseDouble(campo[9]), campo[10], 0, new ArrayList<>() , new ArrayList<>());
                            
                            try {
                                ap.insereUtilizador(novoU);
                                view.printCriacaoUtilizador(novoU.getNick(), novoU.getPassword(),
                                            novoU.getNome(),novoU.getEmail(),novoU.getGenero(),
                                            novoU.getDataNascimento(),novoU.getAltura(),
                                            novoU.getPeso(),novoU.getFreqCardiaca(),
                                            novoU.getFatorMultiplicativo(),novoU.caracteristicasUExtra(),
                                            novoU.getTotalCalorias());
                            } catch (UtilizadorExisteException e) {
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
                                          Integer.parseInt(campo[8]), Integer.parseInt(campo[9]), campo[10], 0, new ArrayList<>() , new ArrayList<>());
                            
                            try {
                                ap.insereUtilizador(novoU);
                                view.printCriacaoUtilizador(novoU.getNick(), novoU.getPassword(),
                                            novoU.getNome(),novoU.getEmail(),novoU.getGenero(),
                                            novoU.getDataNascimento(),novoU.getAltura(),
                                            novoU.getPeso(),novoU.getFreqCardiaca(),
                                            novoU.getFatorMultiplicativo(),novoU.caracteristicasUExtra(),
                                            novoU.getTotalCalorias());
                            } catch (UtilizadorExisteException e) {
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
    //!
    public static void save(FitnessApp ap) throws IOException 
    {

        View view = new View();
        ap.save();
        view.msg("-------------Saved------------");

    }
    //!
    public static void load(FitnessApp ap) throws IOException, ClassNotFoundException 
    {
        View view = new View();
        ap.load();
        view.msg("-------------Loaded------------");

    }
    
    public static void menuUtilizador(FitnessApp ap, String nick) {
        String[] s = {"Ver Atividades", "Ver Planos Treino", "Pesquisar Atividade", "Pesquisar Plano", "Registar Atividade Realizada",
                "Escolher Plano de Treino", "Criar Plano Treino (Automatico)", "Criar Plano(Personalizado)", "Historico de Ativiades Realizadas", 
                "Os Meus Planos Treino", "O Meu Perfil"};
        Menu menuCriar = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        String line2;
        String line3;
        PlanoTreino plano_gerado = null;
        String[] all;
        Utilizador uAtual = null;

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
                        a.getDescricao(),a.caracteristicasExtra(),
                        a.getIsHard());
                        
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
                    view.msg("Quanto tempo demorou? (minutos) :D");
                    line2 = sc.nextLine();
                    try 
                    {
                        Atividade a = ap.getAtividade(Integer.valueOf(line));
                        uAtual = ap.getUtilizador(nick);
                        ap.insereAtividadeNoHistoricoUtilizador(uAtual,a,Integer.valueOf(line3),dia,Integer.valueOf(line2));
                        view.printAtividadeRealizada(uAtual.getNome(), dia, 
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
                        PlanoTreino pt = ap.getPlanoTreino(line);
                        uAtual = ap.getUtilizador(nick);
                        ap.inserePlanoTreinoNoUtilizador(uAtual.getNick(),pt);
                        view.printPlanoTreinoEscolhido(uAtual.getNome(), pt.getNomePlano());
                    } 
                    catch (PlanoTreinoExisteException | PlanoTreinoNaoExisteException | UtilizadorNaoExisteException e )
                    {
                        view.msg(e.getMessage());
                    }
                    

                    break;
                case 7:
                    view.msg("Para que tipo de Atividade gostava de ter um plano de treino ? :D");
                    view.msg("Patinagem, Remo, Corrida, Bicicleta, Abdominais, Alongamentos, LevantaPeso, ExtensaoPernas, Flexoes");
                    line = sc.nextLine();
                    switch (line.toLowerCase())
                    {
                        case "patinagem":
                            plano_gerado = new PlanoTreino("Patinagem - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Patinagem - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoExisteException | PlanoTreinoNaoExisteException | AtividadeNaoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "remo":
                            plano_gerado = new PlanoTreino("Remo - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Remo - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "corrida":
                            plano_gerado = new PlanoTreino("Corrida - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Corrida - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "bicicleta":
                            plano_gerado = new PlanoTreino("Bicicleta - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Bicicleta - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "abdominais":
                            plano_gerado = new PlanoTreino("Abdominais - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Abdominais - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "alongamentos":
                            plano_gerado = new PlanoTreino("Alongamentos - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Alongamentos - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "flexoes":
                            plano_gerado = new PlanoTreino("Flexoes - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Flexoes - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "levantapeso":
                            plano_gerado = new PlanoTreino("Levantamento de Peso - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Levantamento de Peso - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        case "extensaopernas":
                            plano_gerado = new PlanoTreino("Extensao Pernas - Modulo 1", LocalDate.of(2024,06,07),2,0,""); // plano gerado automaticamente
                            line = "11";
                            all = line.split(",");
                            try 
                            {
                                ap.inserePlanoTreino(plano_gerado);
                                for (int i=0; i<all.length; i++)
                                {
                                    Atividade a = ap.getAtividade(Integer.valueOf(all[i]));
                                    ap.insereAtiviadeNoPlanoTreino("Extensao Pernas - Modulo 1",a);  
                                }
                            } 
                            catch (PlanoTreinoNaoExisteException | AtividadeNaoExisteException | PlanoTreinoExisteException e) // alterar execption do Plano
                            {
                                view.msg(e.getMessage());
                            }
                            break;
                        
                    }
                    break;
                case 8:
                    view.msg("Siga os passos para criar o Plano de Treino Personalizado :D\n");
                    
                    //verificar se o utilizador pretende ter atividades hard
                    view.msg("Pretende incluir atividades do tipo Hard ? [Y/N]");
                    line = sc.nextLine();
                    String[] dias_semana;
                    String[] datas_semana;
                    String[] ndata;
                    String line4;
                    String[] tipo_ativ;
                    String[] at;
                    String nome;
                    int flag = 0;
                    int incrementa = 1;
                    LocalDate data_p;
                    LocalDate data_semana = null;
                    List<Atividade> att = new ArrayList<>();
                    List<LocalDate> datas_plano = new ArrayList<>();; // lista com os dias em que o plano vai se realizar inicialmente
                    switch (line.toLowerCase())
                    {
                        case "y":
                            view.msg(" Em que semana pretende começar? (data do primeiro dia da semana)");
                            line2 = sc.nextLine();
                            ndata = line2.split("-");
                            data_p = LocalDate.of(Integer.parseInt(ndata[0]), Integer.parseInt(ndata[1]), 
                                                  Integer.parseInt(ndata[2]));
                            data_semana = null;
                            view.msg("Qual a recorrencia semanal das atividades ?");
                            line3 = sc.nextLine();
                            view.msg("Quais os dias da semana? ( Ter em atencao que apenas pode ter ate 3 dias)");
                            view.msg("1-Segunda, 2-Terca, 3-Quarta, 4-Quinta, 5-Sexta, 6-Sabado, 7-Domingo");
                            line2 = sc.nextLine();
                            dias_semana = line2.split(",");
                            if( line3.equals("2"))
                            {
                                while( Integer.parseInt(dias_semana[1]) - Integer.parseInt(dias_semana[0]) <= 1)
                                {
                                    view.msg("Escolha de novo os dias ");
                                    view.msg("1-Segunda, 2-Terca, 3-Quarta, 4-Quinta, 5-Sexta, 6-Sabado, 7-Domingo");
                                    line2 = sc.nextLine();
                                    dias_semana = line2.split(",");
                                }
                            }
                            else
                            {
                                if( line3.equals("3"))
                                {
                                    while( Integer.parseInt(dias_semana[1]) - Integer.parseInt(dias_semana[0]) <= 1 && 
                                    Integer.parseInt(dias_semana[2]) - Integer.parseInt(dias_semana[1]) <= 1 )
                                    {
                                        view.msg("Escolha de novo os dias ");
                                        view.msg("1-Segunda, 2-Terca, 3-Quarta, 4-Quinta, 5-Sexta, 6-Sabado, 7-Domingo");
                                        line2 = sc.nextLine();
                                        dias_semana = line2.split(",");
                                    }
                                }
                            }
                            
                            //1º - Saber quantos dias e quais as datas a inicializar o plano de treino
                            if( Integer.parseInt(line3) > 0 && Integer.parseInt(line3) <= 3)
                            { 
                                
                                for( int i=0 ; i < Integer.parseInt(line3) ; i++)
                                {
                                    switch (dias_semana[i].toLowerCase())
                                    {
                                        case "1":
                                                datas_plano.add(data_p);
                                            break;
                                        case "2":
                                            data_semana = data_p.plusDays(1);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "3":
                                            data_semana = data_p.plusDays(2);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "4":
                                            data_semana = data_p.plusDays(3);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "5":
                                            data_semana = data_p.plusDays(4);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "6":
                                            data_semana = data_p.plusDays(5);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "7":
                                            data_semana = data_p.plusDays(6);
                                            datas_plano.add(data_semana);
                                            break;
                                    }
                                }
                            }
                            view.msg("Que tipo de Atividades (pode escolher até 3)?");
                            view.msg("Patinagem, Remo, Corrida, Bicicleta, Abdominais, Alongamentos, LevantaPeso, ExtensaoPernas, Flexoes");
                            line3 = sc.nextLine();
                            tipo_ativ = line3.split(",");
                            flag = 1;
                            for(int i = 0; i< tipo_ativ.length && i < 3 ; i++)
                            {
                                view.printAtividades(ap.toStringAtividades());
                            }
                            view.msg("Escolha as atividades de acordo com o maximo: (CodigoAtividade1,CodigoAtividade2.. ");
                            line3 = sc.nextLine();
                            at = line3.split(",");
                            while( at.length < 1 || at.length > 3)
                            {
                                view.msg("Escolha de novo as atividades de acordo com o maximo: (CodigoAtividade1,CodigoAtividade2.. ");
                                line3 = sc.nextLine();
                                at = line3.split(",");
                            }
                            //List<Atividade> att = new ArrayList<>();
                            flag = 0;
                            for (int i=0; i<at.length; i++)
                            {
                                try {
                                    Atividade a = ap.getAtividade(Integer.valueOf(at[i]));
                                    if (flag == 0)
                                    {
                                        att.add(a);
                                        if (a.getIsHard() == true)
                                        flag = 1;
                                    }
                                    else
                                    {
                                        if (a.getIsHard() == true)
                                            view.msg("Nao pode ter mais que 1 Hard , Atividade excluida");
                                        else
                                           att.add(a); 
                                    }
                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            }
                            view.msg("Siga os restantes passos para criar a base do Plano de Treino :D");
                            view.msg("Nome,Iteracoes das Atividades,Calorias Previstas");
                            line= sc.nextLine();
                            all = line.split(",");
                            for( LocalDate d : datas_plano)
                            {
                                nome = all[0] + Integer.toString(incrementa);
                                incrementa += 1;
                                //agora os planos de treino tem calorias previstas e os dias a executar em string
                                plano_gerado = new PlanoTreino(nome,d,Integer.parseInt(all[1]),Double.parseDouble(all[2]),line2);
                                try {
                                    ap.inserePlanoTreino(plano_gerado);
                                } catch (PlanoTreinoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                                for (Atividade a : att)
                                {
                                    try {
                                        ap.insereAtiviadeNoPlanoTreino(plano_gerado.getNomePlano(),a);
                                        view.printAtividadeAdicionada(a.toString2());
                                    } catch (AtividadeNaoExisteException | PlanoTreinoNaoExisteException e) {
                                        view.msg(e.getMessage());
                                    }
                                }   
                            }
                            break;
                        case "n":
                            view.msg(" Em que semana pretende começar? (data do primeiro dia da semana)");
                            line2 = sc.nextLine();
                            ndata = line2.split("-");
                            data_p = LocalDate.of(Integer.parseInt(ndata[0]), Integer.parseInt(ndata[1]), 
                                                  Integer.parseInt(ndata[2]));
                            data_semana = null;
            
                            view.msg("Qual a recorrencia semanal das atividades ?");
                            line3 = sc.nextLine();
                            if( line3.equals("7"))
                            {
                                line2 = "1,2,3,4,5,6,7";
                                dias_semana = line2.split(",");
                            }
                            else
                            {
                                view.msg("Quais os dias da semana? ( Ter em atencao que apenas pode ter ate 3 dias)");
                                view.msg("1-Segunda, 2-Terca, 3-Quarta, 4-Quinta, 5-Sexta, 6-Sabado, 7-Domingo 8-Todos");
                                line2 = sc.nextLine();
                                dias_semana = line2.split(",");
                            }
                            
                            //1º - Saber quantos dias e quais as datas a inicializar o plano de treino
                            if( Integer.parseInt(line3) > 0 && Integer.parseInt(line3) <= 7)
                            { 
                                
                                for( int i=0 ; i < Integer.parseInt(line3) ; i++)
                                {
                                    switch (dias_semana[i].toLowerCase())
                                    {
                                        case "1":
                                                datas_plano.add(data_p);
                                            break;
                                        case "2":
                                            data_semana = data_p.plusDays(1);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "3":
                                            data_semana = data_p.plusDays(2);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "4":
                                            data_semana = data_p.plusDays(3);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "5":
                                            data_semana = data_p.plusDays(4);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "6":
                                            data_semana = data_p.plusDays(5);
                                            datas_plano.add(data_semana);
                                            break;
                                        case "7":
                                            data_semana = data_p.plusDays(6);
                                            datas_plano.add(data_semana);
                                            break;
                                    }
                                }
                            }
                            view.msg("Que tipo de Atividades (pode escolher até 3)?");
                            view.msg("Patinagem, Remo, Corrida, Bicicleta, Abdominais, Alongamentos, LevantaPeso, ExtensaoPernas, Flexoes");
                            line3 = sc.nextLine();
                            tipo_ativ = line3.split(",");
                            flag = 1;
                            for(int i = 0; i< tipo_ativ.length && i < 3 ; i++)
                            {
                                view.printAtividades(ap.toStringAtividades());
                            }
                            view.msg("Escolha as atividades de acordo com o maximo: (CodigoAtividade1,CodigoAtividade2.. ");
                            line3 = sc.nextLine();
                            at = line3.split(",");
                            while( at.length < 1 || at.length > 3)
                            {
                                view.msg("Escolha de novo as atividades de acordo com o maximo: (CodigoAtividade1,CodigoAtividade2.. ");
                                line3 = sc.nextLine();
                                at = line3.split(",");
                            }
                            //List<Atividade> att2 = new ArrayList<>();
                            flag = 0;
                            for (int i=0; i<at.length; i++)
                            {
                                try {
                                    Atividade a = ap.getAtividade(Integer.valueOf(at[i]));
                                    if (a.getIsHard() == true)
                                        view.msg("Nao pode ter  Hard , Atividade excluida");
                                    else
                                       att.add(a); 
                                
                                } catch (AtividadeNaoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            }
                            view.msg("Siga os restantes passos para criar a base do Plano de Treino :D");
                            view.msg("Nome,Iteracoes das Atividades,Calorias Previstas");
                            line= sc.nextLine();
                            all = line.split(",");
                            for( LocalDate d : datas_plano)
                            {
                                nome = all[0] + Integer.toString(incrementa);
                                incrementa += 1;
                                //agora os planos de treino tem calorias previstas e os dias a executar em string
                                plano_gerado = new PlanoTreino(nome,d,Integer.parseInt(all[1]),Double.parseDouble(all[2]),line2);
                                try {
                                    ap.inserePlanoTreino(plano_gerado);
                                } catch (PlanoTreinoExisteException e) {
                                    view.msg(e.getMessage());
                                }
                                for (Atividade a : att)
                                {
                                    try {
                                        ap.insereAtiviadeNoPlanoTreino(plano_gerado.getNomePlano(),a);
                                        view.printAtividadeAdicionada(a.toString2());
                                    } catch (AtividadeNaoExisteException | PlanoTreinoNaoExisteException e) {
                                        view.msg(e.getMessage());
                                    }
                                }   
                            }
                            break;
                    }
                    break;
                case 9:
                    try
                    {
                        uAtual = ap.getUtilizador(nick);
                        view.printHistoricoUtilizador(uAtual.getNick(), uAtual.getNome(),
                        uAtual.getTipoUtilizador(), uAtual.toStringHistorico());
                    }
                    catch (UtilizadorNaoExisteException e)
                    {
                        view.msg(e.getMessage());
                    }
                    break;
                case 10:
                    try
                    {
                        uAtual = ap.getUtilizador(nick);
                        //view.msg("planos" + uAtual.toStringPlanosTreinoU());
                        view.printPlanosTreinoUtilizador(uAtual.getNick(), uAtual.getNome(),
                        uAtual.getTipoUtilizador(), uAtual.toStringPlanosTreinoU());
    
                    }
                    catch (UtilizadorNaoExisteException e)
                    {
                        view.msg(e.getMessage());
                    }
                    break;
                case 11:
                    try
                    {
                        uAtual = ap.getUtilizador(nick);

                        view.printUtilizador(uAtual.getNick(), uAtual.getPassword(), uAtual.getNome(),
                        uAtual.getEmail(), uAtual.getGenero(),uAtual.getDataNascimento(),
                        uAtual.getAltura(), uAtual.getPeso(), uAtual.getFreqCardiaca(),
                        uAtual.getFatorMultiplicativo(),uAtual.caracteristicasUExtra(),
                        uAtual.getTotalCalorias());
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
        String[] s = { "Qual O Utilizador que mais calorias gastou (Sempre)","Qual O Utilizador que mais calorias gastou (Periodo)",
        "Qual O Utilizador que mais atividades realizou (Sempre)","Qual O Utilizador que mais atividades realizou (Periodo)",
        "Qual o tipo de Atividade mais realizada","Quantos kms totalizou um Utilizador (Sempre)",
        "Quantos kms totalizou um Utilizador (Periodo)","Quantos metros totalizou um Utilizador (Sempre)",
        "Quantos metros totalizou um Utilizador (Periodo)","Plano de Treino Mais Exigente em Calorias Propostas"};
        Menu menuVer = new Menu(s);
        int op = -1;
        Scanner sc = new Scanner(System.in);
        View view = new View();
        String line;
        Utilizador u = null;
        PlanoTreino p = null;
        String[] data;
        LocalDate inicio ;
        LocalDate fim ;
        while (op != 0) {
            menuVer.executa();
            op = menuVer.getOpcao();
            System.out.println(op);
            switch (op) {
                case 1:
                    u = ap.maisCaloriasDespendidasSempre();
                    view.printUtilizadorEstatisticaCal(u.getNome());
                    break;
                case 2:
                    view.msg("Qual é a data de inicio ? (ano-mes-dia)");
                    line= sc.nextLine();  
                    data = line.split("-");
                    inicio = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.msg("Qual é a data de fim ? (ano-mes-dia)");
                    line= sc.nextLine();
                    fim = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    u = ap.maisCaloriasDespendidasPeriodo(inicio, fim);
                    view.printUtilizadorEstatisticaCal(u.getNick());
                    break;
                case 3:
                    u = ap.maisAtividadesSempre();
                    view.printUtilizadorEstatisticaCal(u.getNome());
                    break;
                case 4:
                    view.msg("Qual é a data de inicio ? (ano-mes-dia)");
                    line= sc.nextLine();  
                    data = line.split("-");
                    inicio = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.msg("Qual é a data de fim ? (ano-mes-dia)");
                    line= sc.nextLine();
                    fim = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.printUtilizadorEstatisticaCal(u.getNick());
                    break;
                case 5:
                    line = ap.maisRealizada() + "\n";
                    view.printAtividades(line);
                    break;
                case 6:
                    view.msg("Insira o Nickname:");
                    line = sc.nextLine();
                    try {
                        u = ap.getUtilizador(line);
                        double km = ap.quantoKmsUtilizadorSempre(u);
                        view.printUtilizadorEstatisticaKM(u.getNick(), km);
                    } catch (UtilizadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    } 
                    break;
                case 7:
                    view.msg("Qual é a data de inicio ? (ano-mes-dia)");
                    line= sc.nextLine();  
                    data = line.split("-");
                    inicio = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.msg("Qual é a data de fim ? (ano-mes-dia)");
                    line= sc.nextLine();
                    fim = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.msg("Insira o Nickname:");
                    line = sc.nextLine();
                    try {
                        u = ap.getUtilizador(line);
                        double km = ap.quantoKmsUtilizadorPeriodo(u,inicio,fim);
                        view.printUtilizadorEstatisticaKM(u.getNick(), km);
                    } catch (UtilizadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    }
                    break;
                case 8:
                    view.msg("Insira o Nickname:");
                    line = sc.nextLine();
                    try {
                        u = ap.getUtilizador(line);
                        double alt = ap.quantoAltUtilizadorSempre(u);
                        view.printUtilizadorEstatisticaAL(u.getNick(), alt);
                    } catch (UtilizadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    } 
                    break;
                case 9:
                    view.msg("Qual é a data de inicio ? (ano-mes-dia)");
                    line= sc.nextLine();  
                    data = line.split("-");
                    inicio = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.msg("Qual é a data de fim ? (ano-mes-dia)");
                    line= sc.nextLine();
                    fim = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), 
                                        Integer.parseInt(data[2]));
                    view.msg("Insira o Nickname:");
                    line = sc.nextLine();
                    try {
                        u = ap.getUtilizador(line);
                        double alt = ap.quantoAltUtilizadorPeriodo(u,inicio,fim);
                        view.printUtilizadorEstatisticaAL(u.getNick(), alt);
                    } catch (UtilizadorNaoExisteException e) {
                        view.msg(e.getMessage());
                    }
                    break;
                case 10:
                    p = ap.qualMaisExigente();
                    view.printPlanosTreino(p.getNomePlano());
                    break;
                
            }

        }

    }
    
    public static void menuAdministrador(FitnessApp ap) {
        String[] s = { "Criar Atividade", "Criar Plano"};
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
                            view.msg("Codigo,Nome,Descricao,Distancia,Percurso,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Patinagem(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Double.parseDouble(all[3]),
                                                        all[4], null, 0, 0, Boolean.parseBoolean(all[5]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "remo":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Distancia,Percurso,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Remo(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Double.parseDouble(all[3]),
                                                        all[4], null, 0, 0, Boolean.parseBoolean(all[5]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "corrida":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Distancia,Altimetria,Percurso,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Corrida(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Double.parseDouble(all[3]),
                                                        Double.parseDouble(all[4]),all[5], null, 0, 0, Boolean.parseBoolean(all[6]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "bicicleta":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Distancia,Altimetria,Percurso,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Bicicleta(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Double.parseDouble(all[3]),
                                                        Double.parseDouble(all[4]),all[5], null, 0, 0, Boolean.parseBoolean(all[6]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "abdominais":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Repeticoes,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Abdominais(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Integer.parseInt(all[3]),
                                                        null, 0, 0, Boolean.parseBoolean(all[4]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "alongamentos":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Repeticoes,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Alongamentos(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Integer.parseInt(all[3]),
                                                        null, 0, 0, Boolean.parseBoolean(all[4]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "flexoes":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Repeticoes,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new Flexoes(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Integer.parseInt(all[3]),
                                                        null, 0, 0, Boolean.parseBoolean(all[4]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "levantapeso":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Repeticoes,Peso,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new LevantaPeso(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Integer.parseInt(all[3]),
                                                        Double.parseDouble(all[4]),null, 0, 0, Boolean.parseBoolean(all[5]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
                                    view.msg(e.getMessage());
                                }
                            break;
                        case "extensaopernas":
                            view.msg("Sigo os seguintes passos para criar :D");
                            view.msg("Codigo,Nome,Descricao,Repeticoes,Peso,Hard");
                            line = sc.nextLine();
                            all = line.split(",");
                            atividade_nova = new ExtensaoPernas(Integer.parseInt(all[0]),all[1],
                                                        all[2],0,Integer.parseInt(all[3]),
                                                        Double.parseDouble(all[4]),null, 0, 0, Boolean.parseBoolean(all[5]));
                            
                            try {
                                    ap.insereAtividade(atividade_nova);
                                    view.printAtividadeCriada(atividade_nova.getCodigo(),atividade_nova.getNome(),
                                    atividade_nova.getDescricao(),
                                    atividade_nova.caracteristicasExtra(), atividade_nova.getIsHard());

                                } catch (AtividadeExisteException e) {
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
                                          Integer.parseInt(data_execucao[2])), Integer.parseInt(all[2]), 0, "");
                    try {
                            ap.inserePlanoTreino(planoTreino_novo);
                            view.printPlanoTreinoCriado(planoTreino_novo.getNomePlano(), 
                        planoTreino_novo.getData(),planoTreino_novo.getIteracoes());
                        } catch (PlanoTreinoExisteException e) {
                            view.msg(e.getMessage());
                        }
                    view.msg("Lista Atividades: ");
                    view.printAtividades(ap.toStringAtividades());
                    view.msg("Que atividades quer no Novo Plano ?:D");
                    view.msg("Codigo da Atividade1,Codigo da Atividade2...");
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
                    view.msg("Para que dia quer viajar:D (ano-mes-dia) ");
                    line = sc.nextLine();
                    String[] data = line.split("-");
                    LocalDate dia = LocalDate.of(Integer.parseInt(data[0]),
                                    Integer.parseInt(data[1]), 
                                    Integer.parseInt(data[2]));
                    ap.viajarNoTempo(dia);
                    view.msg("Viagem Completa para o dia" + line);
                    break;
                
            }

        }
    }
    
    //!
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
