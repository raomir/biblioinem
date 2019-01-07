/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiante;
/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String idEstudiante;
    private static String nombres;
    private static String apellidos;
    private static String documento;
    private static String direccion;
    private static String telefono;
    private static String seccion;
    
    static String listar = "SELECT * FROM estudiante";
    
    String registrarEstudiante = "INSERT INTO estudiante(nombres, apellidos, documento, direccion, telefono, seccion) "
            + "VALUES(?,?,?,?,?,?)";
    
    String actualizarEstudiante = "UPDATE estudiante SET "
            + "nombres = ?, "
            + "apellidos = ?, "
            + "documento = ?, "
            + "direccion = ?, "
            + "telefono = ?, "
            + "seccion = ? "
            + "WHERE idEstudiante=?";
    
    String eliminarPrestamo = "DELETE FROM prestamo WHERE estudiante = ?";
    
    String eliminarEstudiante = "DELETE FROM estudiante WHERE idEstudiante = ?";

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        Sentencias.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        Sentencias.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Sentencias.telefono = telefono;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        Sentencias.seccion = seccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
   
 
}
