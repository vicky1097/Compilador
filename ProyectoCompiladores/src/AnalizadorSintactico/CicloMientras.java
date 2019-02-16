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
class CicloMientras extends Sentencia {

    private ExpresionRelacional sentenciaRelacional;
    private ArrayList<Sentencia> listaSentencias;

    public CicloMientras(ExpresionRelacional sentenciaRelacional, ArrayList<Sentencia> listaSentencias) {
        this.sentenciaRelacional = sentenciaRelacional;
        this.listaSentencias = listaSentencias;
    }

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Ciclo Mientras");
        nodo.add(new DefaultMutableTreeNode("Expresión Relacional: "+sentenciaRelacional.getTermino1().toString()+""+sentenciaRelacional.getOperadorRelacional().getLexema()+""+sentenciaRelacional.getTermino2().toString()));

        DefaultMutableTreeNode sentencia = new DefaultMutableTreeNode("Sentencias");
        nodo.add(sentencia);

        for (Sentencia sent : listaSentencias) {
            sentencia.add(sent.getArbolVisual());
        }

        return nodo;
    }

}
