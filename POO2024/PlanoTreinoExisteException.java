/**
 * Exception triggered when PlanoTreino doesn't exist
 */

public class PlanoTreinoExisteException extends Exception 
{
    public PlanoTreinoExisteException()
    {
        super();
    }

    public PlanoTreinoExisteException(String s)
    {
        super(s);
    }
}
