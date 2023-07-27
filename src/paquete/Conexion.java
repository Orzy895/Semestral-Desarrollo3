package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection conectar() throws Exception {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "baseBiblioteca.accdb";
            return DriverManager.getConnection("jdbc:ucanaccess://" + path);
        } catch (ClassNotFoundException e) {
            throw new Exception("JDBC ERROR: "+e);
        } catch (SQLException e) {
            throw new Exception("SQL ERROR: "+e);
        }
    }
}