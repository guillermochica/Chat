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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guillermo y nacho
 */
public class VentanaConversacion extends javax.swing.JFrame {

    /**
     * Creates new form VentanaConversacion
     */
    
    String loginOrigen;
    String loginDestino;
    Cliente cliente;
    public String respuesta;
    
    public VentanaConversacion(String usuarioOrigen, String usuarioDestino, Cliente c) {
        initComponents();
        labelUsuarios.setText(usuarioOrigen + " | " + usuarioDestino);
        loginOrigen = usuarioOrigen;
        loginDestino = usuarioDestino;
        cliente = c;
        
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            onExit();
        }
        });
        
    }

    public void onExit() {
        String mensaje = Protocolo.mensajeUsuarioAdios(loginOrigen,loginDestino);
        cliente.out.println(mensaje);
        this.dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoTextoEnviado = new javax.swing.JTextArea();
        campoTextoEnviar = new javax.swing.JTextField();
        botonEnviarTexto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelUsuarios.setText("Usuarios: ");

        campoTextoEnviado.setEditable(false);
        campoTextoEnviado.setColumns(20);
        campoTextoEnviado.setRows(5);
        jScrollPane1.setViewportView(campoTextoEnviado);

        campoTextoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoEnviarActionPerformed(evt);
            }
        });

        botonEnviarTexto.setText("Enviar");
        botonEnviarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarTextoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoTextoEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEnviarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEnviarTexto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarTextoActionPerformed
        
        String texto = campoTextoEnviar.getText();
        String mensaje = Protocolo.mensajeConversacion(loginOrigen,loginDestino,texto);
        
        if (mensaje.split("/").length == 4) {
            cliente.out.println(mensaje);
            campoTextoEnviado.append(loginOrigen + ": " + texto + "\n");
            
        }
        campoTextoEnviar.setText("");
        
        
        
    }//GEN-LAST:event_botonEnviarTextoActionPerformed

    private void campoTextoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoEnviarActionPerformed
   
    public void pegarTexto(String texto) {
        campoTextoEnviado.append(texto);
    }
        


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviarTexto;
    private javax.swing.JTextArea campoTextoEnviado;
    private javax.swing.JTextField campoTextoEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUsuarios;
    // End of variables declaration//GEN-END:variables
}
