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
public class CicloMientras extends Sentencia {

    private ExpresionRelacional expresionRelacional;
    private ArrayList<Sentencia> listaSentencias;

    public CicloMientras(ExpresionRelacional expresionRelacional, ArrayList<Sentencia> listaSentencias) {
        this.expresionRelacional = expresionRelacional;
        this.listaSentencias = listaSentencias;
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
