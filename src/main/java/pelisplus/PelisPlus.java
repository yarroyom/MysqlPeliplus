/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelisplus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author dell
 */
public class PelisPlus {
    private static final Scanner scanner= new Scanner(System.in);
    private static int opcion=-1;
  private static final String nombreArchivo= "C:\\Users\\dell\\OneDrive\\Documentos\\CUARTO SEMESTRE\\PelisConAño.csv";
    private static final CatalogoPeliculas catalogopeli=new CatalogoPeliculasImpl();
    
    public static void main(String[] args) {
       
          //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Eliminar peliculas"
                        + "\n2.- Agregar pelicula\n"
                        + "3.- Listar Peliculas\n"
                        + "4.- Actualizar Pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogopeli.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                          System.out.println("Nombre de una pelicula");
                        String nombre = scanner.nextLine();
                        System.out.println("Año de Produccion");
                        String fecha = scanner.nextLine();
                        catalogopeli.agregarPeliculas(nombre, fecha);     
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogopeli.listarPeliculas(nombreArchivo);
                        
                        break;
                    case 4:
                           
                        //4. Buscar pelicula
                    System.out.println("Introduce el nombre de una pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        System.out.println("Ingresa el año de produccion");
                        String fproduccion = scanner.nextLine();
                        catalogopeli.buscarPeliculas(buscar, fproduccion);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
   
         
      
     
}
        
        
 
