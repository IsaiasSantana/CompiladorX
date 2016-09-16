package ufs.compiladores.x.error;

/**
 * Lança uma exceção quando se declara uma outra variável com o mesmo nome.
 * @author Isaías
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
