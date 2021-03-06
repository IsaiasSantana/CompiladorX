/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.node;

import java.util.*;
import ufs.compiladores.x.analysis.*;

@SuppressWarnings("nls")
public final class ADecConst extends PDecConst
{
    private TCons _cons_;
    private PTipo _tipo_;
    private PInicializacao _inicializacao_;
    private final LinkedList<PContInicializacao> _contInicializacao_ = new LinkedList<PContInicializacao>();

    public ADecConst()
    {
        // Constructor
    }

    public ADecConst(
        @SuppressWarnings("hiding") TCons _cons_,
        @SuppressWarnings("hiding") PTipo _tipo_,
        @SuppressWarnings("hiding") PInicializacao _inicializacao_,
        @SuppressWarnings("hiding") List<?> _contInicializacao_)
    {
        // Constructor
        setCons(_cons_);

        setTipo(_tipo_);

        setInicializacao(_inicializacao_);

        setContInicializacao(_contInicializacao_);

    }

    @Override
    public Object clone()
    {
        return new ADecConst(
            cloneNode(this._cons_),
            cloneNode(this._tipo_),
            cloneNode(this._inicializacao_),
            cloneList(this._contInicializacao_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADecConst(this);
    }

    public TCons getCons()
    {
        return this._cons_;
    }

    public void setCons(TCons node)
    {
        if(this._cons_ != null)
        {
            this._cons_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cons_ = node;
    }

    public PTipo getTipo()
    {
        return this._tipo_;
    }

    public void setTipo(PTipo node)
    {
        if(this._tipo_ != null)
        {
            this._tipo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tipo_ = node;
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

    public LinkedList<PContInicializacao> getContInicializacao()
    {
        return this._contInicializacao_;
    }

    public void setContInicializacao(List<?> list)
    {
        for(PContInicializacao e : this._contInicializacao_)
        {
            e.parent(null);
        }
        this._contInicializacao_.clear();

        for(Object obj_e : list)
        {
            PContInicializacao e = (PContInicializacao) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._contInicializacao_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._cons_)
            + toString(this._tipo_)
            + toString(this._inicializacao_)
            + toString(this._contInicializacao_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._cons_ == child)
        {
            this._cons_ = null;
            return;
        }

        if(this._tipo_ == child)
        {
            this._tipo_ = null;
            return;
        }

        if(this._inicializacao_ == child)
        {
            this._inicializacao_ = null;
            return;
        }

        if(this._contInicializacao_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._cons_ == oldChild)
        {
            setCons((TCons) newChild);
            return;
        }

        if(this._tipo_ == oldChild)
        {
            setTipo((PTipo) newChild);
            return;
        }

        if(this._inicializacao_ == oldChild)
        {
            setInicializacao((PInicializacao) newChild);
            return;
        }

        for(ListIterator<PContInicializacao> i = this._contInicializacao_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PContInicializacao) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
