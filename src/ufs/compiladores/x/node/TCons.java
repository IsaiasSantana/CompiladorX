/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class TCons extends Token
{
    public TCons()
    {
        super.setText("cons");
    }

    public TCons(int line, int pos)
    {
        super.setText("cons");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCons(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCons(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCons text.");
    }
}
