import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import paquete.*;

public class App {
    public static void main(String[] args) {
        //Declaracion de variables a utilizar y objetos
        LinkedList<Libro> libros;
        LinkedList<String> librosPopu;
        LinkedList<Usuario> usuarios;
        LinkedList<PrestamoUsuarioLibro> prestamos;
        // Formato de fecha Dia/Mes/Año
        SimpleDateFormat formato = new SimpleDateFormat("dd, MMMM, yyyy");
        Conexion obj1 = new Conexion();
        Operaciones obj2 = new Operaciones();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int menuP;
        boolean menuPT = true;
        do {
            try {
                // Menu Principal
                System.out.println("==== Menu Principal ====");
                System.out.println("1. Menu Usuario");
                System.out.println("2. Menu Administrativo");
                System.out.println("3. Salir");
                System.out.println("Seleccione una opcion: ");
                menuP = Integer.parseInt(br.readLine());

                // Menu Usuario
                if (menuP == 1) {
                    int menuU = 0;
                    do {
                        try {
                            System.out.println("==== Menu Usuario ====");
                            System.out.println("1. Acceder catalogo");
                            System.out.println("2. Busqueda filtrado");
                            System.out.println("3. Libros populares");
                            System.out.println("4. Registrarse");
                            System.out.println("5. Salir");
                            System.out.println("Seleccione una opcion: ");
                            menuU = Integer.parseInt(br.readLine());

                        } catch (Exception e) {
                            System.out.println("Error :" + e);
                        }
                        // Catalogo
                        if (menuU == 1) {
                            libros = obj2.catalogo_completo(obj1);
                            System.out.println("------------------");
                            System.out.println("Catalogo Completo:");
                            System.out.println(
                                    "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-8s %-25s %-25s %-20s %-20s %-25s %-30s %s%n",
                                    "ID", "Titulo", "Autor", "Genero", "ISBN", "Fecha de Publicacion", "Editorial",
                                    "Disponibilidad");
                            System.out.println(
                                    "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                            for (Libro libro : libros) {
                                System.out.printf("%-8d %-25s %-25s %-20s %-20s %-25s %-30s %d%n",
                                        libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(),
                                        libro.getISBN(), formato.format(libro.getFechaPub()), libro.getEditorial(),
                                        libro.getDisponible());
                            }
                            System.out.println(
                                    "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Introduzca cualquier tecla para continuar");
                            br.readLine();
                        }
                        // Menu Filtrado
                        else if (menuU == 2) {

                            int menuF = 0;
                            do {
                                try {
                                    System.out.println("=== Menu Filtrado ===");
                                    System.out.println("1. Titulo");
                                    System.out.println("2. Autor");
                                    System.out.println("3. Genero");
                                    System.out.println("4. Salir");
                                    menuF = Integer.parseInt(br.readLine());
                                    // Filtrado por Titulo
                                    if (menuF == 1) {
                                        String tipo_interes = "Titulo";
                                        try {
                                            System.out.println("---------------------------------------");
                                            System.out.println("Ingrese el Titulo Completo de la Obra: ");
                                            String interes = br.readLine();

                                            libros = obj2.libro_por_interes(interes, obj1, tipo_interes);

                                            if (!libros.isEmpty()) {
                                                System.out.println("Resultado de " + interes + ":");
                                                System.out.println();
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.printf("%-8s %-25s %-25s %-20s %-20s %-25s %-30s %s%n",
                                                        "ID", "Titulo", "Autor", "Genero", "ISBN", "Fecha de Publicacion", "Editorial",
                                                        "Disponibilidad");
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                                for (Libro libro : libros) {
                                                    System.out.printf("%-8d %-25s %-25s %-20s %-20s %-25s %-30s %d%n",
                                                            libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(),
                                                            libro.getISBN(), formato.format(libro.getFechaPub()), libro.getEditorial(),
                                                            libro.getDisponible());
                                                }
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.println("Introduzca cualquier tecla para continuar");
                                                br.readLine();

                                            } else {
                                                System.out.println("Libro no Encontrado de: " + interes);
                                            }
                                            System.out.println("Introduzca cualquier tecla para continuar");
                                            br.readLine();

                                        } catch (Exception e) {
                                            System.out.println(
                                                    "Un Error se ha Encontrado al Buscar el Libro: " + e.getMessage());
                                        }
                                    }
                                    // Filtrado por Autor
                                    else if (menuF == 2) {
                                        String tipo_interes = "Autor";
                                        try {
                                            System.out.println("--------------------------------------");
                                            System.out.println("Ingrese el Nombre Completo del Autor: ");
                                            String interes = br.readLine();

                                            libros = obj2.libro_por_interes(interes, obj1, tipo_interes);

                                            if (!libros.isEmpty()) {
                                                System.out.println("Resultado de" + interes + ":");
                                                System.out.println();
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.printf("%-8s %-25s %-25s %-20s %-20s %-25s %-30s %s%n",
                                                        "ID", "Titulo", "Autor", "Genero", "ISBN", "Fecha de Publicacion", "Editorial",
                                                        "Disponibilidad");
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                                for (Libro libro : libros) {
                                                    System.out.printf("%-8d %-25s %-25s %-20s %-20s %-25s %-30s %d%n",
                                                            libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(),
                                                            libro.getISBN(), formato.format(libro.getFechaPub()), libro.getEditorial(),
                                                            libro.getDisponible());
                                                }
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.println("Introduzca cualquier tecla para continuar");
                                                br.readLine();
                                            } else {
                                                System.out.println("Libro no Encontrado de: " + interes);
                                            }
                                            System.out.println("Introduzca cualquier tecla para continuar");
                                            br.readLine();
                                        } catch (Exception e) {
                                            System.out.println(
                                                    "Un Error se ha Encontrado al Buscar el Libro: " + e.getMessage());
                                        }
                                    }
                                    // Filtrado por Genero
                                    else if (menuF == 3) {
                                        String tipo_interes = "Genero";
                                        try {
                                            System.out.println("-----------------------------");
                                            System.out.println("Ingrese el Genero del Libro: ");
                                            String interes = br.readLine();

                                            libros = obj2.libro_por_interes(interes, obj1, tipo_interes);

                                            if (!libros.isEmpty()) {
                                                System.out.println("Resultado de" + interes + ":");
                                                System.out.println();
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.printf("%-8s %-25s %-25s %-20s %-20s %-25s %-30s %s%n",
                                                        "ID", "Titulo", "Autor", "Genero", "ISBN", "Fecha de Publicacion", "Editorial",
                                                        "Disponibilidad");
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                                for (Libro libro : libros) {
                                                    System.out.printf("%-8d %-25s %-25s %-20s %-20s %-25s %-30s %d%n",
                                                            libro.getIdLibro(), libro.getTitulo(), libro.getAutor(), libro.getGenero(),
                                                            libro.getISBN(), formato.format(libro.getFechaPub()), libro.getEditorial(),
                                                            libro.getDisponible());
                                                }
                                                System.out.println(
                                                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                                System.out.println("Introduzca cualquier tecla para continuar");
                                                br.readLine();
                                            } else {
                                                System.out.println("Libro no Encontrado de " + interes);
                                            }
                                            System.out.println("Introduzca cualquier tecla para continuar");
                                            br.readLine();
                                        } catch (Exception e) {
                                            System.out.println(
                                                    "Un Error se ha Encontrado al Buscar el Libro: " + e.getMessage());
                                        }
                                    }
                                    // Salida Menu de Catalogo Filtrado
                                    else if (menuF == 4) {
                                        System.out.println("Volviendo al Menu Usuario");
                                    }
                                    // Opcion invalida de Menu de Catalogo Filtrado
                                    else {
                                        System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error: " + e);
                                }
                            } while (menuF != 4);
                        }
                        // Libros populares
                        else if (menuU == 3) {
                            librosPopu = obj2.librosPopulares(obj1);
                            System.out.println("-----------------------------");
                            System.out.println("Los Libros Mas Populares son:");
                            for (int i = 0; i < librosPopu.size(); i++) {
                                System.out.println((i + 1) + ". " + librosPopu.get(i));
                            }
                            System.out.println("-----------------------------");
                            System.out.println("Introduzca cualquier tecla para continuar");
                            br.readLine();
                        }
                        // Registro de Usuario
                        else if (menuU == 4) {
                            try {

                                System.out.println("---------------------------------");
                                System.out.println("Bienvenido al Sistema de Registro");
                                System.out.println();

                                System.out.print("Ingrese su Nombre: ");
                                String nombre = br.readLine();

                                System.out.print("Ingrese su Apellido: ");
                                String apellido = br.readLine();

                                System.out.print("Ingrese su Direccion: ");
                                String direccion = br.readLine();

                                System.out.print("Ingrese su Numero de Telefono: ");
                                String telefono = br.readLine();

                                System.out.print("Ingrese su Correo Electronico: ");
                                String correo = br.readLine();

                                obj2.registro_usuario(nombre, apellido, direccion, telefono, correo, obj1);
                                System.out.println("Registro Exitoso!");
                                System.out.println("-----------------");
                                System.out.println("Introduzca cualquier tecla para continuar");
                                br.readLine();
                            } catch (Exception e) {
                                System.out
                                        .println("Un Error ha Ocurrido en el Proceso del Registro: " + e.getMessage());
                            }
                        }
                        // Salida del Menu de Usuarios
                        else if (menuU == 5) {
                            System.out.println("Volviendo al menu principal...");
                        }
                        // Opcion Invalida del Menu de Usuarios
                        else {
                            System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                        }

                    } while (menuU != 5);
                }

                // Menu Administrativo
                else if (menuP == 2) {
                    int menuA = 0;

                    do {
                        try {
                            System.out.println("==== Menu Administrativo ====");
                            System.out.println("1. Registrar prestamo");
                            System.out.println("2. Registrar devoluciones");
                            System.out.println("3. Enviar notificaciones");
                            System.out.println("4. Informe periodico");
                            System.out.println("5. Salir");
                            System.out.print("Seleccione una opcion: ");
                            menuA = Integer.parseInt(br.readLine());
                            // Registrar Prestamo
                            if (menuA == 1) {
                                try {

                                    System.out.println("---------------------------------------------");
                                    System.out.println("Bienvenido al Sistema de Registro de Prestamo");
                                    System.out.println();
                                    System.out.println("Libros: ");
                                    System.out.println("id\t\tTitulo");
                                    libros = obj2.catalogo_completo(obj1);
                                    for (Libro libro : libros) {
                                        System.out.println(libro.getIdLibro() + "\t\t" + libro.getTitulo());
                                    }
                                    System.out.print("Ingrese el ID del Libro: ");
                                    int idLibro = Integer.parseInt(br.readLine());
                                    if (obj2.Disponible(idLibro, obj1)) {
                                        System.out.println("Usuarios: ");
                                        usuarios = obj2.lista_usuarios(obj1);
                                        System.out.println("id\t\tUsuario");
                                        for (Usuario usuario : usuarios) {
                                            System.out.println(usuario.getIdUsuario() + "\t\t" + usuario.getNombre()
                                                    + " " + usuario.getApellido());
                                        }
                                        System.out.print("Ingrese su ID de Usuario: ");
                                        int idUsuario = Integer.parseInt(br.readLine());

                                        obj2.registrar_prestamo(idLibro, idUsuario, obj1);
                                        System.out.println("Registro de Prestamo Exitoso!");
                                        System.out.println("-----------------------------");
                                        System.out.println("Introduzca cualquier tecla para continuar");
                                        br.readLine();
                                    } else {
                                        System.out.println("Libro no disponible");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Un Error ha Ocurrido en el Proceso del Registro de Prestamo: "
                                            + e.getMessage());
                                }
                                // Registrar devolucion
                            } else if (menuA == 2) {
                                try {

                                    System.out.println("-----------------------------------");
                                    System.out.println("Bienvenido al Sistema de Devolucion");
                                    System.out.println();
                                    prestamos = obj2.Prestamos(obj1);
                                    System.out.println("id\tNombre\t\t\t\tTitulo");
                                    for (PrestamoUsuarioLibro prestamo : prestamos) {
                                        System.out.println(prestamo.getIdPrestamo() + "\t" + prestamo.getNombre() + " "
                                                + prestamo.getApellido() + "\t" + prestamo.getTitulo());
                                    }
                                    System.out.print("Ingrese el ID del Prestamo: ");
                                    int idPrestamo = Integer.parseInt(br.readLine());
                                    String tituloLibroDevolucion = null;
                                    for(PrestamoUsuarioLibro prestamo : prestamos){
                                        if(prestamo.getIdPrestamo()==idPrestamo){
                                            tituloLibroDevolucion = prestamo.getTitulo();
                                        }
                                    }
                                    if(obj2.devuelto_verificacion(obj1, idPrestamo)){
                                        System.out.println("Este prestamo ya ha sido devuelto");
                                    }
                                    else{
                                        obj2.registrar_devolucion(obj1, idPrestamo,tituloLibroDevolucion);
                                        System.out.println("Registro de Devolucion Exitoso!");
                                        System.out.println("-----------------------------------");
                                        System.out.println("Introduzca cualquier tecla para continuar");
                                        br.readLine();
                                    }

                                } catch (Exception e) {
                                    System.out.println("Un Error ha Ocurrido en el Proceso del Registro de Prestamo: "
                                            + e.getMessage());
                                }
                                // Enviar notificaciones de devoluciones proximas a usuarios
                                // Opcion no realizada
                            } else if (menuA == 3) {
                                System.out.println("Se ha enviado las notificaciones de devoluciones proximas a los usuarios");
                                System.out.println("Introduzca cualquier tecla para continuar");
                                br.readLine();

                                // Informe periodico
                            } else if (menuA == 4) {
                                LinkedList<String> libroPopulares;
                                libroPopulares = obj2.librosPopulares(obj1);
                                System.out.println("-------------------------------");
                                System.out.println("Bienvenido al Informe Periodico");
                                System.out.println();
                                System.out.println("Los Libros Mas Populares son:");
                                for (int i = 0; i < libroPopulares.size(); i++) {
                                    System.out.println((i + 1) + ". " + libroPopulares.get(i));
                                }
                                System.out.println();
                                System.out.println("Las Cantidades de Prestamos son:");
                                System.out.println(obj2.cantPrestamo(obj1));
                                System.out.println();

                                usuarios = obj2.usuariosPrestamos(obj1);
                                System.out.println("Los Usuaarios con mas Prestamos son:");
                                System.out.println(
                                        "------------------------------------------------------------------------");
                                System.out.printf("%-8s %-25s %-25s %-20s%n",
                                        "ID", "Nombre", "Apillido", "Cantidad");
                                System.out.println(
                                        "------------------------------------------------------------------------");

                                for (Usuario usuario : usuarios) {
                                    System.out.printf("%-8d %-25s %-25s %-20s%n",
                                            usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellido(),
                                            usuario.getContador());
                                }
                                System.out.println(
                                        "------------------------------------------------------------------------");
                                System.out.println("Introduzca cualquier tecla para continuar");
                                br.readLine();
                                // Salida del Menu Administrativo
                            } else if (menuA == 5) {
                                System.out.println("Volviendo al menu principal...");
                                // Notificacion de opcion invalida
                            } else {
                                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                            }

                        } catch (Exception e) {
                            System.out.println("Error: " + e);
                        }

                    } while (menuA != 5);
                // Salida del menu principal
                } else if (menuP == 3) {
                    System.out.println("¡Hasta luego!");
                    menuPT = false;
                //// Notificacion de error
                } else {
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                }
            } catch (Exception e) {
                System.out.println("Error al leer la entrada del usuario: " + e);
            }

        } while (menuPT);// Bucle del menu principal
    }
}