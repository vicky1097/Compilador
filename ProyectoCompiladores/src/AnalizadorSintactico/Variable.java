package AnalizadorSintactico;

import AnalizadorLexico.Token;

public class Variable {

    private Token identificador;
    private ExpresionAritmetica expresion;
    

    public Variable(Token identificador) {
        super();
        this.identificador = identificador;
    }

    public Variable(Token identificador, ExpresionAritmetica expresion) {
        super();
        this.identificador = identificador;
        this.expresion = expresion;
    }

    @Override
    public String toString() {
        return "Variable [identificador=" + identificador + ": expresion=" + expresion + "]";
    }

    public Token getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Token identificador) {
        this.identificador = identificador;
    }

    public ExpresionAritmetica getExpresion() {
        return expresion;
    }

    public void setExpresion(ExpresionAritmetica expresion) {
        this.expresion = expresion;
    }
    
    

}
