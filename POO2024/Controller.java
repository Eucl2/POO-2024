import java.util.*;
import java.io.IOException;

public class Controller 
{

    public static void run() throws IOException, ClassNotFoundException 
    {

        
        String[] s = { "Criacao", "Pesquisa", "Editar", "Carregar Ficheiro", "Save", "Load" };
        Menu menu = new Menu(s);
        menu.menuInicial();


        

    }
}
