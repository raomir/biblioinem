/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema;

/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String idTema;
    private static String nombreTema;
    
    String listar = "SELECT * FROM tema";
            
    String registrarTema = "INSERT INTO tema(nombre) VALUES(?)";
    
    String actualizarTema = "UPDATE tema SET "
            + "nombre = ? "
            + "WHERE idTema=?";
    
    String eliminar = "DELETE FROM libro"
            + " WHERE tema = ?";
    
    String eliminarTema = "DELETE FROM tema"
            + " WHERE idTema = ?";

    public String getIdTema() {
        return idTema;
    }

    public void setIdTema(String idTema) {
        this.idTema = idTema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

}
