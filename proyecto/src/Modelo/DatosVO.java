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
   private String login_user, login_pass, login_telefono, login_correo, login_tipo;
   
   //Variables que se van a usar en la aplicacion
   //login
   private String user_login, pass_login;
   //Vendedor
   private String nombre_vendedor, telefono_vendedor, constructora_vendedor, correo_vendedor;
   //Representante
   private String nombre_representante, parentezco_representante, direccion_representante, telefono_representante, banco_representante;
   
    //Contructores

    public DatosVO(String error, String login_user, String login_pass, String login_telefono, String login_correo, String login_tipo, String user_login, String pass_login, String nombre_vendedor, String telefono_vendedor, String constructora_vendedor, String correo_vendedor, String nombre_representante, String parentezco_representante, String direccion_representante, String telefono_representante, String banco_representante) {
        this.error = error;
        this.login_user = login_user;
        this.login_pass = login_pass;
        this.login_telefono = login_telefono;
        this.login_correo = login_correo;
        this.login_tipo = login_tipo;
        this.user_login = user_login;
        this.pass_login = pass_login;
        this.nombre_vendedor = nombre_vendedor;
        this.telefono_vendedor = telefono_vendedor;
        this.constructora_vendedor = constructora_vendedor;
        this.correo_vendedor = correo_vendedor;
        this.nombre_representante = nombre_representante;
        this.parentezco_representante = parentezco_representante;
        this.direccion_representante = direccion_representante;
        this.telefono_representante = telefono_representante;
        this.banco_representante = banco_representante;
    }
    
    

    
    public DatosVO() {
       
    }

    //Metodos Setter and Getter

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getLogin_pass() {
        return login_pass;
    }

    public void setLogin_pass(String login_pass) {
        this.login_pass = login_pass;
    }

    public String getLogin_telefono() {
        return login_telefono;
    }

    public void setLogin_telefono(String login_telefono) {
        this.login_telefono = login_telefono;
    }

    public String getLogin_correo() {
        return login_correo;
    }

    public void setLogin_correo(String login_correo) {
        this.login_correo = login_correo;
    }

    public String getLogin_tipo() {
        return login_tipo;
    }

    public void setLogin_tipo(String login_tipo) {
        this.login_tipo = login_tipo;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getPass_login() {
        return pass_login;
    }

    public void setPass_login(String pass_login) {
        this.pass_login = pass_login;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getTelefono_vendedor() {
        return telefono_vendedor;
    }

    public void setTelefono_vendedor(String telefono_vendedor) {
        this.telefono_vendedor = telefono_vendedor;
    }

    public String getConstructora_vendedor() {
        return constructora_vendedor;
    }

    public void setConstructora_vendedor(String constructora_vendedor) {
        this.constructora_vendedor = constructora_vendedor;
    }

    public String getCorreo_vendedor() {
        return correo_vendedor;
    }

    public void setCorreo_vendedor(String correo_vendedor) {
        this.correo_vendedor = correo_vendedor;
    }

    public String getNombre_representante() {
        return nombre_representante;
    }

    public void setNombre_representante(String nombre_representante) {
        this.nombre_representante = nombre_representante;
    }

    public String getParentezco_representante() {
        return parentezco_representante;
    }

    public void setParentezco_representante(String parentezco_representante) {
        this.parentezco_representante = parentezco_representante;
    }

    public String getDireccion_representante() {
        return direccion_representante;
    }

    public void setDireccion_representante(String direccion_representante) {
        this.direccion_representante = direccion_representante;
    }

    public String getTelefono_representante() {
        return telefono_representante;
    }

    public void setTelefono_representante(String telefono_representante) {
        this.telefono_representante = telefono_representante;
    }

    public String getBanco_representante() {
        return banco_representante;
    }

    public void setBanco_representante(String banco_representante) {
        this.banco_representante = banco_representante;
    }
    
    
    
}
