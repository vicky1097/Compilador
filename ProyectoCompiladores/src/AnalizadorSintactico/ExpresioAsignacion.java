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
class ExpresioAsignacion extends Expresion{
    private Variable variable;
    private Termino termino;

    public ExpresioAsignacion(Variable variable, Termino termino) {
        this.variable = variable;
        this.termino = termino;
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        System.out.println("holii");
        return new  DefaultMutableTreeNode(variable.getIdentificador()+": "+termino.toString());
    }
    
    
     
}
