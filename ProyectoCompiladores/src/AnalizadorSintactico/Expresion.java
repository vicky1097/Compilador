/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

/**
 *
 * @author Vicky
 */
class Expresion {
    private ExpresionAritmetica expresionAritmetica;
    private ExpresionCadena expresionCadena;
    private ExpresionRelacional expresionRelacionar;
    private ExpresioAsignacion expresionAsignacion;

    public Expresion(ExpresionAritmetica expresionAritmetica) {
        this.expresionAritmetica = expresionAritmetica;
    }

    public Expresion(ExpresionCadena expresionCadena) {
        this.expresionCadena = expresionCadena;
    }

    public Expresion(ExpresionRelacional expresionRelacionar) {
        this.expresionRelacionar = expresionRelacionar;
    }

    public Expresion(ExpresioAsignacion expresionAsignacion) {
        this.expresionAsignacion = expresionAsignacion;
    }
    
    
    
    
}
