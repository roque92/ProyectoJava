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

    ///------------ORDEN DE EJECUCION 8
    @Override
    public ArrayList<StringsBaseDatos> TablaVendedor(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        try {

            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_vendedor WHERE nombre LIKE '%" + sbd.getNombre_vendedor_buscador_sbd() + "%';");

            while (rs.next()) {
                StringsBaseDatos sbd1 = new StringsBaseDatos();
                sbd1.setId_vendedor_sbd(rs.getInt(1));
                sbd1.setNombre_vendedor_sbd(rs.getString(2));
                sbd1.setTelefono_vendedor_sbd(rs.getString(3));
                sbd1.setConstructora_vendedor_sbd(rs.getString(4));
                sbd1.setCorreo_vendedor_sbd(rs.getString(5));

                datos.add(sbd1);

            }

            c.desconectar();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 1

    @Override
    public ArrayList<StringsBaseDatos> TablaUsuario(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT id, nombre, telefono, correo FROM tbl_usuarios WHERE nombre = '" + sbd.getUsername_login_sbd()+ ";");

            while (rs.next()) {
                sbd.setId_usuario_sbd(rs.getInt(1));
                sbd.setNombre_usuario_sbd(rs.getString(2));
                sbd.setTelefono_usuario_sbd(rs.getString(3));
                sbd.setCorreo_usuario_sbd(rs.getString(4));

                datos.add(sbd);
            }
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 2

    @Override
    public ArrayList<StringsBaseDatos> TablaPropiedad(StringsBaseDatos sbd) {
        Conector c = new Conector();
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
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 3

    @Override
    public ArrayList<StringsBaseDatos> TablaRepresentante(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_representante WHERE nombre = '" + sbd.getNombre_representante_sbd()+ " ;");

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
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 10

    @Override
    public ArrayList<StringsBaseDatos> TablaRegistros(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT id_usuario, fecha, notas FROM tbl_registros WHERE id_casos = " + sbd.getId_casos_sbd() + ";");

            while (rs.next()) {
                sbd.setId_usuarios_registros_sbd(rs.getInt(1));
                sbd.setFecha_registros_sbd(rs.getString(2));
                sbd.setNotas_registros_sbd(rs.getString(3));
            }
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 6

    @Override
    public ArrayList<StringsBaseDatos> TablaEstado(StringsBaseDatos sbd) {
        Conector c = new Conector();
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
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 7

    @Override
    public ArrayList<StringsBaseDatos> TablaClientes(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_clientes INNER JOIN tbl_estado_civil INNER JOIN tbl_migratorio WHERE nombre LIKE '%" + sbd.getNombre_cliente_buscador_sbd() + "%';");

            while (rs.next()) {
                StringsBaseDatos sbd1 = new StringsBaseDatos();
                sbd1.setId_clientes_sbd(rs.getInt(1));
                sbd1.setNombre_clientes_sbd(rs.getString(2));
                sbd1.setTelefono_clientes_sbd(rs.getString(3));
                sbd1.setCorreo_clientes_sbd(rs.getString(4));
                sbd1.setEstatus_clientes_sbd(rs.getString(5));
                sbd1.setDireccion_clientes_sbd(rs.getString(6));
                sbd1.setId_EstadoCivil_clientes_sbd(rs.getInt(7));
                sbd1.setId_migratorio_clientes_sbd(rs.getInt(8));
                sbd1.setProfecion_clientes_sbd(rs.getString(9));
                sbd1.setEstadoResidencia_clientes_sbd(rs.getString(10));
                sbd1.setDpi_clientes_sbd(rs.getString(11));
                sbd1.setNit_clientes_sbd(rs.getString(12));
                sbd1.setUsaId_clientes_sbd(rs.getString(13));
                sbd1.setId_EstadoCivil_sbd(rs.getInt(14));
                sbd1.setDescripcion_EstadoCivil_sbd(rs.getString(15));
                sbd1.setId_migratorio_sbd(rs.getInt(16));
                sbd1.setDescripcion_migratorio_sbd(rs.getString(17));

                datos.add(sbd1);
            }
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }
///------------ORDEN DE EJECUCION 9

    @Override
    public ArrayList<StringsBaseDatos> TablaCasos(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_casos WHERE id_cliente = " + sbd.getId_clientes_sbd() + ";");

            while (rs.next()) {
                sbd.setId_casos_sbd(rs.getInt(0));
                sbd.setId_clientes_casos_sbd(rs.getInt(1));
                sbd.setId_vendedor_casos_sbd(rs.getInt(2));
                sbd.setId_usuario_casos_sbd(rs.getInt(3));
                sbd.setHonorario_casos_sbd(rs.getDouble(4));
                sbd.setSalario_casos_sbd(rs.getDouble(5));
                sbd.setNotas_casos_sbd(rs.getString(6));
                sbd.setId_estado_casos_sbd(rs.getInt(7));
                sbd.setId_propiedad_casos_sbd(rs.getInt(8));
                sbd.setId_representante_casos_sbd(rs.getInt(9));
            }
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> CasosAsignados(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            ResultSet rs = c.obtener_datos("SELECT c.id, cl.nombre, v.nombre, u.username, c.honorarios, c.salarios, c.notas, e.tipo, p.descripcion, r.nombre\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id\n"
                    + "INNER JOIN tbl_usuarios AS u ON c.id_usuario = u.id\n"
                    + "INNER JOIN tbl_estado AS e ON c.id_estado = e.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS p ON c.id_tipo_propiedad = p.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "WHERE u.username = '" + sbd.getUsername_login_sbd() + "';");

            while (rs.next()) {
                StringsBaseDatos sbd1 = new StringsBaseDatos();
                sbd1.setId_casos_sbd(rs.getInt(1));
                sbd1.setNombre_clientes_sbd(rs.getString(2));
                sbd1.setNombre_vendedor_sbd(rs.getString(3));
                sbd1.setUsername_usuario_sbd(rs.getString(4));
                sbd1.setHonorario_casos_sbd(rs.getDouble(5));
                sbd1.setSalario_casos_sbd(rs.getDouble(6));
                sbd1.setNotas_casos_sbd(rs.getString(7));
                sbd1.setEstatus_clientes_sbd(rs.getString(8));
                sbd1.setDescripcion_propiedad_sbd(rs.getString(9));
                sbd1.setNombre_representante_sbd(rs.getString(10));

                datos.add(sbd1);
            }

            c.desconectar();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> RegistroDetallado(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();
        
        
        try {
            ResultSet rs = c.obtener_datos("SELECT u.username, r.fecha, r.notas \n"
                    + "FROM tbl_registros AS r \n"
                    + "INNER JOIN tbl_casos AS c ON r.id_casos = c.id\n"
                    + "INNER JOIN tbl_clientes as cl ON c.id_cliente = cl.id\n"
                    + "INNER JOIN tbl_usuarios AS u ON r.id_usuario = u.id\n"
                    + "where cl.nombre = '"+sbd.getNombre_clientes_sbd()+";");
        
        while (rs.next()) {
                StringsBaseDatos sbd1 = new StringsBaseDatos();
                

                datos.add(sbd1);
            }
        
        c.desconectar();
        
        } catch (Exception e) {
            
            System.out.println("Error " + e.getMessage());
        }
        
        return datos;
    
    }
    
    

}
