/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoria;

/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String idCategoria;
    private static String nombreCategoria;
    
    String listar = "SELECT * FROM categoria";
            
    String registrarCategoria = "INSERT INTO categoria(nombreCategoria) VALUES(?)";
    
    String actualizarCategoria = "UPDATE categoria SET "
            + "nombreCategoria = ? "
            + "WHERE idCategoria=?";
    
    String eliminar = "DELETE * FROM libro"
            + " WHERE categoria = ?";
    
    String eliminarCategoria = "DELETE FROM categoria"
            + " WHERE idCategoria = ?";

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

}
