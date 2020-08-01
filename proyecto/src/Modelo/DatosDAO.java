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
public class DatosDAO implements InterfaceMetodos {

    @Override
    public ArrayList<DatosVO> validar_login(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT u.username, u.pass, u.telefono, u.correo, r.tipo\n"
                    + " FROM tbl_usuarios AS u INNER JOIN tbl_roles AS r ON u.id_roles = r.id WHERE username = '" + dvo.getUser_login() + "';");

            while (rs.next()) {
                dvo.setLogin_user(rs.getString(1));
                dvo.setLogin_pass(rs.getString(2));
                dvo.setLogin_telefono(rs.getString(3));
                dvo.setLogin_correo(rs.getString(4));
                dvo.setLogin_tipo(rs.getString(5));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public void insertar_datos(DatosVO dvo) {
        Conector c = new Conector();
        //-----------Tabla Vendedor
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_vendedor (nombre, telefono, constructora, correo)\n"
                    + "VALUES ('" + dvo.getToVendedor_nombre() + "','" + dvo.getToVendedor_telefono() + "','" + dvo.getToVendedor_constructora() + "','" + dvo.getToVendedor_correo() + "');");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
        //-----------Tabla Representante
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_representante (nombre, parentezco, direccion, telefono, banco)\n"
                    + "VALUES ('" + dvo.getToRepresentante_nombre() + "','" + dvo.getToRepresentante_parentezco() + "','" + dvo.getToRepresentante_direccion() + "','" + dvo.getToRepresentante_telefono() + "','" + dvo.getToRepresentante_banco() + "');");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
        //-----------Tabla Registros
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_registros (id_usuario, fecha, notas, id_casos)\n"
                    + "VALUES (" + dvo.getToRegistros_id_usuarios() + ",'" + dvo.getToRegistros_fecha() + "','" + dvo.getToRegistros_notas() + "'," + dvo.getToRegistros_id_casos() + ");");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
        //-----------Tabla Clientes
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_clientes (nombre, telefono, correo, estatus, direccion, id_estado_civil, id_migratorio, profesion, estado_residencia, dpi, nit, usa_id)\n"
                    + "VALUES ('" + dvo.getToClientes_nombre() + "', '" + dvo.getToClientes_telefono() + "', '" + dvo.getToClientes_correo() + "', '" + dvo.getToClientes_status() + "' , '" + dvo.getToClientes_direccion() + "', " + dvo.getToClientes_id_EstadoCivil() + ", " + dvo.getToClientes_id_migratorio() + ", '" + dvo.getToClientes_profesion() + "', '" + dvo.getToClientes_EstadoResidencia() + "', '" + dvo.getToClientes_dpi() + "', '" + dvo.getToClientes_nit() + "', '" + dvo.getToClientes_UsaId() + "');");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
        //-----------Tabla Casos
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_casos (id_cliente, id_vendedor, id_usuario,  honorarios, salarios, notas, id_estado, id_tipo_propiedad, id_representante)\n"
                    + "VALUES (" + dvo.getToCasos_idCliente() + ", " + dvo.getToCasos_idVendedor() + ", " + dvo.getToCasos_idUsuario() + ", " + dvo.getToCasos_honorarios() + ", " + dvo.getToCasos_salario() + ", '" + dvo.getToCasos_notas() + "', " + dvo.getToCasos_idEstado() + ", " + dvo.getToCasos_idPropiedad() + ", " + dvo.getToCasos_idRepresentante() + ");");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
    }

    @Override
    public void modificar_datos_vendedor(DatosVO dvo) {
        Conector c = new Conector();
        try {
            c.connect();
            c.consulta_general("UPDATE tbl_vendedor SET nombre = '"+dvo.getToVendedor_nombre()+"', telefono = '"+dvo.getToVendedor_telefono()+"', constructora ='"+dvo.getToVendedor_constructora()+"', correo = '"+dvo.getToVendedor_correo()+"' WHERE nombre = '"+dvo.getNombre_vendedor()+"';");

            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
    }

    @Override
    public void modificar_datos_representante(DatosVO dvo) {
        Conector c = new Conector();
        try {
            c.connect();
            c.consulta_general("UPDATE tbl_representante SET nombre = '"+dvo.getToRepresentante_nombre()+"', parentezco = '"+dvo.getToRepresentante_parentezco()+"', direccion ='"+dvo.getToRepresentante_direccion()+"', telefono = '"+dvo.getToRepresentante_telefono()+"', banco = '"+dvo.getToRepresentante_banco()+"' WHERE nombre = '"+dvo.getNombre_representante()+"';");

            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
    }

    @Override
    public void modificar_datos_clientes(DatosVO dvo) {
        Conector c = new Conector();
        try {
            c.connect();
            c.consulta_general("UPDATE tbl_clientes SET nombre = '"+dvo.getToClientes_nombre()+"', telefono = '"+dvo.getToClientes_telefono()+"', correo = '"+dvo.getToClientes_correo()+"', direccion = '"+dvo.getToClientes_direccion()+"', id_estado_civil = "+dvo.getToClientes_id_EstadoCivil()+", id_migratorio = "+dvo.getToClientes_id_migratorio()+", profesion = '"+dvo.getToClientes_profesion()+"', estado_residencia = '"+dvo.getToClientes_EstadoResidencia()+"', dpi = '"+dvo.getToClientes_dpi()+"', nit = '"+dvo.getToClientes_nit()+"', usa_id ='"+dvo.getToClientes_UsaId()+"' WHERE nombre = '"+dvo.getNombre_cliente()+"';");

            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
    }

    @Override
    public void modificar_datos_casos(DatosVO dvo) {
        Conector c = new Conector();
        try {
            c.connect();
            c.consulta_general("UPDATE tbl_casos SET id_cliente = "+dvo.getToCasos_idCliente()+", id_vendedor = "+dvo.getToCasos_idVendedor()+", id_usuario = "+dvo.getToCasos_idUsuario()+", honorarios = "+dvo.getToCasos_honorarios()+", salarios = "+dvo.getToCasos_salario()+", notas = '"+dvo.getToCasos_notas()+"', id_estado = "+dvo.getToCasos_idEstado()+", id_tipo_propiedad = "+dvo.getToCasos_idPropiedad()+", id_representante = "+dvo.getToCasos_idRepresentante()+" WHERE id_cliente = 1;");

            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
    }

    @Override
    public ArrayList<DatosVO> mostrar_datos_nombre(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT v.nombre, v.telefono, v.constructora, v.correo, \n"
                    + "c.honorarios, c.salarios, cl.direccion, \n"
                    + "cl.nombre, cl.telefono, cl.correo, cl.profesion, ec.descripcion, m.descripcion, cl.estado_residencia, cl.dpi, cl.nit, cl.usa_id, \n"
                    + "tp.descripcion,\n"
                    + "r.Nombre, r.parentezco, r.direccion, r.telefono, r.banco, c.notas\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id \n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id \n"
                    + "INNER JOIN tbl_estado_civil AS ec ON cl.id_estado_civil = ec.id \n"
                    + "INNER JOIN tbl_migratorio AS m ON cl.id_migratorio = m.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS tp ON c.id_tipo_propiedad = tp.id\n"
                    + "WHERE cl.nombre = '" + dvo.getBuscar_nombre() + "';");

            while (rs.next()) {
                dvo.setNombre_vendedor(rs.getString(1));
                dvo.setTelefono_vendedor(rs.getString(2));
                dvo.setConstructora_vendedor(rs.getString(3));
                dvo.setHonorarios_casos(rs.getString(4));
                dvo.setSalario_casos(rs.getString(5));
                dvo.setDireccion_cliente(rs.getString(6));
                dvo.setNombre_cliente(rs.getString(7));
                dvo.setTelefono_cliente(rs.getString(8));
                dvo.setCorreo_cliente(rs.getString(9));
                dvo.setProfecion_cliente(rs.getString(10));
                dvo.setEstadoCivil_cliente(rs.getString(11));
                dvo.setEstadoMigratorio_cliente(rs.getString(12));
                dvo.setEstadoResidencia_cliente(rs.getString(13));
                dvo.setDpi_cliente(rs.getString(14));
                dvo.setNit_cliente(rs.getString(15));
                dvo.setUsaId_cliente(rs.getString(16));
                dvo.setTipo_propiedad(rs.getString(17));
                dvo.setNombre_representante(rs.getString(18));
                dvo.setParentezco_representante(rs.getString(19));
                dvo.setDireccion_representante(rs.getString(20));
                dvo.setTelefono_representante(rs.getString(21));
                dvo.setBanco_representante(rs.getString(22));
                dvo.setNotas_casos(rs.getString(23));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<DatosVO> mostrar_datos_telefono(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT v.nombre, v.telefono, v.constructora, v.correo, \n"
                    + "c.honorarios, c.salarios, cl.direccion, \n"
                    + "cl.nombre, cl.telefono, cl.correo, cl.profesion, ec.descripcion, m.descripcion, cl.estado_residencia, cl.dpi, cl.nit, cl.usa_id, \n"
                    + "tp.descripcion,\n"
                    + "r.Nombre, r.parentezco, r.direccion, r.telefono, r.banco, c.notas\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id \n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id \n"
                    + "INNER JOIN tbl_estado_civil AS ec ON cl.id_estado_civil = ec.id \n"
                    + "INNER JOIN tbl_migratorio AS m ON cl.id_migratorio = m.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS tp ON c.id_tipo_propiedad = tp.id\n"
                    + "WHERE cl.nombre = '" + dvo.getBuscar_telefono() + "';");

            while (rs.next()) {
                dvo.setNombre_vendedor(rs.getString(1));
                dvo.setTelefono_vendedor(rs.getString(2));
                dvo.setConstructora_vendedor(rs.getString(3));
                dvo.setHonorarios_casos(rs.getString(4));
                dvo.setSalario_casos(rs.getString(5));
                dvo.setDireccion_cliente(rs.getString(6));
                dvo.setNombre_cliente(rs.getString(7));
                dvo.setTelefono_cliente(rs.getString(8));
                dvo.setCorreo_cliente(rs.getString(9));
                dvo.setProfecion_cliente(rs.getString(10));
                dvo.setEstadoCivil_cliente(rs.getString(11));
                dvo.setEstadoMigratorio_cliente(rs.getString(12));
                dvo.setEstadoResidencia_cliente(rs.getString(13));
                dvo.setDpi_cliente(rs.getString(14));
                dvo.setNit_cliente(rs.getString(15));
                dvo.setUsaId_cliente(rs.getString(16));
                dvo.setTipo_propiedad(rs.getString(17));
                dvo.setNombre_representante(rs.getString(18));
                dvo.setParentezco_representante(rs.getString(19));
                dvo.setDireccion_representante(rs.getString(20));
                dvo.setTelefono_representante(rs.getString(21));
                dvo.setBanco_representante(rs.getString(22));
                dvo.setNotas_casos(rs.getString(23));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<DatosVO> mostrar_datos_correo(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT v.nombre, v.telefono, v.constructora, v.correo, \n"
                    + "c.honorarios, c.salarios, cl.direccion, \n"
                    + "cl.nombre, cl.telefono, cl.correo, cl.profesion, ec.descripcion, m.descripcion, cl.estado_residencia, cl.dpi, cl.nit, cl.usa_id, \n"
                    + "tp.descripcion,\n"
                    + "r.Nombre, r.parentezco, r.direccion, r.telefono, r.banco, c.notas\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id \n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id \n"
                    + "INNER JOIN tbl_estado_civil AS ec ON cl.id_estado_civil = ec.id \n"
                    + "INNER JOIN tbl_migratorio AS m ON cl.id_migratorio = m.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS tp ON c.id_tipo_propiedad = tp.id\n"
                    + "WHERE cl.nombre = '" + dvo.getBuscar_correo() + "';");

            while (rs.next()) {
                dvo.setNombre_vendedor(rs.getString(1));
                dvo.setTelefono_vendedor(rs.getString(2));
                dvo.setConstructora_vendedor(rs.getString(3));
                dvo.setHonorarios_casos(rs.getString(4));
                dvo.setSalario_casos(rs.getString(5));
                dvo.setDireccion_cliente(rs.getString(6));
                dvo.setNombre_cliente(rs.getString(7));
                dvo.setTelefono_cliente(rs.getString(8));
                dvo.setCorreo_cliente(rs.getString(9));
                dvo.setProfecion_cliente(rs.getString(10));
                dvo.setEstadoCivil_cliente(rs.getString(11));
                dvo.setEstadoMigratorio_cliente(rs.getString(12));
                dvo.setEstadoResidencia_cliente(rs.getString(13));
                dvo.setDpi_cliente(rs.getString(14));
                dvo.setNit_cliente(rs.getString(15));
                dvo.setUsaId_cliente(rs.getString(16));
                dvo.setTipo_propiedad(rs.getString(17));
                dvo.setNombre_representante(rs.getString(18));
                dvo.setParentezco_representante(rs.getString(19));
                dvo.setDireccion_representante(rs.getString(20));
                dvo.setTelefono_representante(rs.getString(21));
                dvo.setBanco_representante(rs.getString(22));
                dvo.setNotas_casos(rs.getString(23));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public void borrar_datos(DatosVO dvo) {

    }

}
