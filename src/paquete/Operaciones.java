package paquete;

import java.sql.*;
import java.util.LinkedList;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;
import java.time.LocalDate;

public class Operaciones {
    private Statement stmt;
    private ResultSet recordset;

    public LinkedList<Libro> catalogo_completo(Conexion obj1) throws Exception {
        Connection cnn = null;
        LinkedList<Libro> lista_libro = new LinkedList<Libro>();
        try {
            cnn = obj1.conectar();
            stmt = cnn.createStatement();
            recordset = stmt.executeQuery("SELECT * from Libros");
            while (recordset.next()) {
                Libro item = new Libro();
                item.setAutor(recordset.getString("autor"));
                item.setDisponible(recordset.getInt("cantdisponible"));
                item.setEditorial(recordset.getString("editorial"));
                item.setGenero(recordset.getString("genero"));
                item.setISBN(recordset.getString("ISBN"));
                item.setIdLibro(recordset.getInt("idLibro"));
                item.setTitulo(recordset.getString("titulo"));
                item.setFechaPub(recordset.getDate("fechaPublicacion"));
                lista_libro.add(item);
            }
            cnn.close();
            return lista_libro;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta: " + e);
        }
    }

    public LinkedList<Libro> libro_por_interes(String interes, Conexion obj1, String tipo_interes) throws Exception {
        Connection cnn = null;
        LinkedList<Libro> lista_libro = new LinkedList<Libro>();
        try {
            cnn = obj1.conectar();
            stmt = cnn.createStatement();
            String sql = "SELECT * FROM Libros WHERE " + tipo_interes + " = ?";
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setString(1, interes);
            recordset = stmt.executeQuery();
            if (recordset.next()) {
                Libro lista = new Libro();
                lista.setIdLibro(recordset.getInt("idLibro"));
                lista.setTitulo(recordset.getString("titulo"));
                lista.setAutor(recordset.getString("autor"));
                lista.setISBN(recordset.getString("ISBN"));
                lista.setGenero(recordset.getString("genero"));
                lista.setEditorial(recordset.getString("editorial"));
                lista.setDisponible(recordset.getInt("cantdisponible"));
                lista.setFechaPub(recordset.getDate("fechaPublicacion"));
                lista_libro.add(lista);
            } else {
                System.out.println("no hay");
            }
            cnn.close();
            return lista_libro;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta: " + e);
        }
    }

    public void registro_usuario(String nombre, String apellido, String direccion, String telefono,
            String correo, Conexion obj1) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        PreparedStatement insert;
        try {
            String sql = "Insert into Usuarios (nombre,apellido,direccion,telefono,correoElectronico) values (?,?,?,?,?)";
            insert = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, nombre);
            insert.setString(2, apellido);
            insert.setString(3, direccion);
            insert.setString(4, telefono);
            insert.setString(5, correo);
            insert.executeUpdate();
            ResultSet idUsuario = insert.getGeneratedKeys();
            idUsuario.close();
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception(e);
        }
    }
    public void registrar_prestamo(int idLibro, int idUsuario, Conexion obj1)throws Exception{
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        PreparedStatement insert;
        PreparedStatement insert2;
        Date fechaPrestamo = java.sql.Date.valueOf(LocalDate.now());
        Date fechaDevolucion = java.sql.Date.valueOf(LocalDate.now().plusDays(7));
        try {
            String sql = "Insert into Prestamos(idLibros, idUsuarios, fechaPrestamo, fechaDevolucion, Estado) values(?,?,?,?,?)";
            insert = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insert.setInt(1, idLibro);
            insert.setInt(2, idUsuario);
            insert.setDate(3, fechaPrestamo);
            insert.setDate(4, fechaDevolucion);
            insert.setString(5, "No");
            insert.executeUpdate();
            String sql2 = "Update Libros set cantdisponible = cantdisponible - 1 where idLibro = ?";
            insert2 = cnn.prepareStatement(sql2);
            insert2.setInt(1, idLibro);
            insert2.executeUpdate();
            ResultSet idPrestamo = insert.getGeneratedKeys();
            idPrestamo.close();
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception(e);
        }
    }
    public int cantPrestamo(Conexion obj1)throws Exception{
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        try {
            String sql = "Select count(*) from Prestamos";
            ResultSet prestamos = stmt.executeQuery(sql);
            if(prestamos.next()){
                int a = prestamos.getInt(1);
                cnn.close();
                return a;
            }
            else{
                cnn.close();
                return 0;
            }
        } catch (SQLException e) {
            cnn.close();
            throw new Exception(e);
        }
    }
    public LinkedList<String> librosPopulares(Conexion obj1)throws Exception{
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        LinkedList<String> libros = new LinkedList<String>();
        try{
            recordset = stmt.executeQuery("select l.titulo from Libros l join Prestamos p on l.idLibro = p.idLibros group by p.idLibros, l.titulo order by count(*) desc");
            while(recordset.next()){
                libros.add(recordset.getString("titulo"));
            }
            cnn.close();
            return libros;
        }catch(SQLException e){
            cnn.close();
            throw new Exception(e);
        }
    }
    public LinkedList<Usuario> usuariosPrestamos(Conexion obj1)throws Exception{
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        try{
            recordset = stmt.executeQuery("select u.nombre, u.apellido, count(p.idUsuarios) as contador from Usuarios u join Prestamos p on u.idUsuario = p.idUsuarios group by u.idUsuario, u.nombre, u.apellido order by contador desc");
            while(recordset.next()){
                Usuario item = new Usuario();
                item.setNombre(recordset.getString("nombre"));
                item.setApellido(recordset.getString("apellido"));
                item.setContador(recordset.getInt("contador"));
                usuarios.add(item);
            }
            cnn.close();
            return usuarios;
        }catch(SQLException e){
            cnn.close();
            throw new Exception(e);
        }
    }
}