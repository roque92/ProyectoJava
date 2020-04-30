/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jreyes
 */
public class DatosVO {

//Variables Login
    private String usuario, contraseña, referencia;

//Variables Login para DataBase
    private String db_nombre, db_username, db_password, db_telefono, db_correo, db_descripcion;
    private int db_rol;
    
//Variables login de DataBase
    private String cf_nombre, cf_username, cf_password, cf_telefono, cf_correo, cf_descripcion;
    private int cf_rol;
    
//Metodos Login
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

//Metodos para DataBase
    public String getDb_nombre() {
        return db_nombre;
    }

    public void setDb_nombre(String db_nombre) {
        this.db_nombre = db_nombre;
    }

    public String getDb_username() {
        return db_username;
    }

    public int getDb_rol() {
        return db_rol;
    }

    public void setDb_rol(int db_rol) {
        this.db_rol = db_rol;
    }

    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public String getDb_telefono() {
        return db_telefono;
    }

    public void setDb_telefono(String db_telefono) {
        this.db_telefono = db_telefono;
    }

    public String getDb_correo() {
        return db_correo;
    }

    public void setDb_correo(String db_correo) {
        this.db_correo = db_correo;
    }

    public String getDb_descripcion() {
        return db_descripcion;
    }

    public void setDb_descripcion(String db_descripcion) {
        this.db_descripcion = db_descripcion;
    }
    
//Metodos de DataBase

    public String getCf_nombre() {
        return cf_nombre;
    }

    public void setCf_nombre(String cf_nombre) {
        this.cf_nombre = cf_nombre;
    }

    public String getCf_username() {
        return cf_username;
    }

    public void setCf_username(String cf_username) {
        this.cf_username = cf_username;
    }

    public String getCf_password() {
        return cf_password;
    }

    public void setCf_password(String cf_password) {
        this.cf_password = cf_password;
    }

    public int getCf_rol() {
        return cf_rol;
    }

    public void setCf_rol(int cf_rol) {
        this.cf_rol = cf_rol;
    }

    public String getCf_telefono() {
        return cf_telefono;
    }

    public void setCf_telefono(String cf_telefono) {
        this.cf_telefono = cf_telefono;
    }

    public String getCf_correo() {
        return cf_correo;
    }

    public void setCf_correo(String cf_correo) {
        this.cf_correo = cf_correo;
    }

    public String getCf_descripcion() {
        return cf_descripcion;
    }

    public void setCf_descripcion(String cf_descripcion) {
        this.cf_descripcion = cf_descripcion;
    }
    

}
