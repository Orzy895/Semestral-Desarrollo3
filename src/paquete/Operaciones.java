package paquete;

import java.sql.*;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Operaciones {
    private Statement stmt;
    private ResultSet recordset;

    // Metodo para retornar el catalogo de libros con sus atributos
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

    // Metodo para retornar una lista de todos los usuarios con su codigo, nombre y apellido
    public LinkedList<Usuario> lista_usuarios(Conexion obj1) throws Exception {
        Connection cnn = null;
        LinkedList<Usuario> lista_usuario = new LinkedList<Usuario>();
        try {
            cnn = obj1.conectar();
            stmt = cnn.createStatement();
            recordset = stmt.executeQuery("SELECT * from Usuarios");
            while (recordset.next()) {
                Usuario item = new Usuario();
                item.setIdUsuario(recordset.getInt("idUsuario"));
                item.setNombre(recordset.getString("nombre"));
                item.setApellido(recordset.getString("apellido"));
                lista_usuario.add(item);
            }
            cnn.close();
            return lista_usuario;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de usuarios: "+e);
        }
    }

    // Metodo para retornar el catalogo de libros filtrado por un interes del usuario
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
            }
            cnn.close();
            return lista_libro;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de catalogo filtrado: " + e);
        }
    }

    // Metodo para registrar un nuevo usuario en la base de datos
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
            throw new Exception("Error en el registro de usuario: "+e);
        }
    }

    // Metodo para revisar la disponibilidad de un libro (retorna cierto o falso)
    public boolean Disponible(int idLibro, Conexion obj1) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        try {
            String sql = "SELECT cantdisponible FROM Libros WHERE idLibro = ?";
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setInt(1, idLibro);
            recordset = stmt.executeQuery();
            if (recordset.next()) {
                int a = recordset.getInt("cantdisponible");
                if (a > 0) {
                    return true;
                } else {
                    return false;
                }
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de disponibilidad: " + e);
        }
    }

    // Metodo para registrar prestamos de los usuarios en la base de datos
    public void registrar_prestamo(int idLibro, int idUsuario, Conexion obj1) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        PreparedStatement insert;
        PreparedStatement insert2;
        Date fechaPrestamo = java.sql.Date.valueOf(LocalDate.now());
        Date fechaDevolucion = java.sql.Date.valueOf(LocalDate.now().plusDays(7));
        try {
            String sql = "Insert into Prestamos(idLibros, idUsuarios, fechaPrestamo, fechaDevolucion, Devuelto) values(?,?,?,?,?)";
            insert = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insert.setInt(1, idLibro);
            insert.setInt(2, idUsuario);
            insert.setDate(3, fechaPrestamo);
            insert.setDate(4, fechaDevolucion);
            insert.setString(5, "No");
            insert.executeUpdate();
            //Instruccion sql para actualizar la cantidad de libros disponibles (-1)
            String sql2 = "Update Libros set cantdisponible = cantdisponible - 1 where idLibro = ?";
            insert2 = cnn.prepareStatement(sql2);
            insert2.setInt(1, idLibro);
            insert2.executeUpdate();
            ResultSet idPrestamo = insert.getGeneratedKeys();
            idPrestamo.close();
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en el registro de prestamo: "+e);
        }
    }

    // Metodo para revisar la cantidad de prestamos existentes
    public int cantPrestamo(Conexion obj1) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        try {
            String sql = "Select count(*) from Prestamos";
            ResultSet prestamos = stmt.executeQuery(sql);
            if (prestamos.next()) {
                int a = prestamos.getInt(1);
                cnn.close();
                return a;
            } else {
                cnn.close();
                return 0;
            }
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de prestamos existentes: "+e);
        }
    }

    // Metodo para ver los libros más populares(más prestado, solo retorna el nombre del libro)
    public LinkedList<String> librosPopulares(Conexion obj1) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        LinkedList<String> libros = new LinkedList<String>();
        try {
            recordset = stmt.executeQuery(
                    "select l.titulo from Libros l join Prestamos p on l.idLibro = p.idLibros group by p.idLibros, l.titulo order by count(*) desc");
            while (recordset.next()) {
                libros.add(recordset.getString("titulo"));
            }
            cnn.close();
            return libros;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de libros populares: "+e);
        }
    }

    // Metodo para obtener la cantidad de prestamos realizados que tiene cada usuario
    public LinkedList<Usuario> usuariosPrestamos(Conexion obj1) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        try {
            recordset = stmt.executeQuery(
                    "select u.nombre, u.apellido, u.idUsuario, count(p.idUsuarios) as contador from Usuarios u join Prestamos p on u.idUsuario = p.idUsuarios group by u.idUsuario, u.nombre, u.apellido order by contador desc");
            while (recordset.next()) {
                Usuario item = new Usuario();
                item.setIdUsuario(recordset.getInt("idUsuario"));
                item.setNombre(recordset.getString("nombre"));
                item.setApellido(recordset.getString("apellido"));
                item.setContador(recordset.getInt("contador"));
                usuarios.add(item);
            }
            cnn.close();
            return usuarios;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de la cantidad de prestamos por usuarios= "+e);
        }
    }

    // Metodo para registrar la devolucion de un prestamo
    public void registrar_devolucion(Conexion obj1, int idPrestamo, String titulo) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        PreparedStatement insert;
        PreparedStatement insert2;
        try {
            String sql = "Update Prestamos set Devuelto = 'Si' where idPrestamo = ?";
            insert = cnn.prepareStatement(sql);
            insert.setInt(1, idPrestamo);
            insert.executeUpdate();
            //Instruccion sql para actualizar la cantidad de libros disponibles de un titulo(+1)
            String sql2 = "Update Libros set cantdisponible = cantdisponible + 1 where titulo = ?";
            insert2 = cnn.prepareStatement(sql2);
            insert2.setString(1, titulo);
            insert2.executeUpdate();
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en el registro de devolucion = "+e);
        }
    }

    // Metodo para verificar la si un libro ya ha sido devuelto
    public boolean devuelto_verificacion(Conexion obj1, int idPrestamo) throws Exception {
        Connection cnn = null;
        cnn = obj1.conectar();
        stmt = cnn.createStatement();
        try {
            String sql = "Select Devuelto from Prestamos where idPrestamo = ?";
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setInt(1, idPrestamo);
            recordset = stmt.executeQuery();
            if (recordset.next()) {
                String devuelto = recordset.getString("Devuelto");
                if (devuelto.equalsIgnoreCase("Si")) {
                    cnn.close();
                    return true;
                } else {
                    cnn.close();
                    return false;
                }
            } else {
                cnn.close();
                throw new Exception("No existe dicho prestamo");
            }
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la verififacion de prestamo = "+e);
        }
    }

    // Metodo que retorna los prestamos que no han sido devueltos
    public LinkedList<PrestamoUsuarioLibro> Prestamos(Conexion obj1) throws Exception {
        Connection cnn = null;
        LinkedList<PrestamoUsuarioLibro> lista_prestamo = new LinkedList<PrestamoUsuarioLibro>();
        try {
            cnn = obj1.conectar();
            stmt = cnn.createStatement();
            recordset = stmt.executeQuery(
                    "SELECT * from Prestamos p join Usuarios u on p.idUsuarios = u.idUsuario join Libros l on p.idLibros = l.idLibro where Devuelto = 'No'");
            while (recordset.next()) {
                PrestamoUsuarioLibro item = new PrestamoUsuarioLibro();
                item.setIdPrestamo(recordset.getInt("idPrestamo"));
                item.setNombre(recordset.getString("nombre"));
                item.setApellido(recordset.getString("apellido"));
                item.setTitulo(recordset.getString("titulo"));
                lista_prestamo.add(item);
            }
            cnn.close();
            return lista_prestamo;
        } catch (SQLException e) {
            cnn.close();
            throw new Exception("Error en la consulta de Prestamos: " + e);
        }
    }
}