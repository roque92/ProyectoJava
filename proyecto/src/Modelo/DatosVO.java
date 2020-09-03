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
      
   //----------------------Variables que vienen de la base de datos
   //-------Login
   private String login_user, login_pass, login_telefono, login_correo, login_tipo;
   private int Login_id;
   //-------Negociacion
   private String negociacion_nombre_cliente, negociacion_telefono, negociacion_estado_residencia, negociacion_estado_migratorio,
           negociacion_tipo_porpiedad, negociacion_correo, negociacion_estado_civil, negociacion_profecion, 
           negociacion_DPI, negociacion_NIT, negociacion_ID;
   //-------Datos Buscador
   private String buscar_nombre, buscar_telefono, buscar_correo;
   //-------Vendedor
   private String nombre_vendedor, telefono_vendedor, constructora_vendedor, correo_vendedor, id_vendedor;
   //-------Representante
   private String nombre_representante, parentezco_representante, direccion_representante, telefono_representante, banco_representante, id_representante;
   //-------Cliente
   private String nombre_cliente, telefono_cliente, correo_cliente, estatus_cliente, 
           direccion_cliente, estadoCivil_cliente, estadoMigratorio_cliente, 
           profecion_cliente, estadoResidencia_cliente, dpi_cliente, nit_cliente, 
           usaId_cliente, claseTramite_cliente, id_cliente;
   //-------Casos
   private String notas_casos;
   private double honorarios_casos, salario_casos;
   //-------Propiedad
   private String tipo_propiedad;
   //-------Propiedad
   private String fecha_registro, informacion_registro;
   private int idUsuario_registro, idCaso_registro;
   
   //----------------------Variables que van a ser almancenadas en la Base de datos
   ///-------Venedor
   private String toVendedor_nombre, toVendedor_telefono, toVendedor_constructora, toVendedor_correo;
   
   ///-------Usuarios
   private String toUsuarios_nombre,  toUsuarios_telefono, toUsuarios_correo;
   
   ///-------Representante
   private String toRepresentante_nombre, toRepresentante_parentezco, toRepresentante_direccion, toRepresentante_telefono, toRepresentante_banco;
   
   ///-------Registros
   private String toRegistros_id_usuarios, toRegistros_fecha, toRegistros_notas, toRegistros_id_casos;
   
   ///-------Clientes
   private String toClientes_nombre, toClientes_telefono, toClientes_correo, toClientes_status, toClientes_direccion;
   private int toClientes_id_EstadoCivil, toClientes_id_migratorio;
   private String toClientes_profesion, toClientes_EstadoResidencia, toClientes_dpi, toClientes_nit, toClientes_UsaId, toClientes_ClaseTraite;
   
   ///-------Casos
   private int toCasos_idCliente, toCasos_idVendedor, toCasos_idUsuario;
   private double toCasos_honorarios, toCasos_salario;
   private String toCasos_notas;
   private int toCasos_idEstado, toCasos_idPropiedad, toCasos_idRepresentante;
   
   ///-------Tipo Propiedad
   private int toPropiedad_id;
   private String toPropiedad_descripcion;
   
   //----------------------Variables que se van a usar en la aplicacion
   private String error;
   ///-------login
   private String user_login, pass_login;
   
   
   //----------------------Contructores

    public DatosVO(String login_user, String login_pass, String login_telefono, String login_correo, String login_tipo, int Login_id, String negociacion_nombre_cliente, String negociacion_telefono, String negociacion_estado_residencia, String negociacion_estado_migratorio, String negociacion_tipo_porpiedad, String negociacion_correo, String negociacion_estado_civil, String negociacion_profecion, String negociacion_DPI, String negociacion_NIT, String negociacion_ID, String buscar_nombre, String buscar_telefono, String buscar_correo, String nombre_vendedor, String telefono_vendedor, String constructora_vendedor, String correo_vendedor, String id_vendedor, String nombre_representante, String parentezco_representante, String direccion_representante, String telefono_representante, String banco_representante, String id_representante, String nombre_cliente, String telefono_cliente, String correo_cliente, String estatus_cliente, String direccion_cliente, String estadoCivil_cliente, String estadoMigratorio_cliente, String profecion_cliente, String estadoResidencia_cliente, String dpi_cliente, String nit_cliente, String usaId_cliente, String claseTramite_cliente, String id_cliente, String notas_casos, double honorarios_casos, double salario_casos, String tipo_propiedad, String fecha_registro, String informacion_registro, int idUsuario_registro, int idCaso_registro, String toVendedor_nombre, String toVendedor_telefono, String toVendedor_constructora, String toVendedor_correo, String toUsuarios_nombre, String toUsuarios_telefono, String toUsuarios_correo, String toRepresentante_nombre, String toRepresentante_parentezco, String toRepresentante_direccion, String toRepresentante_telefono, String toRepresentante_banco, String toRegistros_id_usuarios, String toRegistros_fecha, String toRegistros_notas, String toRegistros_id_casos, String toClientes_nombre, String toClientes_telefono, String toClientes_correo, String toClientes_status, String toClientes_direccion, int toClientes_id_EstadoCivil, int toClientes_id_migratorio, String toClientes_profesion, String toClientes_EstadoResidencia, String toClientes_dpi, String toClientes_nit, String toClientes_UsaId, String toClientes_ClaseTraite, int toCasos_idCliente, int toCasos_idVendedor, int toCasos_idUsuario, double toCasos_honorarios, double toCasos_salario, String toCasos_notas, int toCasos_idEstado, int toCasos_idPropiedad, int toCasos_idRepresentante, int toPropiedad_id, String toPropiedad_descripcion, String error, String user_login, String pass_login) {
        this.login_user = login_user;
        this.login_pass = login_pass;
        this.login_telefono = login_telefono;
        this.login_correo = login_correo;
        this.login_tipo = login_tipo;
        this.Login_id = Login_id;
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
        this.buscar_nombre = buscar_nombre;
        this.buscar_telefono = buscar_telefono;
        this.buscar_correo = buscar_correo;
        this.nombre_vendedor = nombre_vendedor;
        this.telefono_vendedor = telefono_vendedor;
        this.constructora_vendedor = constructora_vendedor;
        this.correo_vendedor = correo_vendedor;
        this.id_vendedor = id_vendedor;
        this.nombre_representante = nombre_representante;
        this.parentezco_representante = parentezco_representante;
        this.direccion_representante = direccion_representante;
        this.telefono_representante = telefono_representante;
        this.banco_representante = banco_representante;
        this.id_representante = id_representante;
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
        this.claseTramite_cliente = claseTramite_cliente;
        this.id_cliente = id_cliente;
        this.notas_casos = notas_casos;
        this.honorarios_casos = honorarios_casos;
        this.salario_casos = salario_casos;
        this.tipo_propiedad = tipo_propiedad;
        this.fecha_registro = fecha_registro;
        this.informacion_registro = informacion_registro;
        this.idUsuario_registro = idUsuario_registro;
        this.idCaso_registro = idCaso_registro;
        this.toVendedor_nombre = toVendedor_nombre;
        this.toVendedor_telefono = toVendedor_telefono;
        this.toVendedor_constructora = toVendedor_constructora;
        this.toVendedor_correo = toVendedor_correo;
        this.toUsuarios_nombre = toUsuarios_nombre;
        this.toUsuarios_telefono = toUsuarios_telefono;
        this.toUsuarios_correo = toUsuarios_correo;
        this.toRepresentante_nombre = toRepresentante_nombre;
        this.toRepresentante_parentezco = toRepresentante_parentezco;
        this.toRepresentante_direccion = toRepresentante_direccion;
        this.toRepresentante_telefono = toRepresentante_telefono;
        this.toRepresentante_banco = toRepresentante_banco;
        this.toRegistros_id_usuarios = toRegistros_id_usuarios;
        this.toRegistros_fecha = toRegistros_fecha;
        this.toRegistros_notas = toRegistros_notas;
        this.toRegistros_id_casos = toRegistros_id_casos;
        this.toClientes_nombre = toClientes_nombre;
        this.toClientes_telefono = toClientes_telefono;
        this.toClientes_correo = toClientes_correo;
        this.toClientes_status = toClientes_status;
        this.toClientes_direccion = toClientes_direccion;
        this.toClientes_id_EstadoCivil = toClientes_id_EstadoCivil;
        this.toClientes_id_migratorio = toClientes_id_migratorio;
        this.toClientes_profesion = toClientes_profesion;
        this.toClientes_EstadoResidencia = toClientes_EstadoResidencia;
        this.toClientes_dpi = toClientes_dpi;
        this.toClientes_nit = toClientes_nit;
        this.toClientes_UsaId = toClientes_UsaId;
        this.toClientes_ClaseTraite = toClientes_ClaseTraite;
        this.toCasos_idCliente = toCasos_idCliente;
        this.toCasos_idVendedor = toCasos_idVendedor;
        this.toCasos_idUsuario = toCasos_idUsuario;
        this.toCasos_honorarios = toCasos_honorarios;
        this.toCasos_salario = toCasos_salario;
        this.toCasos_notas = toCasos_notas;
        this.toCasos_idEstado = toCasos_idEstado;
        this.toCasos_idPropiedad = toCasos_idPropiedad;
        this.toCasos_idRepresentante = toCasos_idRepresentante;
        this.toPropiedad_id = toPropiedad_id;
        this.toPropiedad_descripcion = toPropiedad_descripcion;
        this.error = error;
        this.user_login = user_login;
        this.pass_login = pass_login;
    }

      
    
      
    public DatosVO() {
       
    }

    //----------------------Setter and Getter
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

    public String getToVendedor_nombre() {
        return toVendedor_nombre;
    }

    public void setToVendedor_nombre(String toVendedor_nombre) {
        this.toVendedor_nombre = toVendedor_nombre;
    }

    public String getToVendedor_telefono() {
        return toVendedor_telefono;
    }

    public void setToVendedor_telefono(String toVendedor_telefono) {
        this.toVendedor_telefono = toVendedor_telefono;
    }

    public String getToVendedor_constructora() {
        return toVendedor_constructora;
    }

    public void setToVendedor_constructora(String toVendedor_constructora) {
        this.toVendedor_constructora = toVendedor_constructora;
    }

    public String getToVendedor_correo() {
        return toVendedor_correo;
    }

    public void setToVendedor_correo(String toVendedor_correo) {
        this.toVendedor_correo = toVendedor_correo;
    }

    public String getToUsuarios_nombre() {
        return toUsuarios_nombre;
    }

    public void setToUsuarios_nombre(String toUsuarios_nombre) {
        this.toUsuarios_nombre = toUsuarios_nombre;
    }

    public String getToUsuarios_telefono() {
        return toUsuarios_telefono;
    }

    public void setToUsuarios_telefono(String toUsuarios_telefono) {
        this.toUsuarios_telefono = toUsuarios_telefono;
    }

    public String getToUsuarios_correo() {
        return toUsuarios_correo;
    }

    public void setToUsuarios_correo(String toUsuarios_correo) {
        this.toUsuarios_correo = toUsuarios_correo;
    }

    public String getToRepresentante_nombre() {
        return toRepresentante_nombre;
    }

    public void setToRepresentante_nombre(String toRepresentante_nombre) {
        this.toRepresentante_nombre = toRepresentante_nombre;
    }

    public String getToRepresentante_parentezco() {
        return toRepresentante_parentezco;
    }

    public void setToRepresentante_parentezco(String toRepresentante_parentezco) {
        this.toRepresentante_parentezco = toRepresentante_parentezco;
    }

    public String getToRepresentante_direccion() {
        return toRepresentante_direccion;
    }

    public void setToRepresentante_direccion(String toRepresentante_direccion) {
        this.toRepresentante_direccion = toRepresentante_direccion;
    }

    public String getToRepresentante_telefono() {
        return toRepresentante_telefono;
    }

    public void setToRepresentante_telefono(String toRepresentante_telefono) {
        this.toRepresentante_telefono = toRepresentante_telefono;
    }

    public String getToRepresentante_banco() {
        return toRepresentante_banco;
    }

    public void setToRepresentante_banco(String toRepresentante_banco) {
        this.toRepresentante_banco = toRepresentante_banco;
    }

    public String getToRegistros_id_usuarios() {
        return toRegistros_id_usuarios;
    }

    public void setToRegistros_id_usuarios(String toRegistros_id_usuarios) {
        this.toRegistros_id_usuarios = toRegistros_id_usuarios;
    }

    public String getToRegistros_fecha() {
        return toRegistros_fecha;
    }

    public void setToRegistros_fecha(String toRegistros_fecha) {
        this.toRegistros_fecha = toRegistros_fecha;
    }

    public String getToRegistros_notas() {
        return toRegistros_notas;
    }

    public void setToRegistros_notas(String toRegistros_notas) {
        this.toRegistros_notas = toRegistros_notas;
    }

    public String getToRegistros_id_casos() {
        return toRegistros_id_casos;
    }

    public void setToRegistros_id_casos(String toRegistros_id_casos) {
        this.toRegistros_id_casos = toRegistros_id_casos;
    }

    public String getToClientes_nombre() {
        return toClientes_nombre;
    }

    public void setToClientes_nombre(String toClientes_nombre) {
        this.toClientes_nombre = toClientes_nombre;
    }

    public String getToClientes_telefono() {
        return toClientes_telefono;
    }

    public void setToClientes_telefono(String toClientes_telefono) {
        this.toClientes_telefono = toClientes_telefono;
    }

    public String getToClientes_correo() {
        return toClientes_correo;
    }

    public void setToClientes_correo(String toClientes_correo) {
        this.toClientes_correo = toClientes_correo;
    }

    public String getToClientes_status() {
        return toClientes_status;
    }

    public void setToClientes_status(String toClientes_status) {
        this.toClientes_status = toClientes_status;
    }

    public String getToClientes_direccion() {
        return toClientes_direccion;
    }

    public void setToClientes_direccion(String toClientes_direccion) {
        this.toClientes_direccion = toClientes_direccion;
    }

    public int getToClientes_id_EstadoCivil() {
        return toClientes_id_EstadoCivil;
    }

    public void setToClientes_id_EstadoCivil(int toClientes_id_EstadoCivil) {
        this.toClientes_id_EstadoCivil = toClientes_id_EstadoCivil;
    }

    public int getToClientes_id_migratorio() {
        return toClientes_id_migratorio;
    }

    public void setToClientes_id_migratorio(int toClientes_id_migratorio) {
        this.toClientes_id_migratorio = toClientes_id_migratorio;
    }

    public String getToClientes_profesion() {
        return toClientes_profesion;
    }

    public void setToClientes_profesion(String toClientes_profesion) {
        this.toClientes_profesion = toClientes_profesion;
    }

    public String getToClientes_EstadoResidencia() {
        return toClientes_EstadoResidencia;
    }

    public void setToClientes_EstadoResidencia(String toClientes_EstadoResidencia) {
        this.toClientes_EstadoResidencia = toClientes_EstadoResidencia;
    }

    public String getToClientes_dpi() {
        return toClientes_dpi;
    }

    public void setToClientes_dpi(String toClientes_dpi) {
        this.toClientes_dpi = toClientes_dpi;
    }

    public String getToClientes_nit() {
        return toClientes_nit;
    }

    public void setToClientes_nit(String toClientes_nit) {
        this.toClientes_nit = toClientes_nit;
    }

    public String getToClientes_UsaId() {
        return toClientes_UsaId;
    }

    public void setToClientes_UsaId(String toClientes_UsaId) {
        this.toClientes_UsaId = toClientes_UsaId;
    }

    public int getToCasos_idCliente() {
        return toCasos_idCliente;
    }

    public void setToCasos_idCliente(int toCasos_idCliente) {
        this.toCasos_idCliente = toCasos_idCliente;
    }

    public int getToCasos_idVendedor() {
        return toCasos_idVendedor;
    }

    public void setToCasos_idVendedor(int toCasos_idVendedor) {
        this.toCasos_idVendedor = toCasos_idVendedor;
    }

    public int getToCasos_idUsuario() {
        return toCasos_idUsuario;
    }

    public void setToCasos_idUsuario(int toCasos_idUsuario) {
        this.toCasos_idUsuario = toCasos_idUsuario;
    }

    public double getToCasos_honorarios() {
        return toCasos_honorarios;
    }

    public void setToCasos_honorarios(double toCasos_honorarios) {
        this.toCasos_honorarios = toCasos_honorarios;
    }

    public double getToCasos_salario() {
        return toCasos_salario;
    }

    public void setToCasos_salario(double toCasos_salario) {
        this.toCasos_salario = toCasos_salario;
    }

    public String getToCasos_notas() {
        return toCasos_notas;
    }

    public void setToCasos_notas(String toCasos_notas) {
        this.toCasos_notas = toCasos_notas;
    }

    public int getToCasos_idEstado() {
        return toCasos_idEstado;
    }

    public void setToCasos_idEstado(int toCasos_idEstado) {
        this.toCasos_idEstado = toCasos_idEstado;
    }

    public int getToCasos_idPropiedad() {
        return toCasos_idPropiedad;
    }

    public void setToCasos_idPropiedad(int toCasos_idPropiedad) {
        this.toCasos_idPropiedad = toCasos_idPropiedad;
    }

    public int getToCasos_idRepresentante() {
        return toCasos_idRepresentante;
    }

    public void setToCasos_idRepresentante(int toCasos_idRepresentante) {
        this.toCasos_idRepresentante = toCasos_idRepresentante;
    }

    public double getHonorarios_casos() {
        return honorarios_casos;
    }

    public void setHonorarios_casos(double honorarios_casos) {
        this.honorarios_casos = honorarios_casos;
    }

    public double getSalario_casos() {
        return salario_casos;
    }

    public void setSalario_casos(double salario_casos) {
        this.salario_casos = salario_casos;
    }

    public String getClaseTramite_cliente() {
        return claseTramite_cliente;
    }

    public void setClaseTramite_cliente(String claseTramite_cliente) {
        this.claseTramite_cliente = claseTramite_cliente;
    }

    public String getToClientes_ClaseTraite() {
        return toClientes_ClaseTraite;
    }

    public void setToClientes_ClaseTraite(String toClientes_ClaseTraite) {
        this.toClientes_ClaseTraite = toClientes_ClaseTraite;
    }

    public int getToPropiedad_id() {
        return toPropiedad_id;
    }

    public void setToPropiedad_id(int toPropiedad_id) {
        this.toPropiedad_id = toPropiedad_id;
    }

    public String getToPropiedad_descripcion() {
        return toPropiedad_descripcion;
    }

    public void setToPropiedad_descripcion(String toPropiedad_descripcion) {
        this.toPropiedad_descripcion = toPropiedad_descripcion;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getInformacion_registro() {
        return informacion_registro;
    }

    public void setInformacion_registro(String informacion_registro) {
        this.informacion_registro = informacion_registro;
    }

    public int getIdUsuario_registro() {
        return idUsuario_registro;
    }

    public void setIdUsuario_registro(int idUsuario_registro) {
        this.idUsuario_registro = idUsuario_registro;
    }

    public int getIdCaso_registro() {
        return idCaso_registro;
    }

    public void setIdCaso_registro(int idCaso_registro) {
        this.idCaso_registro = idCaso_registro;
    }

    public int getLogin_id() {
        return Login_id;
    }

    public void setLogin_id(int Login_id) {
        this.Login_id = Login_id;
    }

    public String getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(String id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getId_representante() {
        return id_representante;
    }

    public void setId_representante(String id_representante) {
        this.id_representante = id_representante;
    }
    
    
}
