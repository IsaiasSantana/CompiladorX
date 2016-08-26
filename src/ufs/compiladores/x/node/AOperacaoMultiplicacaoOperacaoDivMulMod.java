/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AOperacaoMultiplicacaoOperacaoDivMulMod extends POperacaoDivMulMod
{
    private POperacaoDivMulMod _operacaoDivMulMod_;
    private TMult _mult_;
    private POperacaoUnaria _operacaoUnaria_;

    public AOperacaoMultiplicacaoOperacaoDivMulMod()
    {
        // Constructor
    }

    public AOperacaoMultiplicacaoOperacaoDivMulMod(
        @SuppressWarnings("hiding") POperacaoDivMulMod _operacaoDivMulMod_,
        @SuppressWarnings("hiding") TMult _mult_,
        @SuppressWarnings("hiding") POperacaoUnaria _operacaoUnaria_)
    {
        // Constructor
        setOperacaoDivMulMod(_operacaoDivMulMod_);

        setMult(_mult_);

        setOperacaoUnaria(_operacaoUnaria_);

    }

    @Override
    public Object clone()
    {
        return new AOperacaoMultiplicacaoOperacaoDivMulMod(
            cloneNode(this._operacaoDivMulMod_),
            cloneNode(this._mult_),
            cloneNode(this._operacaoUnaria_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOperacaoMultiplicacaoOperacaoDivMulMod(this);
    }

    public POperacaoDivMulMod getOperacaoDivMulMod()
    {
        return this._operacaoDivMulMod_;
    }

    public void setOperacaoDivMulMod(POperacaoDivMulMod node)
    {
        if(this._operacaoDivMulMod_ != null)
        {
            this._operacaoDivMulMod_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operacaoDivMulMod_ = node;
    }

    public TMult getMult()
    {
        return this._mult_;
    }

    public void setMult(TMult node)
    {
        if(this._mult_ != null)
        {
            this._mult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mult_ = node;
    }

    public POperacaoUnaria getOperacaoUnaria()
    {
        return this._operacaoUnaria_;
    }

    public void setOperacaoUnaria(POperacaoUnaria node)
    {
        if(this._operacaoUnaria_ != null)
        {
            this._operacaoUnaria_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._operacaoUnaria_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._operacaoDivMulMod_)
            + toString(this._mult_)
            + toString(this._operacaoUnaria_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._operacaoDivMulMod_ == child)
        {
            this._operacaoDivMulMod_ = null;
            return;
        }

        if(this._mult_ == child)
        {
            this._mult_ = null;
            return;
        }

        if(this._operacaoUnaria_ == child)
        {
            this._operacaoUnaria_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._operacaoDivMulMod_ == oldChild)
        {
            setOperacaoDivMulMod((POperacaoDivMulMod) newChild);
            return;
        }

        if(this._mult_ == oldChild)
        {
            setMult((TMult) newChild);
            return;
        }

        if(this._operacaoUnaria_ == oldChild)
        {
            setOperacaoUnaria((POperacaoUnaria) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
