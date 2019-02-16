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
class ExpresionRelacional extends Expresion{

    private Termino termino1;
    private Termino termino2;
    private Token operadorRelacional;
    //op Relacional

    public ExpresionRelacional(Termino termino1, Token operadorRelacional, Termino termino2) {
        this.termino1 = termino1;
        this.termino2 = termino2;
        this.operadorRelacional = operadorRelacional;
    }

    public Termino getTermino1() {
        return termino1;
    }

    public Termino getTermino2() {
        return termino2;
    }

    public Token getOperadorRelacional() {
        return operadorRelacional;
    }
    

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
       return new DefaultMutableTreeNode(termino1.toString() + " "+operadorRelacional +""+ termino2);
    }

}
