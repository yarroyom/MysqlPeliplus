/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.AccesoDatosAdiclmpl;
import datos.AccesoDatosimpl;
import datos.ClsPeliculasJDBC;
import datos.IAccesoDatos;
import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;

import java.util.List;
import java.util.Scanner;


/**
 *
 * @author dell
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    
    // private final IAccesoDatos datos;
    
     private final datos.AccesoDatosAdiclmpl datos; // nueva linea
     private final ClsPeliculasJDBC pelis;
     
     
    public CatalogoPeliculasImpl(){
       // this.datos=new AccesoDatosimpl();
       this.datos=new AccesoDatosAdiclmpl(); //nueva linea
       this.pelis=new ClsPeliculasJDBC();
    }

    
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {
    
        
         PeliculaAmpliado peli = new PeliculaAmpliado(nombrePelicula, nombreArchivo);
        pelis.insert(peli);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
          try {
            
            List<PeliculaAmpliado> peli= datos.seleccion();
            for (PeliculaAmpliado peliculas: peli) {
            System.out.println("Pelicula: "+ peliculas);
            
        }

        } catch (Exception e) {
            System.out.println("Clavos con el acceso a datos");
        }
    }
    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        PeliculaAmpliado peli = new PeliculaAmpliado(nombreArchivo, buscar);
        pelis.actualizar(peli);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa nombre de la Pelicula");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa año de produccion");
        String fproduccion = scanner.nextLine();
        
       PeliculaAmpliado peli = new PeliculaAmpliado(nombre, fproduccion);
       pelis.borrar(peli);

    }
   
}