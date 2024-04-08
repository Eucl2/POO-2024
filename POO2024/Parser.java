
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser 
{

    private Map<String, Atividade> atividades;
    private Map<String, Utilizador> utilizadores;
    private List<PlanoTreino> plano_de_treino;

    public void parse() throws LinhaIncorretaException 
    {
        List<String> linhas = lerFicheiro("output.txt");
        this.atividades = new HashMap<>(); // 
        this.utilizadores = new HashMap<>();//email,utilizador
        this.plano_de_treino = new ArrayList<>();
        Distancia d=null;
        Repeticao r =null;
        RepeticaoPeso rp =null;
        DistanciaAltimetria t=null;
        Utilizador user=null;
        String[] linhaPartida;
        for (String linha : linhas) 
        {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) 
            {
                case "Utilizador":
                    Utilizador u = Utilizador.parse(linhaPartida[1]);
                    utilizadores.put(u.getEmailUtilizador(), u);
                    user=u;
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }

    }

    public static List<String> lerFicheiro(String nomeFich) 
    {
        List<String> lines;
        try 
        {
            lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8);
        } 
        catch (IOException exc) 
        {
            lines = new ArrayList<>();
        }
        return lines;
    }

}
