package AnalizadorSintactico;

import AnalizadorLexico.Token;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class DeclaracionCampo extends Sentencia {

    
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

    @Override
    public DefaultMutableTreeNode getArbolVisual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
