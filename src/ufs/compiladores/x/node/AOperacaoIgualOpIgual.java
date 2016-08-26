/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AOperacaoIgualOpIgual extends POpIgual
{
    private POpIgual _opIgual_;
    private TIgual _igual_;
    private POperacaoMenor _operacaoMenor_;

    public AOperacaoIgualOpIgual()
    {
        // Constructor
    }

    public AOperacaoIgualOpIgual(
        @SuppressWarnings("hiding") POpIgual _opIgual_,
        @SuppressWarnings("hiding") TIgual _igual_,
        @SuppressWarnings("hiding") POperacaoMenor _operacaoMenor_)
    {
        // Constructor
        setOpIgual(_opIgual_);

        setIgual(_igual_);

        setOperacaoMenor(_operacaoMenor_);

    }

    @Override
    public Object clone()
    {
        return new AOperacaoIgualOpIgual(
            cloneNode(this._opIgual_),
            cloneNode(this._igual_),
            cloneNode(this._operacaoMenor_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOperacaoIgualOpIgual(this);
    }

    public POpIgual getOpIgual()
    {
        return this._opIgual_;
    }

    public void setOpIgual(POpIgual node)
    {
        if(this._opIgual_ != null)
        {
            this._opIgual_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opIgual_ = node;
    }

    public TIgual getIgual()
    {
        return this._igual_;
    }

    public void setIgual(TIgual node)
    {
        if(this._igual_ != null)
        {
            this._igual_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._igual_ = node;
    }

    public POperacaoMenor getOperacaoMenor()
    {
        return this._operacaoMenor_;
    }

    public void setOperacaoMenor(POperacaoMenor node)
    {
        if(this._operacaoMenor_ != null)
        {
            this._operacaoMenor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operacaoMenor_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._opIgual_)
            + toString(this._igual_)
            + toString(this._operacaoMenor_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._opIgual_ == child)
        {
            this._opIgual_ = null;
            return;
        }

        if(this._igual_ == child)
        {
            this._igual_ = null;
            return;
        }

        if(this._operacaoMenor_ == child)
        {
            this._operacaoMenor_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._opIgual_ == oldChild)
        {
            setOpIgual((POpIgual) newChild);
            return;
        }

        if(this._igual_ == oldChild)
        {
            setIgual((TIgual) newChild);
            return;
        }

        if(this._operacaoMenor_ == oldChild)
        {
            setOperacaoMenor((POperacaoMenor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}