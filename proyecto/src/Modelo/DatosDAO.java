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
            ResultSet rs = c.obtener_datos("SELECT u.username, u.pass, u.telefono, u.correo, r.tipo, u.id\n"
                    + " FROM tbl_usuarios AS u INNER JOIN tbl_roles AS r ON u.id_roles = r.id WHERE username = '" + dvo.getUser_login() + "';");

            if (rs.next()) {

                do {
                    dvo.setLogin_user(rs.getString(1));
                    dvo.setLogin_pass(rs.getString(2));
                    dvo.setLogin_telefono(rs.getString(3));
                    dvo.setLogin_correo(rs.getString(4));
                    dvo.setLogin_tipo(rs.getString(5));
                    dvo.setLogin_id(rs.getInt(6));

                    datos.add(dvo);
                } while (rs.next());

            } else {

                dvo.setError("No Existe Usuario en Base de Datos");

            }

            c.desconectar();

        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public void insertar_datos_vendedor(DatosVO dvo) {
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

    }

    @Override
    public void insertar_datos_representante(DatosVO dvo) {
        Conector c = new Conector();
        //-----------Tabla Representante
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_representante (nombre, parentezco, direccion, telefono, banco)\n"
                    + "VALUES ('" + dvo.getToRepresentante_nombre() + "','" + dvo.getToRepresentante_parentezco() + "','" + dvo.getToRepresentante_direccion() + "','" + dvo.getToRepresentante_telefono() + "','" + dvo.getToRepresentante_banco() + "');");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }

    }

    @Override
    public void insertar_datos_clientes(DatosVO dvo) {
        Conector c = new Conector();
        //-----------Tabla Clientes
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_clientes (nombre, telefono, correo, estatus, direccion, id_estado_civil, id_migratorio, profesion, estado_residencia, dpi, nit, usa_id)\n"
                    + "VALUES ('" + dvo.getToClientes_nombre() + "', '" + dvo.getToClientes_telefono() + "', '" + dvo.getToClientes_correo() + "', '" + dvo.getToClientes_status() + "' , '" + dvo.getToClientes_direccion() + "', " + dvo.getToClientes_id_EstadoCivil() + ", " + dvo.getToClientes_id_migratorio() + ", '" + dvo.getToClientes_profesion() + "', '" + dvo.getToClientes_EstadoResidencia() + "', '" + dvo.getToClientes_dpi() + "', '" + dvo.getToClientes_nit() + "', '" + dvo.getToClientes_UsaId() + "');");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }

    }

    @Override
    public void insertar_datos_casos(DatosVO dvo) {
        Conector c = new Conector();
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
    public void insertar_datos_registro(DatosVO dvo) {
        Conector c = new Conector();

        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_registros (id_usuario, fecha, notas, id_casos)\n"
                    + "VALUES (" + dvo.getLogin_id() + ", '" + dvo.getToRegistros_fecha() + "', '" + dvo.getToRegistros_notas() + "', " + dvo.getIdCaso_registro() + ");");
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
            c.consulta_general("UPDATE tbl_vendedor\n"
                    + "SET nombre = '" + dvo.getToVendedor_nombre() + "',\n"
                    + "		telefono = " + dvo.getToVendedor_telefono() + ",\n"
                    + "		constructora = '" + dvo.getToVendedor_constructora() + "',\n"
                    + "		correo = '" + dvo.getToVendedor_correo() + "'\n"
                    + "WHERE tbl_vendedor.nombre = '" + dvo.getNombre_vendedor() + "';");

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
            c.consulta_general("UPDATE tbl_representante\n"
                    + "SET tbl_representante.nombre = '" + dvo.getToRepresentante_nombre() + "',\n"
                    + "		tbl_representante.parentezco = '" + dvo.getToRepresentante_parentezco() + "',\n"
                    + "		tbl_representante.telefono = " + dvo.getToRepresentante_telefono() + ",\n"
                    + "		tbl_representante.direccion = '" + dvo.getToRepresentante_direccion() + "',\n"
                    + "		tbl_representante.banco = '" + dvo.getToRepresentante_banco() + "'\n"
                    + "WHERE tbl_representante.nombre ='" + dvo.getNombre_representante() + "';");

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
            c.consulta_general("UPDATE tbl_clientes\n"
                    + "SET tbl_clientes.nombre = '" + dvo.getToClientes_nombre() + "',\n"
                    + "		tbl_clientes.telefono = '" + dvo.getToClientes_telefono() + "',\n"
                    + "		tbl_clientes.correo = '" + dvo.getToClientes_correo() + "',\n"
                    + "		tbl_clientes.direccion = '" + dvo.getToClientes_direccion() + "',\n"
                    + "		tbl_clientes.id_estado_civil = " + dvo.getToClientes_id_EstadoCivil() + ",\n"
                    + "		tbl_clientes.id_migratorio = " + dvo.getToClientes_id_migratorio() + ",\n"
                    + "		tbl_clientes.profesion = '" + dvo.getToClientes_profesion() + "',\n"
                    + "		tbl_clientes.estado_residencia = '" + dvo.getToClientes_EstadoResidencia() + "',\n"
                    + "		tbl_clientes.clase_tramite = '" + dvo.getToClientes_ClaseTraite() + "',\n"
                    + "		tbl_clientes.dpi = '" + dvo.getToClientes_dpi() + "',\n"
                    + "		tbl_clientes.nit = '" + dvo.getToClientes_nit() + "',\n"
                    + "		tbl_clientes.usa_id = '" + dvo.getToClientes_UsaId() + "'\n"
                    + "WHERE tbl_clientes.nombre = '" + dvo.getNombre_cliente() + "';");

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
            c.consulta_general("UPDATE tbl_casos\n"
                    + "SET honorarios = " + dvo.getToCasos_honorarios() + ",\n"
                    + "		salarios = " + dvo.getToCasos_salario() + ",\n"
                    + "		notas = '" + dvo.getToCasos_notas() + "',\n"
                    + "		id_tipo_propiedad = " + dvo.getToCasos_idPropiedad() + "\n"
                    + "WHERE id_cliente = " + dvo.getId_cliente() + ";");

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
                    + "r.Nombre, r.parentezco, r.direccion, r.telefono, r.banco, c.notas, cl.clase_tramite\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id \n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id \n"
                    + "INNER JOIN tbl_estado_civil AS ec ON cl.id_estado_civil = ec.id \n"
                    + "INNER JOIN tbl_migratorio AS m ON cl.id_migratorio = m.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS tp ON c.id_tipo_propiedad = tp.id\n"
                    + "WHERE cl.nombre = '" + dvo.getBuscar_nombre() + "';");

            if (rs.next()) {
             
                do {
                    dvo.setNombre_vendedor(rs.getString(1));
                    dvo.setTelefono_vendedor(rs.getString(2));
                    dvo.setConstructora_vendedor(rs.getString(3));
                    dvo.setCorreo_vendedor(rs.getString(4));
                    dvo.setHonorarios_casos(rs.getDouble(5));
                    dvo.setSalario_casos(rs.getDouble(6));
                    dvo.setDireccion_cliente(rs.getString(7));
                    dvo.setNombre_cliente(rs.getString(8));
                    dvo.setTelefono_cliente(rs.getString(9));
                    dvo.setCorreo_cliente(rs.getString(10));
                    dvo.setProfecion_cliente(rs.getString(11));
                    dvo.setEstadoCivil_cliente(rs.getString(12));
                    dvo.setEstadoMigratorio_cliente(rs.getString(13));
                    dvo.setEstadoResidencia_cliente(rs.getString(14));
                    dvo.setDpi_cliente(rs.getString(15));
                    dvo.setNit_cliente(rs.getString(16));
                    dvo.setUsaId_cliente(rs.getString(17));
                    dvo.setTipo_propiedad(rs.getString(18));
                    dvo.setNombre_representante(rs.getString(19));
                    dvo.setParentezco_representante(rs.getString(20));
                    dvo.setDireccion_representante(rs.getString(21));
                    dvo.setTelefono_representante(rs.getString(22));
                    dvo.setBanco_representante(rs.getString(23));
                    dvo.setNotas_casos(rs.getString(24));
                    dvo.setClaseTramite_cliente(rs.getString(25));

                    datos.add(dvo);
                } while (rs.next());
            } else {
                c.desconectar();
                dvo.setError("No Existe Cliente");
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
                    + "r.Nombre, r.parentezco, r.direccion, r.telefono, r.banco, c.notas, cl.clase_tramite\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id \n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id \n"
                    + "INNER JOIN tbl_estado_civil AS ec ON cl.id_estado_civil = ec.id \n"
                    + "INNER JOIN tbl_migratorio AS m ON cl.id_migratorio = m.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS tp ON c.id_tipo_propiedad = tp.id\n"
                    + "WHERE cl.telefono = '" + dvo.getBuscar_telefono() + "';");

            while (rs.next()) {
                dvo.setNombre_vendedor(rs.getString(1));
                dvo.setTelefono_vendedor(rs.getString(2));
                dvo.setConstructora_vendedor(rs.getString(3));
                dvo.setCorreo_vendedor(rs.getString(4));
                dvo.setHonorarios_casos(rs.getDouble(5));
                dvo.setSalario_casos(rs.getDouble(6));
                dvo.setDireccion_cliente(rs.getString(7));
                dvo.setNombre_cliente(rs.getString(8));
                dvo.setTelefono_cliente(rs.getString(9));
                dvo.setCorreo_cliente(rs.getString(10));
                dvo.setProfecion_cliente(rs.getString(11));
                dvo.setEstadoCivil_cliente(rs.getString(12));
                dvo.setEstadoMigratorio_cliente(rs.getString(13));
                dvo.setEstadoResidencia_cliente(rs.getString(14));
                dvo.setDpi_cliente(rs.getString(15));
                dvo.setNit_cliente(rs.getString(16));
                dvo.setUsaId_cliente(rs.getString(17));
                dvo.setTipo_propiedad(rs.getString(18));
                dvo.setNombre_representante(rs.getString(19));
                dvo.setParentezco_representante(rs.getString(20));
                dvo.setDireccion_representante(rs.getString(21));
                dvo.setTelefono_representante(rs.getString(22));
                dvo.setBanco_representante(rs.getString(23));
                dvo.setNotas_casos(rs.getString(24));
                dvo.setClaseTramite_cliente(rs.getString(25));

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
                    + "r.Nombre, r.parentezco, r.direccion, r.telefono, r.banco, c.notas, cl.clase_tramite\n"
                    + "FROM tbl_casos AS c\n"
                    + "INNER JOIN tbl_vendedor AS v ON c.id_vendedor = v.id \n"
                    + "INNER JOIN tbl_clientes AS cl ON c.id_cliente = cl.id \n"
                    + "INNER JOIN tbl_estado_civil AS ec ON cl.id_estado_civil = ec.id \n"
                    + "INNER JOIN tbl_migratorio AS m ON cl.id_migratorio = m.id\n"
                    + "INNER JOIN tbl_representante AS r ON c.id_representante = r.id\n"
                    + "INNER JOIN tbl_tipo_propiedad AS tp ON c.id_tipo_propiedad = tp.id\n"
                    + "WHERE cl.correo = '" + dvo.getBuscar_correo() + "';");

            while (rs.next()) {
                dvo.setNombre_vendedor(rs.getString(1));
                dvo.setTelefono_vendedor(rs.getString(2));
                dvo.setConstructora_vendedor(rs.getString(3));
                dvo.setCorreo_vendedor(rs.getString(4));
                dvo.setHonorarios_casos(rs.getDouble(5));
                dvo.setSalario_casos(rs.getDouble(6));
                dvo.setDireccion_cliente(rs.getString(7));
                dvo.setNombre_cliente(rs.getString(8));
                dvo.setTelefono_cliente(rs.getString(9));
                dvo.setCorreo_cliente(rs.getString(10));
                dvo.setProfecion_cliente(rs.getString(11));
                dvo.setEstadoCivil_cliente(rs.getString(12));
                dvo.setEstadoMigratorio_cliente(rs.getString(13));
                dvo.setEstadoResidencia_cliente(rs.getString(14));
                dvo.setDpi_cliente(rs.getString(15));
                dvo.setNit_cliente(rs.getString(16));
                dvo.setUsaId_cliente(rs.getString(17));
                dvo.setTipo_propiedad(rs.getString(18));
                dvo.setNombre_representante(rs.getString(19));
                dvo.setParentezco_representante(rs.getString(20));
                dvo.setDireccion_representante(rs.getString(21));
                dvo.setTelefono_representante(rs.getString(22));
                dvo.setBanco_representante(rs.getString(23));
                dvo.setNotas_casos(rs.getString(24));
                dvo.setClaseTramite_cliente(rs.getString(25));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<DatosVO> idCliente(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT id FROM tbl_clientes WHERE nombre = '" + dvo.getNombre_cliente() + "';");

            while (rs.next()) {

                dvo.setId_cliente(rs.getString(1));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datos;
    }

    @Override
    public ArrayList<DatosVO> idCaso(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT id FROM tbl_casos WHERE id_cliente = " + dvo.getId_cliente() + ";");

            while (rs.next()) {
                dvo.setIdCaso_registro(rs.getInt(1));

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

    @Override
    public ArrayList<DatosVO> buscar_id_vendedor(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList<DatosVO> datos = new ArrayList();

        try {
            c.connect();
            ResultSet rs = c.obtener_datos("Select id FROM tbl_vendedor where nombre = '"+dvo.getNombre_vendedor()+"' OR telefono = "+dvo.getTelefono_vendedor()+" or correo = '"+dvo.getCorreo_vendedor()+"';");

            while (rs.next()) {

                dvo.setId_vendedor(rs.getString(1));

                datos.add(dvo);
            }

            c.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datos;
        
    }

    @Override
    public void insertar_nuevo_representante(DatosVO dvo) {
    }

    @Override
    public ArrayList<DatosVO> buscar_id_representante(DatosVO dvo) {
    }

    @Override
    public void insertar_nuevo_cliente(DatosVO dvo) {
    }

    @Override
    public void insertar_nuevo_caso(DatosVO dvo) {
    }

}
