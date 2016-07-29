/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class TTrue extends Token
{
    public TTrue()
    {
        super.setText("true");
    }

    public TTrue(int line, int pos)
    {
        super.setText("true");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTrue(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTrue(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTrue text.");
    }
}
