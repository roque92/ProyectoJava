/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
           this.con = DriverManager.getConnection(this.cadena, this.user, this.password);
       } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
           error = e.getMessage();
       }
   }
   
   //Metodo para Obtener los datos de la Base de Datos
   public ResultSet obtener_datos (String consulta){
       try {
           this.connect();
           ResultSet respuesta = null;
           this.st = this.con.createStatement();
           respuesta = st.executeQuery(consulta);
           return respuesta;
       } catch (Exception e) {
           error = e.getMessage();
       }
       return null;
   }
   
   //Desconectar de la Base de Datos
   public void desconectar(){
       try {
           con.close();
       } catch (Exception e) {
           error = e.getMessage();
       }
   }
   
   //Metodos para consultas a la Base de Datos ( Insertar Borrar Modificar)
   public int consulta_general (String consulta){
       int resultado = 0;
       
       try {
           this.connect();
           this.st = this.con.createStatement();
           resultado = this.st.executeUpdate(consulta);
       } catch (Exception e) {
           error = e.getMessage();
           return 0;
       }
       
       return resultado;
   }
    
   public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
  
   
}
