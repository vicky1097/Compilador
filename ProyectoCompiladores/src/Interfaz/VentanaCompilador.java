/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import AnalizadorLexico.AnalizadorLexico;
import AnalizadorSintactico.AnalizadorSintactico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Vicky
 */
public class VentanaCompilador extends javax.swing.JFrame {

    //Instancia de la clase donde se encuentra el analizador lexico
    private AnalizadorLexico analizador;
    //Instancia de la clase donde se encuentra el analizador sintactico
    private AnalizadorSintactico analizadorSin;
    //Variable que manejará las filas de la tabla de tokens
    int contador = 0;
    //Variable que manejará las filas de la tabla de errores
    int contador1 = 0;

    /**
     * Creates new form VentanaCompilador
     */
    public VentanaCompilador() {

        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTokens = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaErroresLexicos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCodigoFuente = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree_ArbolVisual = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaErroresSintacticos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código fuente:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("COMPILADOR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabla de Tokens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tablaTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Categoría", "Fila", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTokens);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 680, 180));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabla de Errores Léxicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tablaErroresLexicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Categoría", "Fila", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaErroresLexicos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 680, 160));

        txtCodigoFuente.setColumns(20);
        txtCodigoFuente.setRows(5);
        txtCodigoFuente.setText("F :sumar: entero ()\nMientras 3 >>: 4 hacer\n:cadena: : 4 !\nFinMientras\nn!");
        jScrollPane3.setViewportView(txtCodigoFuente);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 66, 610, 90));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 70, -1));

        jTree_ArbolVisual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(jTree_ArbolVisual);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 310, 580));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla Errores Sintácticos"));

        tablaErroresSintacticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Error Sintáctico....................................................................................................", "Fila", "Columna"
            }
        ));
        jScrollPane5.setViewportView(tablaErroresSintacticos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 680, 140));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Árbol Visual");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if (!txtCodigoFuente.getText().equals("")) {
            analizador = new AnalizadorLexico(txtCodigoFuente.getText());
            

            analizador.Analizar();
            agregarTablaTokens();
            agregarTablaErroresLexicos();
            analizadorSin = new AnalizadorSintactico(analizador.getTablaSimbolos());
            analizadorSin.analizar();
            agregarTablaErroresSintacticos();
            
            
            
            
            jTree_ArbolVisual.setModel(new DefaultTreeModel(analizadorSin.getUnidadDeCompilacion().getArbolVisual()));
        } else {
            JOptionPane.showMessageDialog(null, "¡Debe ingresar primero código fuente!");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtCodigoFuente.setText("");
        limpiarTablaSimbolos();
        limpiarTablaErrores();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCompilador().setVisible(true);
            }
        });
    }

    //Metodo que agregará los elementos a las respectivas tablas
    public void agregarTablaTokens() {
        DefaultTableModel modelo = (DefaultTableModel) tablaTokens.getModel();

        Object[] fila = new Object[4];

        for (int i = 0; i < analizador.getTablaSimbolos().size(); i++) {
            fila[0] = analizador.getTablaSimbolos().get(i).getLexema();
            fila[1] = analizador.getTablaSimbolos().get(i).getCategoria();
            fila[2] = analizador.getTablaSimbolos().get(i).getFila();
            fila[3] = analizador.getTablaSimbolos().get(i).getColumna();

            modelo.addRow(fila);

        }
        tablaTokens.setModel(modelo);

    }

    //Metodo que borra todos los elementos de la tabla de simbolos
    public void limpiarTablaSimbolos() {

        tablaTokens.setModel(new DefaultTableModel(null, new String[]{"Lexema", "Categoría", "Fila", "Columna"}));

    }
    //Metodo que borra todos los elementos de la tabla de errores

    public void limpiarTablaErrores() {
        tablaErroresLexicos.setModel(new DefaultTableModel(null, new String[]{"Lexema", "Categoría", "Fila", "Columna"}));
    }

    //Metodo que agrega los elementos a la tabla de errores
    public void agregarTablaErroresLexicos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaErroresLexicos.getModel();

        Object[] fila = new Object[4];

        for (int i = 0; i < analizador.getTablaErrores().size(); i++) {
            fila[0] = analizador.getTablaErrores().get(i).getLexema();
            fila[1] = analizador.getTablaErrores().get(i).getCategoria();
            fila[2] = analizador.getTablaErrores().get(i).getFila();
            fila[3] = analizador.getTablaErrores().get(i).getColumna();

            modelo.addRow(fila);

        }
        tablaErroresLexicos.setModel(modelo);

    }
    
    public void agregarTablaErroresSintacticos(){
        DefaultTableModel modelo = (DefaultTableModel) tablaErroresSintacticos.getModel();

        Object[] fila = new Object[3];

        for (int i = 0; i < analizadorSin.getTablaErrores().size(); i++) {
            fila[1] = analizadorSin.getTablaErrores().get(i).getFila();
            fila[2] = analizadorSin.getTablaErrores().get(i).getColumna();
            fila[0]= analizadorSin.getTablaErrores().get(i).getMensaje();
            

            modelo.addRow(fila);

        }
        tablaErroresSintacticos.setModel(modelo);
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTree jTree_ArbolVisual;
    private javax.swing.JTable tablaErroresLexicos;
    private javax.swing.JTable tablaErroresSintacticos;
    private javax.swing.JTable tablaTokens;
    private javax.swing.JTextArea txtCodigoFuente;
    // End of variables declaration//GEN-END:variables
}
