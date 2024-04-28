/**
 * Exception triggered when PlanoTreino doesn't exist
 */

public class UtilizadorNaoExisteException extends Exception 
{
    public UtilizadorNaoExisteException()
    {
        super();
    }

    public UtilizadorNaoExisteException(String s)
    {
        super(s);
    }
}
