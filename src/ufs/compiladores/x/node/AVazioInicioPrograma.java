/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AVazioInicioPrograma extends PInicioPrograma
{
    private PVazio _vazio_;

    public AVazioInicioPrograma()
    {
        // Constructor
    }

    public AVazioInicioPrograma(
        @SuppressWarnings("hiding") PVazio _vazio_)
    {
        // Constructor
        setVazio(_vazio_);

    }

    @Override
    public Object clone()
    {
        return new AVazioInicioPrograma(
            cloneNode(this._vazio_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVazioInicioPrograma(this);
    }

    public PVazio getVazio()
    {
        return this._vazio_;
    }

    public void setVazio(PVazio node)
    {
        if(this._vazio_ != null)
        {
            this._vazio_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._vazio_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._vazio_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._vazio_ == child)
        {
            this._vazio_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._vazio_ == oldChild)
        {
            setVazio((PVazio) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
