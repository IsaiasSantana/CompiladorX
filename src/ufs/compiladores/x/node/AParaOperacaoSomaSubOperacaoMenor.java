/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AParaOperacaoSomaSubOperacaoMenor extends POperacaoMenor
{
    private POperacaoSomaSub _operacaoSomaSub_;

    public AParaOperacaoSomaSubOperacaoMenor()
    {
        // Constructor
    }

    public AParaOperacaoSomaSubOperacaoMenor(
        @SuppressWarnings("hiding") POperacaoSomaSub _operacaoSomaSub_)
    {
        // Constructor
        setOperacaoSomaSub(_operacaoSomaSub_);

    }

    @Override
    public Object clone()
    {
        return new AParaOperacaoSomaSubOperacaoMenor(
            cloneNode(this._operacaoSomaSub_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParaOperacaoSomaSubOperacaoMenor(this);
    }

    public POperacaoSomaSub getOperacaoSomaSub()
    {
        return this._operacaoSomaSub_;
    }

    public void setOperacaoSomaSub(POperacaoSomaSub node)
    {
        if(this._operacaoSomaSub_ != null)
        {
            this._operacaoSomaSub_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operacaoSomaSub_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._operacaoSomaSub_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._operacaoSomaSub_ == child)
        {
            this._operacaoSomaSub_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._operacaoSomaSub_ == oldChild)
        {
            setOperacaoSomaSub((POperacaoSomaSub) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}