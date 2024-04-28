
public class View {
    public void msg(String msg) {
        System.out.println("=>" + msg);
    }

    public void printUtilizador(String nomeJ, String posi, int numeroJ, int vel, int res, int des, int imp, int cab,
            int rem, int p, String extra, Double med, String his) {
        System.out.println("-------------Utilizador--------------- ");
        System.out.println("Name: " + nomeJ);
        System.out.println("Posicao: " + posi);
        System.out.println("Numero: " + numeroJ);
        System.out.println("Velocidade: " + vel);
        System.out.println("Resistencia: " + res);
        System.out.println("Destreza: " + des);
        System.out.println("Impulsao: " + imp);
        System.out.println("cabeca: " + cab);
        System.out.println("Remate: " + rem);
        System.out.println("Passe: " + p);
        System.out.println(extra);
        System.out.println("Media: " + med);
        System.out.println("Historico: " + his);

    }

    public void printAtividade(String nome, double media, String jogadores) {
        System.out.println("-----------Equipa----------- ");
        System.out.println("Name: " + nome);
        System.out.println("Media: " + media);
        System.out.println("Jogadores: " + jogadores);

    }
    
    public void printPlanosTreino(String nome, double media, String jogadores) {
        System.out.println("-----------Equipa----------- ");
        System.out.println("Name: " + nome);
        System.out.println("Media: " + media);
        System.out.println("Jogadores: " + jogadores);

    }

    public void printEquipas(String equipas) {
        System.out.println("------------Equipas----------- " + equipas);

    }

    public void printMedia(double media) {
        System.out.println("Media: " + media);
    }

    public void printTransferencia(String jogador, String e1, String e2, int n1, int n2) {
        System.out.println("-----------Transferencia---------- ");
        System.out.println("Jogador: " + jogador);
        System.out.println(e1 + " -----------> " + e2);
        System.out.println("Numero:" + n1 + " -----------> " + n2);

    }

    public void printRemocaoJogador(String jogador, String equipa) {
        System.out.println("-----------Remocao de Jogador ---------- ");
        System.out.println(jogador + " foi cancelado da equipa: " + equipa);
    }

    public void printRemocaoEquipa(String equipa) {
        System.out.println("-----------Remocao de Equipa---------- ");
        System.out.println(equipa + " foi cancelada");
    }

    public void printCriacaoEquipa(String equipa) {
        System.out.println("-----------Equipa Criada---------- ");
        System.out.println(equipa + " foi criada");

    }
    
    public void printCriacaoUtilizador(int id) {
        System.out.println("-----------Utilizador Criado---------- ");
        System.out.println(id + " foi criado");

    }

}
