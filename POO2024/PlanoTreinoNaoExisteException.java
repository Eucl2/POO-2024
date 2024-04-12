/**
 * Exception triggered when PlanoTreino doesn't exist
 */

public class PlanoTreinoNaoExisteException extends Exception 
{
    public PlanoTreinoNaoExisteException()
    {
        super();
    }

    public PlanoTreinoNaoExisteException(String s)
    {
        super(s);
    }
}