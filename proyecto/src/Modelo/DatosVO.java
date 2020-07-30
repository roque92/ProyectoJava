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
   
   //----------------------Variables que vienen de la base de datos
   //-------Login
   private String login_user, login_pass, login_telefono, login_correo, login_tipo;
   //-------Negociacion
   private String negociacion_nombre_cliente, negociacion_telefono, negociacion_estado_residencia, negociacion_estado_migratorio,
           negociacion_tipo_porpiedad, negociacion_correo, negociacion_estado_civil, negociacion_profecion, 
           negociacion_DPI, negociacion_NIT, negociacion_ID;
   //-------Datos Buscador
   private String buscar_nombre, buscar_telefono, buscar_correo;
   //-------Vendedor
   private String nombre_vendedor, telefono_vendedor, constructora_vendedor, correo_vendedor;
   //-------Representante
   private String nombre_representante, parentezco_representante, direccion_representante, telefono_representante, banco_representante;
   //-------Cliente
   private String nombre_cliente, telefono_cliente, correo_cliente, estatus_cliente, direccion_cliente, estadoCivil_cliente, estadoMigratorio_cliente, profecion_cliente, estadoResidencia_cliente, dpi_cliente, nit_cliente,usaId_cliente;
   //-------Casos
   private String honorarios_casos, salario_casos, notas_casos;
   //-------Propiedad
   private String tipo_propiedad;
   
   //----------------------Variables que van a ser almancenadas en la Base de datos
   ///-------
   
   //----------------------Variables que se van a usar en la aplicacion
   ///-------login
   private String user_login, pass_login;
   
   //----------------------Contructores
    public DatosVO(String error, String login_user, String login_pass, String login_telefono, String login_correo, String login_tipo, String negociacion_nombre_cliente, String negociacion_telefono, String negociacion_estado_residencia, String negociacion_estado_migratorio, String negociacion_tipo_porpiedad, String negociacion_correo, String negociacion_estado_civil, String negociacion_profecion, String negociacion_DPI, String negociacion_NIT, String negociacion_ID, String user_login, String pass_login, String buscar_nombre, String buscar_telefono, String buscar_correo, String nombre_vendedor, String telefono_vendedor, String constructora_vendedor, String correo_vendedor, String nombre_representante, String parentezco_representante, String direccion_representante, String telefono_representante, String banco_representante, String nombre_cliente, String telefono_cliente, String correo_cliente, String estatus_cliente, String direccion_cliente, String estadoCivil_cliente, String estadoMigratorio_cliente, String profecion_cliente, String estadoResidencia_cliente, String dpi_cliente, String nit_cliente, String usaId_cliente, String honorarios_casos, String salario_casos, String notas_casos, String tipo_propiedad) {
        this.error = error;
        this.login_user = login_user;
        this.login_pass = login_pass;
        this.login_telefono = login_telefono;
        this.login_correo = login_correo;
        this.login_tipo = login_tipo;
        this.negociacion_nombre_cliente = negociacion_nombre_cliente;
        this.negociacion_telefono = negociacion_telefono;
        this.negociacion_estado_residencia = negociacion_estado_residencia;
        this.negociacion_estado_migratorio = negociacion_estado_migratorio;
        this.negociacion_tipo_porpiedad = negociacion_tipo_porpiedad;
        this.negociacion_correo = negociacion_correo;
        this.negociacion_estado_civil = negociacion_estado_civil;
        this.negociacion_profecion = negociacion_profecion;
        this.negociacion_DPI = negociacion_DPI;
        this.negociacion_NIT = negociacion_NIT;
        this.negociacion_ID = negociacion_ID;
        this.user_login = user_login;
        this.pass_login = pass_login;
        this.buscar_nombre = buscar_nombre;
        this.buscar_telefono = buscar_telefono;
        this.buscar_correo = buscar_correo;
        this.nombre_vendedor = nombre_vendedor;
        this.telefono_vendedor = telefono_vendedor;
        this.constructora_vendedor = constructora_vendedor;
        this.correo_vendedor = correo_vendedor;
        this.nombre_representante = nombre_representante;
        this.parentezco_representante = parentezco_representante;
        this.direccion_representante = direccion_representante;
        this.telefono_representante = telefono_representante;
        this.banco_representante = banco_representante;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
        this.estatus_cliente = estatus_cliente;
        this.direccion_cliente = direccion_cliente;
        this.estadoCivil_cliente = estadoCivil_cliente;
        this.estadoMigratorio_cliente = estadoMigratorio_cliente;
        this.profecion_cliente = profecion_cliente;
        this.estadoResidencia_cliente = estadoResidencia_cliente;
        this.dpi_cliente = dpi_cliente;
        this.nit_cliente = nit_cliente;
        this.usaId_cliente = usaId_cliente;
        this.honorarios_casos = honorarios_casos;
        this.salario_casos = salario_casos;
        this.notas_casos = notas_casos;
        this.tipo_propiedad = tipo_propiedad;
    }
    
    
    
     
   
    public DatosVO() {
       
    }

    //----------------------Metodos Setter and Getter
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

    public String getNegociacion_nombre_cliente() {
        return negociacion_nombre_cliente;
    }

    public void setNegociacion_nombre_cliente(String negociacion_nombre_cliente) {
        this.negociacion_nombre_cliente = negociacion_nombre_cliente;
    }

    public String getNegociacion_telefono() {
        return negociacion_telefono;
    }

    public void setNegociacion_telefono(String negociacion_telefono) {
        this.negociacion_telefono = negociacion_telefono;
    }

    public String getNegociacion_estado_residencia() {
        return negociacion_estado_residencia;
    }

    public void setNegociacion_estado_residencia(String negociacion_estado_residencia) {
        this.negociacion_estado_residencia = negociacion_estado_residencia;
    }

    public String getNegociacion_estado_migratorio() {
        return negociacion_estado_migratorio;
    }

    public void setNegociacion_estado_migratorio(String negociacion_estado_migratorio) {
        this.negociacion_estado_migratorio = negociacion_estado_migratorio;
    }

    public String getNegociacion_tipo_porpiedad() {
        return negociacion_tipo_porpiedad;
    }

    public void setNegociacion_tipo_porpiedad(String negociacion_tipo_porpiedad) {
        this.negociacion_tipo_porpiedad = negociacion_tipo_porpiedad;
    }

    public String getNegociacion_correo() {
        return negociacion_correo;
    }

    public void setNegociacion_correo(String negociacion_correo) {
        this.negociacion_correo = negociacion_correo;
    }

    public String getNegociacion_estado_civil() {
        return negociacion_estado_civil;
    }

    public void setNegociacion_estado_civil(String negociacion_estado_civil) {
        this.negociacion_estado_civil = negociacion_estado_civil;
    }

    public String getNegociacion_profecion() {
        return negociacion_profecion;
    }

    public void setNegociacion_profecion(String negociacion_profecion) {
        this.negociacion_profecion = negociacion_profecion;
    }

    public String getNegociacion_DPI() {
        return negociacion_DPI;
    }

    public void setNegociacion_DPI(String negociacion_DPI) {
        this.negociacion_DPI = negociacion_DPI;
    }

    public String getNegociacion_NIT() {
        return negociacion_NIT;
    }

    public void setNegociacion_NIT(String negociacion_NIT) {
        this.negociacion_NIT = negociacion_NIT;
    }

    public String getNegociacion_ID() {
        return negociacion_ID;
    }

    public void setNegociacion_ID(String negociacion_ID) {
        this.negociacion_ID = negociacion_ID;
    }

    public String getBuscar_nombre() {
        return buscar_nombre;
    }

    public void setBuscar_nombre(String buscar_nombre) {
        this.buscar_nombre = buscar_nombre;
    }

    public String getBuscar_telefono() {
        return buscar_telefono;
    }

    public void setBuscar_telefono(String buscar_telefono) {
        this.buscar_telefono = buscar_telefono;
    }

    public String getBuscar_correo() {
        return buscar_correo;
    }

    public void setBuscar_correo(String buscar_correo) {
        this.buscar_correo = buscar_correo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getEstatus_cliente() {
        return estatus_cliente;
    }

    public void setEstatus_cliente(String estatus_cliente) {
        this.estatus_cliente = estatus_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getEstadoCivil_cliente() {
        return estadoCivil_cliente;
    }

    public void setEstadoCivil_cliente(String estadoCivil_cliente) {
        this.estadoCivil_cliente = estadoCivil_cliente;
    }

    public String getEstadoMigratorio_cliente() {
        return estadoMigratorio_cliente;
    }

    public void setEstadoMigratorio_cliente(String estadoMigratorio_cliente) {
        this.estadoMigratorio_cliente = estadoMigratorio_cliente;
    }

    public String getProfecion_cliente() {
        return profecion_cliente;
    }

    public void setProfecion_cliente(String profecion_cliente) {
        this.profecion_cliente = profecion_cliente;
    }

    public String getEstadoResidencia_cliente() {
        return estadoResidencia_cliente;
    }

    public void setEstadoResidencia_cliente(String estadoResidencia_cliente) {
        this.estadoResidencia_cliente = estadoResidencia_cliente;
    }

    public String getDpi_cliente() {
        return dpi_cliente;
    }

    public void setDpi_cliente(String dpi_cliente) {
        this.dpi_cliente = dpi_cliente;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public String getUsaId_cliente() {
        return usaId_cliente;
    }

    public void setUsaId_cliente(String usaId_cliente) {
        this.usaId_cliente = usaId_cliente;
    }

    public String getHonorarios_casos() {
        return honorarios_casos;
    }

    public void setHonorarios_casos(String honorarios_casos) {
        this.honorarios_casos = honorarios_casos;
    }

    public String getSalario_casos() {
        return salario_casos;
    }

    public void setSalario_casos(String salario_casos) {
        this.salario_casos = salario_casos;
    }

    public String getTipo_propiedad() {
        return tipo_propiedad;
    }

    public void setTipo_propiedad(String tipo_propiedad) {
        this.tipo_propiedad = tipo_propiedad;
    }

    public String getNotas_casos() {
        return notas_casos;
    }

    public void setNotas_casos(String notas_casos) {
        this.notas_casos = notas_casos;
    }
    
    
    
}
