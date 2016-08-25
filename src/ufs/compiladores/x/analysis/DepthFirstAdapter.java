/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.analysis;

import java.util.*;
import ufs.compiladores.x.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPInicioPrograma().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAInicioPrograma(AInicioPrograma node)
    {
        defaultIn(node);
    }

    public void outAInicioPrograma(AInicioPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInicioPrograma(AInicioPrograma node)
    {
        inAInicioPrograma(node);
        if(node.getPrograma() != null)
        {
            node.getPrograma().apply(this);
        }
        outAInicioPrograma(node);
    }

    public void inADecVariavelRecPrograma(ADecVariavelRecPrograma node)
    {
        defaultIn(node);
    }

    public void outADecVariavelRecPrograma(ADecVariavelRecPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecVariavelRecPrograma(ADecVariavelRecPrograma node)
    {
        inADecVariavelRecPrograma(node);
        if(node.getPrograma() != null)
        {
            node.getPrograma().apply(this);
        }
        if(node.getDecVar() != null)
        {
            node.getDecVar().apply(this);
        }
        outADecVariavelRecPrograma(node);
    }

    public void inADecVariavelUnicoPrograma(ADecVariavelUnicoPrograma node)
    {
        defaultIn(node);
    }

    public void outADecVariavelUnicoPrograma(ADecVariavelUnicoPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecVariavelUnicoPrograma(ADecVariavelUnicoPrograma node)
    {
        inADecVariavelUnicoPrograma(node);
        if(node.getDecVar() != null)
        {
            node.getDecVar().apply(this);
        }
        outADecVariavelUnicoPrograma(node);
    }

    public void inADecConstanteRecPrograma(ADecConstanteRecPrograma node)
    {
        defaultIn(node);
    }

    public void outADecConstanteRecPrograma(ADecConstanteRecPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecConstanteRecPrograma(ADecConstanteRecPrograma node)
    {
        inADecConstanteRecPrograma(node);
        if(node.getPrograma() != null)
        {
            node.getPrograma().apply(this);
        }
        if(node.getDecConst() != null)
        {
            node.getDecConst().apply(this);
        }
        outADecConstanteRecPrograma(node);
    }

    public void inADecConstanteUnicoPrograma(ADecConstanteUnicoPrograma node)
    {
        defaultIn(node);
    }

    public void outADecConstanteUnicoPrograma(ADecConstanteUnicoPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecConstanteUnicoPrograma(ADecConstanteUnicoPrograma node)
    {
        inADecConstanteUnicoPrograma(node);
        if(node.getDecConst() != null)
        {
            node.getDecConst().apply(this);
        }
        outADecConstanteUnicoPrograma(node);
    }

    public void inADecProcedimentoRecPrograma(ADecProcedimentoRecPrograma node)
    {
        defaultIn(node);
    }

    public void outADecProcedimentoRecPrograma(ADecProcedimentoRecPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecProcedimentoRecPrograma(ADecProcedimentoRecPrograma node)
    {
        inADecProcedimentoRecPrograma(node);
        if(node.getPrograma() != null)
        {
            node.getPrograma().apply(this);
        }
        if(node.getDecProcedimento() != null)
        {
            node.getDecProcedimento().apply(this);
        }
        outADecProcedimentoRecPrograma(node);
    }

    public void inADecProcedimentoUnicoPrograma(ADecProcedimentoUnicoPrograma node)
    {
        defaultIn(node);
    }

    public void outADecProcedimentoUnicoPrograma(ADecProcedimentoUnicoPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecProcedimentoUnicoPrograma(ADecProcedimentoUnicoPrograma node)
    {
        inADecProcedimentoUnicoPrograma(node);
        if(node.getDecProcedimento() != null)
        {
            node.getDecProcedimento().apply(this);
        }
        outADecProcedimentoUnicoPrograma(node);
    }

    public void inADecFuncaoRecPrograma(ADecFuncaoRecPrograma node)
    {
        defaultIn(node);
    }

    public void outADecFuncaoRecPrograma(ADecFuncaoRecPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecFuncaoRecPrograma(ADecFuncaoRecPrograma node)
    {
        inADecFuncaoRecPrograma(node);
        if(node.getPrograma() != null)
        {
            node.getPrograma().apply(this);
        }
        if(node.getDecFuncao() != null)
        {
            node.getDecFuncao().apply(this);
        }
        outADecFuncaoRecPrograma(node);
    }

    public void inADecFuncaoUnicoPrograma(ADecFuncaoUnicoPrograma node)
    {
        defaultIn(node);
    }

    public void outADecFuncaoUnicoPrograma(ADecFuncaoUnicoPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecFuncaoUnicoPrograma(ADecFuncaoUnicoPrograma node)
    {
        inADecFuncaoUnicoPrograma(node);
        if(node.getDecFuncao() != null)
        {
            node.getDecFuncao().apply(this);
        }
        outADecFuncaoUnicoPrograma(node);
    }

    public void inADecVar(ADecVar node)
    {
        defaultIn(node);
    }

    public void outADecVar(ADecVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecVar(ADecVar node)
    {
        inADecVar(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getOpcaoVar() != null)
        {
            node.getOpcaoVar().apply(this);
        }
        {
            List<PContOpcaoVar> copy = new ArrayList<PContOpcaoVar>(node.getContOpcaoVar());
            for(PContOpcaoVar e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        outADecVar(node);
    }

    public void inADecConst(ADecConst node)
    {
        defaultIn(node);
    }

    public void outADecConst(ADecConst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecConst(ADecConst node)
    {
        inADecConst(node);
        if(node.getCons() != null)
        {
            node.getCons().apply(this);
        }
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getInicializacao() != null)
        {
            node.getInicializacao().apply(this);
        }
        {
            List<PContInicializacao> copy = new ArrayList<PContInicializacao>(node.getContInicializacao());
            for(PContInicializacao e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        outADecConst(node);
    }

    public void inAInicializacao(AInicializacao node)
    {
        defaultIn(node);
    }

    public void outAInicializacao(AInicializacao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInicializacao(AInicializacao node)
    {
        inAInicializacao(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getAtri() != null)
        {
            node.getAtri().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAInicializacao(node);
    }

    public void inAContInicializacao(AContInicializacao node)
    {
        defaultIn(node);
    }

    public void outAContInicializacao(AContInicializacao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAContInicializacao(AContInicializacao node)
    {
        inAContInicializacao(node);
        if(node.getVirgula() != null)
        {
            node.getVirgula().apply(this);
        }
        if(node.getInicializacao() != null)
        {
            node.getInicializacao().apply(this);
        }
        outAContInicializacao(node);
    }

    public void inAArrayExt(AArrayExt node)
    {
        defaultIn(node);
    }

    public void outAArrayExt(AArrayExt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayExt(AArrayExt node)
    {
        inAArrayExt(node);
        if(node.getColcheteE() != null)
        {
            node.getColcheteE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PContExp> copy = new ArrayList<PContExp>(node.getContExp());
            for(PContExp e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getColcheteD() != null)
        {
            node.getColcheteD().apply(this);
        }
        outAArrayExt(node);
    }

    public void inAArrayComp(AArrayComp node)
    {
        defaultIn(node);
    }

    public void outAArrayComp(AArrayComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayComp(AArrayComp node)
    {
        inAArrayComp(node);
        if(node.getColcheteE() != null)
        {
            node.getColcheteE().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPipe() != null)
        {
            node.getPipe().apply(this);
        }
        if(node.getContArrayComp() != null)
        {
            node.getContArrayComp().apply(this);
        }
        if(node.getColcheteD() != null)
        {
            node.getColcheteD().apply(this);
        }
        outAArrayComp(node);
    }

    public void inAArrayCompEscolhaContArrayComp(AArrayCompEscolhaContArrayComp node)
    {
        defaultIn(node);
    }

    public void outAArrayCompEscolhaContArrayComp(AArrayCompEscolhaContArrayComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayCompEscolhaContArrayComp(AArrayCompEscolhaContArrayComp node)
    {
        inAArrayCompEscolhaContArrayComp(node);
        if(node.getArrayComp() != null)
        {
            node.getArrayComp().apply(this);
        }
        outAArrayCompEscolhaContArrayComp(node);
    }

    public void inAExpEscolhaContArrayComp(AExpEscolhaContArrayComp node)
    {
        defaultIn(node);
    }

    public void outAExpEscolhaContArrayComp(AExpEscolhaContArrayComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpEscolhaContArrayComp(AExpEscolhaContArrayComp node)
    {
        inAExpEscolhaContArrayComp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAExpEscolhaContArrayComp(node);
    }

    public void inATipoBaseTipo(ATipoBaseTipo node)
    {
        defaultIn(node);
    }

    public void outATipoBaseTipo(ATipoBaseTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoBaseTipo(ATipoBaseTipo node)
    {
        inATipoBaseTipo(node);
        if(node.getTipoBase() != null)
        {
            node.getTipoBase().apply(this);
        }
        outATipoBaseTipo(node);
    }

    public void inATipoCompostoTipo(ATipoCompostoTipo node)
    {
        defaultIn(node);
    }

    public void outATipoCompostoTipo(ATipoCompostoTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoCompostoTipo(ATipoCompostoTipo node)
    {
        inATipoCompostoTipo(node);
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getColcheteE() != null)
        {
            node.getColcheteE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getColcheteD() != null)
        {
            node.getColcheteD().apply(this);
        }
        outATipoCompostoTipo(node);
    }

    public void inAIntTipoBase(AIntTipoBase node)
    {
        defaultIn(node);
    }

    public void outAIntTipoBase(AIntTipoBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntTipoBase(AIntTipoBase node)
    {
        inAIntTipoBase(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAIntTipoBase(node);
    }

    public void inABoolTipoBase(ABoolTipoBase node)
    {
        defaultIn(node);
    }

    public void outABoolTipoBase(ABoolTipoBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoolTipoBase(ABoolTipoBase node)
    {
        inABoolTipoBase(node);
        if(node.getBool() != null)
        {
            node.getBool().apply(this);
        }
        outABoolTipoBase(node);
    }

    public void inARealTipoBase(ARealTipoBase node)
    {
        defaultIn(node);
    }

    public void outARealTipoBase(ARealTipoBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARealTipoBase(ARealTipoBase node)
    {
        inARealTipoBase(node);
        if(node.getReal() != null)
        {
            node.getReal().apply(this);
        }
        outARealTipoBase(node);
    }

    public void inADecProcedimento(ADecProcedimento node)
    {
        defaultIn(node);
    }

    public void outADecProcedimento(ADecProcedimento node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecProcedimento(ADecProcedimento node)
    {
        inADecProcedimento(node);
        if(node.getProcedure() != null)
        {
            node.getProcedure().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getParametros() != null)
        {
            node.getParametros().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        outADecProcedimento(node);
    }

    public void inADecFuncao(ADecFuncao node)
    {
        defaultIn(node);
    }

    public void outADecFuncao(ADecFuncao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecFuncao(ADecFuncao node)
    {
        inADecFuncao(node);
        if(node.getFunction() != null)
        {
            node.getFunction().apply(this);
        }
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getParametros() != null)
        {
            node.getParametros().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outADecFuncao(node);
    }

    public void inAVazioParametros(AVazioParametros node)
    {
        defaultIn(node);
    }

    public void outAVazioParametros(AVazioParametros node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioParametros(AVazioParametros node)
    {
        inAVazioParametros(node);
        outAVazioParametros(node);
    }

    public void inAParametros(AParametros node)
    {
        defaultIn(node);
    }

    public void outAParametros(AParametros node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametros(AParametros node)
    {
        inAParametros(node);
        if(node.getParametro() != null)
        {
            node.getParametro().apply(this);
        }
        {
            List<PParametroCont> copy = new ArrayList<PParametroCont>(node.getParametroCont());
            for(PParametroCont e : copy)
            {
                e.apply(this);
            }
        }
        outAParametros(node);
    }

    public void inAParametro(AParametro node)
    {
        defaultIn(node);
    }

    public void outAParametro(AParametro node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametro(AParametro node)
    {
        inAParametro(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getTipoParametro() != null)
        {
            node.getTipoParametro().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAParametro(node);
    }

    public void inATipoBaseParamTipoParametro(ATipoBaseParamTipoParametro node)
    {
        defaultIn(node);
    }

    public void outATipoBaseParamTipoParametro(ATipoBaseParamTipoParametro node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoBaseParamTipoParametro(ATipoBaseParamTipoParametro node)
    {
        inATipoBaseParamTipoParametro(node);
        if(node.getTipoBase() != null)
        {
            node.getTipoBase().apply(this);
        }
        outATipoBaseParamTipoParametro(node);
    }

    public void inATipoParamContTipoParametro(ATipoParamContTipoParametro node)
    {
        defaultIn(node);
    }

    public void outATipoParamContTipoParametro(ATipoParamContTipoParametro node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoParamContTipoParametro(ATipoParamContTipoParametro node)
    {
        inATipoParamContTipoParametro(node);
        if(node.getTipoParametro() != null)
        {
            node.getTipoParametro().apply(this);
        }
        if(node.getColcheteE() != null)
        {
            node.getColcheteE().apply(this);
        }
        if(node.getColcheteD() != null)
        {
            node.getColcheteD().apply(this);
        }
        outATipoParamContTipoParametro(node);
    }

    public void inAParametroCont(AParametroCont node)
    {
        defaultIn(node);
    }

    public void outAParametroCont(AParametroCont node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParametroCont(AParametroCont node)
    {
        inAParametroCont(node);
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        if(node.getParametro() != null)
        {
            node.getParametro().apply(this);
        }
        outAParametroCont(node);
    }

    public void inAComandoIfComando(AComandoIfComando node)
    {
        defaultIn(node);
    }

    public void outAComandoIfComando(AComandoIfComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoIfComando(AComandoIfComando node)
    {
        inAComandoIfComando(node);
        if(node.getComandosIf() != null)
        {
            node.getComandosIf().apply(this);
        }
        outAComandoIfComando(node);
    }

    public void inAComandoWhileComando(AComandoWhileComando node)
    {
        defaultIn(node);
    }

    public void outAComandoWhileComando(AComandoWhileComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoWhileComando(AComandoWhileComando node)
    {
        inAComandoWhileComando(node);
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        outAComandoWhileComando(node);
    }

    public void inAComandoVarComando(AComandoVarComando node)
    {
        defaultIn(node);
    }

    public void outAComandoVarComando(AComandoVarComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoVarComando(AComandoVarComando node)
    {
        inAComandoVarComando(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getAtri() != null)
        {
            node.getAtri().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        outAComandoVarComando(node);
    }

    public void inAComandoChamadaComando(AComandoChamadaComando node)
    {
        defaultIn(node);
    }

    public void outAComandoChamadaComando(AComandoChamadaComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoChamadaComando(AComandoChamadaComando node)
    {
        inAComandoChamadaComando(node);
        if(node.getChamada() != null)
        {
            node.getChamada().apply(this);
        }
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        outAComandoChamadaComando(node);
    }

    public void inAComandoBlocoComando(AComandoBlocoComando node)
    {
        defaultIn(node);
    }

    public void outAComandoBlocoComando(AComandoBlocoComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoBlocoComando(AComandoBlocoComando node)
    {
        inAComandoBlocoComando(node);
        if(node.getBloco() != null)
        {
            node.getBloco().apply(this);
        }
        outAComandoBlocoComando(node);
    }

    public void inAIfSemElseComandosIf(AIfSemElseComandosIf node)
    {
        defaultIn(node);
    }

    public void outAIfSemElseComandosIf(AIfSemElseComandosIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfSemElseComandosIf(AIfSemElseComandosIf node)
    {
        inAIfSemElseComandosIf(node);
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        outAIfSemElseComandosIf(node);
    }

    public void inAIfComElseComandosIf(AIfComElseComandosIf node)
    {
        defaultIn(node);
    }

    public void outAIfComElseComandosIf(AIfComElseComandosIf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfComElseComandosIf(AIfComElseComandosIf node)
    {
        inAIfComElseComandosIf(node);
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getIfComElse() != null)
        {
            node.getIfComElse().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        outAIfComElseComandosIf(node);
    }

    public void inAIfComElse(AIfComElse node)
    {
        defaultIn(node);
    }

    public void outAIfComElse(AIfComElse node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfComElse(AIfComElse node)
    {
        inAIfComElse(node);
        if(node.getComandoComElse() != null)
        {
            node.getComandoComElse().apply(this);
        }
        outAIfComElse(node);
    }

    public void inAIfComElse2(AIfComElse2 node)
    {
        defaultIn(node);
    }

    public void outAIfComElse2(AIfComElse2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfComElse2(AIfComElse2 node)
    {
        inAIfComElse2(node);
        if(node.getComandoComElse() != null)
        {
            node.getComandoComElse().apply(this);
        }
        outAIfComElse2(node);
    }

    public void inAComandoComElse(AComandoComElse node)
    {
        defaultIn(node);
    }

    public void outAComandoComElse(AComandoComElse node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoComElse(AComandoComElse node)
    {
        inAComandoComElse(node);
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getIfComElse() != null)
        {
            node.getIfComElse().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getIfComElse2() != null)
        {
            node.getIfComElse2().apply(this);
        }
        outAComandoComElse(node);
    }

    public void inABloco(ABloco node)
    {
        defaultIn(node);
    }

    public void outABloco(ABloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABloco(ABloco node)
    {
        inABloco(node);
        if(node.getChaveE() != null)
        {
            node.getChaveE().apply(this);
        }
        if(node.getContBloco() != null)
        {
            node.getContBloco().apply(this);
        }
        if(node.getChaveD() != null)
        {
            node.getChaveD().apply(this);
        }
        outABloco(node);
    }

    public void inAOpDecVarOpcaoBloco(AOpDecVarOpcaoBloco node)
    {
        defaultIn(node);
    }

    public void outAOpDecVarOpcaoBloco(AOpDecVarOpcaoBloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOpDecVarOpcaoBloco(AOpDecVarOpcaoBloco node)
    {
        inAOpDecVarOpcaoBloco(node);
        if(node.getDecVar() != null)
        {
            node.getDecVar().apply(this);
        }
        outAOpDecVarOpcaoBloco(node);
    }

    public void inAOpDecConstOpcaoBloco(AOpDecConstOpcaoBloco node)
    {
        defaultIn(node);
    }

    public void outAOpDecConstOpcaoBloco(AOpDecConstOpcaoBloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOpDecConstOpcaoBloco(AOpDecConstOpcaoBloco node)
    {
        inAOpDecConstOpcaoBloco(node);
        if(node.getDecConst() != null)
        {
            node.getDecConst().apply(this);
        }
        outAOpDecConstOpcaoBloco(node);
    }

    public void inAOpComandoOpcaoBloco(AOpComandoOpcaoBloco node)
    {
        defaultIn(node);
    }

    public void outAOpComandoOpcaoBloco(AOpComandoOpcaoBloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOpComandoOpcaoBloco(AOpComandoOpcaoBloco node)
    {
        inAOpComandoOpcaoBloco(node);
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        outAOpComandoOpcaoBloco(node);
    }

    public void inAContBlocoContBloco(AContBlocoContBloco node)
    {
        defaultIn(node);
    }

    public void outAContBlocoContBloco(AContBlocoContBloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAContBlocoContBloco(AContBlocoContBloco node)
    {
        inAContBlocoContBloco(node);
        if(node.getContBloco() != null)
        {
            node.getContBloco().apply(this);
        }
        if(node.getOpcaoBloco() != null)
        {
            node.getOpcaoBloco().apply(this);
        }
        outAContBlocoContBloco(node);
    }

    public void inABaseContBlocoContBloco(ABaseContBlocoContBloco node)
    {
        defaultIn(node);
    }

    public void outABaseContBlocoContBloco(ABaseContBlocoContBloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABaseContBlocoContBloco(ABaseContBlocoContBloco node)
    {
        inABaseContBlocoContBloco(node);
        if(node.getOpcaoBloco() != null)
        {
            node.getOpcaoBloco().apply(this);
        }
        outABaseContBlocoContBloco(node);
    }

    public void inAIdVariavelVar(AIdVariavelVar node)
    {
        defaultIn(node);
    }

    public void outAIdVariavelVar(AIdVariavelVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdVariavelVar(AIdVariavelVar node)
    {
        inAIdVariavelVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdVariavelVar(node);
    }

    public void inAComandoVarRecVar(AComandoVarRecVar node)
    {
        defaultIn(node);
    }

    public void outAComandoVarRecVar(AComandoVarRecVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAComandoVarRecVar(AComandoVarRecVar node)
    {
        inAComandoVarRecVar(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getColcheteE() != null)
        {
            node.getColcheteE().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getColcheteD() != null)
        {
            node.getColcheteD().apply(this);
        }
        outAComandoVarRecVar(node);
    }

    public void inATesteExp(ATesteExp node)
    {
        defaultIn(node);
    }

    public void outATesteExp(ATesteExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATesteExp(ATesteExp node)
    {
        inATesteExp(node);
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outATesteExp(node);
    }

    public void inAContExp(AContExp node)
    {
        defaultIn(node);
    }

    public void outAContExp(AContExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAContExp(AContExp node)
    {
        inAContExp(node);
        if(node.getPontoVirgula() != null)
        {
            node.getPontoVirgula().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAContExp(node);
    }

    public void inAChamada(AChamada node)
    {
        defaultIn(node);
    }

    public void outAChamada(AChamada node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAChamada(AChamada node)
    {
        inAChamada(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getParE() != null)
        {
            node.getParE().apply(this);
        }
        if(node.getListaExp() != null)
        {
            node.getListaExp().apply(this);
        }
        if(node.getParD() != null)
        {
            node.getParD().apply(this);
        }
        outAChamada(node);
    }

    public void inAVazioListaExp(AVazioListaExp node)
    {
        defaultIn(node);
    }

    public void outAVazioListaExp(AVazioListaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVazioListaExp(AVazioListaExp node)
    {
        inAVazioListaExp(node);
        outAVazioListaExp(node);
    }

    public void inAListaExpListaExp(AListaExpListaExp node)
    {
        defaultIn(node);
    }

    public void outAListaExpListaExp(AListaExpListaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListaExpListaExp(AListaExpListaExp node)
    {
        inAListaExpListaExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PContExp> copy = new ArrayList<PContExp>(node.getContExp());
            for(PContExp e : copy)
            {
                e.apply(this);
            }
        }
        outAListaExpListaExp(node);
    }

    public void inAIdOpcaoVar(AIdOpcaoVar node)
    {
        defaultIn(node);
    }

    public void outAIdOpcaoVar(AIdOpcaoVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdOpcaoVar(AIdOpcaoVar node)
    {
        inAIdOpcaoVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdOpcaoVar(node);
    }

    public void inAInicializacaoOpcaoVar(AInicializacaoOpcaoVar node)
    {
        defaultIn(node);
    }

    public void outAInicializacaoOpcaoVar(AInicializacaoOpcaoVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInicializacaoOpcaoVar(AInicializacaoOpcaoVar node)
    {
        inAInicializacaoOpcaoVar(node);
        if(node.getInicializacao() != null)
        {
            node.getInicializacao().apply(this);
        }
        outAInicializacaoOpcaoVar(node);
    }

    public void inAContOpcaoVar(AContOpcaoVar node)
    {
        defaultIn(node);
    }

    public void outAContOpcaoVar(AContOpcaoVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAContOpcaoVar(AContOpcaoVar node)
    {
        inAContOpcaoVar(node);
        if(node.getVirgula() != null)
        {
            node.getVirgula().apply(this);
        }
        if(node.getOpcaoVar() != null)
        {
            node.getOpcaoVar().apply(this);
        }
        outAContOpcaoVar(node);
    }
}
