/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AParametroContRecParametroCont extends PParametroCont
{
    private PParametroCont _parametroCont_;
    private PParametro _parametro_;

    public AParametroContRecParametroCont()
    {
        // Constructor
    }

    public AParametroContRecParametroCont(
        @SuppressWarnings("hiding") PParametroCont _parametroCont_,
        @SuppressWarnings("hiding") PParametro _parametro_)
    {
        // Constructor
        setParametroCont(_parametroCont_);

        setParametro(_parametro_);

    }

    @Override
    public Object clone()
    {
        return new AParametroContRecParametroCont(
            cloneNode(this._parametroCont_),
            cloneNode(this._parametro_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParametroContRecParametroCont(this);
    }

    public PParametroCont getParametroCont()
    {
        return this._parametroCont_;
    }

    public void setParametroCont(PParametroCont node)
    {
        if(this._parametroCont_ != null)
        {
            this._parametroCont_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parametroCont_ = node;
    }

    public PParametro getParametro()
    {
        return this._parametro_;
    }

    public void setParametro(PParametro node)
    {
        if(this._parametro_ != null)
        {
            this._parametro_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parametro_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._parametroCont_)
            + toString(this._parametro_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parametroCont_ == child)
        {
            this._parametroCont_ = null;
            return;
        }

        if(this._parametro_ == child)
        {
            this._parametro_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._parametroCont_ == oldChild)
        {
            setParametroCont((PParametroCont) newChild);
            return;
        }

        if(this._parametro_ == oldChild)
        {
            setParametro((PParametro) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
