/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class AccesoDatosimpl  implements IAccesoDatos{

    @Override
    public boolean existen(String nombreArchivo) throws AccesoDatosEx {
       File archivo = new File(nombreArchivo);
       return archivo.exists();//nos sirve para saber si existe o no el archivo
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
      List<Pelicula> Peliculas= new ArrayList();
        try {
            BufferedReader entrada =null;
            File archivo = new File (nombreArchivo);
            entrada = new BufferedReader  (new FileReader (archivo));
            String linea= null;
            linea=entrada.readLine();
            while (linea!= null){
                Pelicula pelicula = new Pelicula(linea);
                Peliculas.add(pelicula);
                linea=entrada.readLine();
            }
            
            entrada.close();
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        }catch (IOException ex){
          System.out.println("Clavos al abrir el archivo");
        }
        return Peliculas;
    }

    @Override
    public void escribir(Pelicula Pelicula, String nombreArchivo, boolean anaxar) throws EscrituraDatosEx {
      PrintWriter salida= null;
        try {
            File archivo = new File(nombreArchivo);
            salida=new PrintWriter(new FileWriter(archivo,anaxar));
            salida.println(Pelicula.toString());
            salida.close();
            System.out.println("se ha escrito el registro de pelicula");
            
        } catch (Exception e) {
        }
        
    }

    @Override
    public String Buscar(String nombreArchivo, String buscar) throws EscrituraDatosEx {
      BufferedReader entrada = null;
      String resultado=null;
        try {
           File archivo = new File (nombreArchivo);
           
           entrada = new BufferedReader (new FileReader (archivo));
           String linea=null;
           int i =0;
           linea = entrada.readLine();
           
           while (linea != null){
               
               if (buscar != null && buscar.equalsIgnoreCase(linea)){
                   resultado ="peli:"+linea+"encontrada en la linea="+i;
                   break;
               }
               linea=entrada.readLine();
               i++;
           }
           entrada.close();
           
        } catch (FileNotFoundException ex) {
            System.out.println("no se encontro"+ ex.getMessage());
            
        }catch (IOException ex){
            System.out.println("problema de archivo"+ ex.getMessage());
        }finally{
            
            
            try {
                entrada.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
 
        return resultado;
        
 
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
       PrintWriter salida =null;
        try {
            File archivo=new File (nombreArchivo);
            salida=new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            System.out.println("problema al creae"+ex.getMessage());
        }
       
    }


    
    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
       File archivo = new File (nombreArchivo);
       archivo.delete();
               System.out.println("El archivo se eliminó");
        
    }
    
    
    
    
}
