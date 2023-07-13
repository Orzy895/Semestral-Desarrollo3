package paquete;
import java.sql.Date;

public class Prestamo {
    private int idLibro, idPrestamo, idUsuario;
    private Date fechaPres, fechaDev;

    public Date getFechaPres() {
        return this.fechaPres;
    }

    public void setFechaPres(Date fechaPres) {
        this.fechaPres = fechaPres;
    }

    public Date getFechaDev() {
        return this.fechaDev;
    }

    public void setFechaDev(Date fechaDev) {
        this.fechaDev = fechaDev;
    }

    public int getIdLibro() {
        return this.idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdPrestamo() {
        return this.idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
