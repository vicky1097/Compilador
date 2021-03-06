package AnalizadorSintactico;

import AnalizadorLexico.Token;
import javax.swing.tree.DefaultMutableTreeNode;

public class Termino {

    private Token termino;
    private Invocacion invocacion;

    public Termino(Token termino) {
        super();
        this.termino = termino;
    }

    public Termino(Invocacion invocacion) {
        this.invocacion = invocacion;
    }
    

    public Token getTermino() {
        return termino;
    }

    public DefaultMutableTreeNode getArbolVisual() {

        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Termino");
        String valor = "ERROR";

        if (termino != null) {
            valor = termino.getLexema() + ":" + termino.getCategoria();
        }

        nodo.add(new DefaultMutableTreeNode(valor));
        return nodo;
    }

    @Override
    public String toString() {
        return termino.getLexema();
    }

}
