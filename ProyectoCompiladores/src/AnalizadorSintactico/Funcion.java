/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import AnalizadorLexico.Token;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author andre
 */
public class Funcion {

    private Token identificador;
    private Token tipoRetorno;
    private ArrayList<Parametro> listaParametros;
    private ArrayList<Sentencia> listaSentencias;

    public Funcion(Token identificador, Token tipoRetorno, ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
        this.identificador = identificador;
        this.tipoRetorno = tipoRetorno;
        this.listaParametros = listaParametros;
        this.listaSentencias = listaSentencias;
    }

    public Funcion(Token identificador, Token tipoRetorno, ArrayList<Sentencia> listaSentencias) {
        this.identificador = identificador;
        this.tipoRetorno = tipoRetorno;

        this.listaSentencias = listaSentencias;
    }

    public Token getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Token identificador) {
        this.identificador = identificador;
    }

    public Token getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(Token tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    public ArrayList<Parametro> getParametros() {
        return listaParametros;
    }

    public void setParametros(ArrayList<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public ArrayList<Sentencia> getSentencias() {
        return listaSentencias;
    }

    public void setSentencias(ArrayList<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }

    public DefaultMutableTreeNode getArbolVisual() {

        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Funcion");
        nodo.add(new DefaultMutableTreeNode("Nombre función: " + identificador.getLexema() ));
        nodo.add(new DefaultMutableTreeNode("Tipo de Retorno: " +  tipoRetorno.getLexema()));

        if (NullPointerException.class.equals(listaParametros)) {
            DefaultMutableTreeNode params = new DefaultMutableTreeNode("Parametros");
            nodo.add(params);

            for (Parametro parametro : listaParametros) {
                params.add(parametro.getArbolVisual());
            }

        }

        DefaultMutableTreeNode sentencias = new DefaultMutableTreeNode("Sentencias");
        nodo.add(sentencias);
       

        for (Sentencia sentencia : listaSentencias) {
            sentencias.add(sentencia.getArbolVisual());
        }

        return nodo;
    }

}
