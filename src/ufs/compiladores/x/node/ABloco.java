/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class ABloco extends PBloco
{
    private TChaveE _chaveE_;
    private PContBloco _contBloco_;
    private TChaveD _chaveD_;

    public ABloco()
    {
        // Constructor
    }

    public ABloco(
        @SuppressWarnings("hiding") TChaveE _chaveE_,
        @SuppressWarnings("hiding") PContBloco _contBloco_,
        @SuppressWarnings("hiding") TChaveD _chaveD_)
    {
        // Constructor
        setChaveE(_chaveE_);

        setContBloco(_contBloco_);

        setChaveD(_chaveD_);

    }

    @Override
    public Object clone()
    {
        return new ABloco(
            cloneNode(this._chaveE_),
            cloneNode(this._contBloco_),
            cloneNode(this._chaveD_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABloco(this);
    }

    public TChaveE getChaveE()
    {
        return this._chaveE_;
    }

    public void setChaveE(TChaveE node)
    {
        if(this._chaveE_ != null)
        {
            this._chaveE_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._chaveE_ = node;
    }

    public PContBloco getContBloco()
    {
        return this._contBloco_;
    }

    public void setContBloco(PContBloco node)
    {
        if(this._contBloco_ != null)
        {
            this._contBloco_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._contBloco_ = node;
    }

    public TChaveD getChaveD()
    {
        return this._chaveD_;
    }

    public void setChaveD(TChaveD node)
    {
        if(this._chaveD_ != null)
        {
            this._chaveD_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._chaveD_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._chaveE_)
            + toString(this._contBloco_)
            + toString(this._chaveD_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._chaveE_ == child)
        {
            this._chaveE_ = null;
            return;
        }

        if(this._contBloco_ == child)
        {
            this._contBloco_ = null;
            return;
        }

        if(this._chaveD_ == child)
        {
            this._chaveD_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._chaveE_ == oldChild)
        {
            setChaveE((TChaveE) newChild);
            return;
        }

        if(this._contBloco_ == oldChild)
        {
            setContBloco((PContBloco) newChild);
            return;
        }

        if(this._chaveD_ == oldChild)
        {
            setChaveD((TChaveD) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
