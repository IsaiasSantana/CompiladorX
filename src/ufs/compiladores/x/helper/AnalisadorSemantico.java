package ufs.compiladores.x.helper;

import java.util.Hashtable;

import ufs.compiladores.x.analysis.DepthFirstAdapter;
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
		 System.out.println(key);
		 if(tabelaDeSimbolos.containsKey(key))
		 {
			 System.out.println("Variável "+key+" Já existe. Linha: "+identificador.getLine());
			 System.exit(0);
		 }else tabelaDeSimbolos.put(key,key);
	}
}
