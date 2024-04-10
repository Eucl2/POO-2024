/**
 * Exception triggered when activity doesn't exist
 */

public class AtividadeNaoExisteException extends Exception 
{
    public AtividadeNaoExisteException()
    {
        super();
    }

    public AtividadeNaoExisteException(String s)
    {
        super(s);
    }
}