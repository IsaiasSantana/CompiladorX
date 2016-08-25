/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AOpDecVarOpcaoBloco extends POpcaoBloco
{
    private PDecVar _decVar_;

    public AOpDecVarOpcaoBloco()
    {
        // Constructor
    }

    public AOpDecVarOpcaoBloco(
        @SuppressWarnings("hiding") PDecVar _decVar_)
    {
        // Constructor
        setDecVar(_decVar_);

    }

    @Override
    public Object clone()
    {
        return new AOpDecVarOpcaoBloco(
            cloneNode(this._decVar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOpDecVarOpcaoBloco(this);
    }

    public PDecVar getDecVar()
    {
        return this._decVar_;
    }

    public void setDecVar(PDecVar node)
    {
        if(this._decVar_ != null)
        {
            this._decVar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._decVar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._decVar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._decVar_ == child)
        {
            this._decVar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._decVar_ == oldChild)
        {
            setDecVar((PDecVar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
