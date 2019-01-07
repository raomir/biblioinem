/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author Raomir
 */
public class Opciones {

    static Conexion cc = new Conexion();
    static Connection cn = cc.getConexion();

    public static void verifica(String usuario, String password, JFrame login) {
        String user = "";
        String pass = "";
        String tipo_us = "";
        try {
            String sql = "SELECT * FROM administrador WHERE usuario = '" + usuario + "' && password = '" + password + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                login.dispose();
                new menu.Principal().setVisible(true);

            } else {
                Login.lblMensaje.setText("¡Usuario y/o contraseña incorrectos!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

}
