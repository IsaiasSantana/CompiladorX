/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AElseParte2 extends PElseParte2
{
    private PComando2 _comando2_;

    public AElseParte2()
    {
        // Constructor
    }

    public AElseParte2(
        @SuppressWarnings("hiding") PComando2 _comando2_)
    {
        // Constructor
        setComando2(_comando2_);

    }

    @Override
    public Object clone()
    {
        return new AElseParte2(
            cloneNode(this._comando2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAElseParte2(this);
    }

    public PComando2 getComando2()
    {
        return this._comando2_;
    }

    public void setComando2(PComando2 node)
    {
        if(this._comando2_ != null)
        {
            this._comando2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comando2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comando2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comando2_ == child)
        {
            this._comando2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comando2_ == oldChild)
        {
            setComando2((PComando2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
