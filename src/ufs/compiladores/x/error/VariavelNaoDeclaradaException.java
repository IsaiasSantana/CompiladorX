package ufs.compiladores.x.error;

/**
 * Lan�a essa exce��o caso a vari�vel n�o esteja declarada.
 * @author Isa�asSantana
 * @since 17/09/2016 21:39
 * @version 0.1
 */
public class VariavelNaoDeclaradaException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param msg mensagem informando o errro.
	 */
	public VariavelNaoDeclaradaException(String msg)
	{
		super(msg);
	}	
}