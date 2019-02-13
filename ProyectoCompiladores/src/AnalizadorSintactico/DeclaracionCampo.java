package AnalizadorSintactico;

import AnalizadorLexico.Token;
import java.util.ArrayList;

public class DeclaracionCampo {

    
    private Token tipoDato;
    private ArrayList<Variable> listaIdentificadores;

    public DeclaracionCampo( Token tipoDato, ArrayList<Variable> listaIdentificadores) {
        super();
        
        this.tipoDato = tipoDato;
        this.listaIdentificadores = listaIdentificadores;
    }

    

    public Token getTipoDato() {
        return tipoDato;
    }

    public ArrayList<Variable> getListaIdentificadores() {
        return listaIdentificadores;
    }

    @Override
    public String toString() {
        return "DeclaracionCampo [TipoDato=" + tipoDato + ", listaIdentificadores="
                + listaIdentificadores + "]";
    }

}
