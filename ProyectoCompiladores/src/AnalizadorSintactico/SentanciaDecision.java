/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Vicky
 */
public class SentanciaDecision extends Sentencia{

    private ExpresionRelacional sentenciaRelacional;
    private ArrayList<Sentencia> listaSentencia;
    private ArrayList<Sentencia> listaSentencia1;

    public SentanciaDecision(ExpresionRelacional sentenciaRelacional, ArrayList<Sentencia> listaSentencia) {

        this.sentenciaRelacional = sentenciaRelacional;
        this.listaSentencia = listaSentencia;
    }

    public SentanciaDecision(ExpresionRelacional sentenciaRelacional, ArrayList<Sentencia> listaSentencia, ArrayList<Sentencia> listaSentencia1) {
        this.sentenciaRelacional = sentenciaRelacional;
        this.listaSentencia = listaSentencia;
        this.listaSentencia1 = listaSentencia1;
    }

    //@Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
