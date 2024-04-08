 /**
 * Esta classe implementa um menu em modo texto.
 * 
 * @author JosÃ© Creissac Campos 
 * @version v2.1 (20170504)
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu 
{
    private List<String> opcoes;
    private int op;

    public Menu(String[] opcoes) 
    {
        this.opcoes = Arrays.asList(opcoes);
    }

    /**
     * para apresentar o menu e ler uma opcao
     */
    public void menuInicial()
    {
        showMenu();
        lerOpcao();

        switch(getOpcao()){
            case 0:
                System.out.println("Adeus!");
                break;
            case 1:
                System.out.println("passei aqui");
                this.menuCriacao();
                break;
        }
    }

    public void menuCriacao()
    {
        showCriacao();
        lerOpcao();
        int valor = getOpcao();

        switch(valor){
            case 0:
                this.menuInicial();
                break;
            case 1:
                this.menuuserCreation();
                break;
            case 2:
                this.menuactivityCreation();
                break;
            case 3:
                this.menuplanningCreation();
                break;
        }
    }
    public void menuuserCreation()
    {
        userCreation();
        lerOpcao();
        int valor = getOpcao();

        switch(valor){
            case 0:
                this.menuCriacao();
                break;
        }
    }

    public void menuactivityCreation()
    {
        activityCreation();
        lerOpcao();
        int valor = getOpcao();

        switch(valor){
            case 0:
                this.menuCriacao();
                break;
        }
    }

    public void menuplanningCreation()
    {
        planningCreation();
        lerOpcao();
        int valor = getOpcao();

        switch(valor){
            case 0:
                this.menuCriacao();
                break;
        }
    }

    /** Apresentar o menu */
    private void showMenu() 
    {
        System.out.println("\n *** Menu *** ");
        for (int i = 0; i < this.opcoes.size(); i++) {
            System.out.print(i + 1);
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        System.out.println("0 - Sair");
    }

    /**Criar Utilizadores, Atividades, Planos de treino */
    private void showCriacao()
    {
        System.out.println("\n *** Criacao ***");
        System.out.println("1 - Utilizador");
        System.out.println("2 - Atividades");
        System.out.println("3 - Planos de treino");
        System.out.println("0 - Voltar");
    }
    /** Ler uma opcao valida */

    private void userCreation()
    {
        System.out.println("\n *** Criacao Utilizador***");
        System.out.println("Insere o nome:");
        System.out.println("Sexo:");
        System.out.println("Morada:");
        System.out.println("Email");
        System.out.println("Frequencia Cardiaca Media");
        System.out.println("0 - Voltar");

    }

    private void activityCreation()
    {
        System.out.println("\n *** Criacao Atividade***");
        System.out.println("Tipo da atividade:");
        System.out.println("Nome da atividade:");
        System.out.println("Dificuldade:");
        System.out.println("0 - Voltar");
    }

    private void planningCreation()
    {
        System.out.println("\n *** Criacao Planos de Atividades***");
        System.out.println("Dia(s) da semana:");
        System.out.println("Caso não queira inserir plano ou  exercicios, na respetiva ordem escreva 1");
        System.out.println("Plano a seguir:");
        System.out.println("Caso não queira seguir um plano em concreto ou adicionar exercícios, especifique abaixo");
        System.out.println("Exercicio(s):");
        System.out.println("0 - Voltar");
    }
    private void lerOpcao()
    {
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("Opcao: ");
        try {
            op = is.nextInt();
        } catch (InputMismatchException e) { // nao e int
            op = -1;
        }
        if (op < 0 || op > this.opcoes.size()) {
            System.out.println("Opcao invalida");
            lerOpcao();
        }

        setOpcao(op);
    }

    public int getOpcao() 
    {
        return this.op;
    }

    public void setOpcao(int op){
        this.op = op;
    }
}
