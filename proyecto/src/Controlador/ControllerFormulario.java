/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosDAO;
import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import Modelo.TablasBaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author Jose Roque
 */
public class ControllerFormulario implements ActionListener, ChangeListener, InternalFrameListener {

    Usuario usuario = new Usuario();
    Login login = new Login();
    DatosVO dvo = new DatosVO();
    DatosDAO ddao = new DatosDAO();
    StringsBaseDatos sbd = new StringsBaseDatos();
    TablasBaseDatos tbd = new TablasBaseDatos();

    public ControllerFormulario(Usuario usuario, Login login, DatosVO dvo, DatosDAO ddao, StringsBaseDatos sbd, TablasBaseDatos tbd) {
        this.usuario = usuario;
        this.login = login;
        this.dvo = dvo;
        this.ddao = ddao;
        this.sbd = sbd;
        this.tbd = tbd;

        usuario.f_btn_buscarCliente.addActionListener(this);
        usuario.f_btn_guardar.addActionListener(this);
        usuario.f_cb_editar.addChangeListener(this);
        usuario.f_cb_nuevo.addChangeListener(this);
        usuario.if_formulario.addInternalFrameListener(this);
    }

    private void buscarCliente() {

        String valorBuscado = (String) usuario.f_valor_buscado.getSelectedItem();

        switch (valorBuscado) {
            case "Nombre":
                dvo.setBuscar_nombre(usuario.f_txt_buscarCliente.getText().trim());
                buscarNombre();
                registroDetallado();
                break;
            case "Telefono":
                dvo.setBuscar_telefono(usuario.f_txt_buscarCliente.getText());
                buscarTelefono();
                registroDetallado();
                break;
            case "Correo":
                dvo.setBuscar_correo(usuario.f_txt_buscarCliente.getText().trim());
                buscarCorreo();
                registroDetallado();
                break;
            default:
                login.mensaje.showMessageDialog(null, "Por favor indicar el tipo de busqueda");
                usuario.f_txt_buscarCliente.setText("");
                break;
        }

    }

    private void buscarNombre() {
        usuario.f_txt_buscarCliente.setText("");
        usuario.f_valor_buscado.setSelectedItem("Seleccionar");
        ddao.mostrar_datos_nombre(dvo);
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
        usuario.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
        usuario.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
        usuario.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText(String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText(String.valueOf(dvo.getSalario_casos()));
        usuario.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
        usuario.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
        usuario.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
        usuario.f_txt_estadoMigratorio.setSelectedItem(dvo.getEstadoMigratorio_cliente());
        usuario.f_txt_tipoPropiedad.setSelectedItem(dvo.getTipo_propiedad());
        usuario.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
        usuario.f_txt_estadoCivil.setSelectedItem(dvo.getEstadoCivil_cliente());
        usuario.f_txt_profesion.setText(dvo.getProfecion_cliente());
        usuario.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
        usuario.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
        usuario.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }

    private void buscarTelefono() {
        usuario.f_txt_buscarCliente.setText("");
        usuario.f_valor_buscado.setSelectedItem("Seleccionar");
        ddao.mostrar_datos_telefono(dvo);
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
        usuario.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
        usuario.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
        usuario.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText(String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText(String.valueOf(dvo.getSalario_casos()));
        usuario.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
        usuario.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
        usuario.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
        usuario.f_txt_estadoMigratorio.setSelectedItem(dvo.getEstadoMigratorio_cliente());
        usuario.f_txt_tipoPropiedad.setSelectedItem(dvo.getTipo_propiedad());
        usuario.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
        usuario.f_txt_estadoCivil.setSelectedItem(dvo.getEstadoCivil_cliente());
        usuario.f_txt_profesion.setText(dvo.getProfecion_cliente());
        usuario.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
        usuario.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
        usuario.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }

    private void buscarCorreo() {

        usuario.f_txt_buscarCliente.setText("");
        usuario.f_valor_buscado.setSelectedItem("Seleccionar");
        ddao.mostrar_datos_correo(dvo);
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
        usuario.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
        usuario.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
        usuario.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText(String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText(String.valueOf(dvo.getSalario_casos()));
        usuario.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
        usuario.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
        usuario.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
        usuario.f_txt_estadoMigratorio.setSelectedItem(dvo.getEstadoMigratorio_cliente());
        usuario.f_txt_tipoPropiedad.setSelectedItem(dvo.getTipo_propiedad());
        usuario.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
        usuario.f_txt_estadoCivil.setSelectedItem(dvo.getEstadoCivil_cliente());
        usuario.f_txt_profesion.setText(dvo.getProfecion_cliente());
        usuario.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
        usuario.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
        usuario.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }

    private void registroDetallado() {
        sbd.setBuscar_cliente_registros_sbd(dvo.getNombre_cliente());

        try {
            DefaultTableModel m = new DefaultTableModel();
            m.setColumnCount(0);
            m.addColumn("Fecha");
            m.addColumn("Usuario");
            m.addColumn("Informacion");

            for (StringsBaseDatos sbd : this.tbd.RegistroDetallado(sbd)) {
                m.addRow(new Object[]{sbd.getFecha_registros_sbd(), sbd.getUsuario_registros_sbd(), sbd.getNotas_registros_sbd()});
            }

            usuario.f_tbl_seguimiento.setModel(m);

        } catch (Exception e) {
            login.mensaje.showMessageDialog(null, "No se puede conectar con la base de datos Contacte con su Administrador", "Problemas de Conexion", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void enableText() {
//Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setEditable(true);
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setEditable(true);
        usuario.f_txt_vendedorTelefono.setEditable(true);
        usuario.f_txt_vendedorContructora.setEditable(true);
        usuario.f_txt_vendedorCorreo.setEditable(true);
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setEditable(true);
        usuario.f_txt_salario.setEditable(true);
        usuario.f_txt_direccionUSA.setEditable(true);
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setEditable(true);
        usuario.f_txt_telefonoCliente.setEditable(true);
        usuario.f_txt_estadoResidencia.setEditable(true);
        usuario.f_txt_estadoMigratorio.setEditable(true);
        usuario.f_txt_tipoPropiedad.setEditable(true);
        usuario.f_txt_correoCliente.setEditable(true);
        usuario.f_txt_estadoCivil.setEditable(true);
        usuario.f_txt_profesion.setEditable(true);
        usuario.f_cb_dpi.setEditable(true);
        usuario.f_cb_nit.setEditable(true);
        usuario.f_cb_id.setEditable(true);
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setEditable(true);
        usuario.f_txt_repDireccion.setEditable(true);
        usuario.f_txt_repTelefono.setEditable(true);
        usuario.f_txt_repParentezco.setEditable(true);
        usuario.f_txt_repBanco.setEditable(true);
//Asignacion de datos Notas
        usuario.f_txt_notas.setEditable(true);

        usuario.if_RegistroDetallado.setVisible(true);
    }

    private void disableText() {
        //Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setEditable(false);
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setEditable(false);
        usuario.f_txt_vendedorTelefono.setEditable(false);
        usuario.f_txt_vendedorContructora.setEditable(false);
        usuario.f_txt_vendedorCorreo.setEditable(false);
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setEditable(false);
        usuario.f_txt_salario.setEditable(false);
        usuario.f_txt_direccionUSA.setEditable(false);
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setEditable(false);
        usuario.f_txt_telefonoCliente.setEditable(false);
        usuario.f_txt_estadoResidencia.setEditable(false);
        usuario.f_txt_estadoMigratorio.setEditable(false);
        usuario.f_txt_tipoPropiedad.setEditable(false);
        usuario.f_txt_correoCliente.setEditable(false);
        usuario.f_txt_estadoCivil.setEditable(false);
        usuario.f_txt_profesion.setEditable(false);
        usuario.f_cb_dpi.setEditable(false);
        usuario.f_cb_nit.setEditable(false);
        usuario.f_cb_id.setEditable(false);
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setEditable(false);
        usuario.f_txt_repDireccion.setEditable(false);
        usuario.f_txt_repTelefono.setEditable(false);
        usuario.f_txt_repParentezco.setEditable(false);
        usuario.f_txt_repBanco.setEditable(false);
//Asignacion de datos Notas
        usuario.f_txt_notas.setEditable(false);

        usuario.if_RegistroDetallado.setVisible(false);
    }

    private void cleanText() {
        //Asignacion de datos Clase Tramite
        usuario.f_txt_tramite.setText("");
//Asignacino de datos del Asesor/Vendedor
        usuario.f_txt_vendedorNombre.setText("");
        usuario.f_txt_vendedorTelefono.setText("");
        usuario.f_txt_vendedorContructora.setText("");
        usuario.f_txt_vendedorCorreo.setText("");
//Asignacion de datos Financieros
        usuario.f_txt_honorarios.setText("");
        usuario.f_txt_salario.setText("");
        usuario.f_txt_direccionUSA.setText("");
//Asignacion de datos Negociacion
        usuario.f_txt_nombreCliente.setText("");
        usuario.f_txt_telefonoCliente.setText("");
        usuario.f_txt_estadoResidencia.setText("");
        usuario.f_txt_estadoMigratorio.setSelectedItem("Seleccionar");
        usuario.f_txt_tipoPropiedad.setSelectedItem("Seleccionar");
        usuario.f_txt_correoCliente.setText("");
        usuario.f_txt_estadoCivil.setSelectedItem("Seleccionar");
        usuario.f_txt_profesion.setText("");
        usuario.f_cb_dpi.setSelectedItem("Seleccionar");
        usuario.f_cb_nit.setSelectedItem("Seleccionar");
        usuario.f_cb_id.setSelectedItem("Seleccionar");
//Asignacion de datos Representante Legal
        usuario.f_txt_repNombre.setText("");
        usuario.f_txt_repDireccion.setText("");
        usuario.f_txt_repTelefono.setText("");
        usuario.f_txt_repParentezco.setText("");
        usuario.f_txt_repBanco.setText("");
//Asignacion de datos Notas
        usuario.f_txt_notas.setText("");

        usuario.f_cb_editar.setSelected(false);
        usuario.f_cb_nuevo.setSelected(false);

        DefaultTableModel tMOdel = (DefaultTableModel) usuario.f_tbl_seguimiento.getModel();
        tMOdel.setRowCount(0);

    }

    private void editarCaso() {

        if (usuario.f_txt_vendedorNombre.getText().isEmpty()) {
            dvo.setToVendedor_nombre("");
        } else {
            dvo.setToVendedor_nombre(usuario.f_txt_vendedorNombre.getText());
        }

        if (usuario.f_txt_vendedorTelefono.getText().isEmpty()) {
            dvo.setToVendedor_telefono("");
        } else {
            dvo.setToVendedor_telefono(usuario.f_txt_vendedorTelefono.getText());
        }

        if (usuario.f_txt_vendedorContructora.getText().isEmpty()) {
            dvo.setToVendedor_constructora("");
        } else {
            dvo.setToVendedor_constructora(usuario.f_txt_vendedorContructora.getText());
        }

        if (usuario.f_txt_vendedorCorreo.getText().isEmpty()) {
            dvo.setToVendedor_correo("");
        } else {
            dvo.setToVendedor_correo(usuario.f_txt_vendedorCorreo.getText());
        }

        if (usuario.f_txt_tramite.getText().isEmpty()) {
            dvo.setToClientes_ClaseTraite("");
        } else {
            dvo.setToClientes_ClaseTraite(usuario.f_txt_tramite.getText());
        }

        if (usuario.f_txt_direccionUSA.getText().isEmpty()) {
            dvo.setToClientes_direccion("");
        } else {
            dvo.setToClientes_direccion(usuario.f_txt_direccionUSA.getText());
        }

        if (usuario.f_txt_nombreCliente.getText().isEmpty()) {
            dvo.setToClientes_nombre("");
        } else {
            dvo.setToClientes_nombre(usuario.f_txt_nombreCliente.getText());
        }

        if (usuario.f_txt_telefonoCliente.getText().isEmpty()) {
            dvo.setToClientes_telefono("");
        } else {
            dvo.setToClientes_telefono(usuario.f_txt_telefonoCliente.getText());
        }

        if (usuario.f_txt_estadoResidencia.getText().isEmpty()) {
            dvo.setToClientes_EstadoResidencia("");
        } else {
            dvo.setToClientes_EstadoResidencia(usuario.f_txt_estadoResidencia.getText());
        }

        if (usuario.f_txt_estadoCivil.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_id_EstadoCivil(5);
        } else {
            String estadoCivil = (String) usuario.f_txt_estadoCivil.getSelectedItem();
            switch (estadoCivil) {

                case "Soltero (a)":
                    dvo.setToClientes_id_EstadoCivil(1);
                    break;
                case "Casado (a)":
                    dvo.setToClientes_id_EstadoCivil(2);
                    break;
                case "Divorciado (a)":
                    dvo.setToClientes_id_EstadoCivil(3);
                    break;
                case "Viudo (a)":
                    dvo.setToClientes_id_EstadoCivil(4);
                    break;
                default:
                    break;
            }

        }

        if (usuario.f_txt_correoCliente.getText().isEmpty()) {
            dvo.setToClientes_correo("");
        } else {
            dvo.setToClientes_correo(usuario.f_txt_correoCliente.getText());
        }

        if (usuario.f_txt_estadoMigratorio.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_id_migratorio(4);
        } else {
            String estadoMigratorio = (String) usuario.f_txt_estadoMigratorio.getSelectedItem();
            switch (estadoMigratorio) {

                case "Residente":
                    dvo.setToClientes_id_migratorio(1);
                    break;
                case "Ciudadano":
                    dvo.setToClientes_id_migratorio(2);
                    break;
                case "Regular (a)":
                    dvo.setToClientes_id_migratorio(3);
                    break;
                default:
                    break;
            }
        }

        if (usuario.f_txt_profesion.getText().isEmpty()) {
            dvo.setToClientes_profesion("");
        } else {
            dvo.setToClientes_profesion(usuario.f_txt_profesion.getText());
        }

        if (usuario.f_cb_dpi.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_dpi("Seleccionar");
        } else {
            String DPI = (String) usuario.f_cb_dpi.getSelectedItem();
            dvo.setToClientes_dpi(DPI);
        }

        if (usuario.f_cb_nit.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_nit("Seleccionar");
        } else {
            String Nit = (String) usuario.f_cb_nit.getSelectedItem();
            dvo.setToClientes_nit(Nit);
        }

        if (usuario.f_cb_id.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_UsaId("Seleccionar");
        } else {
            String UsID = (String) usuario.f_cb_id.getSelectedItem();
            dvo.setToClientes_UsaId(UsID);
        }

        if (usuario.f_txt_repNombre.getText().isEmpty()) {
            dvo.setToRepresentante_nombre("");
        } else {
            dvo.setToRepresentante_nombre(usuario.f_txt_repNombre.getText());
        }

        if (usuario.f_txt_repDireccion.getText().isEmpty()) {
            dvo.setToRepresentante_direccion("");
        } else {
            dvo.setToRepresentante_direccion(usuario.f_txt_repDireccion.getText());
        }

        if (usuario.f_txt_repTelefono.getText().isEmpty()) {
            dvo.setToRepresentante_telefono("");
        } else {
            dvo.setToRepresentante_telefono(usuario.f_txt_repTelefono.getText());
        }

        if (usuario.f_txt_repParentezco.getText().isEmpty()) {
            dvo.setToRepresentante_parentezco("");
        } else {
            dvo.setToRepresentante_parentezco(usuario.f_txt_repParentezco.getText());
        }

        if (usuario.f_txt_repBanco.getText().isEmpty()) {
            dvo.setToRepresentante_banco("");
        } else {
            dvo.setToRepresentante_banco(usuario.f_txt_repBanco.getText());
        }

        if (usuario.f_txt_honorarios.getText().isEmpty()) {
            dvo.setToCasos_honorarios(0.00);
        } else {
            dvo.setToCasos_honorarios(Double.parseDouble(usuario.f_txt_honorarios.getText()));
        }

        if (usuario.f_txt_salario.getText().isEmpty()) {
            dvo.setToCasos_salario(0.00);
        } else {
            dvo.setToCasos_salario(Double.parseDouble(usuario.f_txt_salario.getText()));
        }

        if (usuario.f_txt_notas.getText().isEmpty()) {
            dvo.setToCasos_notas("");
        } else {
            dvo.setToCasos_notas(usuario.f_txt_notas.getText());
        }

        if (usuario.f_txt_tipoPropiedad.getSelectedItem().equals("Seleccionar")) {
            dvo.setToCasos_idPropiedad(5);
        } else {
            String tipoPropiedad = (String) usuario.f_txt_tipoPropiedad.getSelectedItem();
            switch (tipoPropiedad) {

                case "Terreno":
                    dvo.setToCasos_idPropiedad(1);
                    break;
                case "Casa":
                    dvo.setToCasos_idPropiedad(2);
                    break;
                case "Apartamento":
                    dvo.setToCasos_idPropiedad(3);
                    break;
                case "Oficina":
                    dvo.setToCasos_idPropiedad(4);
                    break;
                default:
                    break;
            }
        }

        if (usuario.rd_txt_informacion.getText().isEmpty()) {
            dvo.setToRegistros_notas("");
        } else {
            dvo.setToRegistros_notas(usuario.rd_txt_informacion.getText());
        }
        try {

            ddao.modificar_datos_vendedor(dvo);
            ddao.modificar_datos_representante(dvo);
            ddao.modificar_datos_clientes(dvo);
            ddao.idCliente(dvo);
            ddao.modificar_datos_casos(dvo);
            if (!usuario.rd_txt_informacion.getText().isEmpty()) {
                ddao.idCaso(dvo);
                ddao.insertar_datos_registro(dvo);
            }
            login.mensaje.showMessageDialog(null, "Datos modificados exitosamente");

            usuario.f_cb_editar.setSelected(false);
            usuario.f_btn_guardar.setEnabled(false);
            usuario.rd_txt_informacion.setText("");
        } catch (Exception e) {
            System.out.println("----- Error " + e.getMessage());
            login.mensaje.showMessageDialog(null, "A ocurrido un error Contacte a su administrador de Servicio");
        }

        if (!dvo.getBuscar_nombre().isEmpty()) {
            buscarNombre();
            registroDetallado();
        } else if (!dvo.getBuscar_telefono().isEmpty()) {
            buscarTelefono();
            registroDetallado();
        } else if (!dvo.getBuscar_correo().isEmpty()) {
            buscarCorreo();
            registroDetallado();
        } else {

        }

    }

    private void nuevoCaso() {
        if (usuario.f_txt_tramite.getText().isEmpty()) {
            dvo.setToClientes_ClaseTraite("pendiente");
        } else {
            dvo.setToClientes_ClaseTraite(usuario.f_txt_tramite.getText());
        }

        if (usuario.f_txt_vendedorNombre.getText().isEmpty()) {
            dvo.setToVendedor_nombre("pendiente");
        } else {
            dvo.setToVendedor_nombre(usuario.f_txt_vendedorNombre.getText());
        }

        if (usuario.f_txt_vendedorTelefono.getText().isEmpty()) {
            dvo.setToVendedor_telefono("pendiente");
        } else {
            dvo.setToVendedor_telefono(usuario.f_txt_vendedorTelefono.getText());
        }

        if (usuario.f_txt_vendedorContructora.getText().isEmpty()) {
            dvo.setToVendedor_constructora("pendiente");
        } else {
            dvo.setToVendedor_constructora(usuario.f_txt_vendedorContructora.getText());
        }

        if (usuario.f_txt_vendedorCorreo.getText().isEmpty()) {
            dvo.setToVendedor_correo("pendiente");
        } else {
            dvo.setToVendedor_correo(usuario.f_txt_vendedorCorreo.getText());
        }

        if (usuario.f_txt_honorarios.getText().isEmpty()) {
            dvo.setToCasos_honorarios(0.00);
        } else {
            dvo.setToCasos_honorarios(Double.parseDouble(usuario.f_txt_honorarios.getText()));
        }

        if (usuario.f_txt_salario.getText().isEmpty()) {
            dvo.setToCasos_salario(0.00);
        } else {
            dvo.setToCasos_salario(Double.parseDouble(usuario.f_txt_salario.getText()));
        }

        if (usuario.f_txt_direccionUSA.getText().isEmpty()) {
            dvo.setToClientes_direccion("pendiente");
        } else {
            dvo.setToClientes_direccion(usuario.f_txt_direccionUSA.getText());
        }

        if (usuario.f_txt_nombreCliente.getText().isEmpty()) {
            dvo.setToClientes_nombre("pendiente");
        } else {
            dvo.setToClientes_nombre(usuario.f_txt_nombreCliente.getText());
        }

        if (usuario.f_txt_telefonoCliente.getText().isEmpty()) {
            dvo.setToClientes_telefono("pendente");
        } else {
            dvo.setToClientes_telefono(usuario.f_txt_telefonoCliente.getText());
        }

        if (usuario.f_txt_estadoResidencia.getText().isEmpty()) {
            dvo.setToClientes_EstadoResidencia("pendiente");
        } else {
            dvo.setToClientes_EstadoResidencia(usuario.f_txt_estadoResidencia.getText());
        }

        if (usuario.f_txt_estadoCivil.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_id_EstadoCivil(5);
        } else {
            String estadoCivil = (String) usuario.f_txt_estadoMigratorio.getSelectedItem();
            switch (estadoCivil) {

                case "Soltero (a)":
                    dvo.setToClientes_id_EstadoCivil(1);
                    break;
                case "Casado (a)":
                    dvo.setToClientes_id_EstadoCivil(2);
                    break;
                case "Divorciado (a)":
                    dvo.setToClientes_id_EstadoCivil(3);
                    break;
                case "Viudo (a)":
                    dvo.setToClientes_id_EstadoCivil(4);
                    break;
                default:
                    break;
            }

        }

        if (usuario.f_txt_tipoPropiedad.getSelectedItem().equals("Seleccionar")) {
            dvo.setToPropiedad_id(5);
        } else {
            String tipoPropiedad = (String) usuario.f_txt_tipoPropiedad.getSelectedItem();
            switch (tipoPropiedad) {

                case "Terreno":
                    dvo.setToPropiedad_id(1);
                    break;
                case "Casa":
                    dvo.setToPropiedad_id(2);
                    break;
                case "Divorciado (a)":
                    dvo.setToPropiedad_id(3);
                    break;
                case "Oficina":
                    dvo.setToPropiedad_id(4);
                    break;
                default:
                    break;
            }
        }

        if (usuario.f_txt_correoCliente.getText().isEmpty()) {
            dvo.setToClientes_correo("pendiente");
        } else {
            dvo.setToClientes_correo(usuario.f_txt_correoCliente.getText());
        }

        if (usuario.f_txt_estadoMigratorio.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_id_migratorio(4);
        } else {
            String estadoMigratorio = (String) usuario.f_txt_tipoPropiedad.getSelectedItem();
            switch (estadoMigratorio) {

                case "Residente":
                    dvo.setToClientes_id_migratorio(1);
                    break;
                case "Ciudadano":
                    dvo.setToClientes_id_migratorio(2);
                    break;
                case "Regular (a)":
                    dvo.setToClientes_id_migratorio(3);
                    break;
                default:
                    break;
            }
        }

        if (usuario.f_txt_profesion.getText().isEmpty()) {
            dvo.setToClientes_profesion("Pendiente");
        } else {
            dvo.setToClientes_profesion(usuario.f_txt_profesion.getText());
        }

        if (usuario.f_cb_dpi.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_dpi("Seleccionar");
        } else {
            String DPI = (String) usuario.f_cb_dpi.getSelectedItem();
            dvo.setToClientes_dpi(DPI);
        }

        if (usuario.f_cb_nit.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_nit("Seleccionar");
        } else {
            String Nit = (String) usuario.f_cb_nit.getSelectedItem();
            dvo.setToClientes_nit(Nit);
        }

        if (usuario.f_cb_id.getSelectedItem().equals("Seleccionar")) {
            dvo.setToClientes_UsaId("Seleccionar");
        } else {
            String UsID = (String) usuario.f_cb_id.getSelectedItem();
            dvo.setToClientes_UsaId(UsID);
        }

        if (usuario.f_txt_repNombre.getText().isEmpty()) {
            dvo.setToRepresentante_nombre("pendiente");
        } else {
            dvo.setToRepresentante_nombre(usuario.f_txt_repNombre.getText());
        }

        if (usuario.f_txt_repDireccion.getText().isEmpty()) {
            dvo.setToRepresentante_direccion("pendiente");
        } else {
            dvo.setToRepresentante_direccion(usuario.f_txt_repDireccion.getText());
        }

        if (usuario.f_txt_repTelefono.getText().isEmpty()) {
            dvo.setToRepresentante_telefono("pendiente");
        } else {
            dvo.setToRepresentante_telefono(usuario.f_txt_repTelefono.getText());
        }

        if (usuario.f_txt_repParentezco.getText().isEmpty()) {
            dvo.setToRepresentante_parentezco("pendiente");
        } else {
            dvo.setToRepresentante_parentezco("pendiente");
        }

        if (usuario.f_txt_repBanco.getText().isEmpty()) {
            dvo.setToRepresentante_banco("Pendiente");
        } else {

        }

        if (usuario.f_txt_notas.getText().isEmpty()) {
            dvo.setToCasos_notas("No Hay Notas");
        } else {
            dvo.setToCasos_notas(usuario.f_txt_notas.getText());
        }

        if (usuario.rd_txt_informacion.getText().isEmpty()) {
            dvo.setToRegistros_notas("");
        } else {
            dvo.setToRegistros_notas(usuario.rd_txt_informacion.getText());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuario.f_btn_buscarCliente) {
            buscarCliente();
        }

        if (e.getSource() == usuario.f_btn_guardar) {
            if (usuario.f_cb_editar.isSelected() == true) {
                editarCaso();
            }

            if (usuario.f_cb_nuevo.isSelected() == true) {
                nuevoCaso();
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (usuario.f_cb_editar.isSelected() == true) {
            enableText();
            usuario.f_btn_guardar.setEnabled(true);
            usuario.f_cb_nuevo.setEnabled(false);

            if (usuario.rd_txt_fecha.getText().isEmpty()) {
                GregorianCalendar c = new GregorianCalendar();
                int year, month, day;
                String date;
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;
                usuario.rd_txt_fecha.setText(date);
                dvo.setToRegistros_fecha(date);
            }

            if (usuario.rd_txt_usuario.getText().isEmpty()) {
                usuario.rd_txt_usuario.setText(dvo.getUser_login());
                switch (usuario.rd_txt_usuario.getText()) {
                    case "gsandoval":
                        dvo.setToRegistros_id_usuarios("2");
                        break;
                    case "ssoto":
                        dvo.setToRegistros_id_usuarios("3");
                        break;
                    case "ririarte":
                        dvo.setToRegistros_id_usuarios("4");
                        break;
                    default:
                        break;
                }
            }

        } else if (usuario.f_cb_nuevo.isSelected() == true) {
            enableText();
            usuario.f_btn_guardar.setEnabled(true);
            usuario.f_cb_editar.setEnabled(false);
            if (usuario.rd_txt_fecha.getText().isEmpty()) {
                GregorianCalendar c = new GregorianCalendar();
                int year, month, day;
                String date;
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;
                usuario.rd_txt_fecha.setText(date);
                dvo.setToRegistros_fecha(date);
            }

            if (usuario.rd_txt_usuario.getText().isEmpty()) {
                usuario.rd_txt_usuario.setText(dvo.getUser_login());
                switch (usuario.rd_txt_usuario.getText()) {
                    case "gsandoval":
                        dvo.setToRegistros_id_usuarios("2");
                        break;
                    case "ssoto":
                        dvo.setToRegistros_id_usuarios("3");
                        break;
                    case "ririarte":
                        dvo.setToRegistros_id_usuarios("4");
                        break;
                    default:
                        break;
                }
            }
        } else {
            disableText();
            usuario.f_btn_guardar.setEnabled(false);
            usuario.f_cb_nuevo.setEnabled(true);
            usuario.f_cb_editar.setEnabled(true);
        }
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        cleanText();
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

}
