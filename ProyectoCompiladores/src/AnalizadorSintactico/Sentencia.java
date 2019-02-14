/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

/**
 *
 * @author andre
 */
class Sentencia {

    private SentanciaDecision sentenciaDecision;
    private ExpresionRelacional sentenciaRelacional;
    private DeclaracionCampo declaracionCampo;
    private Expresion expresion;
    private ImprimirDato imprimirDato;
    private CicloMientras cicloMientras;
    private Retorno retorno;
    private LeerDato leerDato;

    public Sentencia(SentanciaDecision sentenciaDecision) {
        this.sentenciaDecision = sentenciaDecision;
    }

    public Sentencia(ExpresionRelacional sentenciaRelacional) {
        this.sentenciaRelacional = sentenciaRelacional;
    }

    public Sentencia(DeclaracionCampo declaracionCampo) {
        this.declaracionCampo = declaracionCampo;
    }

    public Sentencia(Expresion expresion) {
        this.expresion = expresion;
    }

    public Sentencia(ImprimirDato imprimirDato) {
        this.imprimirDato = imprimirDato;
    }

    public Sentencia(CicloMientras cicloMientras) {
        this.cicloMientras = cicloMientras;
    }

    public Sentencia(Retorno retorno) {
        this.retorno = retorno;
    }

    public Sentencia(LeerDato leerDato) {
        this.leerDato = leerDato;
    }
    
    
    
}
