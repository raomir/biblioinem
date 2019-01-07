/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplares;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raomir
 */
public class Opciones {
    
    static Conexion cc = new Conexion();
    static Connection cn = cc.getConexion();
    static PreparedStatement ps;
    Sentencias s = new Sentencias();
    
    public void listarEjemplar(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaEjemplares.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = null;
        
        if (busca.equals("")) {
            sql = s.listar;
        } else {
            sql = "SELECT * FROM ejemplar WHERE (edicion like'" + busca + "%' or pasillo like'" + busca + "%')";
        }
         String datos[] = new String[3];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idUbicacion");
                datos[1] = rs.getString("edicion");
                datos[2] = rs.getString("pasillo");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public int ingresarEjemplar(){
        int rsu = 0;
        String sql = s.registrarEjemplar;
        
        try {            
  
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreEdicion());
            ps.setString(2, s.getNombrePasillo());
            rsu = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int actualizarEjemplar(){
        int rsu = 0;
        String sql = s.actualizarEjemplar;
        
        try {            
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreEdicion());
            ps.setString(2, s.getNombrePasillo());
            ps.setString(3, s.getIdEjemplar());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int eliminarEjemplar(){
        int rsu = 0;
        String sql = s.eliminar;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getIdEjemplar());
            rsu = ps.executeUpdate();
            if (rsu != 0) {
                sql = s.eliminarEjemplar;
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getIdEjemplar());
                rsu = ps.executeUpdate();
            } else {
                rsu = 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
}
