/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema;

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
    
    public void listarTema(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaTemas.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = null;
        
        if (busca.equals("")) {
            sql = s.listar;
        } else {
            sql = "SELECT * FROM tema WHERE (nombre like'" + busca + "%')";
        }
         String datos[] = new String[2];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idTema");
                datos[1] = rs.getString("nombre");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public int ingresarTema(){
        int rsu = 0;
        String sql = s.registrarTema;
        
        try {            
  
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreTema());
            rsu = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int actualizarTema(){
        int rsu = 0;
        String sql = s.actualizarTema;
        
        try {            
  
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreTema());
            ps.setString(2, s.getIdTema());
            rsu = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int eliminarTema(){
        int rsu = 0;
        String sql = s.eliminarTema;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getIdTema());
            rsu = ps.executeUpdate();
            if (rsu != 0) {
                sql = s.eliminarTema;
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getIdTema());
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
