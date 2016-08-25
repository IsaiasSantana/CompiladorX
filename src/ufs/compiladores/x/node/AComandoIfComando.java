/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class AComandoIfComando extends PComando
{
    private PComandosIf _comandosIf_;

    public AComandoIfComando()
    {
        // Constructor
    }

    public AComandoIfComando(
        @SuppressWarnings("hiding") PComandosIf _comandosIf_)
    {
        // Constructor
        setComandosIf(_comandosIf_);

    }

    @Override
    public Object clone()
    {
        return new AComandoIfComando(
            cloneNode(this._comandosIf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComandoIfComando(this);
    }

    public PComandosIf getComandosIf()
    {
        return this._comandosIf_;
    }

    public void setComandosIf(PComandosIf node)
    {
        if(this._comandosIf_ != null)
        {
            this._comandosIf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comandosIf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comandosIf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comandosIf_ == child)
        {
            this._comandosIf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comandosIf_ == oldChild)
        {
            setComandosIf((PComandosIf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
