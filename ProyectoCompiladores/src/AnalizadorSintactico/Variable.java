package AnalizadorSintactico;

import AnalizadorLexico.Token;

public class Variable {

    private Token identificador;
    private Termino termino;

    public Variable(Token identificador) {
        super();
        this.identificador = identificador;
    }

    public Variable(Token identificador, Termino termino) {
        super();
        this.identificador = identificador;
        this.termino = termino;
    }

    

    public Token getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Token identificador) {
        this.identificador = identificador;
    }

   
}
