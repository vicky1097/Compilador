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
public class Argumento {

    private Token identificador;
    private Termino termino;

    public Argumento(Token identificador, Termino termino) {
        this.identificador = identificador;
        this.termino = termino;
    }
    
    public DefaultMutableTreeNode getArbolVisual(){
        return null;
        
    }
    

}
