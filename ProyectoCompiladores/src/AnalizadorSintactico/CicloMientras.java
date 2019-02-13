/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import java.util.ArrayList;

/**
 *
 * @author Vicky
 */
class CicloMientras {
    private SentanciaRelacional sentenciaRelacional;
    private ArrayList<Sentencia> listaSentencias;

    public CicloMientras(SentanciaRelacional sentenciaRelacional) {
        this.sentenciaRelacional = sentenciaRelacional;
    }

    public CicloMientras(ArrayList<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }
    
    
    
}
