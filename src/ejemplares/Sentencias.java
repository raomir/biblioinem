/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplares;

/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String idEjemplar;
    private static String nombreEdicion;
    private static String nombrePasillo;
    
    String listar = "SELECT * FROM ejemplar";
            
    String registrarEjemplar = "INSERT INTO ejemplar(edicion, pasillo) VALUES(?,?)";
    
    String actualizarEjemplar = "UPDATE ejemplar SET "
            + "edicion = ?, "
            + "pasillo = ? "
            + "WHERE idUbicacion=?";
    
    String eliminar = "DELETE ubicacion FROM libro"
            + " WHERE ubicacion = ?";
    
    String eliminarEjemplar = "DELETE FROM ejemplar"
            + " WHERE idUbicacion = ?";

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getNombreEdicion() {
        return nombreEdicion;
    }

    public void setNombreEdicion(String nombreEdicion) {
        this.nombreEdicion = nombreEdicion;
    }

    public String getNombrePasillo() {
        return nombrePasillo;
    }

    public void setNombrePasillo(String nombrePasillo) {
        this.nombrePasillo = nombrePasillo;
    }

}
