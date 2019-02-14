/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import java.util.ArrayList;

/**
 *
 * @author Vicky
 */
public class SentanciaDecision {
    
    private ExpresionRelacional sentenciaRelacional;
    private ArrayList<Sentencia> listaSentencia;
    private ArrayList<Sentencia>listaSentencia1;
    

    public SentanciaDecision(ExpresionRelacional sentenciaRelacional, ArrayList<Sentencia> listaSentencia) {
        this.sentenciaRelacional = sentenciaRelacional;
        this.listaSentencia = listaSentencia;
    }

    public SentanciaDecision(ExpresionRelacional sentenciaRelacional, ArrayList<Sentencia> listaSentencia, ArrayList<Sentencia> listaSentencia1) {
        this.sentenciaRelacional = sentenciaRelacional;
        this.listaSentencia = listaSentencia;
        this.listaSentencia1 = listaSentencia1;
    }
    
    
    
    
}
