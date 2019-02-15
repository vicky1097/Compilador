/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Vicky
 */
public class Retorno extends Sentencia {

    private Termino termino;

    public Retorno(Termino termino) {
        this.termino = termino;
        
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
