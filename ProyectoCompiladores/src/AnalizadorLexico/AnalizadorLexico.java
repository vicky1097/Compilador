package AnalizadorLexico;

import java.util.ArrayList;
import jdk.nashorn.internal.ir.BreakNode;

public class AnalizadorLexico {

    private String codigoFuente;
    private char caracterActual, finCodigo;
    private int posActual, filActual, colActual, posInicial;
    private ArrayList<Token> tablaSimbolos, tablaErrores;

    public AnalizadorLexico(String codigoFuente) {
        this.codigoFuente = codigoFuente;
        this.caracterActual = codigoFuente.charAt(0);
        this.finCodigo = 0;
        this.tablaSimbolos = new ArrayList<>();
        this.tablaErrores = new ArrayList<>();
    }

    /*
	 * Metodo que se encarga de analizar el lexema
     */
    public void Analizar() {

        while (caracterActual != finCodigo) {
            if (caracterActual == ' ' || caracterActual == '\n' || caracterActual == '\t') {
                darSiguienteCaracter();
                continue;
            }

            if (esComentarioLinea()) {
                continue;
            }
            if (esComentarioBloque()) {
                continue;
            }

            if (esIdentificador()) {
                continue;
            }
            if (esTipoCadena()) {
                continue;
            }
            if (esTipoCaracter()) {
                continue;
            }
            if (esTipoEntero()) {
                continue;
            }
            if (esTipoDoble()) {
                continue;
            }
            if (esCadena()) {
                continue;
            }
            if (esBoolean()) {
                continue;
            }
            if (esOperadorAritmetico()) {
                continue;
            }
            if (esOperadorAsignacion()) {
                continue;
            }
            if (esOperadorRelacional()) {
                continue;
            }
            if (esEntero()) {
                continue;
            }
            if (esCaracter()) {
                continue;
            }
            if (esReal()) {
                continue;
            }
            if (esCorchete()) {
                continue;
            }
            if (esLlaves()) {
                continue;
            }
            if (esParentesis()) {
                continue;
            }
            if (esFinSentencia()) {
                continue;
            }

            if (esCicloMientrasInicio()) {
                continue;
            }
            if (esCicloMientrasFin()) {
                continue;
            }
            if (esPalabraReservadaHacer()) {
                continue;
            }
 
            if (esOperadorLogico()) {
                continue;
            }
            if (esOperadorIncremento()) {
                continue;
            }
            if (esOperadorDecremento()) {
                continue;
            }

            if (esPunto()) {
                continue;
            }
            if (esSeparador()) {
                continue;
            }
            if (esArreglo()) {
                continue;
            }

            if (esDesconocido()) {
            }

        }

    }

    public boolean esCicloMientrasInicio() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'M') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'i') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 'e') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'n') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 't') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'r') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'a') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 's') {
                                        lexema += caracterActual;
                                        almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                        darSiguienteCaracter();
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
            }
        } else {
            return false;
        }
        return true;

    }

    public boolean esCicloMientrasFin() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'F') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'i') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 'n') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'M') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'i') {
                            lexema += caracterActual;
                            darSiguienteCaracter();

                            if (caracterActual == 'e') {
                                lexema += caracterActual;
                                darSiguienteCaracter();

                                if (caracterActual == 'n') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 't') {
                                        lexema += caracterActual;
                                        darSiguienteCaracter();

                                        if (caracterActual == 'r') {
                                            lexema += caracterActual;
                                            darSiguienteCaracter();
                                            if (caracterActual == 'a') {
                                                lexema += caracterActual;
                                                darSiguienteCaracter();
                                                if (caracterActual == 's') {
                                                    lexema += caracterActual;
                                                    almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                                    darSiguienteCaracter();
                                                } else {
                                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                                }
                                            } else {
                                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                            }
                                        } else {
                                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                        }
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                }
                            } else {

                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                    }

                } else {
                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                }

            } else {
                hacerBacktracking(posInicial);
                darSiguienteCaracter();
            }

        } else {
            return false;
        }
        return true;
    }

    /*
	 * Metodo que permite hacer las iteraciones y saltos de caracter en caracter
     */
    public void darSiguienteCaracter() {

        if (posActual == codigoFuente.length() - 1) {
            caracterActual = finCodigo;
        } else {
            if (caracterActual == '\n') {
                colActual = 0;
                filActual++;
            } else {
                colActual++;
            }

            posActual++;
            caracterActual = codigoFuente.charAt(posActual);
        }

    }

    /*
	 * Metodo para realizar el backtracking en el caso espesifico
     */
    public void hacerBacktracking(int posInicial) {
        posActual = posInicial;
        caracterActual = codigoFuente.charAt(posActual);

    }

    //Metodo que indica si el lexema es un fin de sentancia
    public boolean esFinSentencia() {
        if (caracterActual != '!') {

            return false;
        }
        String lexema = "";
        int fila = filActual;
        int columna = colActual;

        lexema += caracterActual;

        almacenarSimbolo(lexema, fila, columna, Categoria.FIN_SENTENCIA);
        darSiguienteCaracter();

        return true;
    }

    //Metodo que indica si el lexema es un parentesis derecho u izquierdo
    public boolean esParentesis() {
        if (!(caracterActual == '(' || caracterActual == ')')) {
            return false;
        }
        String lexema = Character.toString(caracterActual);
        int fila = filActual;
        int columna = colActual;

        if (caracterActual == '(') {

            almacenarSimbolo(lexema, filActual, colActual, Categoria.PARENTESIS_ABRIR);
            darSiguienteCaracter();
            return true;
        } else {

            almacenarSimbolo(lexema, filActual, colActual, Categoria.PARENTESIS_CERRAR);
            darSiguienteCaracter();
            return true;
        }

    }

    //Metodo que indica si el lexema es una llave derecha u izquierda
    public boolean esLlaves() {
        if (!(caracterActual == '{' || caracterActual == '}')) {
            return false;
        }
        String lexema = Character.toString(caracterActual);
        int fila = filActual;
        int columna = colActual;

        if (caracterActual == '{') {

            almacenarSimbolo(lexema, filActual, colActual, Categoria.LLAVES_ABRIR);
            darSiguienteCaracter();
            return true;
        } else {

            almacenarSimbolo(lexema, filActual, colActual, Categoria.LLAVES_CERRAR);
            darSiguienteCaracter();
            return true;
        }

    }

    //Metodo que indica si el lexema es un corchete derecho u izquierdo
    public boolean esCorchete() {
        if (!(caracterActual == '[' || caracterActual == ']')) {
            return false;
        }
        String lexema = Character.toString(caracterActual);
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == '[') {
            darSiguienteCaracter();

            if (caracterActual == 'a') {
                hacerBacktracking(pos);
                return false;
            } else {
                almacenarSimbolo(lexema, filActual, colActual, Categoria.CORCHETE_ABRIR);
                //darSiguienteCaracter();
                return true;
            }

        } else {

            darSiguienteCaracter();
            almacenarSimbolo(lexema, filActual, colActual, Categoria.CORCHETE_CERRAR);
            return true;

        }

    }

    /*
    Metodo que valida si es una palabra reservada o no
     */
    public boolean esPalabraReservada() {

        if (caracterActual != ':') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        lexema += caracterActual;
        darSiguienteCaracter();

        if (caracterActual == 'p') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'u') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 'b') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'l') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'i') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'c') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'o') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == ':') {
                                        lexema += caracterActual;
                                        almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                        darSiguienteCaracter();
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                }

                            } else {
                                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                            }

                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                }

            } else if (caracterActual == 'r') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 'i') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'v') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'a') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'd') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'o') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == ':') {
                                        lexema += caracterActual;
                                        almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                        darSiguienteCaracter();
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    }
                } else if (caracterActual == 'o') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 't') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'e') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'g') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'i') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 'd') {
                                        lexema += caracterActual;
                                        darSiguienteCaracter();
                                        if (caracterActual == 'o') {
                                            lexema += caracterActual;
                                            darSiguienteCaracter();
                                            if (caracterActual == ':') {
                                                lexema += caracterActual;
                                                almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                                darSiguienteCaracter();
                                            } else {
                                                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                            }
                                        } else {
                                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                        }
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
            }

        } else if (caracterActual == 's') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'i') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == ':') {
                    lexema += caracterActual;
                    almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    darSiguienteCaracter();
                } else if (caracterActual == 'n') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'o') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == ':') {
                            lexema += caracterActual;
                            almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                            darSiguienteCaracter();
                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
            }
        } else if (caracterActual == 'e') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 's') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 't') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'a') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 't') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'i') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'c') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 'o') {
                                        lexema += caracterActual;
                                        darSiguienteCaracter();
                                        if (caracterActual == ':') {
                                            lexema += caracterActual;
                                            almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                            darSiguienteCaracter();
                                        } else {
                                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                        }
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    }

                } else {
                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
            }
        } else if (caracterActual == 'f') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'i') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 'n') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'a') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'l') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == ':') {
                                lexema += caracterActual;
                                almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                                darSiguienteCaracter();
                            } else {
                                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
            }
        } else {
            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA);
        }

        return true;
    }

    //Metodo que verifica si es entero o no
    public boolean esEntero() {

        if (!(Character.isDigit(caracterActual))) {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        //Transición
        lexema += caracterActual;
        darSiguienteCaracter();

        while (Character.isDigit(caracterActual)) {
            lexema += caracterActual;
            darSiguienteCaracter();

        }

        if (caracterActual == '.' || caracterActual == 'b') {
            hacerBacktracking(pos);
            return false;

        } else {
            almacenarSimbolo(lexema, fila, columna, Categoria.ENTERO);

        }
        return true;
    }

    /*
    *Metodo que verifica si es un numero real o no
     */
    public boolean esReal() {

        if (!Character.isDigit(caracterActual)) {
            return false;
        }
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        lexema += caracterActual;
        darSiguienteCaracter();

        while (Character.isDigit(caracterActual)) {
            lexema += caracterActual;
            darSiguienteCaracter();
        }
        if (caracterActual == '.') {
            lexema += caracterActual;
            darSiguienteCaracter();
        } else {
            hacerBacktracking(pos);
            return false;
        }
        if (Character.isDigit(caracterActual)) {
            while (Character.isDigit(caracterActual)) {
                lexema += caracterActual;
                darSiguienteCaracter();
            }
            almacenarSimbolo(lexema, fila, columna, Categoria.REAL);
        } else {
            reportarError(lexema, fila, columna, Categoria.REAL);
            darSiguienteCaracter();
        }

        return true;
    }

    /*
	 * Metodo para verificar si lo que se esta analizando es un identificador o no
     */
    public boolean esIdentificador() {

        if (caracterActual != ':') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int col = colActual;
        int pos = posActual;

        lexema += caracterActual;
        darSiguienteCaracter();

        if (caracterActual == ':') {
            hacerBacktracking(pos);
            return false;
        }

        while (!(caracterActual == ':' || caracterActual == finCodigo || caracterActual == 10)) {
            lexema += caracterActual;
            darSiguienteCaracter();
        }

        if (caracterActual == ':') {
            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, col, Categoria.IDENTIFICADOR);
            darSiguienteCaracter();
        } else {
            lexema += caracterActual;
            hacerBacktracking(pos);
            return false;
        }
        return true;

    }

    /*
    *Metodo que verifica si el caracter a analizar en un operador relacional
     */
    public boolean esOperadorRelacional() {

        //RI
        if (!(caracterActual == ':' || caracterActual == '>' || caracterActual == '<'
                || caracterActual == '¡')) {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == '>') {
            lexema += caracterActual;

            darSiguienteCaracter();

            if (caracterActual == '>') {
                lexema += caracterActual;

                darSiguienteCaracter();

                if (caracterActual == ':') {
                    lexema += caracterActual;
                    almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_RELACIONAL);
                    darSiguienteCaracter();

                } else {
                    almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_RELACIONAL);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.DESCONOCIDO);
                darSiguienteCaracter();
            }

        } else if (caracterActual == '<') {
            lexema += caracterActual;

            darSiguienteCaracter();

            if (caracterActual == '<') {
                lexema += caracterActual;

                darSiguienteCaracter();

                if (caracterActual == ':') {
                    lexema += caracterActual;

                    almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_RELACIONAL);
                    darSiguienteCaracter();
                    System.out.println(caracterActual + "R2");

                } else {
                    System.out.println(lexema + "R3");
                    almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_RELACIONAL);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.DESCONOCIDO);
                darSiguienteCaracter();
            }

        } else if (caracterActual == ':' || caracterActual == '¡') {
            lexema += caracterActual;
            darSiguienteCaracter();

            if (caracterActual != ':') {
                hacerBacktracking(pos);
                return false;
            } else {
                lexema += caracterActual;
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_RELACIONAL);
                darSiguienteCaracter();
            }

        }

        return true;
    }

    /*
    * Metodo que se encarga de identificar si el caracter que se analiza es 
    * un operador logico.
     */
    public boolean esOperadorLogico() {

        if (!((caracterActual == '¡') || (caracterActual == 'Y') || (caracterActual == 'O'))) {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == '¡') {
            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_LOGICO);
            darSiguienteCaracter();

        } else if (caracterActual == 'Y') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (!(caracterActual == 'Y')) {
                hacerBacktracking(pos);
                return false;
            } else {
                lexema += caracterActual;
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_LOGICO);
                darSiguienteCaracter();
            }

        } else if (caracterActual == 'O') {
            lexema += caracterActual;
            darSiguienteCaracter();

            if (caracterActual == 'O') {
                lexema += caracterActual;
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_LOGICO);
                darSiguienteCaracter();
            } else {
                hacerBacktracking(posInicial);
                return false;
            }
        }

        return true;
    }

    /*
    * Metodo que verifica si el lexema es un operador de incremento
     */
    public boolean esOperadorIncremento() {

        if (caracterActual != '+') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == '+') {
            lexema += caracterActual;
            darSiguienteCaracter();

            if (caracterActual != '>') {
                hacerBacktracking(pos);
                return false;
            } else {
                lexema += caracterActual;
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_INCREMENTO);
                darSiguienteCaracter();
            }

        }

        return true;
    }

    /*
    * Metodo que verifica si el lexema es un operador de decremento
     */
    public boolean esOperadorDecremento() {

        if (caracterActual != '-') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == '-') {
            lexema += caracterActual;
            darSiguienteCaracter();

            if (caracterActual != '<') {
                hacerBacktracking(pos);
                return false;
            } else {
                lexema += caracterActual;
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_DECREMENTO);
                darSiguienteCaracter();
            }

        }
        return true;
    }

    /*
    * Metodo que verifica si el lexema es un punto
     */
    public boolean esPunto() {

        if (caracterActual != '_') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        lexema += caracterActual;
        almacenarSimbolo(lexema, fila, columna, Categoria.PUNTO);
        darSiguienteCaracter();

        return true;
    }

    /*
    *Metodo que verifica si el caracter a analizar en un operador de asignacion
     */
    public boolean esOperadorAsignacion() {

        if (!(caracterActual == ':' || caracterActual == '+'
                || caracterActual == '*' || caracterActual == '/'
                || caracterActual == '-' || caracterActual == '%')) {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == ':') {
            lexema += caracterActual;
            darSiguienteCaracter();
            //BT
            if (caracterActual == ':') {
                hacerBacktracking(pos);
                return false;
            } else {
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_ASIGNACION);
                darSiguienteCaracter();
            }

        } else if (caracterActual == '+'
                || caracterActual == '*' || caracterActual == '/'
                || caracterActual == '-' || caracterActual == '%') {

            darSiguienteCaracter();

            if (caracterActual == ':') {
                lexema += caracterActual;
                almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_ASIGNACION);
                darSiguienteCaracter();
            } else {
                hacerBacktracking(pos);
                return false;
            }

        }

        return true;
    }

    /*
    *Metodo que verifica si el lexema que se analiza es un operador aritmetrico
     */
    public boolean esOperadorAritmetico() {

        if (!(caracterActual == '+' || caracterActual == '*' || caracterActual == '/'
                || caracterActual == '-' || caracterActual == '%')) {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        lexema += caracterActual;
        darSiguienteCaracter();

        if (caracterActual == ':' || caracterActual == '<' || caracterActual == '>') {
            hacerBacktracking(pos);
            return false;
        }
        almacenarSimbolo(lexema, fila, columna, Categoria.OPERADOR_ARITMETICO);
        return true;
    }

    /*
	 * Metodo encargado de indicar si lo que se esta analizando es o no un
	 * comentario de bloque
     */
    public boolean esComentarioLinea() {

        if (caracterActual != '#') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        lexema += caracterActual;
        darSiguienteCaracter();

        while (caracterActual != '\n' && caracterActual != finCodigo) {

            lexema += caracterActual;
            darSiguienteCaracter();
        }
        almacenarSimbolo(lexema, fila, columna, Categoria.COMENTARIO_LINEA);
        return true;
    }

    /*
    *Metodo encargado de indicar si lo que se esta analizando es o no un
    *arreglo
     */
    public boolean esArreglo() {

        if (caracterActual != '[') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == '[') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'a') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 'r') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'r') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'e') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'g') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'l') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 'o') {
                                        lexema += caracterActual;
                                        darSiguienteCaracter();
                                        if (caracterActual == ']') {
                                            lexema += caracterActual;
                                            System.out.println(lexema);
                                            if (lexema.equals("[arreglo]")) {
                                                almacenarSimbolo(lexema, fila, columna, Categoria.ARREGLO);
                                                darSiguienteCaracter();
                                            } else {
                                                reportarError(lexema, fila, columna, Categoria.ARREGLO);
                                            }

                                        } else {
                                            reportarError(lexema, fila, columna, Categoria.ARREGLO);
                                        }

                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.ARREGLO);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.ARREGLO);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.ARREGLO);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.ARREGLO);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.ARREGLO);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.ARREGLO);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.ARREGLO);
            }

        }

        return false;
    }

    /*
	 * Metodo encargado de indicar si lo que se esta analizando es o no un
	 * comentario de linea
     */
    public boolean esComentarioBloque() {
        //RI
        if (caracterActual != '$') {
            return false;
        }
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        lexema += caracterActual;
        darSiguienteCaracter();

        if (caracterActual == '$') {
            lexema += caracterActual;
            darSiguienteCaracter();
            while (!(caracterActual == '$' || caracterActual == finCodigo)) {

                if (caracterActual == ':') {

                    darSiguienteCaracter();
                    if (caracterActual == '$') {
                        lexema += caracterActual;

                    }
                }
                lexema += caracterActual;
                darSiguienteCaracter();

            }

            if (caracterActual == '$') {

                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == '$') {
                    lexema += caracterActual;
                    almacenarSimbolo(lexema, fila, columna, Categoria.COMENTARIO_BLOQUE);
                    darSiguienteCaracter();
                    return true;
                } else {

                    reportarError(lexema, fila, columna, Categoria.COMENTARIO_BLOQUE);
                    darSiguienteCaracter();
                }

            } else {

                reportarError(lexema, fila, columna, Categoria.COMENTARIO_BLOQUE);

            }
        } else {

            reportarError(lexema, fila, columna, Categoria.COMENTARIO_BLOQUE);

        }

        return true;
    }

    /*
    * Metodo encargado de indicar si lo que se esta analizando es un separador
     */
    public boolean esSeparador() {

        //RI
        if (!(caracterActual == ',' || caracterActual == ';')) {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;

        lexema += caracterActual;
        almacenarSimbolo(lexema, fila, columna, Categoria.SEPARADOR);
        darSiguienteCaracter();

        return true;
    }

    //Metodo que indica si un lexema es desconocido
    public boolean esDesconocido() {

        String lexema = "";
        int fila = filActual;
        int columna = colActual;

        if (caracterActual == 0) {
            return false;
        } else {
            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, columna, Categoria.DESCONOCIDO);
            darSiguienteCaracter();
            return true;
        }

    }

    //Metodo que indica si un lexema es de tipo booleano
    public boolean esBoolean() {
        if (!(caracterActual == '0' || caracterActual == '1')) {

            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posActual;

        if (caracterActual == '0') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual != 'b') {
                hacerBacktracking(pos);
                return false;
            }

            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, columna, Categoria.BOOLEAN);
            darSiguienteCaracter();

        } else if (caracterActual == '1') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual != 'b') {
                hacerBacktracking(pos);
                return false;
            }

            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, columna, Categoria.BOOLEAN);
            darSiguienteCaracter();

        }
        return true;
    }

    //Metodo que indica si el lexema ingresado es una cadena
    public boolean esCadena() {
        if (caracterActual != '\'') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        lexema += caracterActual;
        darSiguienteCaracter();

        while (caracterActual != '\'' && caracterActual != '!') {

            if (caracterActual == ':') {
                lexema += caracterActual;

                darSiguienteCaracter();
                if (caracterActual == '\'') {

                }
            }
            lexema += caracterActual;
            darSiguienteCaracter();

        }

        if (caracterActual == '\'') {
            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, columna, Categoria.CADENA_CARACTERES);
            darSiguienteCaracter();

        } else {
            lexema += caracterActual;
            reportarError(lexema, fila, columna, Categoria.CADENA_CARACTERES);
            darSiguienteCaracter();
        }

        return true;
    }

    //Metodo que indica si el lexema ingresado es un caracter
    public boolean esCaracter() {
        if (caracterActual != '\"') {
            return false;
        }

        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        lexema += caracterActual;
        darSiguienteCaracter();
        if (caracterActual != '\"') {
            if (caracterActual == ':') {

                darSiguienteCaracter();
                if (caracterActual == '\"') {
                    lexema += caracterActual;

                }
            }
            lexema += caracterActual;
            darSiguienteCaracter();
        }

        if (caracterActual == '\"') {
            lexema += caracterActual;
            almacenarSimbolo(lexema, fila, columna, Categoria.CARACTER);
            darSiguienteCaracter();

        } else {

            reportarError(lexema, fila, columna, Categoria.CARACTER);

        }

        return true;
    }

    public boolean esTipoEntero() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;
        if (caracterActual == 'e') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'n') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 't') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'e') {
                        lexema += caracterActual;
                        darSiguienteCaracter();

                        if (caracterActual == 'r') {
                            lexema += caracterActual;
                            darSiguienteCaracter();

                            if (caracterActual == 'o') {

                                lexema += caracterActual;
                                almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_ENTERO);
                                darSiguienteCaracter();
                            } else {
                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_ENTERO);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_ENTERO);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_ENTERO);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_ENTERO);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_ENTERO);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean esTipoDoble() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;
        if (caracterActual == 'd') {
            lexema += caracterActual;
            darSiguienteCaracter();

            if (caracterActual == 'o') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 'b') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'l') {
                        lexema += caracterActual;
                        darSiguienteCaracter();

                        if (caracterActual == 'e') {

                            lexema += caracterActual;
                            almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_DOBLE);
                            darSiguienteCaracter();
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_DOBLE);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_DOBLE);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_DOBLE);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_DOBLE);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean esTipoCadena() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'c') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'a') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 'd') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'e') {
                        lexema += caracterActual;
                        System.out.println("" + caracterActual);
                        darSiguienteCaracter();
                        if (caracterActual == 'n') {
                            lexema += caracterActual;
                            darSiguienteCaracter();

                            if (caracterActual == 'a') {
                                lexema += caracterActual;
                                almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_CADENA);
                                darSiguienteCaracter();

                            } else {
                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CADENA);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CADENA);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CADENA);
                    }
                } else {
                    hacerBacktracking(pos);
                    return false;
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CADENA);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean esPalabraReservadaHacer() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'h') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'a') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 'c') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'e') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'r') {
                            lexema += caracterActual;
                            almacenarSimbolo(lexema, fila, columna, Categoria.PALABRA_RESERVADA_HACER);
                            darSiguienteCaracter();

                        } else {
                            reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA_HACER);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA_HACER);
                    }
                } else {
                    hacerBacktracking(pos);
                    return false;
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.PALABRA_RESERVADA_HACER);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean esTipoCaracter() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'c') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'a') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 'r') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'a') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'c') {
                            lexema += caracterActual;
                            darSiguienteCaracter();

                            if (caracterActual == 't') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'e') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();

                                    if (caracterActual == 'r') {

                                        lexema += caracterActual;
                                        System.out.println("ntro: " + lexema);
                                        almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                        darSiguienteCaracter();

                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                    }
                } else {

                    hacerBacktracking(pos);
                    return false;
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
            }
        } else {
            return false;
        }
        return true;

    }

    public boolean esCicloMientrasInicio() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'M') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'i') {
                lexema += caracterActual;
                darSiguienteCaracter();
                if (caracterActual == 'e') {
                    lexema += caracterActual;
                    darSiguienteCaracter();
                    if (caracterActual == 'n') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 't') {
                            lexema += caracterActual;
                            darSiguienteCaracter();
                            if (caracterActual == 'r') {
                                lexema += caracterActual;
                                darSiguienteCaracter();
                                if (caracterActual == 'a') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 's') {
                                        lexema += caracterActual;
                                        almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                        darSiguienteCaracter();
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                }
                            } else {
                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                    }
                } else {
                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                }
            } else {
                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
            }
        } else {
            return false;
        }
        return true;

    }

    public boolean esCicloMientrasFin() {
        String lexema = "";
        int fila = filActual;
        int columna = colActual;
        int pos = posInicial;

        if (caracterActual == 'F') {
            lexema += caracterActual;
            darSiguienteCaracter();
            if (caracterActual == 'i') {
                lexema += caracterActual;
                darSiguienteCaracter();

                if (caracterActual == 'n') {
                    lexema += caracterActual;
                    darSiguienteCaracter();

                    if (caracterActual == 'M') {
                        lexema += caracterActual;
                        darSiguienteCaracter();
                        if (caracterActual == 'i') {
                            lexema += caracterActual;
                            darSiguienteCaracter();

                            if (caracterActual == 'e') {
                                lexema += caracterActual;
                                darSiguienteCaracter();

                                if (caracterActual == 'n') {
                                    lexema += caracterActual;
                                    darSiguienteCaracter();
                                    if (caracterActual == 't') {
                                        lexema += caracterActual;
                                        darSiguienteCaracter();

                                        if (caracterActual == 'r') {
                                            lexema += caracterActual;
                                            darSiguienteCaracter();
                                            if (caracterActual == 'a') {
                                                lexema += caracterActual;
                                                darSiguienteCaracter();
                                                if (caracterActual == 's') {
                                                    lexema += caracterActual;
                                                    almacenarSimbolo(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                                    darSiguienteCaracter();
                                                } else {
                                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                                }
                                            } else {
                                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                            }
                                        } else {
                                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                        }
                                    } else {
                                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                    }
                                } else {
                                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                                }
                            } else {

                                reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                            }
                        } else {
                            reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                        }
                    } else {
                        reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                    }

                } else {
                    reportarError(lexema, fila, columna, Categoria.TIPO_DATO_CARACTER);
                }

            } else {
                hacerBacktracking(posInicial);
                darSiguienteCaracter();
            }

        } else {
            return false;
        }
        return true;
    }

    /*
	 * Metodo que se encarga de reportar los errores que encuentra en el analisis
	 * del lexema
     */
    public void reportarError(String lexema, int fila, int columna, Categoria categoria) {
        tablaErrores.add(new Token(lexema, categoria, fila, columna));

    }

    /*
	 * Metodo para almacenar los simbolos que reconozca e indicar respectivamente
	 * que tipo de lexema son y su categoria.
     */
    public void almacenarSimbolo(String lexema, int fila, int columna, Categoria categoria) {
        tablaSimbolos.add(new Token(lexema, categoria, fila, columna));
    }

    public ArrayList<Token> getTablaSimbolos() {
        return tablaSimbolos;
    }

    public void setTablaSimbolos(ArrayList<Token> tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public ArrayList<Token> getTablaErrores() {
        return tablaErrores;
    }

    public void setTablaErrores(ArrayList<Token> tablaErrores) {
        this.tablaErrores = tablaErrores;
    }

}
