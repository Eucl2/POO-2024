/**
 * Exception triggered when PlanoTreino doesn't exist
 */

public class UtilizadorExisteException extends Exception 
{
    public UtilizadorExisteException()
    {
        super();
    }

    public UtilizadorExisteException(String s)
    {
        super(s);
    }
}
