package AnalizadorSintactico;

import java.util.ArrayList;

public class UnidadDeCompilacion {

    private ArrayList<Funcion> funcion;

    public UnidadDeCompilacion(ArrayList<Funcion> funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return "UnidadDeCompilacion [Función= " + funcion + "]";
    }

}
