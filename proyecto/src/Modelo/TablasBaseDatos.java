/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jroque
 */
//---------------- Aqui se encuentan los metodo que traen toda la informcion de las tablas
public class TablasBaseDatos implements InterfaceTablasBase {

    @Override
    public ArrayList<StringsBaseDatos> TablaVendedor(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        try {
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_vendedor WHERE nombre = '" + dvo.getNombre_vendedor() + ";");
            c.desconectar();
            while (rs.next()) {
                sbd.setId_vendedor_sbd(rs.getInt(0));
                sbd.setNombre_vendedor_sbd(rs.getString(1));
                sbd.setTelefono_vendedor_sbd(rs.getString(2));
                sbd.setConstructora_vendedor_sbd(rs.getString(3));
                sbd.setCorreo_vendedor_sbd(rs.getString(4));

                datos.add(sbd);
            }
            c.connect();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaUsuario(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT id, nombre, telefono, correo FROM tbl_usuarios WHERE nombre = '" + dvo.getUser_login() + ";");

            while (rs.next()) {
                sbd.setId_usuario_sbd(rs.getInt(1));
                sbd.setNombre_usuario_sbd(rs.getString(2));
                sbd.setTelefono_usuario_sbd(rs.getString(3));
                sbd.setCorreo_usuario_sbd(rs.getString(4));

                datos.add(sbd);
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaPropiedad(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_tipo_propiedad;");

            while (rs.next()) {
                sbd.setId_propiedad_sbd(rs.getInt(0));
                sbd.setDescripcion_propiedad_sbd(rs.getString(1));
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaRepresentante(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_representante;");
            
            while (rs.next()) {                
                sbd.setId_representante_sbd(rs.getInt(0));
                sbd.setNombre_representante_sbd(rs.getString(1));
                sbd.setParentezco_representante_sbd(rs.getString(2));
                sbd.setDireccion_representante_sbd(rs.getString(3));
                sbd.setTelefono_representante_sbd(rs.getString(4));
                sbd.setBanco_representante_sbd(rs.getString(5));
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaRegistros(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT id_usuario, fecha, notas FROM tbl_registros WHERE id_casos = "+sbd.getId_casos_sbd()+";");
            
            while (rs.next()) {                
                sbd.setId_usuarios_registros_sbd(rs.getInt(1));
                sbd.setFecha_registros_sbd(rs.getString(2));
                sbd.setNotas_registros_sbd(rs.getString(3));
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaMigratorio(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_migratorio;");
                    
            while (rs.next()) {                
                sbd.setId_migratorio_sbd(rs.getInt(0));
                sbd.setDescripcion_migratorio_sbd(rs.getString(1));
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaEstadoCivil(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_estado_civil;");
                    
            while (rs.next()) {                
                sbd.setId_EstadoCivil_sbd(rs.getInt(0));
                sbd.setDescripcion_EstadoCivil_sbd(rs.getString(1));
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaEstado(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_estado;");
                    
            while (rs.next()) {                
                sbd.setId_estado_sbd(rs.getInt(0));
                sbd.setDescripcion_estdo_sbd(rs.getString(1));
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaClientes(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos(consultaSQL);
                    
            while (rs.next()) {                
                
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> TablaCasos(StringsBaseDatos sbd) {
        Conector c = new Conector();
        DatosVO dvo = new DatosVO();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos(consultaSQL);
                    
            while (rs.next()) {                
                
            }
            c.desconectar();
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

}