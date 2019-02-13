/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import AnalizadorLexico.Token;

/**
 *
 * @author Vicky
 */
class ExpresionCadena {
    private Token cadena;
    private  Termino termino;

    public ExpresionCadena(Token cadena) {
        this.cadena = cadena;
    }

    public ExpresionCadena(Token cadena, Termino termino) {
        this.cadena = cadena;
        this.termino = termino;
    }
    
    
    
}
