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


public class StringsBaseDatos {
    //----Tabla Vendedor
    private int id_vendedor_sbd;
    private String nombre_vendedor_sbd, telefono_vendedor_sbd, constructora_vendedor_sbd, correo_vendedor_sbd;
    private String nombre_vendedor_buscador_sbd;
    
     //----Tabla Usuario
    private int id_usuario_sbd;
    private String nombre_usuario_sbd, telefono_usuario_sbd, correo_usuario_sbd;
    
    //----Tabla propiedad
    private int id_propiedad_sbd;
    private String descripcion_propiedad_sbd;
    
    //----Tabla representante
    private int id_representante_sbd;
    private String nombre_representante_sbd, parentezco_representante_sbd, direccion_representante_sbd, telefono_representante_sbd, banco_representante_sbd;
    
    //----Tabla registros
    private int id_registros_sbd, id_usuarios_registros_sbd, id_casos_registros_sbd;
    private String fecha_registros_sbd, notas_registros_sbd;
    
    //----Tabla migratorio
    private int id_migratorio_sbd;
    private String descripcion_migratorio_sbd;
    
    //----Tabla estado civil
    private int id_EstadoCivil_sbd;
    private String descripcion_EstadoCivil_sbd;
    
    //----Tabla estado
    private int id_estado_sbd;
    private String tipo_estdo_sbd, descripcion_estdo_sbd;
    
    //----Tabla clientes
    private int id_clientes_sbd, id_EstadoCivil_clientes_sbd, id_migratorio_clientes_sbd;
    private String nombre_clientes_sbd, telefono_clientes_sbd, correo_clientes_sbd, estatus_clientes_sbd, direccion_clientes_sbd, profecion_clientes_sbd,
            EstadoResidencia_clientes_sbd, dpi_clientes_sbd, nit_clientes_sbd, usaId_clientes_sbd;
    
    //----Tabla casos
    private int id_casos_sbd, id_clientes_casos_sbd, id_vendedor_casos_sbd, id_usuario_casos_sbd, id_estado_casos_sbd, id_propiedad_casos_sbd, id_representante_casos_sbd;
    private double honorario_casos_sbd, salario_casos_sbd;
    private String notas_casos_sbd;

    public StringsBaseDatos(int id_vendedor_sbd, String nombre_vendedor_sbd, String telefono_vendedor_sbd, String constructora_vendedor_sbd, String correo_vendedor_sbd, String nombre_vendedor_buscador_sbd, int id_usuario_sbd, String nombre_usuario_sbd, String telefono_usuario_sbd, String correo_usuario_sbd, int id_propiedad_sbd, String descripcion_propiedad_sbd, int id_representante_sbd, String nombre_representante_sbd, String parentezco_representante_sbd, String direccion_representante_sbd, String telefono_representante_sbd, String banco_representante_sbd, int id_registros_sbd, int id_usuarios_registros_sbd, int id_casos_registros_sbd, String fecha_registros_sbd, String notas_registros_sbd, int id_migratorio_sbd, String descripcion_migratorio_sbd, int id_EstadoCivil_sbd, String descripcion_EstadoCivil_sbd, int id_estado_sbd, String tipo_estdo_sbd, String descripcion_estdo_sbd, int id_clientes_sbd, int id_EstadoCivil_clientes_sbd, int id_migratorio_clientes_sbd, String nombre_clientes_sbd, String telefono_clientes_sbd, String correo_clientes_sbd, String estatus_clientes_sbd, String direccion_clientes_sbd, String profecion_clientes_sbd, String EstadoResidencia_clientes_sbd, String dpi_clientes_sbd, String nit_clientes_sbd, String usaId_clientes_sbd, int id_casos_sbd, int id_clientes_casos_sbd, int id_vendedor_casos_sbd, int id_usuario_casos_sbd, int id_estado_casos_sbd, int id_propiedad_casos_sbd, int id_representante_casos_sbd, double honorario_casos_sbd, double salario_casos_sbd, String notas_casos_sbd) {
        this.id_vendedor_sbd = id_vendedor_sbd;
        this.nombre_vendedor_sbd = nombre_vendedor_sbd;
        this.telefono_vendedor_sbd = telefono_vendedor_sbd;
        this.constructora_vendedor_sbd = constructora_vendedor_sbd;
        this.correo_vendedor_sbd = correo_vendedor_sbd;
        this.nombre_vendedor_buscador_sbd = nombre_vendedor_buscador_sbd;
        this.id_usuario_sbd = id_usuario_sbd;
        this.nombre_usuario_sbd = nombre_usuario_sbd;
        this.telefono_usuario_sbd = telefono_usuario_sbd;
        this.correo_usuario_sbd = correo_usuario_sbd;
        this.id_propiedad_sbd = id_propiedad_sbd;
        this.descripcion_propiedad_sbd = descripcion_propiedad_sbd;
        this.id_representante_sbd = id_representante_sbd;
        this.nombre_representante_sbd = nombre_representante_sbd;
        this.parentezco_representante_sbd = parentezco_representante_sbd;
        this.direccion_representante_sbd = direccion_representante_sbd;
        this.telefono_representante_sbd = telefono_representante_sbd;
        this.banco_representante_sbd = banco_representante_sbd;
        this.id_registros_sbd = id_registros_sbd;
        this.id_usuarios_registros_sbd = id_usuarios_registros_sbd;
        this.id_casos_registros_sbd = id_casos_registros_sbd;
        this.fecha_registros_sbd = fecha_registros_sbd;
        this.notas_registros_sbd = notas_registros_sbd;
        this.id_migratorio_sbd = id_migratorio_sbd;
        this.descripcion_migratorio_sbd = descripcion_migratorio_sbd;
        this.id_EstadoCivil_sbd = id_EstadoCivil_sbd;
        this.descripcion_EstadoCivil_sbd = descripcion_EstadoCivil_sbd;
        this.id_estado_sbd = id_estado_sbd;
        this.tipo_estdo_sbd = tipo_estdo_sbd;
        this.descripcion_estdo_sbd = descripcion_estdo_sbd;
        this.id_clientes_sbd = id_clientes_sbd;
        this.id_EstadoCivil_clientes_sbd = id_EstadoCivil_clientes_sbd;
        this.id_migratorio_clientes_sbd = id_migratorio_clientes_sbd;
        this.nombre_clientes_sbd = nombre_clientes_sbd;
        this.telefono_clientes_sbd = telefono_clientes_sbd;
        this.correo_clientes_sbd = correo_clientes_sbd;
        this.estatus_clientes_sbd = estatus_clientes_sbd;
        this.direccion_clientes_sbd = direccion_clientes_sbd;
        this.profecion_clientes_sbd = profecion_clientes_sbd;
        this.EstadoResidencia_clientes_sbd = EstadoResidencia_clientes_sbd;
        this.dpi_clientes_sbd = dpi_clientes_sbd;
        this.nit_clientes_sbd = nit_clientes_sbd;
        this.usaId_clientes_sbd = usaId_clientes_sbd;
        this.id_casos_sbd = id_casos_sbd;
        this.id_clientes_casos_sbd = id_clientes_casos_sbd;
        this.id_vendedor_casos_sbd = id_vendedor_casos_sbd;
        this.id_usuario_casos_sbd = id_usuario_casos_sbd;
        this.id_estado_casos_sbd = id_estado_casos_sbd;
        this.id_propiedad_casos_sbd = id_propiedad_casos_sbd;
        this.id_representante_casos_sbd = id_representante_casos_sbd;
        this.honorario_casos_sbd = honorario_casos_sbd;
        this.salario_casos_sbd = salario_casos_sbd;
        this.notas_casos_sbd = notas_casos_sbd;
    }

    

    public StringsBaseDatos() {
    }
    
    public int getId_vendedor_sbd() {
        return id_vendedor_sbd;
    }

    public void setId_vendedor_sbd(int id_vendedor_sbd) {
        this.id_vendedor_sbd = id_vendedor_sbd;
    }

    public String getNombre_vendedor_sbd() {
        return nombre_vendedor_sbd;
    }

    public void setNombre_vendedor_sbd(String nombre_vendedor_sbd) {
        this.nombre_vendedor_sbd = nombre_vendedor_sbd;
    }

    public String getTelefono_vendedor_sbd() {
        return telefono_vendedor_sbd;
    }

    public void setTelefono_vendedor_sbd(String telefono_vendedor_sbd) {
        this.telefono_vendedor_sbd = telefono_vendedor_sbd;
    }

    public String getConstructora_vendedor_sbd() {
        return constructora_vendedor_sbd;
    }

    public void setConstructora_vendedor_sbd(String constructora_vendedor_sbd) {
        this.constructora_vendedor_sbd = constructora_vendedor_sbd;
    }

    public String getCorreo_vendedor_sbd() {
        return correo_vendedor_sbd;
    }

    public void setCorreo_vendedor_sbd(String correo_vendedor_sbd) {
        this.correo_vendedor_sbd = correo_vendedor_sbd;
    }

    public int getId_propiedad_sbd() {
        return id_propiedad_sbd;
    }

    public void setId_propiedad_sbd(int id_propiedad_sbd) {
        this.id_propiedad_sbd = id_propiedad_sbd;
    }

    public String getDescripcion_propiedad_sbd() {
        return descripcion_propiedad_sbd;
    }

    public void setDescripcion_propiedad_sbd(String descripcion_propiedad_sbd) {
        this.descripcion_propiedad_sbd = descripcion_propiedad_sbd;
    }

    public int getId_representante_sbd() {
        return id_representante_sbd;
    }

    public void setId_representante_sbd(int id_representante_sbd) {
        this.id_representante_sbd = id_representante_sbd;
    }

    public String getNombre_representante_sbd() {
        return nombre_representante_sbd;
    }

    public void setNombre_representante_sbd(String nombre_representante_sbd) {
        this.nombre_representante_sbd = nombre_representante_sbd;
    }

    public String getParentezco_representante_sbd() {
        return parentezco_representante_sbd;
    }

    public void setParentezco_representante_sbd(String parentezco_representante_sbd) {
        this.parentezco_representante_sbd = parentezco_representante_sbd;
    }

    public String getDireccion_representante_sbd() {
        return direccion_representante_sbd;
    }

    public void setDireccion_representante_sbd(String direccion_representante_sbd) {
        this.direccion_representante_sbd = direccion_representante_sbd;
    }

    public String getTelefono_representante_sbd() {
        return telefono_representante_sbd;
    }

    public void setTelefono_representante_sbd(String telefono_representante_sbd) {
        this.telefono_representante_sbd = telefono_representante_sbd;
    }

    public String getBanco_representante_sbd() {
        return banco_representante_sbd;
    }

    public void setBanco_representante_sbd(String banco_representante_sbd) {
        this.banco_representante_sbd = banco_representante_sbd;
    }

    public int getId_registros_sbd() {
        return id_registros_sbd;
    }

    public void setId_registros_sbd(int id_registros_sbd) {
        this.id_registros_sbd = id_registros_sbd;
    }

    public int getId_usuarios_registros_sbd() {
        return id_usuarios_registros_sbd;
    }

    public void setId_usuarios_registros_sbd(int id_usuarios_registros_sbd) {
        this.id_usuarios_registros_sbd = id_usuarios_registros_sbd;
    }

    public int getId_casos_registros_sbd() {
        return id_casos_registros_sbd;
    }

    public void setId_casos_registros_sbd(int id_casos_registros_sbd) {
        this.id_casos_registros_sbd = id_casos_registros_sbd;
    }

    public String getNotas_registros_sbd() {
        return notas_registros_sbd;
    }

    public void setNotas_registros_sbd(String notas_registros_sbd) {
        this.notas_registros_sbd = notas_registros_sbd;
    }

    public int getId_migratorio_sbd() {
        return id_migratorio_sbd;
    }

    public void setId_migratorio_sbd(int id_migratorio_sbd) {
        this.id_migratorio_sbd = id_migratorio_sbd;
    }

    public String getDescripcion_migratorio_sbd() {
        return descripcion_migratorio_sbd;
    }

    public void setDescripcion_migratorio_sbd(String descripcion_migratorio_sbd) {
        this.descripcion_migratorio_sbd = descripcion_migratorio_sbd;
    }

    public int getId_EstadoCivil_sbd() {
        return id_EstadoCivil_sbd;
    }

    public void setId_EstadoCivil_sbd(int id_EstadoCivil_sbd) {
        this.id_EstadoCivil_sbd = id_EstadoCivil_sbd;
    }

    public String getDescripcion_EstadoCivil_sbd() {
        return descripcion_EstadoCivil_sbd;
    }

    public void setDescripcion_EstadoCivil_sbd(String descripcion_EstadoCivil_sbd) {
        this.descripcion_EstadoCivil_sbd = descripcion_EstadoCivil_sbd;
    }

    public int getId_estado_sbd() {
        return id_estado_sbd;
    }

    public void setId_estado_sbd(int id_estado_sbd) {
        this.id_estado_sbd = id_estado_sbd;
    }

    public String getTipo_estdo_sbd() {
        return tipo_estdo_sbd;
    }

    public void setTipo_estdo_sbd(String tipo_estdo_sbd) {
        this.tipo_estdo_sbd = tipo_estdo_sbd;
    }

    public String getDescripcion_estdo_sbd() {
        return descripcion_estdo_sbd;
    }

    public void setDescripcion_estdo_sbd(String descripcion_estdo_sbd) {
        this.descripcion_estdo_sbd = descripcion_estdo_sbd;
    }

    public int getId_clientes_sbd() {
        return id_clientes_sbd;
    }

    public void setId_clientes_sbd(int id_clientes_sbd) {
        this.id_clientes_sbd = id_clientes_sbd;
    }

    public int getId_EstadoCivil_clientes_sbd() {
        return id_EstadoCivil_clientes_sbd;
    }

    public void setId_EstadoCivil_clientes_sbd(int id_EstadoCivil_clientes_sbd) {
        this.id_EstadoCivil_clientes_sbd = id_EstadoCivil_clientes_sbd;
    }

    public int getId_migratorio_clientes_sbd() {
        return id_migratorio_clientes_sbd;
    }

    public void setId_migratorio_clientes_sbd(int id_migratorio_clientes_sbd) {
        this.id_migratorio_clientes_sbd = id_migratorio_clientes_sbd;
    }

    public String getNombre_clientes_sbd() {
        return nombre_clientes_sbd;
    }

    public void setNombre_clientes_sbd(String nombre_clientes_sbd) {
        this.nombre_clientes_sbd = nombre_clientes_sbd;
    }

    public String getTelefono_clientes_sbd() {
        return telefono_clientes_sbd;
    }

    public void setTelefono_clientes_sbd(String telefono_clientes_sbd) {
        this.telefono_clientes_sbd = telefono_clientes_sbd;
    }

    public String getCorreo_clientes_sbd() {
        return correo_clientes_sbd;
    }

    public void setCorreo_clientes_sbd(String correo_clientes_sbd) {
        this.correo_clientes_sbd = correo_clientes_sbd;
    }

    public String getEstatus_clientes_sbd() {
        return estatus_clientes_sbd;
    }

    public void setEstatus_clientes_sbd(String estatus_clientes_sbd) {
        this.estatus_clientes_sbd = estatus_clientes_sbd;
    }

    public String getDireccion_clientes_sbd() {
        return direccion_clientes_sbd;
    }

    public void setDireccion_clientes_sbd(String direccion_clientes_sbd) {
        this.direccion_clientes_sbd = direccion_clientes_sbd;
    }

    public String getProfecion_clientes_sbd() {
        return profecion_clientes_sbd;
    }

    public void setProfecion_clientes_sbd(String profecion_clientes_sbd) {
        this.profecion_clientes_sbd = profecion_clientes_sbd;
    }

    public String getEstadoResidencia_clientes_sbd() {
        return EstadoResidencia_clientes_sbd;
    }

    public void setEstadoResidencia_clientes_sbd(String EstadoResidencia_clientes_sbd) {
        this.EstadoResidencia_clientes_sbd = EstadoResidencia_clientes_sbd;
    }

    public String getDpi_clientes_sbd() {
        return dpi_clientes_sbd;
    }

    public void setDpi_clientes_sbd(String dpi_clientes_sbd) {
        this.dpi_clientes_sbd = dpi_clientes_sbd;
    }

    public String getNit_clientes_sbd() {
        return nit_clientes_sbd;
    }

    public void setNit_clientes_sbd(String nit_clientes_sbd) {
        this.nit_clientes_sbd = nit_clientes_sbd;
    }

    public String getUsaId_clientes_sbd() {
        return usaId_clientes_sbd;
    }

    public void setUsaId_clientes_sbd(String usaId_clientes_sbd) {
        this.usaId_clientes_sbd = usaId_clientes_sbd;
    }

    public int getId_casos_sbd() {
        return id_casos_sbd;
    }

    public void setId_casos_sbd(int id_casos_sbd) {
        this.id_casos_sbd = id_casos_sbd;
    }

    public int getId_clientes_casos_sbd() {
        return id_clientes_casos_sbd;
    }

    public void setId_clientes_casos_sbd(int id_clientes_casos_sbd) {
        this.id_clientes_casos_sbd = id_clientes_casos_sbd;
    }

    public int getId_vendedor_casos_sbd() {
        return id_vendedor_casos_sbd;
    }

    public void setId_vendedor_casos_sbd(int id_vendedor_casos_sbd) {
        this.id_vendedor_casos_sbd = id_vendedor_casos_sbd;
    }

    public int getId_usuario_casos_sbd() {
        return id_usuario_casos_sbd;
    }

    public void setId_usuario_casos_sbd(int id_usuario_casos_sbd) {
        this.id_usuario_casos_sbd = id_usuario_casos_sbd;
    }

    public int getId_estado_casos_sbd() {
        return id_estado_casos_sbd;
    }

    public void setId_estado_casos_sbd(int id_estado_casos_sbd) {
        this.id_estado_casos_sbd = id_estado_casos_sbd;
    }

    public int getId_propiedad_casos_sbd() {
        return id_propiedad_casos_sbd;
    }

    public void setId_propiedad_casos_sbd(int id_propiedad_casos_sbd) {
        this.id_propiedad_casos_sbd = id_propiedad_casos_sbd;
    }

    public int getId_representante_casos_sbd() {
        return id_representante_casos_sbd;
    }

    public void setId_representante_casos_sbd(int id_representante_casos_sbd) {
        this.id_representante_casos_sbd = id_representante_casos_sbd;
    }

    public double getHonorario_casos_sbd() {
        return honorario_casos_sbd;
    }

    public void setHonorario_casos_sbd(double honorario_casos_sbd) {
        this.honorario_casos_sbd = honorario_casos_sbd;
    }

    public double getSalario_casos_sbd() {
        return salario_casos_sbd;
    }

    public void setSalario_casos_sbd(double salario_casos_sbd) {
        this.salario_casos_sbd = salario_casos_sbd;
    }

    public String getNotas_casos_sbd() {
        return notas_casos_sbd;
    }

    public void setNotas_casos_sbd(String notas_casos_sbd) {
        this.notas_casos_sbd = notas_casos_sbd;
    }

    public String getNombre_usuario_sbd() {
        return nombre_usuario_sbd;
    }

    public void setNombre_usuario_sbd(String nombre_usuario_sbd) {
        this.nombre_usuario_sbd = nombre_usuario_sbd;
    }

    public String getTelefono_usuario_sbd() {
        return telefono_usuario_sbd;
    }

    public void setTelefono_usuario_sbd(String telefono_usuario_sbd) {
        this.telefono_usuario_sbd = telefono_usuario_sbd;
    }

    public String getCorreo_usuario_sbd() {
        return correo_usuario_sbd;
    }

    public void setCorreo_usuario_sbd(String correo_usuario_sbd) {
        this.correo_usuario_sbd = correo_usuario_sbd;
    }

    public int getId_usuario_sbd() {
        return id_usuario_sbd;
    }

    public void setId_usuario_sbd(int id_usuario_sbd) {
        this.id_usuario_sbd = id_usuario_sbd;
    }

    public String getFecha_registros_sbd() {
        return fecha_registros_sbd;
    }

    public void setFecha_registros_sbd(String fecha_registros_sbd) {
        this.fecha_registros_sbd = fecha_registros_sbd;
    }

    public String getNombre_vendedor_buscador_sbd() {
        return nombre_vendedor_buscador_sbd;
    }

    public void setNombre_vendedor_buscador_sbd(String nombre_vendedor_buscador_sbd) {
        this.nombre_vendedor_buscador_sbd = nombre_vendedor_buscador_sbd;
    }
    
         
}
