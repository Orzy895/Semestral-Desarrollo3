import java.util.LinkedList;
import java.text.SimpleDateFormat;

import paquete.*;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Libro> libros;
        LinkedList<String> librosPopu;
        LinkedList<Usuario> usuarios;
        SimpleDateFormat formato = new SimpleDateFormat("dd, MMMM, yyyy");
        Conexion obj1 = new Conexion();
        Operaciones obj2 = new Operaciones();
        try {
            usuarios=obj2.usuariosPrestamos(obj1);
            for(int i = 0; i <usuarios.size(); i++){
            System.out.println((i+1)+".\nNombre :"+usuarios.get(i).getNombre()
                                    +"\nApellido :"+usuarios.get(i).getApellido()
                                    +"\nCantidad Prestamos: "+usuarios.get(i).getContador());
            }
            /*librosPopu=obj2.librosPopulares(obj1);
            System.out.println("Libros populares:");
            for(int i = 0; i <librosPopu.size(); i++){
            System.out.println((i+1)+". "+librosPopu.get(i));
            }
            */
            //obj2.registrar_prestamo(3, 2, obj1);
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