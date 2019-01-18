package estudiante;

import Alertas.EliminarRegistro;
import Alertas.ErrorEliminar;
import Alertas.ErrorRegistro;
import Alertas.RellenarCampos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raomir
 */
public class Eliminar extends javax.swing.JFrame {

    /**
     * Creates new form Nuevo
     */
    Sentencias s = new Sentencias();
    public Eliminar() {
        initComponents();
        this.setLocationRelativeTo(this);
        lblNombres.setText(s.getNombres());
        lblApellidos.setText(s.getApellidos());
        lblDocumento.setText(s.getDocumento());
        lblDireccion.setText(s.getDireccion());
        lblTelefono.setText(s.getTelefono());
        lblSeccion.setText(s.getSeccion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDocumento2 = new rojeru_san.RSMTextFull();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new rojeru_san.RSButton();
        btnEliminar = new rojeru_san.RSButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSeccion = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();

        txtDocumento2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDocumento2.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        txtDocumento2.setPlaceholder("Núimero de identificación");
        txtDocumento2.setSoloNumeros(true);
        txtDocumento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDocumento2KeyReleased(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 127, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 127, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 112, 192));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿Estas seguro de eliminar?");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 112, 192));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estas a punto de eliminar al siguinete estudiante:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 330, 20));

        lblNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombres.setForeground(new java.awt.Color(0, 112, 192));
        lblNombres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 120, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 112, 192));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombres: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 20));

        lblApellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(0, 112, 192));
        lblApellidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 130, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 112, 192));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Apellidos:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 60, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 112, 192));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Teléfono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, 20));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(0, 112, 192));
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 120, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 112, 192));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Dirección:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 60, 20));

        lblSeccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSeccion.setForeground(new java.awt.Color(0, 112, 192));
        lblSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 130, 20));

        lblDocumento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDocumento.setForeground(new java.awt.Color(0, 112, 192));
        lblDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 120, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 112, 192));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Documento:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 112, 192));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Sección:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 60, 20));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(0, 112, 192));
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 130, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Opciones op = new Opciones();
        int rsu = op.eliminarEstudiante();
        if (rsu == 1) {
            Opciones.listarEstudiante("");
            EliminarRegistro eli = new EliminarRegistro();
            eli.lblNombre.setText("estudianate");
            eli.setVisible(true);
            this.dispose();
        } else {
            this.dispose();
            ErrorEliminar er = new ErrorEliminar();
            er.setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDocumento2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumento2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumento2KeyReleased
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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btnCancelar;
    private rojeru_san.RSButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblSeccion;
    private javax.swing.JLabel lblTelefono;
    protected static rojeru_san.RSMTextFull txtDocumento2;
    // End of variables declaration//GEN-END:variables
}