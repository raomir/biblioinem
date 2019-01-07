/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raomir
 */
public class Conexion {
    
    public  Connection getConexion(){
        
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/biblioinem";
        String usu = "root";
        String contra = "";
                
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url,usu,contra);
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"errorhola" + e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error  " + ex);
        }
    return conexion;

    }
    
}
