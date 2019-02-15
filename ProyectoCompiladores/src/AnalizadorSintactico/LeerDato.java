/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import AnalizadorLexico.Token;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Vicky
 */
class LeerDato extends Sentencia{
    private Token termino;

    public LeerDato(Token termino) {
        this.termino = termino;
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
