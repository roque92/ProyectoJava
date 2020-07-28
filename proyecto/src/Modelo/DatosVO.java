/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jroque
 */
public class DatosVO {
    
   private String error;
   
   //Variables que vienen de la base de datos 
   private String nombre_rep, parentezco_rep, direccion_rep, telefono_rep, banco_rep;
   
   //Variables que se van a user en la aplicacion
   
   //Metodos Setter and Getter

    public DatosVO(String error) {
        this.error = error;
    }

    public DatosVO() {
       
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
   
       
    
}
