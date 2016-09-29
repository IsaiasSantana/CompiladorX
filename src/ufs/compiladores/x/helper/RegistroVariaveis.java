package ufs.compiladores.x.helper;

/**
 * Classe responsável por guardar as informações das variáveis, como também para nomes de procedimentos e funções.
 * @author IsaíasSantana
 * @since 24/09/2016
 * @version 0.1
 */
public class RegistroVariaveis 
{
	private int tipo; // Tipo da variável;
	private int escopo; // O escopo onde ela foi declarada;
	private String nome; // O valor da variável.
	private boolean inicializada;
	
	/**
	 * 
	 * @param tipo Tipo da variável;
	 * @param escopo O escopo onde ela foi declarada;
	 * @param valor O valor da variável.
	 */
	public RegistroVariaveis(int tipo, int escopo, boolean inicializada, String valor)
	{
		this(tipo,escopo,inicializada);
		this.nome = valor;
	}
	
	/**
	 * 
	 * @param tipo Tipo da variável;
	 * @param escopo O escopo onde ela foi declarada;
	 *
	 * */
	public RegistroVariaveis(int tipo, int escopo, boolean inicializada)
	{
		this.tipo  = tipo;
		this.escopo = escopo;
		this.inicializada = inicializada;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEscopo() {
		return escopo;
	}

	public void setEscopo(int escopo) {
		this.escopo = escopo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String valor) {
		this.nome = valor;
	}

	public boolean isInicializada() {
		return inicializada;
	}

	public void setInicializada(boolean inicializada) {
		this.inicializada = inicializada;
	}
	
	
}
