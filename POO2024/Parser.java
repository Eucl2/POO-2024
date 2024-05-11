
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
    private Map<String, Utilizador> utilizadores;
    private Map<Integer, Atividade> atividades;
    private Map<String, PlanoTreino> planostreino;

    public void parse() throws LinhaIncorretaException 
    {
        List<String> linhas = lerFicheiro("output.txt");
        this.utilizadores = new HashMap<>();
        this.atividades = new HashMap<>();
        this.planostreino = new HashMap<>();
        PlanoTreino novoplano = null;
        Atividade a = null;
        Utilizador u = null;
        String[] linhaPartida;
        for (String linha : linhas) 
        {
            linhaPartida = linha.split(":", 2);
            switch (linhaPartida[0]) 
            {
                case "Amador":
                    u = Amador.parse(linhaPartida[1]);
                    if(this.utilizadores.containsKey(u.getNick()))
                    {
                        throw new LinhaIncorretaException();
                    }
                    else
                    {
                        utilizadores.put(u.getNick(), u);
                    }
                    break;
                case "Profissional":
                    u = Profissional.parse(linhaPartida[1]);
                    if(this.utilizadores.containsKey(u.getNick()))
                    {
                        throw new LinhaIncorretaException();
                    }
                    else
                    {
                        utilizadores.put(u.getNick(), u);
                    }
                    break;
                case "Ocasional":
                    u = Ocasional.parse(linhaPartida[1]);
                    if(this.utilizadores.containsKey(u.getNick()))
                    {
                        throw new LinhaIncorretaException();
                    }
                    else
                    {
                        utilizadores.put(u.getNick(), u);
                    }
                    break;
                case "Corrida":
                    a = Corrida.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "Patinagem":
                    a = Patinagem.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "Remo":
                    a = Remo.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "Bicicleta":
                    a = Bicicleta.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "Abdominais":
                    a = Abdominais.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "Alongamentos":
                    a = Alongamentos.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "LevantaPeso":
                    a = LevantaPeso.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "ExtensaoPernas":
                    a = ExtensaoPernas.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                case "Flexoes":
                    a = Flexoes.parse(linhaPartida[1]);
                    if (this.atividades.containsKey(a.getCodigo()))
                    {
                        if(novoplano == null)
                        {
                            throw new LinhaIncorretaException();
                        }
                        novoplano.insereAtividade(a.clone());
                    }
                    else
                    {
                        atividades.put(a.getCodigo(), a);  
                    }   
                    break;
                 case "PlanoTreino":
                    PlanoTreino pt = PlanoTreino.parse(linhaPartida[1]);
                    planostreino.put(pt.getNomePlano(), pt);
                    novoplano = pt;
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
        return this.planostreino.values().stream().collect(Collectors.toMap(pt -> pt.getNomePlano(), pt -> pt.clone()));
    }
    
}
