/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.PeliculaAmpliado;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
 
public class AccesoDatosAdiclmpl extends AccesoDatosimpl {
    
    
    
       public List<PeliculaAmpliado> peliFecha = new ArrayList<PeliculaAmpliado>();
    
 /*   public void cargarInformacion(String nombreArchivo) throws LecturaDatosEx, IOException {
       peliFecha = new ArrayList<PeliculaAmpliado>(); 
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea!=null){
                
                String nombrePe;
                String Year;
                String[] arreglo = linea.split(";");
                Year = arreglo[1];
                nombrePe = arreglo[0];
                PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePe, Year);
                peliFecha.add(pelicula);
                linea = entrada.readLine();
                System.out.println("pelicula = "+pelicula.getNombre() +" Año = "+ pelicula.getFproduccion());
            }
            entrada.close();
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch ( IOException ex){
            ex.printStackTrace(System.out);
        }
        
    }

    public List<PeliculaAmpliado> seleccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
*/
       
     private static final String SQL_SELECT = "SELECT * FROM tb_peliplus";
   public List<PeliculaAmpliado> seleccion(){
     Connection conn = null;   
     PreparedStatement stmt = null;
     ResultSet rs = null;
     PeliculaAmpliado pelicula = null;
     List<PeliculaAmpliado> peliculas = new ArrayList<PeliculaAmpliado>();
     
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
//                alumno.setNombre(rs.getString("nombre"));

                String name = rs.getString("Nombre");
                String year = rs.getString("Año");
                
                
                pelicula = new PeliculaAmpliado(name, year);
                
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            System.out.println("Hay problemas ..."+ex.getMessage());
        }
        finally{
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return peliculas; 
    } 
    
}
    


