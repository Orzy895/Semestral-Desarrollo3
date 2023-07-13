import java.util.LinkedList;
import java.text.SimpleDateFormat;

import paquete.*;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Libro> libros;
        SimpleDateFormat formato = new SimpleDateFormat("dd, MMMM, yyyy");
        Conexion obj1 = new Conexion();
        Operaciones obj2 = new Operaciones();
        try {
            obj2.registrar_prestamo(3, 2, obj1);
            /*
             * Catalogo Completo
              libros = obj2.catalogo_completo(obj1);
              for (int i = 0; i < libros.size(); i++) {
              System.out.println("idLibro: " + libros.get(i).getIdLibro()
              + "\nTitulo: " + libros.get(i).getTitulo()
              + "\nAutor: " + libros.get(i).getAutor()
              + "\nGenero: " + libros.get(i).getGenero()
              + "\nEditorial: " + libros.get(i).getEditorial()
              + "\nFecha Publicacion: " + formato.format(libros.get(i).getFechaPub())
              + "\nISBN: " + libros.get(i).getISBN()
              + "\nDisponible: " + libros.get(i).getDisponible() + "\n");
              }
             */

             /* Catalogo por Filtro 
            libros = obj2.libro_por_interes("1", obj1, "idLibro");
            if (libros.isEmpty()) {
                System.out.println("No se han encontrado ningun libro por dicho interes");
            } else {
                for (int i = 0; i < libros.size(); i++) {
                    System.out.println("idLibro: " + libros.get(i).getIdLibro()
                            + "\nTitulo: " + libros.get(i).getTitulo()
                            + "\nAutor: " + libros.get(i).getAutor()
                            + "\nGenero: " + libros.get(i).getGenero()
                            + "\nEditorial: " + libros.get(i).getEditorial()
                            + "\nFecha Publicacion: " + formato.format(libros.get(i).getFechaPub())
                            + "\nISBN: " + libros.get(i).getISBN()
                            + "\nDisponible: " + libros.get(i).getDisponible() + "\n");
                }
            }
            */
            // Registro Usuario obj2.registro_usuario( "Enrique", "Wen", "Panama",
            // "1234-1234", "enrique@test.com", obj1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}