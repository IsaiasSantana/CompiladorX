package ufs.compiladores.x.main;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import ufs.compiladores.x.helper.ASTDisplay;
import ufs.compiladores.x.helper.ASTPrinter;
import ufs.compiladores.x.helper.Helper;
import ufs.compiladores.x.lexer.Lexer;
import ufs.compiladores.x.node.Start;
import ufs.compiladores.x.parser.Parser;

public class Main 
{
	
	public static void main(String[] args)
	 {
	  try
	  {
	  
	   Parser p =
	    new Parser(
	    new Lexer(
	    new PushbackReader(  
	    new FileReader(args[0]), 1024))); 
	   
	   Start tree = p.parse();

	   tree.apply(new ASTDisplay());
	  }
	  catch(Exception e)
	  {
	   System.out.println(e.getMessage()); //
	  }
	 }
	
	/*public static void main(String[] args) throws IOException 
	{
		if (args.length > 0)
		{
			boolean a = true;
			boolean b = !!!!!!!!!!!!!!!!!a;
			Lexer lexer = new Lexer(new PushbackReader(new FileReader(args[0])));
			Helper.buscarTokens(lexer);
		} else {
			System.out.println("Nenhum arquivo para leitura.");
		}
	}*/
}