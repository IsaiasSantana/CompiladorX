/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class ARealTipoBase extends PTipoBase
{
    private TReal _real_;

    public ARealTipoBase()
    {
        // Constructor
    }

    public ARealTipoBase(
        @SuppressWarnings("hiding") TReal _real_)
    {
        // Constructor
        setReal(_real_);

    }

    @Override
    public Object clone()
    {
        return new ARealTipoBase(
            cloneNode(this._real_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARealTipoBase(this);
    }

    public TReal getReal()
    {
        return this._real_;
    }

    public void setReal(TReal node)
    {
        if(this._real_ != null)
        {
            this._real_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._real_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._real_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._real_ == child)
        {
            this._real_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._real_ == oldChild)
        {
            setReal((TReal) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
