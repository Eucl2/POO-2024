import java.time.LocalDate;

public class View {
    public void msg(String msg) {
        System.out.println("=>" + msg);
    }

    public void printCriacaoUtilizador(String nick, String password, String nome, String email, String genero,
                LocalDate data_nascimento, double altura, double peso, int frequencia_cardiaca_media,
                double fator_mult,String extraU, double calorias) {
        System.out.println("-------------Utilizador Criado--------------- ");
        System.out.println("Nickname: " + nick);
        System.out.println("Password: " + password);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Genero: " + genero);
        System.out.println("Data de Nascimento: " + data_nascimento);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Frequencia Cardiaca Media: " + frequencia_cardiaca_media);
        System.out.println("Fator Multiplicativo: " + fator_mult);
        System.out.println(extraU);
        System.out.println("Total de Calorias Gastas: " + calorias);
        
        

    }
    
    public void printUtilizador(String nick, String password, String nome, String email, String genero,
                LocalDate data_nascimento, double altura, double peso, int frequencia_cardiaca_media,
                double fator_mult,String extraU, double calorias) {
        System.out.println("-------------Utilizador--------------- ");
        System.out.println("Nickname: " + nick);
        System.out.println("Password: " + password);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Genero: " + genero);
        System.out.println("Data de Nascimento: " + data_nascimento);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Frequencia Cardiaca Media: " + frequencia_cardiaca_media);
        System.out.println("Fator Multiplicativo: " + fator_mult);
        System.out.println(extraU);
        System.out.println("Total de Calorias Gastas: " + calorias);
        
        

    }
    
    public void printHistoricoUtilizador(String nick, String nome,
                String atleta, String historico) {
        System.out.println("-------------Utilizador--------------- ");
        System.out.println("NickName: " + nick);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de Atleta: " + atleta);
        System.out.println("-------------Atividades Realizadas--------------- ");
        System.out.println(historico);
        
    }
    
    public void printPlanosTreinoUtilizador(String nick, String nome,
                String atleta, String planos) {
        System.out.println("-------------Utilizador--------------- ");
        System.out.println("NickName: " + nick);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de Atleta: " + atleta);
        System.out.println("Planos de Treino Escolhidos: " + planos);
        
    }
    
    public void printUtilizadores(String utilizadores) {
        System.out.println("------------Utilizadores----------- " + utilizadores);

    }
    
    public void printUtilizadorEstatisticaKM(String nick, double valor) {
        System.out.println("------------Utilizadores----------- ");
        System.out.println("NickName: " + nick);
        System.out.println("Total de Kms: " + valor);

    }
    
    public void printUtilizadorEstatisticaAL(String nick, double valor) {
        System.out.println("------------Utilizadores----------- ");
        System.out.println("NickName: " + nick);
        System.out.println("Altimetria : " + valor);

    }
    
    public void printUtilizadorEstatisticaCal(String nick) {
        System.out.println("------------Utilizadores----------- ");
        System.out.println("NickName: " + nick);

    }

    public void printAtividade(int codigo, String nome, String descricao,
                int duracao, String extra, int freq_at, double cal,
                boolean hard, LocalDate data_realizada) {
        System.out.println("-----------Atividade----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println(extra);
        System.out.println("Atividade Hard: " + hard);
        //retirar daqui , apenas para debug
        System.out.println("Frequencia Cardiaca Ativiade: " + freq_at);
        System.out.println("Calorias Gastas: " + cal);
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeCriada(int codigo, String nome, String descricao,
                int duracao, String extra, boolean hard, LocalDate data_realizada) {
        System.out.println("-----------Atividade Adicionada----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println(extra);
        System.out.println("Atividade Hard: " + hard);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividades(String atividades) {
        System.out.println("------------Atividades----------- " + atividades);

    }
    
    public void printAtividadeAdicionada(String atividade) {
        System.out.println("A atividade " + atividade + " " + "foi adicionada ao plano");

    }
    
    public void printPlanoTreino(String nome, LocalDate data_executar, 
                int iteracoes, String atividades) {
        System.out.println("-----------PlanoTreino----------- ");
        System.out.println("Nome: " + nome);
        System.out.println("Data a Executar: " + data_executar);
        System.out.println("Iteracoes: " + iteracoes);
        System.out.println("Atividades: " + atividades);

    }
    
    public void printPlanoTreinoCriado(String nome, LocalDate data_executar, 
                int iteracoes) {
        System.out.println("-----------PlanoTreino Criado----------- ");
        System.out.println("Nome: " + nome);
        System.out.println("Data a Executar: " + data_executar);
        System.out.println("Iteracoes: " + iteracoes);

    }
    
    public void printPlanosTreino(String planos_treino) {
        System.out.println("------------PlanosTreino----------- " + planos_treino);

    }
    
    public void printAtividadeRealizada(String utilizador, LocalDate data, 
                int id_atividade, String atividade) {
        System.out.println("-----------Registo de Atividade----------- ");
        System.out.println(utilizador +" " + "realizou atividade" + " " + id_atividade + "-" + atividade + " " + "no dia " + " " + data);

    }
    
    public void printPlanoTreinoEscolhido(String utilizador, String planoTreino) {
        System.out.println("-----------Escolha de Plano----------- ");
        System.out.println(utilizador + " " + "escolheu o plano" + " " + planoTreino);

    }
    


}
