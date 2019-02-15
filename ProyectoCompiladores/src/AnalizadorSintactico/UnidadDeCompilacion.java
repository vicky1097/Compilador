package AnalizadorSintactico;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class UnidadDeCompilacion {

    private ArrayList<Funcion> listaFunciones;

    public UnidadDeCompilacion(ArrayList<Funcion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    @Override
    public String toString() {
        return "UnidadDeCompilacion [Función= " + listaFunciones + "]";
    }

    public DefaultMutableTreeNode getArbolVisual() {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Unidad de compilaciÃ³n");

        for (Funcion funcion : listaFunciones) {
            nodo.add(funcion.getArbolVisual());
        }

        return nodo;
    }

}
