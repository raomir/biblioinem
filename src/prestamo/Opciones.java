/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import Alertas.*;
import javax.swing.JOptionPane;
import static prestamo.Lista.tablaPrestamos;

/**
 *
 * @author Raomir
 */
public class Opciones {
    
    static Conexion cc = new Conexion();
    static Connection cn = cc.getConexion();
    static PreparedStatement ps;
    Sentencias s = new Sentencias();
    
    public String fecha(){
        
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String año = Integer.toString(c1.get(Calendar.YEAR));
        String fecha = año + "-" + mes + "-" + dia;
    
        return fecha;
    }
    
    public void listarPersonal(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaPrestamos.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        
        
        if (busca.equals("")) {
            sql = s.listar;
        } else {
            sql = "SELECT * FROM prestamo, estudiante, libro WHERE nombres like'" + busca + "%' or apellidos like'" + busca + "%' "
                    + "or documento ='" + busca + "' or titulo like'" + busca + "' "
                    + "or fechaSolicitud= '" + busca + "' GROUP BY idPrestamo ORDER BY estado = 1 ASC";

        }
         String datos[] = new String[8];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idPrestamo");
                datos[1] = rs.getString("nombres");
                datos[2] = rs.getString("apellidos");
                datos[3] = rs.getString("documento");
                datos[4] = rs.getString("titulo");
                datos[5] = rs.getString("fechaSolicitud");
                datos[6] = rs.getString("fechaDevolucion");
                int estado = rs.getInt("estado");
                
                if (estado == 0) {
                    datos[7] = "prestado";
                } else {
                    datos[7] = "devuelto";
                }
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public void ingresarEstudiante(String documento){
    
        String sql = s.setSeleccionarEstudiante(documento);
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Nuevo.txtNombres.setText(rs.getString("nombres"));
                Nuevo.txtApellidos.setText(rs.getString("apellidos"));
                Nuevo.txtSeccion.setText(rs.getString("seccion"));
            }else{
                Documento doc = new Documento();
                doc.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    public void ingresarLibro(String libro){
    
        String sql = s.setNombreLibro(libro);
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Nuevo.txtAutor.setText(rs.getString("nombreAutor"));
                Nuevo.txtPasillo.setText(rs.getString("pasillo"));
                Nuevo.txtTema.setText(rs.getString("nombre"));
                Nuevo.txtCategoria.setText(rs.getString("nombreCategoria"));
            }else{
                Libro libro1 = new Libro();
                libro1.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    public ArrayList<String> selecionarId(){
        
        ArrayList<String> id = new ArrayList<String>();
        
        try {
            String sql = "Select * from libro, estudiante WHERE documento ='"+Nuevo.txtDocumento.getText()+"' AND "
                    + "titulo = '"+Nuevo.txtLibro.getText()+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id.add("");
                id.add(rs.getString("idLibro"));
                id.add(rs.getString("idEstudiante"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }
    
    public int registroPrestamo(){
        int rsu = 0;
        int cantidad = 0;
        
        String sql = s.setSeleccionarEstudiante(s.getDocumento());
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                sql = s.setValidar(rs.getString("idEstudiante"));
                st = cn.createStatement();
                rs = st.executeQuery(sql);
                System.out.println(rs.next());
                
                if (!rs.next()) {
                    sql = s.setValidarLibro(s.getLibro());
                    st = cn.createStatement();
                    rs = st.executeQuery(sql);
                
                    if (rs.next()) {
                        sql = s.registrarPrestamo;
                        ps = cn.prepareStatement(sql);
                
                        for (int i = 1; i < selecionarId().size(); i++) {
                            ps.setString(i, selecionarId().get(i));
                            ps.setString(i, selecionarId().get(i));
                    }
                        ps.setString(3, fecha());
                        ps.setInt(4, 0);
                        rsu = ps.executeUpdate();
                        actualizarCantidadLibro();
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay suficiente cantidad de libro");
                    }
                
                } else {
                }
            } else {
                JOptionPane.showMessageDialog(null, "El documento no existe");
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        System.out.println(rsu);
        System.out.println(sql);
        return rsu;
    }
    
    public int actualizarCantidadLibro(){
        int rsu = 0;
        int a = registroPrestamo();
        String sql = s.setNombreLibro(Nuevo.txtLibro.getText());
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                s.setIdLibro(rs.getInt("idLibro"));
                s.setCantidad(rs.getInt("cantidad"));
                
                if (a == 1) {
                    int cantidad = s.getCantidad();
                    cantidad = cantidad - 1;
                    sql = s.actualizarCantidad;
                    
                    try {
                        ps = cn.prepareStatement(sql);
                        ps.setInt(1, cantidad);
                        ps.setInt(2, s.getIdLibro());
                        rsu = ps.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return rsu;
    }
    
    public int devolverPrestamo(){
        
        int rsu = 0;
        int fila = tablaPrestamos.getSelectedRow();
        String sql = s.setNombreLibro(tablaPrestamos.getValueAt(fila, 4).toString());
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                s.setIdLibro(rs.getInt("idLibro"));
                s.setCantidad(rs.getInt("cantidad"));
                
                sql = s.actualizarPrestamo;
                s.setFechaDevolucion(fecha());
                s.setEstado(1);
                
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getFechaDevolucion());
                ps.setInt(2, s.getEstado());
                ps.setString(3, s.getIdPrestamo());
                rsu = ps.executeUpdate();
            
                if (rsu != 0) {
                    int cantidad = s.getCantidad();
                    cantidad = cantidad + 1;
                    sql = s.actualizarCantidad;
                    ps = cn.prepareStatement(sql);
                    ps.setInt(1, cantidad);
                    ps.setInt(2, s.getIdLibro());
                    rsu = ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rsu;
    }
}
