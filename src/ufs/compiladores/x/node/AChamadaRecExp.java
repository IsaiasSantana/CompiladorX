/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AChamadaRecExp extends PRecExp
{
    private PChamada _chamada_;

    public AChamadaRecExp()
    {
        // Constructor
    }

    public AChamadaRecExp(
        @SuppressWarnings("hiding") PChamada _chamada_)
    {
        // Constructor
        setChamada(_chamada_);

    }

    @Override
    public Object clone()
    {
        return new AChamadaRecExp(
            cloneNode(this._chamada_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAChamadaRecExp(this);
    }

    public PChamada getChamada()
    {
        return this._chamada_;
    }

    public void setChamada(PChamada node)
    {
        if(this._chamada_ != null)
        {
            this._chamada_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._chamada_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._chamada_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._chamada_ == child)
        {
            this._chamada_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._chamada_ == oldChild)
        {
            setChamada((PChamada) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}