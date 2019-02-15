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
class CicloMientras extends Sentencia{

    private ExpresionRelacional sentenciaRelacional;
    private ArrayList<Sentencia> listaSentencias;

    public CicloMientras(ExpresionRelacional sentenciaRelacional, ArrayList<Sentencia> listaSentencias) {
        this.sentenciaRelacional = sentenciaRelacional;
        this.listaSentencias = listaSentencias;
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
