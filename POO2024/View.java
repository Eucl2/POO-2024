import java.time.LocalDate;

public class View {
    public void msg(String msg) {
        System.out.println("=>" + msg);
    }

    public void printCriacaoUtilizador(int id, String password, String nome, String email, String genero,
                LocalDate data_nascimento, double altura, double peso, int frequencia_cardiaca_media,
                TipoAtleta atleta) {
        System.out.println("-------------Utilizador Criado--------------- ");
        System.out.println("Id: " + id);
        System.out.println("Password: " + password);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Genero: " + genero);
        System.out.println("Data de Nascimento: " + data_nascimento);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Frequencia Cardiaca Media: " + frequencia_cardiaca_media);
        System.out.println("Tipo de Atleta: " + atleta);
        

    }
    
    public void printUtilizador(int id, String password, String nome, String email, String genero,
                LocalDate data_nascimento, double altura, double peso, int frequencia_cardiaca_media,
                TipoAtleta atleta) {
        System.out.println("-------------Utilizador Criado--------------- ");
        System.out.println("Id: " + id);
        System.out.println("Password: " + password);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Genero: " + genero);
        System.out.println("Data de Nascimento: " + data_nascimento);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.println("Frequencia Cardiaca Media: " + frequencia_cardiaca_media);
        System.out.println("Tipo de Atleta: " + atleta);
        

    }
    
    public void printHistoricoUtilizador(int id, String nome,
                TipoAtleta atleta, String historico) {
        System.out.println("-------------Utilizador--------------- ");
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de Atleta: " + atleta);
        System.out.println("Historico de Atividades: " + historico);
        
    }
    
    public void printPlanosTreinoUtilizador(int id, String nome,
                TipoAtleta atleta, String planos_treino) {
        System.out.println("-------------Utilizador--------------- ");
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de Atleta: " + atleta);
        System.out.println("Planos de Treino Escolhidos: " + planos_treino);
        
    }
    
    public void printUtilizadores(String utilizadores) {
        System.out.println("------------Utilizadores----------- " + utilizadores);

    }

    public void printAtividade(int codigo, String nome, String descricao,
                int duracao, String extra, LocalDate data_realizada) {
        System.out.println("-----------Atividade----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println(extra);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeCriada(int codigo, String nome, String descricao,
                int duracao, String extra, LocalDate data_realizada) {
        System.out.println("-----------Atividade Adicionada----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println(extra);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeRemo(int codigo, String nome, String descricao,
                int duracao, double distancia, String percurso, LocalDate data_realizada) {
        System.out.println("-----------Remo----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Distancia: " + distancia);
        System.out.println("Percurso: " + percurso);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeCorrida(int codigo, String nome, String descricao,
                int duracao, double distancia, double altimetria, String percurso, LocalDate data_realizada) {
        System.out.println("-----------Corrida----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Distancia: " + distancia);
        System.out.println("Altimetria: " + altimetria);
        System.out.println("Percurso: " + percurso);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeBicicleta(int codigo, String nome, String descricao,
                int duracao, double distancia, double altimetria, String percurso, LocalDate data_realizada) {
        System.out.println("-----------Bicicleta----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Distancia: " + distancia);
        System.out.println("Altimetria: " + altimetria);
        System.out.println("Percurso: " + percurso);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeAbdominais(int codigo, String nome, String descricao,
                int duracao, int repeticoes, LocalDate data_realizada) {
        System.out.println("-----------Abdominais----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Repeticao: " + repeticoes);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeAlongamentos(int codigo, String nome, String descricao,
                int duracao, int repeticoes, LocalDate data_realizada) {
        System.out.println("-----------Alongamentos----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Repeticao: " + repeticoes);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeFlexoes(int codigo, String nome, String descricao,
                int duracao, int repeticoes, LocalDate data_realizada) {
        System.out.println("-----------Flexoes----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Repeticao: " + repeticoes);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeLevantamentoPeso(int codigo, String nome, String descricao,
                int duracao, int repeticoes, double peso, LocalDate data_realizada) {
        System.out.println("-----------LevantamentoPeso----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Repeticao: " + repeticoes);
        System.out.println("Peso: " + peso);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividadeExtensaoPernas(int codigo, String nome, String descricao,
                int duracao, int repeticoes, double peso, LocalDate data_realizada) {
        System.out.println("-----------LevantamentoPeso----------- ");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descricao: " + descricao);
        System.out.println("Duracao: " + duracao);
        System.out.println("Repeticao: " + repeticoes);
        System.out.println("Peso: " + peso);
        //retirar daqui , apenas para debug
        System.out.println("Data a Realizar: " + data_realizada);
    }
    
    public void printAtividades(String atividades) {
        System.out.println("------------Atividades----------- " + atividades);

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
                int iteracoes, String atividades) {
        System.out.println("-----------PlanoTreino Criado----------- ");
        System.out.println("Nome: " + nome);
        System.out.println("Data a Executar: " + data_executar);
        System.out.println("Iteracoes: " + iteracoes);
        System.out.println("Atividades: " + atividades);

    }
    
    public void printPlanosTreino(String planos_treino) {
        System.out.println("------------PlanosTreino----------- " + planos_treino);

    }
    
    public void printAtividadeRealizada(String utilizador, LocalDate data, 
                int id_atividade, String atividade) {
        System.out.println("-----------Registo de Atividade----------- ");
        System.out.println(utilizador + "realizou atividade" + atividade + id_atividade + "no dia " + data);

    }
    
    public void printPlanoTreinoEscolhido(String utilizador, String planoTreino) {
        System.out.println("-----------Escolha de Plano----------- ");
        System.out.println(utilizador + "escolheu o plano" + planoTreino);

    }
    


}
