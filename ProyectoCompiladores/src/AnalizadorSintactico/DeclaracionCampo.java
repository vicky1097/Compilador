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
        String cadena = "";
		
		for (int i = 0; i < listaIdentificadores.size(); i++) {
			if(i == listaIdentificadores.size()-1) {
				cadena+=listaIdentificadores.get(i).getIdentificador().getLexema();
			}else {
				cadena+=listaIdentificadores.get(i).getIdentificador().getLexema()+", ";
			}
		}
		
		cadena+=" : "+tipoDato.getLexema();
		
		return new DefaultMutableTreeNode(cadena);
    }

}
