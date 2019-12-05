/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import reportes.Reporte;

/**
 *
 * @author Raomir
 */
public class Lista extends javax.swing.JPanel {

    /**
     * Creates new form Lista
     */
    
    Sentencias s = new Sentencias();
    Opciones op = new Opciones();
    public Lista() {
        initComponents();
        tablaPrestamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        limpiaCampos();
    }
    
    void limpiaCampos() {
        if (tablaPrestamos.getSelectedRow() > -1) {
            tablaPrestamos.removeRowSelectionInterval(tablaPrestamos.getSelectedRow(), tablaPrestamos.getSelectedRow());
        }
        op.listarPersonal("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelsSlider1 = new rojeru_san.RSPanelsSlider();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        btnNuevoPrestamo = new rojeru_san.RSButtonRiple();
        btnDevolverPrestamo = new rojeru_san.RSButtonRiple();
        txtBuscar = new rojeru_san.RSMTextFull();
        btnNuevoPrestamo1 = new rojeru_san.RSButtonRiple();

        setPreferredSize(new java.awt.Dimension(620, 440));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelsSlider1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Prestamos de libros");
        rSPanelsSlider1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 320, 60));

        jPanel1.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 80));

        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPrestamo", "Nombres", "Apellidos", "Identificación", "Libro", "Fecha solicitud", "Fecha devolución", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaPrestamos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1050, 380));

        btnNuevoPrestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        btnNuevoPrestamo.setText("Nuevo");
        btnNuevoPrestamo.setColorHover(new java.awt.Color(255, 255, 255));
        btnNuevoPrestamo.setColorTextHover(new java.awt.Color(0, 112, 192));
        btnNuevoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPrestamoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        btnDevolverPrestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        btnDevolverPrestamo.setText("Devolver prestamo");
        btnDevolverPrestamo.setColorHover(new java.awt.Color(255, 255, 255));
        btnDevolverPrestamo.setColorTextHover(new java.awt.Color(0, 112, 192));
        btnDevolverPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverPrestamoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDevolverPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 140, -1));

        txtBuscar.setPlaceholder("Buscar prestamo...");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, -1));

        btnNuevoPrestamo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        btnNuevoPrestamo1.setText("Reporte");
        btnNuevoPrestamo1.setColorHover(new java.awt.Color(255, 255, 255));
        btnNuevoPrestamo1.setColorTextHover(new java.awt.Color(0, 112, 192));
        btnNuevoPrestamo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPrestamo1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoPrestamo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 140, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPrestamoActionPerformed
        Nuevo obj = new Nuevo();
        obj.setVisible(true);
    }//GEN-LAST:event_btnNuevoPrestamoActionPerformed
    public void devolver(){
        if (tablaPrestamos.getRowCount() > 0) {
            if (tablaPrestamos.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this, "Esta a punto de devolver un libro.\n¿Desea continuar?", "Devolución de Prestamo", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource(""))) == JOptionPane.YES_OPTION) {
                    int fila = tablaPrestamos.getSelectedRow();
                    s.setIdPrestamo(tablaPrestamos.getValueAt(fila, 0).toString());
                    s.setNombres(tablaPrestamos.getValueAt(fila, 4).toString());
                    System.out.println(s.getIdPrestamo());
                    int elimina = op.devolverPrestamo();
                    if (elimina != 0) {
                        limpiaCampos();
                        JOptionPane.showMessageDialog(this, "Registro devuelto.", "Devolución de Prestamo", 0,
                                  new ImageIcon(getClass().getResource("")));
                        
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un registro.", "Devolución de Prestamo", 0,
                        new ImageIcon(getClass().getResource("")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "No hay registros\npara eliminar.", "Registro Ventas", 0,
                    new ImageIcon(getClass().getResource("")));
        }
    }
    private void btnDevolverPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverPrestamoActionPerformed
        devolver();
    }//GEN-LAST:event_btnDevolverPrestamoActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        txtBuscar.setText(txtBuscar.getText().toUpperCase());
        op.listarPersonal(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnNuevoPrestamo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPrestamo1ActionPerformed
        Reporte reporte = new Reporte();
        reporte.mostrarReporte();
    }//GEN-LAST:event_btnNuevoPrestamo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnDevolverPrestamo;
    private rojeru_san.RSButtonRiple btnNuevoPrestamo;
    private rojeru_san.RSButtonRiple btnNuevoPrestamo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSPanelsSlider rSPanelsSlider1;
    protected static javax.swing.JTable tablaPrestamos;
    private rojeru_san.RSMTextFull txtBuscar;
    // End of variables declaration//GEN-END:variables
}
