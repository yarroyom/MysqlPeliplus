/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.PeliculaAmpliado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ClsPeliculasJDBC {
     private static final String SQL_SELECT = "SELECT * FROM tb_peliplus";
    private static final String SQL_INSERT ="insert into tb_peliplus (Nombre, año) values(?,?)";//? = parametros
    private static final String SQL_UPDATE = "update tb_peliplus set Nombre=?, año=? where Nombre=?";
    private static final String SQL_DELETE = "delete from tb_peliplus where Nombre=?";

 
    
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
                String year = rs.getString("año");
                
                
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
    
    public int insert(PeliculaAmpliado pelicula){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getFproduccion());
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados = "+rows);
        } catch (SQLException e) {
            System.out.println("Error insertar "+e.toString());
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
        
    }
    
        public int actualizar(PeliculaAmpliado pelicula){
        Connection conn=null;
        PreparedStatement stmt=null;
        int rows=0;
        try {
            conn=ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pelicula.getNombre());
            stmt.setString(2, pelicula.getFproduccion());
            stmt.setString(3, pelicula.getNombre());
            rows= stmt.executeUpdate();
            System.out.println("Registros Afectados = "+rows);
        } catch (SQLException e) {
            System.out.println("Error actualizar "+e.toString());
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;  
    }
        
        public int borrar(PeliculaAmpliado pelicula){
        Connection conn=null;
        PreparedStatement stmt=null;
        int rows=0;
        try {
            conn=ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, pelicula.getNombre());
            rows = stmt.executeUpdate();
            System.out.println("Registros Afectados = "+rows);  
        } catch (SQLException e) {
            System.out.println("Error al borrar "+e.toString());
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;  
    }
    
}
    
    
    

