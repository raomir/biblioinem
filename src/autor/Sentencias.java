/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autor;

/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String idAutor;
    private static String nombreAutor;
    
    String listar = "SELECT * FROM autor";
            
    String registrarAutor = "INSERT INTO autor(nombreAutor) VALUES(?)";
    
    String actualizarLibro = "UPDATE autor SET "
            + "nombreAutor = ? "
            + "WHERE idAutor=?";
    
    String eliminar = "DELETE FROM libro"
            + " WHERE autor = ?";
    
    String eliminarLibro = "DELETE FROM autor"
            + " WHERE idAutor = ?";

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
}
