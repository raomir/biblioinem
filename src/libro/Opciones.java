/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Raomir
 */
public class Opciones {
    
    static Conexion cc = new Conexion();
    static Connection cn = cc.getConexion();
    static PreparedStatement ps;
    Sentencias s = new Sentencias();
    
    public void listarLibro(String busca){
        DefaultTableModel modelo = (DefaultTableModel) Lista.tablaLibros.getModel();
       
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        String sql = null;
        
        if (busca.equals("")) {
            sql = s.listar;
        } else {
            sql = "SELECT * FROM libro, tema, autor, ejemplar, categoria WHERE (titulo like'" + busca + "%' or autor like'" + busca + "%')"
                    + " or nombre ='" + busca + "'";
        }
         String datos[] = new String[10];    
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("idLibro");
                datos[1] = rs.getString("titulo");
                datos[2] = rs.getString("nombreAutor");
                datos[3] = rs.getString("nombre");
                datos[4] = rs.getString("editorial");
                datos[5] = rs.getString("idioma");
                datos[6] = rs.getString("nombreCategoria");
                datos[7] = rs.getString("edicion");
                datos[8] = rs.getString("pasillo");
                datos[9] = rs.getString("cantidad");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   } 
 
    public int ingresarLibro(){
        int rsu = 0;
        String idAutor = "";
        String idTema = "";
        String idUbicacion = "";
        String idCategoria = "";
        
        String sql = "SELECT * FROM autor, tema, ejemplar, categoria "
            + "WHERE nombreAutor = '"+ s.getNombreAutor() +"' "
            + "AND nombre = '"+ s.getNombreTema()+"' "
            + "AND edicion = '"+ s.getEdicion() + "' "
            + "AND pasillo = '"+ s.getPasillo()+"' "
            + "AND nombreCategoria = '"+ s.getCategoría()+"'";
        
        try {            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                        
                idAutor = rs.getString("idAutor");
                idTema = rs.getString("idTema");
                idUbicacion = rs.getString("idUbicacion");
                idCategoria = rs.getString("idCategoria");
                
                sql = s.registrarLibro;
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getEditorial());
                ps.setString(2, idAutor);
                ps.setString(3, idTema);
                ps.setObject(4, idUbicacion);
                ps.setObject(5, s.getTitulo());
                ps.setObject(6, s.getIdioma());
                ps.setObject(7, idCategoria);
                ps.setObject(8, s.getCantidad());
                rsu = ps.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(s.getCantidad());
        return rsu;
    }
    
    public int actualizarLibro(){
        int rsu = 0;
        String idAutor = "";
        String idTema = "";
        String idUbicacion = "";
        String idCategoria = "";
        Double cantidad;
        
        String sql = "SELECT * FROM autor, tema, ejemplar, libro, categoria "
            + "WHERE nombreAutor = '"+ s.getNombreAutor() +"' "
            + "AND nombre = '"+ s.getNombreTema()+"' "
            + "AND edicion = '"+ s.getEdicion() + "' "
            + "AND pasillo = '"+ s.getPasillo()+"' "
            + "AND nombreCategoria = '"+ s.getCategoría()+"'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                idAutor = rs.getString("idAutor");
                idTema = rs.getString("idTema");
                idUbicacion = rs.getString("idUbicacion");
                idCategoria = rs.getString("idCategoria");
                cantidad = rs.getDouble("cantidad");
                cantidad = cantidad + s.getCantidad();
                
                sql = s.actualizarLibro;
                ps = cn.prepareStatement(sql);
                ps.setString(1, s.getEditorial());
                ps.setString(2, idAutor);
                ps.setString(3, idTema);
                ps.setObject(4, idUbicacion);
                ps.setObject(5, s.getTitulo());
                ps.setObject(6, s.getIdioma());
                ps.setObject(7, idCategoria);
                ps.setDouble(8, cantidad);
                ps.setString(9, s.getIdLibro());
                rsu = ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return rsu;
    }
    
    public int eliminarLibro(){
        int rsu = 0;
        String sql = s.eliminarLibro;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, s.getIdLibro());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rsu;
    }

    public void llenarTema(JComboBox jComboBox){
        ArrayList<String> listaTema = new ArrayList<>();
        String sql = s.buscar("tema");
            
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                listaTema.add(rs.getString("nombre"));
            }
            listaTema.stream().forEach((tema) -> {
                jComboBox.addItem(tema);
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarAutor(JComboBox jComboBox){
        ArrayList<String> listaAutor = new ArrayList<>();
        String sql = s.buscar("autor");
            
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                listaAutor.add(rs.getString("nombreAutor"));
            }
            listaAutor.stream().forEach((autor) -> {
                jComboBox.addItem(autor);
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarPasillo(JComboBox jComboBox){
        ArrayList<String> listaPasillo = new ArrayList<>();
        String sql = s.buscar("ejemplar");
            
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                listaPasillo.add(rs.getString("pasillo"));
            }
            listaPasillo.stream().forEach((pasillo) -> {
                jComboBox.addItem(pasillo);
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarEdicion(JComboBox jComboBox){
        ArrayList<String> listaEdicion = new ArrayList<>();
        String sql = s.buscar("ejemplar");

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                listaEdicion.add(rs.getString("edicion"));
            }
            listaEdicion.stream().forEach((edicion) -> {
                jComboBox.addItem(edicion);
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarCategoria(JComboBox jComboBox){
        ArrayList<String> listaCategoria = new ArrayList<>();
        String sql = s.buscar("categoria");
            
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                listaCategoria.add(rs.getString("nombreCategoria"));
            }
            listaCategoria.stream().forEach((categoria) -> {
                jComboBox.addItem(categoria);
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
