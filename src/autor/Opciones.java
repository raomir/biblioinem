/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autor;

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
    
    public void listarAutor(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaAutores.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = null;
        
        if (busca.equals("")) {
            sql = s.listar;
        } else {
            sql = "SELECT * FROM autor WHERE (nombreAutor like'" + busca + "%')";
        }
         String datos[] = new String[2];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idAutor");
                datos[1] = rs.getString("nombreAutor");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public int ingresarAutor(){
        int rsu = 0;
        String sql = s.registrarAutor;
        
        try {            
  
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreAutor());
            rsu = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int actualizarAutor(){
        int rsu = 0;
        String sql = s.actualizarLibro;
        
        try {            
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreAutor());
            ps.setString(2, s.getIdAutor());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int eliminarAutor(){
        int rsu = 0;
        String sql = s.eliminar;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getIdAutor());
            rsu = ps.executeUpdate();
            if (rsu != 0) {
                sql = s.eliminarLibro;
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getIdAutor());
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
