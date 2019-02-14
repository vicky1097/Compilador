package AnalizadorSintactico;

import AnalizadorLexico.Categoria;
import AnalizadorLexico.Token;
import java.util.ArrayList;

public class AnalizadorSintactico {

    private ArrayList<Token> tablaSimbolos;
    private ArrayList<ErrorSintactico> tablaErrores;
    private int posicionActual;
    private Token tokenActual;
    private UnidadDeCompilacion unidadDeCompilacion;

    public AnalizadorSintactico(ArrayList<Token> tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
        this.tokenActual = tablaSimbolos.get(posicionActual);
        this.tablaErrores = new ArrayList<>();
    }

    public void analizar() {
        this.unidadDeCompilacion = esUnidadDeCompilacion();
    }

    /**
     * <UnidadCompilación> ::= <ListaDeclaracion>
     *
     * @return
     */
    public UnidadDeCompilacion esUnidadDeCompilacion() {

        ArrayList<Funcion> ea = esListaFunciones();

        if (ea != null) {
            return new UnidadDeCompilacion(ea);
        }

        return null;
    }

    /**
     * <ListaDeclaracion> ::= <DeclaracionCampo>[<ListaDeclaracion>]
     *
     * @return
     */
    public ArrayList<DeclaracionCampo> esListaDeclaraciones() {
        ArrayList<DeclaracionCampo> lista = new ArrayList<>();

        DeclaracionCampo declaracionCampo = esDeclaracionCampo();

        while (declaracionCampo != null) {
            lista.add(declaracionCampo);
            declaracionCampo = esDeclaracionCampo();
        }

        return lista;
    }

    /**
     * <EA> ::= <Termino>[op.Arit<EA>] | "("<EA>")"[op.Arit<EA>]
     *
     * @return
     */
    public ExpresionAritmetica esExpresionAritmetica() {

        Termino termino = esTermino();

        if (termino != null) {
            obtenerSiguienteToken();

            if (tokenActual.getCategoria() == Categoria.OPERADOR_ARITMETICO) {
                Token operadorAritmetico = tokenActual;
                obtenerSiguienteToken();

                ExpresionAritmetica exp = esExpresionAritmetica();

                if (exp != null) {
                    return new ExpresionAritmetica(termino, operadorAritmetico, exp);
                } else {
                    reportarError("Falta una expresión aritmética");
                }

            } else {
                return new ExpresionAritmetica(termino);
            }

        }

        if (tokenActual.getCategoria() == Categoria.PARENTESIS_ABRIR) {
            obtenerSiguienteToken();

            ExpresionAritmetica ea = esExpresionAritmetica();

            if (ea != null) {

                if (tokenActual.getCategoria() == Categoria.PARENTESIS_CERRAR) {
                    obtenerSiguienteToken();

                    if (tokenActual.getCategoria() == Categoria.OPERADOR_ARITMETICO) {
                        Token operadorAritmetico = tokenActual;
                        obtenerSiguienteToken();

                        ExpresionAritmetica ea2 = esExpresionAritmetica();

                        if (ea2 != null) {
                            return new ExpresionAritmetica(ea, operadorAritmetico, ea2);
                        } else {
                            reportarError("Falta expresión aritmética");
                        }

                    } else {
                        return new ExpresionAritmetica(ea);
                    }

                } else {
                    reportarError("Falta paréntesis derecho");
                }

            } else {
                reportarError("Falta expresión aritmética");
            }

        }

        return null;

    }

    /**
     * <Termino> ::= entero | real | identificador
     *
     * @return
     */
    public Termino esTermino() {

        if (tokenActual.getCategoria() == Categoria.ENTERO
                || tokenActual.getCategoria() == Categoria.REAL
                || tokenActual.getCategoria() == Categoria.IDENTIFICADOR
                || tokenActual.getCategoria() == Categoria.BOOLEAN
                || tokenActual.getCategoria() == Categoria.CADENA_CARACTERES
                || tokenActual.getCategoria() == Categoria.CARACTER
                || esInvocacion(tokenActual.getCategoria())) {
            return new Termino(tokenActual);
        }

        return null;
    }

    /**
     * <DeclaracionCampo> ::= [<visibilidad>] <tipoDato> <ListaVariables> ";"
     *
     * @return
     */
    public DeclaracionCampo esDeclaracionCampo() {

        Token tipoDato = esTipoDato();

        if (tipoDato != null) {
            obtenerSiguienteToken();
            ArrayList<Variable> listaIdent = esListaVariables();

            if (listaIdent != null) {

                if (tokenActual.getCategoria() == Categoria.FIN_SENTENCIA) {
                    obtenerSiguienteToken();
                    return new DeclaracionCampo(tipoDato, listaIdent);
                } else {
                    reportarError("Falta fin de sentencia");
                }
            } else {
                reportarError("Debe escribir al menos un identificador");
            }
        }

        return null;
    }

    /**
     * <ListaVariables> :== <variable> [","<ListaVariables>]
     *
     * @return
     */
    public ArrayList<Variable> esListaVariables() {

        ArrayList<Variable> lista = new ArrayList<>();
        Variable variable = esVariable();

        if (variable != null) {

            lista.add(variable);

            if (tokenActual.getCategoria() == Categoria.SEPARADOR) {
                obtenerSiguienteToken();
                lista.addAll(esListaVariables());
            }

        }

        return lista;
    }

    public ArrayList<Parametro> esListaParametro() {

        ArrayList<Parametro> lista = new ArrayList<>();
        Parametro parametro = esParametro();

        if (parametro != null) {

            lista.add(parametro);

            if (tokenActual.getCategoria() == Categoria.SEPARADOR) {
                obtenerSiguienteToken();
                lista.addAll(esListaParametro());
            }

        }

        return lista;
    }

    /**
     * <variable> ::= identificador["="<Expresion>]
     *
     * @return
     */
    public Variable esVariable() {

        if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR) {
            Token identificador = tokenActual;
            obtenerSiguienteToken();

            if (tokenActual.getLexema().equals(":")) {
                obtenerSiguienteToken();

                ExpresionAritmetica e = esExpresionAritmetica();

                if (e != null) {
                    return new Variable(identificador, e);
                } else {
                    reportarError("Falta expresion");
                }

            } else {
                return new Variable(identificador);
            }
        }

        return null;
    }

    /**
     * <Asignacion> ::= identificador operadorAsignacion <Expresion>
     *
     * @return
     */
    public String esAsignacion() {
        return null;
    }

    /**
     * <visibilidad> ::= public | private
     *
     * @return
     */
    public Token esVisibilidad() {

        if (tokenActual.getLexema().equals("public") || tokenActual.getLexema().equals("private")) {
            return tokenActual;
        }

        return null;
    }

    /**
     * <tipoDato> ::= int | double | identificador | char
     *
     * @return
     */
    public Token esTipoDato() {
        if (tokenActual.getLexema().equals("entero") || tokenActual.getLexema().equals("doble")
                || tokenActual.getLexema().equals("caracter") || tokenActual.getLexema().equals("cadena")) {
            return tokenActual;
        }

        return null;
    }

    public Token esTipoRetorno() {
        if (tokenActual.getLexema().equals(esTipoDato().getLexema()) || tokenActual.getLexema().equals("")) {
            return tokenActual;

        }

        return null;
    }

    public Funcion esFuncion() {
        if (tokenActual.getLexema().equals("F")) {
            obtenerSiguienteToken();
            if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR) {
                Token identificador = tokenActual;
                obtenerSiguienteToken();

                Token tipoRetorno = esTipoRetorno();
                if (tipoRetorno != null) {
                    obtenerSiguienteToken();

                    if (tokenActual.getCategoria() == Categoria.PARENTESIS_ABRIR) {
                        obtenerSiguienteToken();
                        ArrayList<Parametro> listaParametro = esListaParametro();

                        if (listaParametro != null) {
                            obtenerSiguienteToken();
                            if (tokenActual.getCategoria() == Categoria.PARENTESIS_CERRAR) {
                                obtenerSiguienteToken();
                                ArrayList<Sentencia> listaSentencias = eslistaSentencia();
                                if (listaSentencias != null) {
                                    if (tokenActual.getLexema().equals("n")) {
                                        if (tokenActual.getCategoria() == Categoria.FIN_SENTENCIA) {
                                            return new Funcion(identificador, tipoRetorno, listaParametro, listaSentencias);
                                        } else {
                                            reportarError("Falta fin de sentencia");
                                        }
                                    }
                                }

                            }

                        }

                    }

                }
            }

        }
        return null;
    }

    public void obtenerSiguienteToken() {

        if (posicionActual < tablaSimbolos.size() - 1) {
            posicionActual++;
            tokenActual = tablaSimbolos.get(posicionActual);
        } else {
            tokenActual = new Token("", Categoria.FIN_CODIGO, tokenActual.getFila(), tokenActual.getColumna());
        }

    }

    public void reportarError(String mensaje) {
        tablaErrores.add(new ErrorSintactico(mensaje, tokenActual.getFila(), tokenActual.getColumna()));
    }

    public void hacerBacktracking(int posInicial) {
        posicionActual = posInicial;
        tokenActual = tablaSimbolos.get(posicionActual);
    }

    public ArrayList<ErrorSintactico> getTablaErrores() {
        return tablaErrores;
    }

    public UnidadDeCompilacion getUnidadDeCompilacion() {
        return unidadDeCompilacion;
    }

    private boolean esInvocacion(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Parametro esParametro() {
        Token tipo = esTipoDato();
        if (tipo != null) {
            obtenerSiguienteToken();
            if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR) {
                return new Parametro(tipo, tokenActual);
            }
        }
        return null;
    }

    private ArrayList<Sentencia> eslistaSentencia() {
        ArrayList<Sentencia> lista = new ArrayList<>();
        Sentencia sentencia = esSentencia();

        if (sentencia != null) {

            lista.add(sentencia);

            if (tokenActual.getCategoria() == Categoria.SEPARADOR) {
                obtenerSiguienteToken();
                lista.addAll(eslistaSentencia());
            }

        }

        return lista;
    }

    private Sentencia esSentencia() {
        // if(tokenActual)

        return null;
    }

    public ExpresionRelacional esExpresionRelacional() {
        Termino termino = esTermino();
        if (termino != null) {
            obtenerSiguienteToken();

            if (tokenActual.getCategoria() == Categoria.OPERADOR_RELACIONAL) {
                Token operadorRelacional = tokenActual;
                obtenerSiguienteToken();

                Termino termino1 = esTermino();
                if (termino1 != null) {
                    return new ExpresionRelacional(termino, operadorRelacional, termino1);
                } else {
                    reportarError("Falta un termino para completar la expresión relacional");
                }
            } else {
                reportarError("Falta un operador relacional en la expresión");

            }

        } else {
            reportarError("Falta un termino para completar la expresión relacional");

        }
        return null;
    }

    public SentanciaDecision esSentanciaDecision() {

        if (tokenActual.getLexema().equals("Si")) {
            obtenerSiguienteToken();
            ExpresionRelacional expresionRelacional = esExpresionRelacional();

            if (expresionRelacional != null) {
                obtenerSiguienteToken();

                if (tokenActual.getLexema().equals("hacer")) {
                    obtenerSiguienteToken();

                    ArrayList<Sentencia> listaSentencias = eslistaSentencia();
                    if (listaSentencias != null) {
                        obtenerSiguienteToken();

                        if (tokenActual.getLexema().equals("FinSi")) {
                            obtenerSiguienteToken();

                            if (!tokenActual.getLexema().equals("Sino")) {
                                return new SentanciaDecision(expresionRelacional, listaSentencias);

                            } else {
                                ArrayList<Sentencia> listaSentencia1 = eslistaSentencia();
                                if (listaSentencia1 != null) {
                                    obtenerSiguienteToken();
                                    if (tokenActual.getLexema().equals("FinSino")) {
                                        return new SentanciaDecision(expresionRelacional, listaSentencias, listaSentencia1);
                                    }
                                }
                            }

                        }

                    }

                }

            }

        }

        return null;

    }

    public ImprimirDato esImprimirDato() {

        if (tokenActual.getLexema().equals("Imprimir")) {
            obtenerSiguienteToken();

            if (tokenActual.getCategoria() == Categoria.PARENTESIS_ABRIR) {
                obtenerSiguienteToken();

                Termino termino = esTermino();
                if (termino != null) {
                    obtenerSiguienteToken();
                    if (tokenActual.getCategoria() == Categoria.PARENTESIS_CERRAR) {
                        obtenerSiguienteToken();

                        if (tokenActual.getCategoria() == Categoria.FIN_SENTENCIA) {
                            return new ImprimirDato(termino);
                        }
                    }

                }
            }
        }

        return null;
    }

    public CicloMientras esCicloMientras() {

        if (tokenActual.getLexema().equals("Mientras")) {
            obtenerSiguienteToken();

            ExpresionRelacional expresionRelacional = esExpresionRelacional();
            if (expresionRelacional != null) {
                obtenerSiguienteToken();

                if (tokenActual.getLexema().equals("hacer")) {
                    obtenerSiguienteToken();

                    ArrayList<Sentencia> listaSentencias = eslistaSentencia();
                    if (listaSentencias != null) {
                        obtenerSiguienteToken();

                        if (tokenActual.getLexema().equals("FinMientras")) {
                            return new CicloMientras(expresionRelacional, listaSentencias);
                        }

                    }
                }

            }

        }

        return null;

    }

    public Retorno esRetorno() {

        if (tokenActual.getLexema().equals("retorno")) {
            obtenerSiguienteToken();

            Termino termino = esTermino();
            if (termino != null) {
                obtenerSiguienteToken();

                if (tokenActual.getCategoria() == Categoria.FIN_SENTENCIA) {
                    return new Retorno(termino);
                }
            }

        }

        return null;
    }

    public LeerDato esLeerDato() {

        if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR) {
            Token identificador = tokenActual;
            obtenerSiguienteToken();

            if (tokenActual.getCategoria() == Categoria.PUNTO) {
                obtenerSiguienteToken();

                if (tokenActual.getLexema().equals("leer")) {
                    return new LeerDato(identificador);

                }
            }

        }

        return null;
    }

    public ArrayList<Funcion> esListaFunciones() {
        ArrayList<Funcion> lista = new ArrayList<>();

        Funcion funcion = esFuncion();

        while (funcion != null) {
            lista.add(funcion);
            funcion = esFuncion();
        }

        return lista;
    }

}
