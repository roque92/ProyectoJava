/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JRoque
 */
public class Conector {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String server = "www.divisagt.com";
    private final String user = "divisagt_cgm";
    private final String password = "@Intecap2020";
    private final String baseDatos ="divisagt_cgm";
    private String cadena, error;
    
    Connection con;
    Statement st;
    
    //Metodo que habilita la conexion con la base de datos
   public void connect(){
       this.cadena = "jdbc:mysql://" +  this.server + "/" + this.baseDatos;
       
       try {
           Class.forName(this.driver).newInstance();
           this.con = (Connection) DriverManager.getConnection(this.cadena, this.user, this.password);
       } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
           System.err.println(e.getMessage());
       }
   }
}
