package ufs.compiladores.x.error;

/**
 * Lan�a uma exce��o quando se declara uma outra vari�vel com o mesmo nome.
 * @author Isa�as
 * @since 16/09/2016 00:32
 * @version 0.1
 */
public class VariavelDeclaradaException extends Exception
{
	public VariavelDeclaradaException(String mensagem) {
		super(mensagem);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
