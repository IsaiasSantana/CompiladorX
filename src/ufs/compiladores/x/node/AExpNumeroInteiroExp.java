/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AExpNumeroInteiroExp extends PExp
{
    private TNumeroInteiro _numeroInteiro_;

    public AExpNumeroInteiroExp()
    {
        // Constructor
    }

    public AExpNumeroInteiroExp(
        @SuppressWarnings("hiding") TNumeroInteiro _numeroInteiro_)
    {
        // Constructor
        setNumeroInteiro(_numeroInteiro_);

    }

    @Override
    public Object clone()
    {
        return new AExpNumeroInteiroExp(
            cloneNode(this._numeroInteiro_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpNumeroInteiroExp(this);
    }

    public TNumeroInteiro getNumeroInteiro()
    {
        return this._numeroInteiro_;
    }

    public void setNumeroInteiro(TNumeroInteiro node)
    {
        if(this._numeroInteiro_ != null)
        {
            this._numeroInteiro_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._numeroInteiro_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._numeroInteiro_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._numeroInteiro_ == child)
        {
            this._numeroInteiro_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._numeroInteiro_ == oldChild)
        {
            setNumeroInteiro((TNumeroInteiro) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
