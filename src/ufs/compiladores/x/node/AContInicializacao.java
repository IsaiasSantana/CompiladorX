/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AContInicializacao extends PContInicializacao
{
    private PInicializacao _inicializacao_;

    public AContInicializacao()
    {
        // Constructor
    }

    public AContInicializacao(
        @SuppressWarnings("hiding") PInicializacao _inicializacao_)
    {
        // Constructor
        setInicializacao(_inicializacao_);

    }

    @Override
    public Object clone()
    {
        return new AContInicializacao(
            cloneNode(this._inicializacao_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAContInicializacao(this);
    }

    public PInicializacao getInicializacao()
    {
        return this._inicializacao_;
    }

    public void setInicializacao(PInicializacao node)
    {
        if(this._inicializacao_ != null)
        {
            this._inicializacao_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._inicializacao_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._inicializacao_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._inicializacao_ == child)
        {
            this._inicializacao_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._inicializacao_ == oldChild)
        {
            setInicializacao((PInicializacao) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
