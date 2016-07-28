package ufs.compiladores.x.helper;

import ufs.compiladores.x.lexer.Lexer;
import ufs.compiladores.x.lexer.LexerException;
import ufs.compiladores.x.node.EOF;
import ufs.compiladores.x.node.Token;

/**
 * Classe que contém os métodos para exbir os tokens, arvore abstrata, etc. 
 * @author Isaías Santana.
 *
 */
public final class Helper 
{
	private static int contaLinha = 0;
	

	private static void imprimeToken(Token token, int linha)
	{
		if(!token.getClass().getSimpleName().equals("TEspaco"))
				System.out.println("Linha "+linha+" -> Tipo do token: "+token.getClass().getSimpleName()+" lexema: "+token.getText());
		else ;
	}
	
	/**
	 * Varre todos os tokens e os exibe.
	 * @param lexer o objeto criado pelo SableCC para nos retornar os tokens.
	 */
	public static void buscarTokens(Lexer lexer) 
	{
		Token token = null;
		
		try
		{
			token = lexer.next();
			contaLinha = token instanceof EOF ? 0 : token.getLine();
			imprimeToken(token, contaLinha);
		
			while (!((token = lexer.next()) instanceof EOF)) 
			{
				//Imprime os tokens referente a linha atual.
				if(contaLinha > 0 && token.getLine() == contaLinha)
				{
					imprimeToken(token, contaLinha);
				}
				else // quebra de linha e imprime o primeiro token dessa linha.
				{
					System.out.println();

					contaLinha = token.getLine();
					imprimeToken(token, contaLinha);
				}
		
			}
		} catch(LexerException e) {
			System.out.print(e.getMessage().substring(0, e.getMessage().length()) + " ");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
