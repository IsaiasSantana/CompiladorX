package ufs.compiladores.x.helper;

import java.util.Hashtable;

import ufs.compiladores.x.analysis.DepthFirstAdapter;
import ufs.compiladores.x.error.VariavelDeclaradaException;
import ufs.compiladores.x.node.ADecVariavelUnicoPrograma;
import ufs.compiladores.x.node.AIdOpcaoVar;
import ufs.compiladores.x.node.PDecVar;
import ufs.compiladores.x.node.TId;

/**
 * @since 15/09/16
 * @author IsaíasSantana
 * @version 0.1
 */
public class AnalisadorSemantico extends DepthFirstAdapter
{
	private Hashtable<String, String> tabelaDeSimbolos = new Hashtable<>();
	
	@Override
	public void  outAIdOpcaoVar(AIdOpcaoVar node)
	{
		 TId identificador =  node.getId();
		 String key = identificador.getText();
		
		 
		 if(tabelaDeSimbolos.containsKey(key))
		 {
			 try {
				throw new VariavelDeclaradaException("Variável '"+key+"' Já existe. Linha: "+identificador.getLine()+" Coluna: "+identificador.getPos());
			} catch (VariavelDeclaradaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else tabelaDeSimbolos.put(key,key);
	}
}
