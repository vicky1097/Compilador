/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import AnalizadorLexico.Token;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author andre
 */
class Parametro {

    private Token tipoDato;
    private Token identificador;

    public Parametro(Token tipoDato, Token identificador) {
        this.tipoDato = tipoDato;
        this.identificador = identificador;
    }

    public DefaultMutableTreeNode getArbolVisual() {
        return new DefaultMutableTreeNode(identificador.getLexema() + " : " + tipoDato.getLexema());
    }
}
