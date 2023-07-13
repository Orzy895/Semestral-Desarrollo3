package paquete;
import java.sql.Date;

public class Libro {
    private String titulo, autor, genero, editorial, ISBN;
    private int idLibro, disponible;
    private Date fechaPub;

    public Date getFechaPub() {
        return this.fechaPub;
    }

    public void setFechaPub(Date fechaPub) {
        this.fechaPub = fechaPub;
    }

    public int getDisponible() {
        return this.disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getIdLibro() {
        return this.idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

}
