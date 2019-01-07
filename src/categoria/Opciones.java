/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

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
    
    public void listarCategoria(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaCategorias.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = null;
        
        if (busca.equals("")) {
            sql = s.listar;
        } else {
            sql = "SELECT * FROM categoria WHERE (nombreCategoria like'" + busca + "%')";
        }
         String datos[] = new String[2];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idCategoria");
                datos[1] = rs.getString("nombreCategoria");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public int ingresarCategoria(){
        int rsu = 0;
        String sql = s.registrarCategoria;
        
        try {            
  
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreCategoria());
            rsu = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int actualizarCategoria(){
        int rsu = 0;
        String sql = s.actualizarCategoria;
        
        try {            
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getNombreCategoria());
            ps.setString(2, s.getIdCategoria());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }
    
    public int eliminarCategoria(){
        int rsu = 0;
        String sql = s.eliminar;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getIdCategoria());
            rsu = ps.executeUpdate();
            if (rsu != 0) {
                sql = s.eliminarCategoria;
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getIdCategoria());
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
