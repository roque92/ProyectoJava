/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jroque
 */
//---------------- Aqui se encuentan los metodo que traen toda la informcion de las tablas
public class TablasBaseDatos implements InterfaceTablasBase {

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
                sbd1.setDpi_clientes_sbd(rs.getString(12));
                sbd1.setNit_clientes_sbd(rs.getString(13));
                sbd1.setUsaId_clientes_sbd(rs.getString(14));
                sbd1.setId_EstadoCivil_sbd(rs.getInt(15));
                sbd1.setDescripcion_EstadoCivil_sbd(rs.getString(16));
                sbd1.setId_migratorio_sbd(rs.getInt(17));
                sbd1.setDescripcion_migratorio_sbd(rs.getString(18));

                datos.add(sbd1);
            }
            c.desconectar();
        } catch (SQLException e) {
            JOptionPane mensaje = new JOptionPane();
            mensaje.showMessageDialog(null, "error " + e.getMessage());
            mensaje.show();

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
                    + "where cl.nombre = '" + sbd.getBuscar_cliente_registros_sbd() + "';");

            while (rs.next()) {
                StringsBaseDatos sbd1 = new StringsBaseDatos();
                sbd1.setUsuario_registros_sbd(rs.getString(1));
                sbd1.setFecha_registros_sbd(rs.getString(2));
                sbd1.setNotas_registros_sbd(rs.getString(3));

                datos.add(sbd1);

            }

            c.desconectar();

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
        }

        return datos;

    }

    @Override
    public ArrayList<StringsBaseDatos> mostrarClientes(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT "
                    + " tbl_clientes.id                  AS id, "
                    + " tbl_clientes.nombre              AS nombre, "
                    + " tbl_clientes.telefono            AS telefono, "
                    + " tbl_clientes.correo              AS correo, "
                    + " tbl_clientes.estatus             AS estatus, "
                    + " tbl_clientes.direccion           AS direccion, "
                    + " tbl_estado_civil.descripcion     AS estado, "
                    + " tbl_migratorio.descripcion       AS migratorio, "
                    + " tbl_clientes.profesion           AS profesion, "
                    + " tbl_clientes.estado_residencia   AS residencia, "
                    + " tbl_clientes.dpi                 AS dpi, "
                    + " tbl_clientes.nit                 AS nit, "
                    + " tbl_clientes.usa_id              AS usa, "
                    + " tbl_clientes.clase_tramite       AS tramite,"
                    + " tbl_usuarios.nombre              AS Usuario"
                    + " FROM tbl_clientes "
                    + " INNER JOIN tbl_estado_civil ON tbl_clientes.id_estado_civil = tbl_estado_civil.id "
                    + " INNER JOIN tbl_migratorio ON tbl_clientes.id_migratorio   = tbl_migratorio.id"
                    + " INNER JOIN tbl_casos ON tbl_clientes.id = tbl_casos.id_cliente"
                    + " INNER JOIN tbl_usuarios ON tbl_casos.id_usuario = tbl_usuarios.id ORDER BY tbl_clientes.id ASC;");

            while (rs.next()) {
                StringsBaseDatos sbd1 = new StringsBaseDatos();
                sbd1.setId_clientes_sbd(rs.getInt(1));
                sbd1.setNombre_clientes_sbd(rs.getString(2));
                sbd1.setTelefono_clientes_sbd(rs.getString(3));
                sbd1.setCorreo_clientes_sbd(rs.getString(4));
                sbd1.setEstatus_clientes_sbd(rs.getString(5));
                sbd1.setDireccion_clientes_sbd(rs.getString(6));
                sbd1.setDescripcion_EstadoCivil_sbd(rs.getString(7));
                sbd1.setDescripcion_migratorio_sbd(rs.getString(8));
                sbd1.setProfecion_clientes_sbd(rs.getString(9));
                sbd1.setEstadoResidencia_clientes_sbd(rs.getString(10));
                sbd1.setDpi_clientes_sbd(rs.getString(11));
                sbd1.setNit_clientes_sbd(rs.getString(12));
                sbd1.setUsaId_clientes_sbd(rs.getString(13));
                sbd1.setTramite_clientes_sbd(rs.getString(14));
                sbd1.setUsuario_clientes_sbd(rs.getString(15));

                datos.add(sbd1);
            }
            c.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obener datos ");
        }
        return datos;
    }

    @Override
    public ArrayList<StringsBaseDatos> mostrarAsesores(StringsBaseDatos sbd) {
        Conector c = new Conector();
        ArrayList<StringsBaseDatos> datos = new ArrayList();

        try {
            ResultSet rs = c.obtener_datos("SELECT * FROM tbl_vendedor;");

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obener datos ");
        }
        return datos;
    }

    @Override
    public void modificarAsignado(StringsBaseDatos sbd) {
        Conector c = new Conector();
        
        try {
            c.connect();
            c.consulta_general("UPDATE tbl_casos SET id_usuario = "+sbd.getToCasos_idUser()+" WHERE id_cliente = "+sbd.getValidacion_toCasos()+";");
            
            c.desconectar();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al actualizar la informacion");
        }
    }

}
