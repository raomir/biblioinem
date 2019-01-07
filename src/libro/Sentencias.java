/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

/**
 *
 * @author Raomir
 */
public class Sentencias{
    
    private static String idLibro;
    private static String titulo;
    private static String autor;
    private static String tema;
    private static String editorial;
    private static String idioma;
    private static String categoría;
    private static String pasillo;
    private static String nombreAutor;
    private static String nombreTema;
    private static String edicion;
    private static Double cantidad;
    
    String listar = "SELECT * FROM libro, autor, ejemplar, tema, categoria "
            + "WHERE autor = idAutor "
            + "AND tema = idTema "
            + "AND ubicacion = idUbicacion "
            + "AND categoria = idCategoria";
            
    String registrarAutor = "INSERT INTO autor(nombreAutor) VALUES(?)";
    
    String registrarTema = "INSERT INTO tema(nombre) VALUES(?)";
    
    String registrarEjemplar = "INSERT INTO ejemplar(edicion, pasillo) VALUES(?,?)";
    
    String registrarLibro = "INSERT INTO libro(editorial, autor, tema, ubicacion, titulo, idioma, categoria, cantidad)"
            + " VALUES(?,?,?,?,?,?,?,?)";
    
    String actualizarLibro = "UPDATE libro SET "
            + "editorial = ?, "
            + "autor = ?, "
            + "tema = ?, "
            + "ubicacion = ?, "
            + "titulo = ?, "
            + "idioma = ?, "
            + "categoria = ?, "
            + "cantidad = ? "
            + "WHERE idLibro=?";
    
    String eliminarLibro = "DELETE FROM libro WHERE idLibro = ?";
    
    public String buscar(String tabla){
        return "SELECT * FROM "+ tabla +"";
    }

    public String getNombreAutor() {
        System.out.println(nombreAutor + nombreTema + edicion + pasillo);
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
    
    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        Sentencias.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        Sentencias.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        Sentencias.autor = autor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        Sentencias.tema = tema;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        Sentencias.editorial = editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        Sentencias.idioma = idioma;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        Sentencias.categoría = categoría;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        Sentencias.pasillo = pasillo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
