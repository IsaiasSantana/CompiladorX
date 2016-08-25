/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.parser;

import ufs.compiladores.x.node.*;

@SuppressWarnings("serial")
public class ParserException extends Exception
{
    private Token token;

    public ParserException(@SuppressWarnings("hiding") Token token, String  message)
    {
        super(message);
        this.token = token;
    }

    public Token getToken()
    {
        return this.token;
    }
}