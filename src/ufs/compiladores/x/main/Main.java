package ufs.compiladores.x.main;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import ufs.compiladores.x.helper.Helper;
import ufs.compiladores.x.lexer.Lexer;

public class Main 
{
	
	public static void main(String[] args) throws IOException 
	{
		if (args.length > 0)
		{
			Lexer lexer = new Lexer(new PushbackReader(new FileReader(args[0])));
			Helper.buscarTokens(lexer);
		} else {
			System.out.println("Nenhum arquivo para leitura.");
		}
	}
}