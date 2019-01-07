/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante;

import prestamo.*;
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

/**
 *
 * @author Raomir
 */
public class Opciones {
    
    static Conexion cc = new Conexion();
    static Connection cn = cc.getConexion();
    static PreparedStatement ps;
    Sentencias s = new Sentencias();
    
    public static void listarEstudiante(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaEstudiantes.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = "";
        
        if (busca.equals("")) {
            sql = Sentencias.listar;
        } else {
            sql = "SELECT * FROM estudiante WHERE (nombres like'" + busca + "%' or apellidos like'" + busca + "%')"
                    + " or documento ='" + busca + "'";

        }
         String datos[] = new String[7];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idEstudiante");
                datos[1] = rs.getString("nombres");
                datos[2] = rs.getString("apellidos");
                datos[3] = rs.getString("documento");
                datos[4] = rs.getString("direccion");
                datos[5] = rs.getString("telefono");
                datos[6] = rs.getString("seccion");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public int ingresarEstudiante(){
        int rsu = 0;
        String sql = s.registrarEstudiante;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombres());
            ps.setString(2, s.getApellidos());
            ps.setString(3, s.getDocumento());
            ps.setString(4, s.getDireccion());
            ps.setString(5, s.getTelefono());
            ps.setString(6, s.getSeccion());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int actualizarEstudiante(){
        int rsu = 0;
        String sql = s.actualizarEstudiante;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombres());
            ps.setString(2, s.getApellidos());
            ps.setString(3, s.getDocumento());
            ps.setString(4, s.getDireccion());
            ps.setString(5, s.getTelefono());
            ps.setString(6, s.getSeccion());
            ps.setString(7, s.getIdEstudiante());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }

    public int eliminarEstudiante(){
        int rsu = 0;
        int rsuEstudiante = 0;
        String sql = s.eliminarPrestamo;
        String sqlEstudiante = s.eliminarEstudiante;
        
        try {
            if (!s.getIdEstudiante().equals("")) {
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getIdEstudiante());
                rsu = ps.executeUpdate();
                ps = cn.prepareStatement(sqlEstudiante);
                ps.setString(1, s.getIdEstudiante());
                rsuEstudiante = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsuEstudiante;
    }
}
