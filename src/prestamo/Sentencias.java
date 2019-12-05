/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamo;

/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String documento;
    private String nombres;
    private int idEstudiante;
    private int idLibro;
    private static String libro;
    private static String fechaDevolucion;
    private static int estado;
    private static String idPrestamo;
    private static int decision;
    private int cantidad;

    String listar = "SELECT * FROM prestamo, estudiante, libro"
            + " WHERE libro = idLibro "
            + "AND estudiante = idEstudiante ORDER BY idPrestamo DESC";
    
    String seleccionarEstudiante = "SELECT nombres FROM estudiante WHERE documento = ?";
    
    String registrarPrestamo = "INSERT INTO prestamo(libro, estudiante, fechaSolicitud, estado) "
            + "VALUES(?,?,?,?)";
    
    String actualizarCantidad = "UPDATE libro SET "
            + "cantidad = ? "
            + "WHERE idLibro = ?";
    
    String actualizarPrestamo = "UPDATE prestamo SET "
            + "fechaDevolucion=?, "
            + "estado=? "
            + "WHERE idPrestamo=?";
    
    public String setValidar(String documento){
        return "SELECT * FROM prestamo, estudiante "
                + "WHERE estudiante = '"+documento+"' "
                + "AND estado = 0";
    }
    
    public String setValidarLibro(String libro){
        return "SELECT * FROM libro "
                + "WHERE cantidad > 0 "
                + "AND titulo = '"+libro+"'";
    }
    
    public String setSeleccionarEstudiante(String documentos){
        return "SELECT * FROM estudiante WHERE documento = '"+ documentos +"'";
    }
    
    public String setNombreLibro(String libro){
        return "SELECT * FROM libro, autor, ejemplar, tema, categoria "
                + "WHERE titulo = '"+ libro +"'"
                + " AND autor = idAutor "
                + "AND ubicacion = idUbicacion "
                + "AND categoria = idCategoria ";
    }

    public String getLibro() {
        return libro;
    }

    public int getDecision() {
        return decision;
    }

    public void setDecision(int decision) {
        this.decision = decision;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getEstado() {
        return estado;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
