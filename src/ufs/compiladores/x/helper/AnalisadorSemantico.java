package ufs.compiladores.x.helper;

import java.util.ArrayList;
import java.util.Hashtable;

import ufs.compiladores.x.analysis.DepthFirstAdapter;
import ufs.compiladores.x.error.VariavelDeclaradaException;
import ufs.compiladores.x.error.VariavelNaoDeclaradaException;
import ufs.compiladores.x.error.VariavelNaoInicializadaException;
import ufs.compiladores.x.node.AAtriExpIniInicializacao;
import ufs.compiladores.x.node.AAtriIniArrayCompInicializacao;
import ufs.compiladores.x.node.AAtriIniArrayExtInicializacao;
import ufs.compiladores.x.node.ABoolTipoBase;
import ufs.compiladores.x.node.AComandoVarRecVariavel;
import ufs.compiladores.x.node.AContOpcaoVar;
import ufs.compiladores.x.node.ADecVar;
import ufs.compiladores.x.node.ADecVariavelUnicoPrograma;
import ufs.compiladores.x.node.AExpNumeroInteiroExp;
import ufs.compiladores.x.node.AFalseExp;
import ufs.compiladores.x.node.AIdOpcaoVar;
import ufs.compiladores.x.node.AIdVariavelVariavel;
import ufs.compiladores.x.node.AInicializacaoOpcaoVar;
import ufs.compiladores.x.node.AIntTipoBase;
import ufs.compiladores.x.node.ANumeroRealExp;
import ufs.compiladores.x.node.AOperacaoAndExp;
import ufs.compiladores.x.node.AOperacaoDivisaoExp;
import ufs.compiladores.x.node.AOperacaoIgualExp;
import ufs.compiladores.x.node.AOperacaoMenorExp;
import ufs.compiladores.x.node.AOperacaoMenosUnariaExp;
import ufs.compiladores.x.node.AOperacaoModuloExp;
import ufs.compiladores.x.node.AOperacaoMultiplicacaoExp;
import ufs.compiladores.x.node.AOperacaoNegExp;
import ufs.compiladores.x.node.AOperacaoOrExp;
import ufs.compiladores.x.node.AOperacaoSomaExp;
import ufs.compiladores.x.node.AOperacaoSubtracaoExp;
import ufs.compiladores.x.node.ARealTipoBase;
import ufs.compiladores.x.node.ATipoBaseTipo;
import ufs.compiladores.x.node.ATipoCompostoTipo;
import ufs.compiladores.x.node.ATrueExp;
import ufs.compiladores.x.node.AVariavelExp;
import ufs.compiladores.x.node.PContOpcaoVar;
import ufs.compiladores.x.node.PDecVar;
import ufs.compiladores.x.node.PExp;
import ufs.compiladores.x.node.POpcaoVar;
import ufs.compiladores.x.node.PTipoBase;

/**
 * @since 15/09/16
 * @author Isa�asSantana
 * @version 0.4.1
 */
public class AnalisadorSemantico extends DepthFirstAdapter
{
	/*
	 * O restante � com voc�s. 
	 * * Implementar a parte real e inteira no m�todo analisarVariaveis para o escopo global.
	 * * implementar o escopo de declara��o de constantes para o escopo global, provavelmente. Se implementado de forma gen�rica aplica-se nos
	 *   escopos de procedimentos e fun��es.
	 * * Logo ap�s, implementar o escopo de declara��o de procedimentos.
	 *  * Feito o de procedimento, implementar o escopo de declara��o de fun��es.
	 *  * Depois ser feliz (: .
	 */
	
	private Hashtable<String, ArrayList<RegistroVariaveis>> tabelaDeSimbolos = new Hashtable<>();
	
	/**
	 * Verifica todas as variaveis no escopo global.
	 */
	public void outADecVariavelUnicoPrograma(ADecVariavelUnicoPrograma node)
	{
		casoBaseDeclaracaoVariavel(node,node.getDecVar());
		casoInterativoDeclaracaoVariavel(node);
	}
	
	/**
	 * M�todo que recupera uma �nica declara��o de vari�vel.
	 * @param node O n� da produ��o dec_variavel_unico de programa.
	 * @param decVar a produ��o dec_var recuperada do n�.
	 */
	private void casoBaseDeclaracaoVariavel(ADecVariavelUnicoPrograma node, PDecVar decVar)
	{
		ADecVar decVariavel = (ADecVar) decVar;	
		analisarVariaveis(decVariavel.getOpcaoVar(),node);
	}
	
	/*
	 * Mais de uma vari�vel. 
	 */
	private void casoInterativoDeclaracaoVariavel(ADecVariavelUnicoPrograma node)
	{
		ADecVar decVariavel = (ADecVar) node.getDecVar();
		int tipoVariavel = getTipoVariavel(node);
		for(PContOpcaoVar prodContOpcaoVar : decVariavel.getContOpcaoVar())
		{
			AContOpcaoVar variaveis = (AContOpcaoVar) prodContOpcaoVar;
			analisarVariaveis(variaveis.getOpcaoVar(),node);
			System.out.println("Tipo vari�vel: "+tipoVariavel);
		}
	}
	
	/**
	 * Verifica o escopo no qual o identificador pertence.
	 * @param identificador o identifiador.
	 * @param escopo o escopo a se verificar. Vide a classe Constantes.java
	 * @return true caso case o escopo, false caso contr�rio.
	 */
	private boolean verificarEscopo(String identificador, int escopo)
	{
		if(isTabelaSimbolosContemIdentificador(identificador))
		{
			for(RegistroVariaveis  interator : getRegistrosVariaveis(identificador))
			{
				if(interator.getEscopo() == escopo)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	private void alerta(int linha, int coluna, String id)
	{
		try{
			throw new VariavelDeclaradaException("Erro na linha: "+linha+", coluna: "+coluna+". Vari�vel: "+id+" j� declarada.");
		}catch(VariavelDeclaradaException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifica se o identiificador id, ja foi declarado no escopo global.
	 * @param id o identificador a ser verificado
	 * @param linha a linha onde se encontra o identificador.
	 * @param coluna a coluna onde se encontra o identificador.
	 * @param node o n� pai.
	 * @param inicializada se o idenficador for uma vari�vel, verifica se foi inicializada.
	 */
	private void verificarEscopoGlobal(String id, int linha, int coluna, ADecVariavelUnicoPrograma node,boolean inicializada)
	{
		if(verificarEscopo(id,Constantes.VARIAVEL_ESCOPO_GLOBAL)) alerta(linha, coluna,id);
		else insertTable(id, new RegistroVariaveis(getTipoVariavel(node), Constantes.VARIAVEL_ESCOPO_GLOBAL,inicializada,id));
	}
	
	private void verificarEscopoGlobal(String id, int linha, int coluna, ADecVariavelUnicoPrograma node, RegistroVariaveis rv)
	{
		if(verificarEscopo(id,Constantes.VARIAVEL_ESCOPO_GLOBAL)) alerta(linha, coluna,id);
		else insertTable(id, rv);
	}
	
	private void insertTable(String key, RegistroVariaveis regV)
	{
		if(isTabelaSimbolosContemIdentificador(key))
		{
			ArrayList<RegistroVariaveis> array = tabelaDeSimbolos.get(key);
			array.add(regV);
			tabelaDeSimbolos.put(key, array);
		}
		else
		{
			ArrayList<RegistroVariaveis> array = new ArrayList<>();
			array.add(regV);
			tabelaDeSimbolos.put(key, array);
		}
	}
	
	/*
	 * M�todo auxiliar para outADecVariavelUnicoPrograma.
	 */
	private void analisarVariaveis(POpcaoVar variavel,ADecVariavelUnicoPrograma node)
	{
		try
		{
			
			AIdOpcaoVar identificador = (AIdOpcaoVar) variavel;
			int linha = identificador.getId().getLine();
			int coluna = identificador.getId().getPos();
			String id = identificador.getId().getText();
			
			verificarEscopoGlobal(id, linha, coluna, node,false);
			
		}
		/* 
		 * Este bloco catch eh um bloco com n�s de atribui��o (Vide a producao de inicializacao). Mas como est� no contexto de 
		 * outADecVariavelUnicoPrograma, ou seja, na declara��o de vari�veis em escopo global. Dessa maneira apenas verifica-se
		 * se as vari�veis nesse ponto j� foram declaradas, se sim, lan�a uma exce��o, caso contr�rio adiciona a vari�vel na tabela de simbolos
		 * com suas informa��es relevantes. O que deve ser feito ap�s este passo � verificar se as atribui��es nessas vari�veis s�o v�lidas.
		 *
		 **/
		catch(Exception e)
		{
			AInicializacaoOpcaoVar identificador = (AInicializacaoOpcaoVar) variavel; // Ver a produ��o inicializacao no arquivo .sable.
			
			try
			{
				// N� de atribuicao de variavel por inicializacao, primeiro tipo.
				
				AAtriExpIniInicializacao aAEII = (AAtriExpIniInicializacao) identificador.getInicializacao();
				int linha = aAEII.getId().getLine();
				int coluna = aAEII.getId().getPos();
				String id = aAEII.getId().getText();
				PExp pExp = aAEII.getExp();
				
				if(getTipoVariavel(node) == Constantes.BOOL)
				{
						escolheOpcoesParaTipoBool(pExp,id,linha,coluna,node); // 40% pronto
				}
				
				if(getTipoVariavel(node) == Constantes.REAL)
				{
					//Todo
					//Implementar a parte real.
					escolheOpcoesParaTipoReal(pExp, id, linha, coluna, node);
				}
				
				if(getTipoVariavel(node) == Constantes.INT)
				{
					//Todo
					//Implementar a parte inteira.
					escolheOpcoesParaTipoInt(pExp, id, linha, coluna, node);
				}
			}
			catch(Exception ee)
			{
				try
				{
					// N� de atribuicao de variavel por inicializacao, segundo tipo.
					
					AAtriIniArrayExtInicializacao altArrayExt = (AAtriIniArrayExtInicializacao) identificador.getInicializacao();
				/*	int linha = altArrayExt.getId().getLine();
					int coluna = altArrayExt.getId().getPos();
					String id = altArrayExt.getId().getText(); */
					
				//	verificarEscopoGlobal(id, linha, coluna, node);
					
				    // Verificar se as atribui��es s�o v�lidas.
					//.......
					
				}
				catch(Exception eee)
				{
					// N� de atribuicao de variavel por inicializacao, terceiro tipo.
					
					AAtriIniArrayCompInicializacao altArrayComp = (AAtriIniArrayCompInicializacao) identificador.getInicializacao();
				/*	altArrayComp.getId().getText();
					
					int linha = altArrayComp.getId().getLine();
					int coluna = altArrayComp.getId().getPos();
					String id = altArrayComp.getId().getText(); */
					
				//	verificarEscopoGlobal(id, linha, coluna, node);

				    // Verificar se as atribui��es s�o v�lidas.
					//.......
				}
			}

		}
	}

	private void escolheOpcoesParaTipoInt(PExp pExp,String id, int linha, int coluna, ADecVariavelUnicoPrograma node )
	{
		try{
			AExpNumeroInteiroExp numInt = (AExpNumeroInteiroExp) pExp;
			verificarEscopoGlobal(id, linha, coluna, node,new RegistroVariaveis(getTipoVariavel(node), Constantes.VARIAVEL_ESCOPO_GLOBAL,true,numInt.getNumeroInteiro().getText()));
		}
		catch(Exception e){
			try {
				throw new Exception("Lado direito inv�lido para a vari�vel inteira.");
			} catch (Exception e1) {
				try{
					ANumeroRealExp numReal = (ANumeroRealExp) pExp;
					
					System.out.println("Aviso, a vari�vel '"+id+"' � do tipo int. Mas o valor � direita � do tipo real, um cast ser� realizado. Linha da ocorr�ncia: "+linha);
				}
				catch(Exception e2){
					try {
						// testarOperacoes(.....);
						// A partir daqui vai aparecer os nos de soma, subtracao....Criem um m�todo generico que ser� util para ambos
						// escolheOpcoesParaTipoReal e escolheOpcoesParaTipoInt para realizar esse processamento.
						// Deem uma olhada nos metodos verificaLadosOperacaoMatematica e verificaExpressoesMatematicas ser� bastante util.
						
						AOperacaoSomaExp operacaoSomaExp = (AOperacaoSomaExp) pExp;
						verificaLadosOperacaoMatematica(operacaoSomaExp, Constantes.INT, Constantes.VARIAVEL_ESCOPO_GLOBAL);
						verificarEscopoGlobal(id, linha, coluna, node, true);
						
						//throw new Exception("Lado direito inv�lido para a vari�vel inteira."); // remover apos implementar o metodo acima.
					} catch (Exception e3) {
						try{
							AOperacaoSubtracaoExp operacaoSubtracaoExp = (AOperacaoSubtracaoExp) pExp;
							verificaLadosOperacaoMatematica(operacaoSubtracaoExp, Constantes.INT, Constantes.VARIAVEL_ESCOPO_GLOBAL);
							verificarEscopoGlobal(id, linha, coluna, node, true);
						}catch(Exception e4){
						
						try{
							AOperacaoMultiplicacaoExp operacaoMultiplicacaoExp = (AOperacaoMultiplicacaoExp) pExp;
							verificaLadosOperacaoMatematica(operacaoMultiplicacaoExp, Constantes.INT, Constantes.VARIAVEL_ESCOPO_GLOBAL);
							verificarEscopoGlobal(id, linha, coluna, node, true);
							//Desmarcar apos implementar tudo.
							//throw new Exception("Lado direito inv�lido para a vari�vel do tipo int.");
						} catch (Exception e5){
							try{
								AOperacaoDivisaoExp operacaoDivisaoExp = (AOperacaoDivisaoExp) pExp;
								verificaLadosOperacaoMatematica(operacaoDivisaoExp, Constantes.INT, Constantes.VARIAVEL_ESCOPO_GLOBAL);
								verificarEscopoGlobal(id, linha, coluna, node, true);
								
							}catch(Exception e6){
								e6.printStackTrace();
							}
						}
					//throw new Exception("Lado direito inv�lido para a vari�vel do tipo int.");
						}
					}
				}
			}
		}
		
		// Continuem, lembrando que para variaveis inteiras e reais nao recebem express�es booleanas. Mas qualquer operacao matematica � valida.
		// Entao qualquer variavel inteira ou real pode receber quaquer combinacao de express�es matematicas.
		// Eu nao implementei como se deve percorrer a �rvore para pegar o valor e atribuir a vari�vel para os tipos b�sicos. Vou deixar isso para voc�s.
		// eh simples de se implementar. Uma ideia eh pegar o no raiz da expressao de atribuicao a direita e empilha-lo. apos empilhar o no raiz. Vai
		//empilhando os nos filho da esquerda primeiro, se dois nos filhos empilhados forem tokens, desempilhe-os e desempilhe a operacao seguida por esses dois tokens e empilhe
		// o resultado. E assim se repete. Eh um metodo so para as variaveis   inteiras e reais. Para booleanos eh semelhante.  
	}
	
	private void escolheOpcoesParaTipoReal(PExp pExp,String id, int linha, int coluna, ADecVariavelUnicoPrograma node )
	{
		try{
			AExpNumeroInteiroExp numInt = (AExpNumeroInteiroExp) pExp;
			verificarEscopoGlobal(id, linha, coluna, node,new RegistroVariaveis(getTipoVariavel(node), Constantes.VARIAVEL_ESCOPO_GLOBAL,true,numInt.getNumeroInteiro().getText()));
		}
		catch(Exception e){
				try
				{
					ANumeroRealExp numReal = (ANumeroRealExp) pExp;
				}
				catch(Exception e1){
					try {
					
						AOperacaoSomaExp operacaoSomaExp = (AOperacaoSomaExp) pExp;
						verificaLadosOperacaoMatematica(operacaoSomaExp, Constantes.REAL, Constantes.VARIAVEL_ESCOPO_GLOBAL);
						verificarEscopoGlobal(id, linha, coluna, node, true);
						
						// testarOperacoes(.....);
						//throw new Exception("Lado direito inv�lido para a vari�vel do tipo real.");
					}catch (Exception e2){
						
						try {
							// testarOperacoes(.....);
							// A partir daqui vai aparecer os nos de soma, subtracao....Criem um m�todo generico que ser� util para ambos
							// escolheOpcoesParaTipoReal e escolheOpcoesParaTipoInt para realizar esse processamento.
							// Deem uma olhada nos metodos verificaLadosOperacaoMatematica e verificaExpressoesMatematicas ser� bastante util.
							
							AOperacaoSomaExp operacaoSomaExp = (AOperacaoSomaExp) pExp;
							verificaLadosOperacaoMatematica(operacaoSomaExp, Constantes.REAL, Constantes.VARIAVEL_ESCOPO_GLOBAL);
							verificarEscopoGlobal(id, linha, coluna, node, true);
							
							//throw new Exception("Lado direito inv�lido para a vari�vel inteira."); // remover apos implementar o metodo acima.
						} catch (Exception e3) {
							try{
								
							}catch(Exception e4){
								AOperacaoSubtracaoExp operacaoSubtracaoExp = (AOperacaoSubtracaoExp) pExp;
								verificaLadosOperacaoMatematica(operacaoSubtracaoExp, Constantes.REAL, Constantes.VARIAVEL_ESCOPO_GLOBAL);
								verificarEscopoGlobal(id, linha, coluna, node, true);
							
								try{
									AOperacaoMultiplicacaoExp operacaoMultiplicacaoExp = (AOperacaoMultiplicacaoExp) pExp;
									verificaLadosOperacaoMatematica(operacaoMultiplicacaoExp, Constantes.REAL, Constantes.VARIAVEL_ESCOPO_GLOBAL);
									verificarEscopoGlobal(id, linha, coluna, node, true);
									//Desmarcar apos implementar tudo.
									//throw new Exception("Lado direito inv�lido para a vari�vel do tipo int.");
								} catch (Exception e5){
										try{
											AOperacaoDivisaoExp operacaoDivisaoExp = (AOperacaoDivisaoExp) pExp;
											verificaLadosOperacaoMatematica(operacaoDivisaoExp, Constantes.REAL, Constantes.VARIAVEL_ESCOPO_GLOBAL);
											verificarEscopoGlobal(id, linha, coluna, node, true);
											
										}catch(Exception e6){
											e6.printStackTrace();
										}
								}
						//Desmarcar apos implementar tudo.
						//throw new Exception("Lado direito inv�lido para a vari�vel do tipo real.");
							}
						}
					}
				}
		}
	}
	
	
	/**
	 * Para o id do tipo booleano, verifica se a expressao atribuida a ela eh valida, atribuicao de inteiro ou real nao eh uma atribuicao valida por
	 * exemplo.
	 * @param pExp O n� da expressao atual.
	 * @param id o identificador que recebe essa expressao.
	 * @param linha a linha onde ocorre a atribuicao.
	 * @param coluna a conluna onde ocorre a atribuicao.
	 * @param node o n� raiz dessa atribuicao para encontrar o tipo de variavel de id.
	 */
	private void escolheOpcoesParaTipoBool(PExp pExp,String id, int linha, int coluna, ADecVariavelUnicoPrograma node )
	{
		try
		{
			AOperacaoOrExp opOR = (AOperacaoOrExp) pExp;
			testaAtribuicaoComOR(opOR,linha,id,Constantes.BOOL,Constantes.VARIAVEL_ESCOPO_GLOBAL);
			verificarEscopoGlobal(id, linha, coluna, node, true);
		}
		catch(Exception ee)
		{
			try
			{
				AOperacaoAndExp opAnd =  (AOperacaoAndExp) pExp;
				testaAtribuicaoComAnd(opAnd, linha, id);
				verificarEscopoGlobal(id, linha, coluna, node, true);
			}
			catch(Exception e3)
			{
				try
				{
					AOperacaoIgualExp opIgual = (AOperacaoIgualExp) pExp;
					testaAtribuicaoComIgual(opIgual,linha,id);
					verificarEscopoGlobal(id, linha, coluna, node, true);
				}
				catch(Exception e4)
				{
					try
					{
						ATrueExp valTrue = (ATrueExp) pExp;
						verificarEscopoGlobal(id, linha, coluna, node, true);
					}
					catch(Exception e5)
					{
						try
						{
							AFalseExp valFalse = (AFalseExp) pExp;
							verificarEscopoGlobal(id, linha, coluna, node, true);
						}
						catch(Exception e6)
						{
							try
							{
								AOperacaoMenorExp menorExp = (AOperacaoMenorExp) pExp;
								testaOperacaoMenor(menorExp, linha, id);
								verificarEscopoGlobal(id, linha, coluna, node, true);
							}
							catch(Exception e7)
							{
								try
								{
									AOperacaoNegExp negExp = (AOperacaoNegExp) pExp;
									testaOperacaoNegacao(negExp, linha, id);
									//ladoEsquerdoDireito(pExp, Constantes.BOOL, Constantes.VARIAVEL_ESCOPO_GLOBAL);
									verificarEscopoGlobal(id, linha, coluna, node, true);
								}
								catch(Exception e8)
								{
									try
									{
										AExpNumeroInteiroExp numInt = (AExpNumeroInteiroExp) pExp;
										try{
											throw new Exception("Erro na linha "+linha+", coluna "+coluna+". Na vari�vel '"+id+"'. N�o se pode atribuir um valor inteiro para uma vari�vel booleana.");
										}catch(Exception atribInvalida){
											atribInvalida.printStackTrace();
										}
									}
									catch(Exception e9)
									{
										try
										{
											ANumeroRealExp numReal = (ANumeroRealExp) pExp;
											try{
												throw new Exception("Erro na linha "+linha+", coluna "+coluna+". Na vari�vel '"+id+"'. N�o se pode atribuir um valor real para uma vari�vel booleana.");
											}catch(Exception atribInvalida){
												atribInvalida.printStackTrace();
											}
										}
										catch(Exception e10)
										{
											e10.printStackTrace();
										}
									}
								}
							}
						}
					}
					
				}
			}
		}
	}
	
	private String mensagem(int linha, String id,String op)
	{
		return "Erro na vari�vel '"+id+"' Linha "+linha+". Lado esquerdo ou direito da opera��o '"+op+"' � incompat�vel.";
	}
	
	private void testaAtribuicaoComOR(AOperacaoOrExp opOR,int linha, String id,int tipoVariavel,int escopo)
	{
		if(!verificaLadosOperacaoOR(opOR,Constantes.VARIAVEL_ESCOPO_GLOBAL))
			try{
				throw new Exception(mensagem(linha,id,"OR"));
			}catch(Exception e1){
				e1.printStackTrace();
			}
		
		
	}
	
	private void testaAtribuicaoComAnd(AOperacaoAndExp opAnd,int linha, String id)
	{
		if(!verificaLadosOperacaoAnd(opAnd,Constantes.VARIAVEL_ESCOPO_GLOBAL))
			try{
				throw new Exception(mensagem(linha,id,"AND"));
			}catch(Exception e1){
				e1.printStackTrace();
			}
	}

	private void testaAtribuicaoComIgual(AOperacaoIgualExp opIgual,int linha, String id)
	{
		if(!verificaLadosOperacaoIgual(opIgual,Constantes.VARIAVEL_ESCOPO_GLOBAL))
			try{
				throw new Exception(mensagem(linha,id,"="));
			}catch(Exception e1){
				e1.printStackTrace();
			}
	}
	
	private void testaOperacaoMenor(AOperacaoMenorExp opMenor, int linha, String id)
	{
		if(!verificaLadosOperacaoMenor(opMenor,Constantes.VARIAVEL_ESCOPO_GLOBAL))
			try{
				throw new Exception(mensagem(linha,id,"<"));
			}catch(Exception e1){
				e1.printStackTrace();
			}
	}
	
	private void testaOperacaoNegacao(AOperacaoNegExp opNeg, int linha, String id)
	{
		if(!ladoEsquerdoDireito(opNeg, Constantes.BOOL, Constantes.VARIAVEL_ESCOPO_GLOBAL))
			try{
				throw new Exception(mensagem(linha,id,"!"));
			}catch(Exception e1){
				e1.printStackTrace();
			}
	}
	
	
	/**
	 * Verifica se o lado esquerdo e direito da opera��o OR s�o v�lidos, ou seja, se ambos os lados possuem express�es booleanas para
	 * realizar a opera��o. Caso um ou ambos os lados n�o s�o express�es booleanas gera um erro.
	 * @param opOR o n� que cont�m a opera��o OR. Para vari�veis, verifica seu tipo e faz a verifica��o.
	 * @return true casos os n�s direito e esquerdo da opera��o OR s�o express�es booleanos, false caso contr�rio.
	 */
	private boolean verificaLadosOperacaoOR(AOperacaoOrExp opOR, int escopoEsperado)
	{
		return (ladoEsquerdoDireito(opOR.getLeft(),Constantes.BOOL, escopoEsperado) && ladoEsquerdoDireito(opOR.getRight(),Constantes.BOOL, escopoEsperado));
	}
	
	/**
	 * Semelhante a opera��o OR. Para vari�veis, verifica seu tipo e faz a verifica��o.
	 * @param opAnd O n� com a express�o AND.
	 * @return true caso os lados s�o express�es booleanas, false caso contr�rio.
	 */
	private boolean verificaLadosOperacaoAnd(AOperacaoAndExp opAnd, int escopoEsperado)
	{
		return ladoEsquerdoDireito(opAnd.getLeft(),Constantes.BOOL,escopoEsperado) && ladoEsquerdoDireito(opAnd.getRight(),Constantes.BOOL, escopoEsperado) && (!verificaComNumeros(opAnd.getLeft()) && !verificaComNumeros(opAnd.getRight()));
	}
	
	/**
	 * Verifica se ambos os lados do n� da opera��o de igualdade s�o ambos booleanos, ou ambos n�meros. N�o se compara um n�mero com
	 * uma express�o booleana. Para vari�veis, verifica seu tipo e faz a verifica��o.
	 * @param opIgual o n� com a opera��o
	 * @return true caso os lados casem, false caso contr�rio.
	 */
	private boolean verificaLadosOperacaoIgual(AOperacaoIgualExp opIgual, int escopoEsperado)
	{
		return ladoEsquerdoDireito(opIgual.getLeft(), Constantes.BOOL,escopoEsperado) && ladoEsquerdoDireito(opIgual.getRight(), Constantes.BOOL,escopoEsperado)
				|| verificaExpressoesMatematicas(opIgual.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opIgual.getRight(), Constantes.INT,  escopoEsperado)
				|| verificaExpressoesMatematicas(opIgual.getLeft(), Constantes.INT,  escopoEsperado) && verificaExpressoesMatematicas(opIgual.getRight(), Constantes.REAL, escopoEsperado)
				|| verificaExpressoesMatematicas(opIgual.getLeft(), Constantes.REAL,  escopoEsperado) && verificaExpressoesMatematicas(opIgual.getRight(), Constantes.INT,  escopoEsperado)
				|| verificaExpressoesMatematicas(opIgual.getLeft(), Constantes.INT,  escopoEsperado) && verificaExpressoesMatematicas(opIgual.getRight(), Constantes.INT, escopoEsperado)
		        || verificaExpressoesMatematicas(opIgual.getLeft(), Constantes.BOOL, escopoEsperado) && verificaExpressoesMatematicas(opIgual.getRight(), Constantes.BOOL,  escopoEsperado);
	}
	/**
	 * Utilit�rio para verificaLadosOperacaoIgual(AOperacaoIgualExp opIgual). 
	 * @param exp
	 * @return true caso seja um n�mero. false caso contr�rio.
	 */
	private boolean verificaComNumeros(PExp exp)
	{
		try
		{
			AExpNumeroInteiroExp numInt = (AExpNumeroInteiroExp) exp;
			return true;
		}
		catch(Exception e)
		{
			try
			{
				ANumeroRealExp numReal = (ANumeroRealExp) exp;
				return true;
			}
			catch(Exception e2)
			{
				return false;
			}
			
		}
	}
	
	private boolean verificaLadosOperacaoMenor(AOperacaoMenorExp opMenor, int escopoEsperado)
	{
		return verificaExpressoesMatematicas(opMenor.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opMenor.getRight(), Constantes.INT, escopoEsperado)
				|| verificaExpressoesMatematicas(opMenor.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opMenor.getRight(), Constantes.REAL, escopoEsperado)
				|| verificaExpressoesMatematicas(opMenor.getLeft(), Constantes.REAL, escopoEsperado) && verificaExpressoesMatematicas(opMenor.getRight(), Constantes.INT, escopoEsperado)
				|| verificaExpressoesMatematicas(opMenor.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opMenor.getRight(), Constantes.INT, escopoEsperado);
	}

	private boolean verificaLadosOperacaoMatematica(AOperacaoSomaExp opSoma, int tipoVariavelEsperado, int escopoEsperado)
	{
		return verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.REAL, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.REAL, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado);
	}
	
	private boolean verificaLadosOperacaoMatematica(AOperacaoSubtracaoExp opSoma, int tipoVariavelEsperado, int escopoEsperado)
	{
		return verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.REAL, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.REAL, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado);
	}
	
	private boolean verificaLadosOperacaoMatematica(AOperacaoMultiplicacaoExp opSoma, int tipoVariavelEsperado, int escopoEsperado)
	{
		return verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.REAL, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.REAL, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado);
	}
	
	private boolean verificaLadosOperacaoMatematica(AOperacaoDivisaoExp opSoma, int tipoVariavelEsperado, int escopoEsperado)
	{
		return verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.REAL, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.REAL, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado);
	}
	
	private boolean verificaLadosOperacaoMatematica(AOperacaoModuloExp opSoma, int tipoVariavelEsperado, int escopoEsperado)
	{
		return verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.REAL, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.REAL, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado)
			|| verificaExpressoesMatematicas(opSoma.getLeft(), Constantes.INT, escopoEsperado) && verificaExpressoesMatematicas(opSoma.getRight(), Constantes.INT, escopoEsperado);
	}
	
	private boolean verificaExpressoesMatematicas(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		return blocoTrySoma(exp, tipoVariavelEsperado, escopoEsperado);
	}
	
	private boolean blocoTrySoma(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
			AOperacaoSomaExp opSoma = (AOperacaoSomaExp) exp;
			return verificaLadosOperacaoMatematica(opSoma, tipoVariavelEsperado, escopoEsperado);
		}
		catch(Exception e)
		{
			return blocoTrySubtracao(exp, tipoVariavelEsperado, escopoEsperado);
		}
	}
	
	private boolean blocoTrySubtracao(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
			AOperacaoSubtracaoExp opSub = (AOperacaoSubtracaoExp) exp;
			return verificaLadosOperacaoMatematica(opSub, tipoVariavelEsperado, escopoEsperado);
		}
		catch(Exception e)
		{
			return blocoTryMultiplicacao(exp, tipoVariavelEsperado, escopoEsperado);
		}
	}
	
	private boolean blocoTryMultiplicacao(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
			AOperacaoMultiplicacaoExp opMul = (AOperacaoMultiplicacaoExp) exp;
			return verificaLadosOperacaoMatematica(opMul, tipoVariavelEsperado, escopoEsperado);
		}
		catch(Exception e)
		{
			return blocoTryOperacaoDivisao(exp, tipoVariavelEsperado, escopoEsperado);
		}
	}
	
	private boolean blocoTryOperacaoDivisao(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
			AOperacaoDivisaoExp opDiv = (AOperacaoDivisaoExp) exp;
			return verificaLadosOperacaoMatematica(opDiv, tipoVariavelEsperado, escopoEsperado);
		}
		catch(Exception e)
		{
			return blocoTryOperacaoModulo(exp, tipoVariavelEsperado, escopoEsperado);
		}
	}
	
	private boolean blocoTryOperacaoModulo(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
			AOperacaoModuloExp opMod = (AOperacaoModuloExp) exp;
			return verificaLadosOperacaoMatematica(opMod, tipoVariavelEsperado, escopoEsperado);
		}
		catch(Exception e1)
		{
			return blocoTryOperacaoMenosUnaria(exp, tipoVariavelEsperado, escopoEsperado);
		}
	}
	
	private boolean blocoTryOperacaoMenosUnaria(PExp exp, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
		
			AOperacaoMenosUnariaExp opMUnaria = (AOperacaoMenosUnariaExp) exp;
			PExp tipoExp = opMUnaria.getExp();
			if(tipoExp instanceof AOperacaoSomaExp) return verificaLadosOperacaoMatematica((AOperacaoSomaExp) tipoExp, tipoVariavelEsperado, escopoEsperado);
			else if(tipoExp instanceof AOperacaoSubtracaoExp) return verificaLadosOperacaoMatematica((AOperacaoSubtracaoExp) tipoExp, tipoVariavelEsperado, escopoEsperado);
			else if(tipoExp instanceof AOperacaoMultiplicacaoExp) return verificaLadosOperacaoMatematica((AOperacaoMultiplicacaoExp) tipoExp, tipoVariavelEsperado, escopoEsperado);
			else if(tipoExp instanceof AOperacaoDivisaoExp) return verificaLadosOperacaoMatematica((AOperacaoDivisaoExp) tipoExp, tipoVariavelEsperado, escopoEsperado);
			else if(tipoExp instanceof AOperacaoModuloExp) return verificaLadosOperacaoMatematica((AOperacaoModuloExp) tipoExp, tipoVariavelEsperado, escopoEsperado);
			else if(tipoExp instanceof AOperacaoMenosUnariaExp) return blocoTryOperacaoMenosUnaria(tipoExp, tipoVariavelEsperado, escopoEsperado);
			else if(tipoExp instanceof AExpNumeroInteiroExp) return verificaComNumeros(tipoExp);
			else if(tipoExp instanceof ANumeroRealExp) return verificaComNumeros(tipoExp);
			else if(tipoExp instanceof AVariavelExp)
				return verificaComVariaveisAtribuicao((tipoExp), Constantes.INT,     escopoEsperado)
						|| verificaComVariaveisAtribuicao((tipoExp), Constantes.REAL, escopoEsperado);
			else return false;
		}
		catch(Exception e)
		{
			return verificaComNumeros(exp) 
					|| verificaComVariaveisAtribuicao(exp, Constantes.INT, escopoEsperado)
					|| verificaComVariaveisAtribuicao(exp, Constantes.REAL, escopoEsperado); 
		}
	}
	

	
	private boolean verificaComVariaveisAtribuicao(PExp exp, int tipoVariavelEsperado,int escopoEsperado)
	{
		try
		{
			AVariavelExp var = (AVariavelExp) exp;
			
			try
			{
				AIdVariavelVariavel id = (AIdVariavelVariavel) var.getVariavel();
				if(!isTabelaSimbolosContemIdentificador(id.getId().getText()))
					try{
						throw new VariavelNaoDeclaradaException("Erro na linha"+id.getId().getLine()+", vari�vel "+id.getId().getText()+" N�o declarada.");
					}catch(VariavelNaoDeclaradaException vnde){
						vnde.printStackTrace();
					}
				else
				{
					ArrayList<RegistroVariaveis> vars = getRegistrosVariaveis(id.getId().getText());
					RegistroVariaveis regVariavel = vars.get(vars.size()-1);
					for(int i = vars.size()-1; i >= 0; i--)
					{
						if(vars.get(i).getEscopo() == escopoEsperado && vars.get(i).getNome().equals(id.getId().getText()))
						{
							regVariavel = vars.get(i);
							break;
						}
					}
					if(!regVariavel.isInicializada())
						try{
							throw new VariavelNaoInicializadaException("Erro na linha"+id.getId().getLine()+", vari�vel "+id.getId().getText()+" N�o inicializada.");				
							}catch(VariavelNaoInicializadaException vnie){
								vnie.printStackTrace();
							}
					return regVariavel.getTipo() == tipoVariavelEsperado;
				}
			}
			catch(Exception e)
			{
				try
				{
					AComandoVarRecVariavel varVetor = (AComandoVarRecVariavel)  var.getVariavel();
					while(!(varVetor.getVariavel() instanceof AIdVariavelVariavel))
					{
						varVetor = (AComandoVarRecVariavel) varVetor.getVariavel();
					}
					AIdVariavelVariavel identificador = (AIdVariavelVariavel) varVetor.getVariavel();
					String variavel = identificador.getId().getText();
					int linha = identificador.getId().getLine();
					int coluna = identificador.getId().getPos();
					
					if(!isTabelaSimbolosContemIdentificador(variavel))
						try{
							throw new VariavelNaoDeclaradaException("Erro  linha "+linha+", coluna "+coluna+". Vari�vel '"+variavel+"' n�o declarada.");
						}catch(VariavelNaoDeclaradaException vnde){
							vnde.printStackTrace();
						}
					else{
						ArrayList<RegistroVariaveis> vars = getRegistrosVariaveis(variavel);
						RegistroVariaveis varResp = vars.get(vars.size()-1);
						for(int i = vars.size()-1; i >= 0; i--)
						{
							if(vars.get(i).getEscopo() == escopoEsperado && vars.get(i).getNome().equals(variavel))
							{
								varResp = vars.get(i);
								break;
							}
						}
						if(!varResp.isInicializada())
							try{
								throw new VariavelNaoInicializadaException("Erro na linha"+linha+", vari�vel '"+variavel+"' N�o inicializada.");				
								}catch(VariavelNaoInicializadaException vnie){
									vnie.printStackTrace();
								}
						return varResp.getTipo() == tipoVariavelEsperado;
				
					}
				}
				catch(Exception exc)
				{
					return false;
				}
			}
		}
		catch(Exception ex)
		{
			return false;
		}
		return false;	
	}
	
	/*
	 * Percorre a �vore at� econtrar a menor redu��o poss�vel.
	 */
	private boolean ladoEsquerdoDireito(PExp esq, int tipoVariavelEsperado, int escopoEsperado)
	{
		try
		{
			AOperacaoOrExp op = (AOperacaoOrExp) esq;
			return verificaLadosOperacaoOR(op,escopoEsperado); //ok
		}
		catch(Exception e)
		{
			try
			{
				AOperacaoAndExp op = (AOperacaoAndExp) esq;
				if(op.getLeft() instanceof AExpNumeroInteiroExp || op.getLeft() instanceof ANumeroRealExp)
					try{
						throw new Exception("Erro caralho.");
					}catch(Exception erroporra){e.printStackTrace();}
				return verificaLadosOperacaoAnd(op,escopoEsperado); // ok
			}
			catch(Exception e2)
			{
				try
				{
					AOperacaoIgualExp op = (AOperacaoIgualExp) esq;
					return verificaLadosOperacaoIgual(op,escopoEsperado); //ok
				}
				catch(Exception e3)
				{
					try
					{
						AOperacaoMenorExp op = (AOperacaoMenorExp) esq; //ok
						return verificaLadosOperacaoMenor(op,escopoEsperado);
					}
					catch(Exception e4)
					{
						try
						{
							AOperacaoNegExp op = (AOperacaoNegExp) esq; //ok
							PExp expPos = op.getExp();
							if(expPos instanceof AOperacaoAndExp){
								return verificaLadosOperacaoAnd((AOperacaoAndExp) expPos, escopoEsperado);
							}
							if(expPos instanceof AOperacaoOrExp) return verificaLadosOperacaoOR((AOperacaoOrExp) expPos,escopoEsperado);
							else if(expPos instanceof AOperacaoIgualExp) return verificaLadosOperacaoIgual((AOperacaoIgualExp) expPos,escopoEsperado);
							else if(expPos instanceof AOperacaoMenorExp) return verificaLadosOperacaoMenor((AOperacaoMenorExp) expPos,escopoEsperado);
							else if(expPos instanceof ATrueExp) return true;
							else if(expPos instanceof AFalseExp) return true;
							else if(expPos instanceof AOperacaoNegExp) return ladoEsquerdoDireito(expPos, tipoVariavelEsperado, escopoEsperado);
							else {
								try
								{
									throw new Exception("Erro na linha "+op.getNeg().getLine()+". O lado direito de '!' � incompat�vel.");
								}catch(Exception erro){
									erro.printStackTrace();
									throw new Exception("Erro na linha "+op.getNeg().getLine()+". O lado direito de '!' � incompat�vel.");
								}
							}
						}
						catch(Exception e5)
						{
							try
							{
								ATrueExp op = (ATrueExp) esq; //ok
								return true;
							}
							catch(Exception e6)
							{
								try{
									AFalseExp op = (AFalseExp) esq; //0k
									return true;
								}
								catch(Exception e7)
								{
									return verificaComVariaveisAtribuicao(esq,tipoVariavelEsperado,escopoEsperado); //ok
								}
								
							}
						}
					}
				}
				
			}
		}
	}
	
	
	
	private int getTipoVariavel(ADecVariavelUnicoPrograma node)
	{
		ADecVar decVariavel = (ADecVar) node.getDecVar();
		int tipoVariavel;
		
		try
		{
			final ATipoBaseTipo tct = (ATipoBaseTipo) decVariavel.getTipo();
			tipoVariavel = getTipoVariavel(tct.getTipoBase());
			return tipoVariavel;
		}
		catch(Exception e)
		{
			//Vetores de inteiros, reais ou booleanos.
			ATipoCompostoTipo tct = (ATipoCompostoTipo) decVariavel.getTipo();
			while(!(tct.getTipo() instanceof ATipoBaseTipo))
			{
				tct = (ATipoCompostoTipo) tct.getTipo();
			}
			tipoVariavel = getTipoVariavel(((ATipoBaseTipo) tct.getTipo()).getTipoBase());
			return getTipoVetor(tipoVariavel);
		}
	}
	
	private int getTipoVetor(int tipoVariavel)
	{
		switch(tipoVariavel)
		{
			case Constantes.INT:  return Constantes.VETOR_INT;
			case Constantes.REAL: return Constantes.VETOR_REAL;
			case Constantes.BOOL: return Constantes.VETOR_BOOL;
			default: return -1;
		}
	}
	
	private int getTipoVariavel(PTipoBase p)
	{
		try
		{
			((AIntTipoBase) p).getInt().getText();
			return Constantes.INT;
		} 
		catch (Exception e) 
		{
			try
			{
				((ABoolTipoBase) p).getBool().getText();
				return Constantes.BOOL;
			}
			catch(Exception ee)
			{
				((ARealTipoBase) p).getReal().getText();
				return Constantes.REAL;
			}
		}
	}
	
	private boolean isTabelaSimbolosContemIdentificador(String key)
	{
		return tabelaDeSimbolos.containsKey(key);
	}
	
	private ArrayList<RegistroVariaveis> getRegistrosVariaveis(String key)
	{
		return tabelaDeSimbolos.get(key);
	}

	public boolean isTipoPassado(int tipo)
	{
		switch(tipo)
		{
			case Constantes.BOOL: return true;
			case Constantes.CONS: return true;
			case Constantes.INT:  return true;
			case Constantes.REAL: return true;
			default:              return false;
		}
	}	
}