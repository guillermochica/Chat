/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Protocolo.Protocolo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guillermo y nacho
 */
public class VentanaConversaciones extends javax.swing.JFrame {
    public static String Usuario;
    public PrintWriter out;
    /**
     * Creates new form VentanaConversaciones
     */
    public VentanaConversaciones(String login, PrintWriter output) {
        initComponents();
        Usuario = login;
        usuario.setText(Usuario);
        out = output;
        
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            onExit();
        }
        });
        
        
    }
    
    public void onExit() {
        
        //PROBLEMA: SI EL USUARIO SALE SIN HABER CERRADO LA VENTANA DE SALA EN LA QUE ESTABA->NO SE LE SACA DE LA SALA
        
        String mensaje = Protocolo.mensajeCerrarSesion(Usuario);
        out.println(mensaje);
        //this.EXIT_ON_CLOSE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioDestino = new javax.swing.JTextField();
        BotonPedirConversacion = new javax.swing.JButton();
        usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        salaConversacion = new javax.swing.JTextField();
        BotonEntrarEnSala = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonPedirConversacion.setText("Iniciar conversación");
        BotonPedirConversacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPedirConversacionActionPerformed(evt);
            }
        });

        salaConversacion.setText("salaGeneral");

        BotonEntrarEnSala.setText("Entrar en Sala");
        BotonEntrarEnSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEntrarEnSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salaConversacion)
                    .addComponent(usuarioDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonPedirConversacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonEntrarEnSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaConversacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEntrarEnSala))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPedirConversacion))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonPedirConversacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPedirConversacionActionPerformed
        
        String origen = usuario.getText();
        String destino = usuarioDestino.getText();
        
        String mensaje = Protocolo.mensajePedirConversacion(origen, destino);
        
        this.out.println(mensaje);
        System.out.println("Enviada peticion: " + mensaje );
    }//GEN-LAST:event_BotonPedirConversacionActionPerformed

    private void BotonEntrarEnSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntrarEnSalaActionPerformed
        
        String login = usuario.getText();
        String sala = salaConversacion.getText();
        
        String mensaje = Protocolo.mensajeEntrarSala(login, sala);
        out.println(mensaje);
        System.out.println("Enviada petición de entrar en sala "+sala);
        
    }//GEN-LAST:event_BotonEntrarEnSalaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEntrarEnSala;
    private javax.swing.JButton BotonPedirConversacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField salaConversacion;
    private javax.swing.JLabel usuario;
    private javax.swing.JTextField usuarioDestino;
    // End of variables declaration//GEN-END:variables
}
