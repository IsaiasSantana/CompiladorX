/* This file was generated by SableCC (http://www.sablecc.org/). */

package ufs.compiladores.x.analysis;

import ufs.compiladores.x.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAInicioPrograma(AInicioPrograma node);
    void caseADecVariavelRecPrograma(ADecVariavelRecPrograma node);
    void caseADecVariavelUnicoPrograma(ADecVariavelUnicoPrograma node);
    void caseADecConstanteRecPrograma(ADecConstanteRecPrograma node);
    void caseADecConstanteUnicoPrograma(ADecConstanteUnicoPrograma node);
    void caseADecProcedimentoRecPrograma(ADecProcedimentoRecPrograma node);
    void caseADecProcedimentoUnicoPrograma(ADecProcedimentoUnicoPrograma node);
    void caseADecFuncaoRecPrograma(ADecFuncaoRecPrograma node);
    void caseADecFuncaoUnicoPrograma(ADecFuncaoUnicoPrograma node);
    void caseADecVar(ADecVar node);
    void caseADecConst(ADecConst node);
    void caseAInicializacao(AInicializacao node);
    void caseAContInicializacao(AContInicializacao node);
    void caseAArrayExt(AArrayExt node);
    void caseAArrayComp(AArrayComp node);
    void caseAArrayCompEscolhaContArrayComp(AArrayCompEscolhaContArrayComp node);
    void caseAExpEscolhaContArrayComp(AExpEscolhaContArrayComp node);
    void caseATipoBaseTipo(ATipoBaseTipo node);
    void caseATipoCompostoTipo(ATipoCompostoTipo node);
    void caseAIntTipoBase(AIntTipoBase node);
    void caseABoolTipoBase(ABoolTipoBase node);
    void caseARealTipoBase(ARealTipoBase node);
    void caseADecProcedimento(ADecProcedimento node);
    void caseADecFuncao(ADecFuncao node);
    void caseAVazioParametros(AVazioParametros node);
    void caseAParametros(AParametros node);
    void caseAParametro(AParametro node);
    void caseATipoBaseParamTipoParametro(ATipoBaseParamTipoParametro node);
    void caseATipoParamContTipoParametro(ATipoParamContTipoParametro node);
    void caseAParametroCont(AParametroCont node);
    void caseAComandoIfComando(AComandoIfComando node);
    void caseAComandoWhileComando(AComandoWhileComando node);
    void caseAComandoVarComando(AComandoVarComando node);
    void caseAComandoChamadaComando(AComandoChamadaComando node);
    void caseAComandoBlocoComando(AComandoBlocoComando node);
    void caseAIfSemElseComandosIf(AIfSemElseComandosIf node);
    void caseAIfComElseComandosIf(AIfComElseComandosIf node);
    void caseAIfComElse(AIfComElse node);
    void caseAIfComElse2(AIfComElse2 node);
    void caseAComandoComElse(AComandoComElse node);
    void caseABloco(ABloco node);
    void caseAOpDecVarOpcaoBloco(AOpDecVarOpcaoBloco node);
    void caseAOpDecConstOpcaoBloco(AOpDecConstOpcaoBloco node);
    void caseAOpComandoOpcaoBloco(AOpComandoOpcaoBloco node);
    void caseAContBlocoContBloco(AContBlocoContBloco node);
    void caseABaseContBlocoContBloco(ABaseContBlocoContBloco node);
    void caseAIdVariavelVar(AIdVariavelVar node);
    void caseAComandoVarRecVar(AComandoVarRecVar node);
    void caseATesteExp(ATesteExp node);
    void caseAContExp(AContExp node);
    void caseAChamada(AChamada node);
    void caseAVazioListaExp(AVazioListaExp node);
    void caseAListaExpListaExp(AListaExpListaExp node);
    void caseAIdOpcaoVar(AIdOpcaoVar node);
    void caseAInicializacaoOpcaoVar(AInicializacaoOpcaoVar node);
    void caseAContOpcaoVar(AContOpcaoVar node);

    void caseTReal(TReal node);
    void caseTInt(TInt node);
    void caseTBool(TBool node);
    void caseTTrue(TTrue node);
    void caseTFalse(TFalse node);
    void caseTIf(TIf node);
    void caseTThen(TThen node);
    void caseTElse(TElse node);
    void caseTWhile(TWhile node);
    void caseTProcedure(TProcedure node);
    void caseTFunction(TFunction node);
    void caseTCons(TCons node);
    void caseTVar(TVar node);
    void caseTAtri(TAtri node);
    void caseTDivisao(TDivisao node);
    void caseTMais(TMais node);
    void caseTMenos(TMenos node);
    void caseTMult(TMult node);
    void caseTMod(TMod node);
    void caseTMenor(TMenor node);
    void caseTIgual(TIgual node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTNeg(TNeg node);
    void caseTPipe(TPipe node);
    void caseTColcheteE(TColcheteE node);
    void caseTColcheteD(TColcheteD node);
    void caseTChaveE(TChaveE node);
    void caseTChaveD(TChaveD node);
    void caseTParE(TParE node);
    void caseTParD(TParD node);
    void caseTPontoVirgula(TPontoVirgula node);
    void caseTVirgula(TVirgula node);
    void caseTEspaco(TEspaco node);
    void caseTComentLinha(TComentLinha node);
    void caseTComentBloco(TComentBloco node);
    void caseTId(TId node);
    void caseTNumeroInteiro(TNumeroInteiro node);
    void caseTNumeroReal(TNumeroReal node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
