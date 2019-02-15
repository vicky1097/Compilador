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
class ExpresionCadena extends Expresion{
    private Token cadena;
    private  Termino termino;

    public ExpresionCadena(Token cadena) {
        this.cadena = cadena;
    }

    public ExpresionCadena(Token cadena, Termino termino) {
        this.cadena = cadena;
        this.termino = termino;
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
