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
        System.out.println("Arbol visual Unidad de compilacion");
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Unidad de compilacion");

      
        for (int i = 0; i < listaFunciones.size(); i++) {
            System.out.println("holi");
            nodo.add(listaFunciones.get(i).getArbolVisual());
            
        }

        return nodo;
    }

}
