import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import paquete.*;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Libro> libros;
        LinkedList<String> librosPopu;
        LinkedList<Usuario> usuarios;
        LinkedList<PrestamoUsuarioLibro> prestamos;
        SimpleDateFormat formato = new SimpleDateFormat("dd, MMMM, yyyy");
        Conexion obj1 = new Conexion();
        Operaciones obj2 = new Operaciones();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int menuP = 0;
        boolean menuPT = true;
        do {
            try {
                //Menu Principal
                System.out.println("==== Menu Principal ===="); // Menu Principal
                System.out.println("1. Menu Usuario");
                System.out.println("2. Menu Administrativo");
                System.out.println("3. Salir");
                System.out.println("Seleccione una opcion: ");
                menuP = Integer.parseInt(br.readLine());

                //Menu Usuario
                if (menuP == 1) {
                    int menuU = 0;
                    do {
                        try {

                            System.out.println("==== Menu Usuario ===="); // Menu Principal opc 1 = Menu Usuario
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

                        if (menuU == 1) {
                            //metodos de la Menu Usuario opc 1
                        } 
                        
                        else if (menuU == 2) {

                            int menuF = 0;
                            do {
                                try{

                                    //Menu Filtrado
                                    System.out.println("=== Menu Filtrado ===");
                                    System.out.println("1. Titulo");
                                    System.out.println("2. Autor");
                                    System.out.println("3. Genero");
                                    System.out.println("4. Salir");
                                    menuF = Integer.parseInt(br.readLine());

                                    if (menuF == 1) {
                                        // metodo de insertar titulo
                                    } 
                                    
                                    else if (menuF == 2) {
                                        // metodo de insertar autor
                                    } 
                                    
                                    else if (menuF == 3) {
                                        // metodo de insertar Genero
                                    } 
                                    
                                    else if (menuF == 4) {
                                        System.out.println("Volviendo al Menu Usuario");
                                    } 
                                    
                                    else {
                                        System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                                    }
                                } catch(Exception e) {
                                    System.out.println("Error: " + e);
                                }
                            }while (menuF != 4); 
                        }

                        else if (menuU == 3) {
                            //metodos de la Menu Usuario opc 3
                        }

                        else if (menuU == 4) {
                            //metodos de la Menu Usuario opc 4 
                        }

                        else if (menuU == 5) {
                            System.out.println("Volviendo al menu principal..."); // Menu Usuario opc 5 = Salir
                        }

                        else {
                            System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                        }

                    } while (menuU !=5);
                }

                //Menu Administrativo
                else if (menuP == 2) {
                    int menuA = 0;
                    
                    do {
                        try{

                            System.out.println("==== Menu Administrativo ===="); // Menu Principal opc 2 = Menu Administrativo
                            System.out.println("1. Registrar prestamo");
                            System.out.println("2. Registrar devoluciones");
                            System.out.println("3. Enviar notificaciones");
                            System.out.println("4. Informe periodico");
                            System.out.println("5. Salir");
                            System.out.print("Seleccione una opcion: ");
                            menuA = Integer.parseInt(br.readLine());

                            if (menuA == 1) {
                                System.out.println("Opcion seleccionada: Registrar prestamo"); // Menu Administrativo opc 1 = prestamo
                                // metodos aqui
                            } else if (menuA == 2) {
                                System.out.println("Opcion seleccionada: Registrar devoluciones"); // Menu Administrativo opc 2 = devoluciones
                                // metodos aqui
                            } else if (menuA == 3) {
                                System.out.println("Opcion seleccionada: Enviar notificaciones"); // Menu Administrativo opc 3 = notificaciones
                                // metodos aqui
                            } else if (menuA == 4) {
                                System.out.println("Opcion seleccionada: Informe periodico"); // Menu Administrativo opc 4 = periodico
                                // metodos aqui
                            } else if (menuA == 5) {
                                System.out.println("Volviendo al menu principal..."); // Menu Administrativo opc 5 = Salir
                            } else {
                                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida."); // Notificacion de error
                            }
                        
                        }catch (Exception e) {
                            System.out.println("Error: " + e);
                        }

                    } while (menuA != 5);
                } else if (menuP == 3) {
                    System.out.println("¡Hasta luego!"); // Menu Principal opc 3 = Salir
                    menuPT = false;
                } else {
                    System.out.println("Opcion invalida. Por favor, seleccione una opcion valida."); // Notificacion de error
                }
            } catch (Exception e) {
                System.out.println("Error al leer la entrada del usuario: " + e);
            }

        } while (menuPT);
    }
}