/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author dell
 */
public class PeliculaAmpliado extends Pelicula {
     private String Fproduccion;

    public PeliculaAmpliado(String nombre_peli, String Fproduccion) {
        super(nombre_peli);
        this.Fproduccion = Fproduccion;
    }

    /**
     * @return the Fproduccion
     */
    public String getFproduccion() {
        return Fproduccion;
    }

    /**
     * @param Fproduccion the Fproduccion to set
     */
    public void setFproduccion(String Fproduccion) {
        this.Fproduccion = Fproduccion;
    }
    
}
