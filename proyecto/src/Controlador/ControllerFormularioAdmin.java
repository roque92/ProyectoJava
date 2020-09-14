
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
import proyecto.Vista.Administrador;
import proyecto.Vista.Login;

/**
 *
 * @author Jose Roque
 */
public class ControllerFormularioAdmin implements ActionListener, ChangeListener, InternalFrameListener {

    Administrador admin = new Administrador();
    Login login = new Login();
    DatosVO dvo = new DatosVO();
    DatosDAO ddao = new DatosDAO();
    StringsBaseDatos sbd = new StringsBaseDatos();
    TablasBaseDatos tbd = new TablasBaseDatos();

    public ControllerFormularioAdmin(Administrador admin, Login login, DatosVO dvo, DatosDAO ddao, StringsBaseDatos sbd, TablasBaseDatos tbd) {
        this.admin = admin;
        this.login = login;
        this.dvo = dvo;
        this.ddao = ddao;
        this.sbd = sbd;
        this.tbd = tbd;

        admin.f_btn_buscarCliente.addActionListener(this);
        admin.f_btn_guardar.addActionListener(this);
        admin.f_cb_editar.addChangeListener(this);
        admin.f_cb_nuevo.addChangeListener(this);
        admin.if_formulario.addInternalFrameListener(this);
    }

    private void buscarCliente() {

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {

                admin.progressUser.setValue(0);
                admin.progressUser.setVisible(true);

                try {

                    String valorBuscado = (String) admin.f_valor_buscado.getSelectedItem();

                    switch (valorBuscado) {
                        case "Nombre":
                            admin.progressUser.setValue(0);
                            Thread.sleep(1000);
                            dvo.setBuscar_nombre(admin.f_txt_buscarCliente.getText().trim());
                            buscarNombre();
                            break;
                        case "Telefono":
                            admin.progressUser.setValue(0);
                            Thread.sleep(1000);
                            dvo.setBuscar_telefono(admin.f_txt_buscarCliente.getText());
                            buscarTelefono();
                            break;
                        case "Correo":
                            admin.progressUser.setValue(0);
                            Thread.sleep(1000);
                            dvo.setBuscar_correo(admin.f_txt_buscarCliente.getText().trim());
                            buscarCorreo();
                            break;
                        default:
                            admin.progressUser.setValue(0);
                            Thread.sleep(1000);
                            login.mensaje.showMessageDialog(null, "Por favor indicar el tipo de busqueda");
                            admin.f_txt_buscarCliente.setText("");
                            admin.progressUser.setValue(0);
                            admin.progressUser.setVisible(false);
                            break;
                    }
                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage());
                }
            }
        });

        th.start();

    }

    //---------------Metodos Principales
    private void buscarNombre() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cleanText();
                    admin.progressUser.setValue(25);
                    Thread.sleep(1000);
                    admin.f_txt_buscarCliente.setText("");
                    admin.f_valor_buscado.setSelectedItem("Seleccionar");
                    ddao.mostrar_datos_nombre(dvo);

                    if (dvo.getNombre_cliente().equals("")) {
                        login.mensaje.showMessageDialog(null, "Cliente no Existe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
//Asignacion de datos Clase Tramite
                        admin.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
                        admin.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
                        admin.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
                        admin.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
                        admin.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
                        admin.progressUser.setValue(50);
                        Thread.sleep(1000);
                        admin.f_txt_honorarios.setText(String.valueOf(dvo.getHonorarios_casos()));
                        admin.f_txt_salario.setText(String.valueOf(dvo.getSalario_casos()));
                        admin.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
                        admin.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
                        admin.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
                        admin.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
                        admin.f_txt_estadoMigratorio.setSelectedItem(dvo.getEstadoMigratorio_cliente());
                        admin.f_txt_tipoPropiedad.setSelectedItem(dvo.getTipo_propiedad());
                        admin.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
                        admin.f_txt_estadoCivil.setSelectedItem(dvo.getEstadoCivil_cliente());
                        admin.f_txt_profesion.setText(dvo.getProfecion_cliente());
                        admin.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
                        admin.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
                        admin.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
                        admin.progressUser.setValue(75);
                        Thread.sleep(1000);
                        admin.f_txt_repNombre.setText(dvo.getNombre_representante());
                        admin.f_txt_repDireccion.setText(dvo.getDireccion_representante());
                        admin.f_txt_repTelefono.setText(dvo.getTelefono_representante());
                        admin.f_txt_repParentezco.setText(dvo.getParentezco_representante());
                        admin.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
                        admin.f_txt_notas.setText(dvo.getNotas_casos());
                        registroDetallado();
                        admin.progressUser.setValue(100);
                        Thread.sleep(1000);
                        admin.progressUser.setVisible(false);
                    }
                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage() + " " + dvo.getError());
                    admin.progressUser.setValue(0);
                    admin.progressUser.setVisible(false);
                    cleanText();
                }
            }

        });

        th.start();

    }

    private void buscarTelefono() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cleanText();
                    admin.progressUser.setValue(25);
                    Thread.sleep(1000);
                    admin.f_txt_buscarCliente.setText("");
                    admin.f_valor_buscado.setSelectedItem("Seleccionar");
                    ddao.mostrar_datos_telefono(dvo);

                    if (dvo.getNombre_cliente().equals("")) {
                        login.mensaje.showMessageDialog(null, "Cliente no Existe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
//Asignacion de datos Clase Tramite
                        admin.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
                        admin.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
                        admin.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
                        admin.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
                        admin.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
                        admin.progressUser.setValue(50);
                        Thread.sleep(1000);
                        admin.f_txt_honorarios.setText(String.valueOf(dvo.getHonorarios_casos()));
                        admin.f_txt_salario.setText(String.valueOf(dvo.getSalario_casos()));
                        admin.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
                        admin.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
                        admin.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
                        admin.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
                        admin.f_txt_estadoMigratorio.setSelectedItem(dvo.getEstadoMigratorio_cliente());
                        admin.f_txt_tipoPropiedad.setSelectedItem(dvo.getTipo_propiedad());
                        admin.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
                        admin.f_txt_estadoCivil.setSelectedItem(dvo.getEstadoCivil_cliente());
                        admin.f_txt_profesion.setText(dvo.getProfecion_cliente());
                        admin.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
                        admin.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
                        admin.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
                        admin.progressUser.setValue(75);
                        Thread.sleep(1000);
                        admin.f_txt_repNombre.setText(dvo.getNombre_representante());
                        admin.f_txt_repDireccion.setText(dvo.getDireccion_representante());
                        admin.f_txt_repTelefono.setText(dvo.getTelefono_representante());
                        admin.f_txt_repParentezco.setText(dvo.getParentezco_representante());
                        admin.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
                        admin.f_txt_notas.setText(dvo.getNotas_casos());
                        registroDetallado();
                        admin.progressUser.setValue(100);
                        Thread.sleep(1000);
                        admin.progressUser.setVisible(false);
                    }
                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage());
                }
            }

        });

        th.start();
    }

    private void buscarCorreo() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cleanText();
                    admin.progressUser.setValue(25);
                    Thread.sleep(1000);
                    admin.f_txt_buscarCliente.setText("");
                    admin.f_valor_buscado.setSelectedItem("Seleccionar");
                    ddao.mostrar_datos_correo(dvo);

                    if (dvo.getNombre_cliente().equals("")) {
                        login.mensaje.showMessageDialog(null, "Cliente no Existe", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
//Asignacion de datos Clase Tramite
                        admin.f_txt_tramite.setText(dvo.getClaseTramite_cliente());
//Asignacino de datos del Asesor/Vendedor
                        admin.f_txt_vendedorNombre.setText(dvo.getNombre_vendedor());
                        admin.f_txt_vendedorTelefono.setText(dvo.getTelefono_vendedor());
                        admin.f_txt_vendedorContructora.setText(dvo.getConstructora_vendedor());
                        admin.f_txt_vendedorCorreo.setText(dvo.getCorreo_vendedor());
//Asignacion de datos Financieros
                        admin.progressUser.setValue(50);
                        Thread.sleep(1000);
                        admin.f_txt_honorarios.setText(String.valueOf(dvo.getHonorarios_casos()));
                        admin.f_txt_salario.setText(String.valueOf(dvo.getSalario_casos()));
                        admin.f_txt_direccionUSA.setText(dvo.getDireccion_cliente());
//Asignacion de datos Negociacion
                        admin.f_txt_nombreCliente.setText(dvo.getNombre_cliente());
                        admin.f_txt_telefonoCliente.setText(dvo.getTelefono_cliente());
                        admin.f_txt_estadoResidencia.setText(dvo.getEstadoResidencia_cliente());
                        admin.f_txt_estadoMigratorio.setSelectedItem(dvo.getEstadoMigratorio_cliente());
                        admin.f_txt_tipoPropiedad.setSelectedItem(dvo.getTipo_propiedad());
                        admin.f_txt_correoCliente.setText(dvo.getCorreo_cliente());
                        admin.f_txt_estadoCivil.setSelectedItem(dvo.getEstadoCivil_cliente());
                        admin.f_txt_profesion.setText(dvo.getProfecion_cliente());
                        admin.f_cb_dpi.setSelectedItem(dvo.getDpi_cliente());
                        admin.f_cb_nit.setSelectedItem(dvo.getNit_cliente());
                        admin.f_cb_id.setSelectedItem(dvo.getUsaId_cliente());
//Asignacion de datos Representante Legal
                        admin.progressUser.setValue(75);
                        Thread.sleep(1000);
                        admin.f_txt_repNombre.setText(dvo.getNombre_representante());
                        admin.f_txt_repDireccion.setText(dvo.getDireccion_representante());
                        admin.f_txt_repTelefono.setText(dvo.getTelefono_representante());
                        admin.f_txt_repParentezco.setText(dvo.getParentezco_representante());
                        admin.f_txt_repBanco.setText(dvo.getBanco_representante());
//Asignacion de datos Notas
                        admin.f_txt_notas.setText(dvo.getNotas_casos());
                        registroDetallado();
                        admin.progressUser.setValue(100);
                        Thread.sleep(1000);
                        admin.progressUser.setVisible(false);
                    }
                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage());
                }
            }

        });

        th.start();
    }

    private void registroDetallado() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
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

                        admin.f_tbl_seguimiento.setModel(m);

                    } catch (Exception e) {
                        login.mensaje.showMessageDialog(null, "No se puede conectar con la base de datos Contacte con su Administrador", "Problemas de Conexion", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage());
                }
            }

            TablasBaseDatos tbd = new TablasBaseDatos();
        });
        th.start();

    }

    private void editarCaso() {

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                admin.progressUser.setValue(0);
                admin.progressUser.setVisible(true);
                try {
                    if (admin.f_txt_vendedorNombre.getText().isEmpty()) {
                        dvo.setToVendedor_nombre(" ");
                    } else {
                        dvo.setToVendedor_nombre(admin.f_txt_vendedorNombre.getText());
                    }

                    if (admin.f_txt_vendedorTelefono.getText().isEmpty()) {
                        dvo.setToVendedor_telefono(" ");
                    } else {
                        dvo.setToVendedor_telefono(admin.f_txt_vendedorTelefono.getText());
                    }

                    if (admin.f_txt_vendedorContructora.getText().isEmpty()) {
                        dvo.setToVendedor_constructora(" ");
                    } else {
                        dvo.setToVendedor_constructora(admin.f_txt_vendedorContructora.getText());
                    }

                    if (admin.f_txt_vendedorCorreo.getText().isEmpty()) {
                        dvo.setToVendedor_correo(" ");
                    } else {
                        dvo.setToVendedor_correo(admin.f_txt_vendedorCorreo.getText());
                    }

                    if (admin.f_txt_tramite.getText().isEmpty()) {
                        dvo.setToClientes_ClaseTraite(" ");
                    } else {
                        dvo.setToClientes_ClaseTraite(admin.f_txt_tramite.getText());
                    }

                    if (admin.f_txt_direccionUSA.getText().isEmpty()) {
                        dvo.setToClientes_direccion(" ");
                    } else {
                        dvo.setToClientes_direccion(admin.f_txt_direccionUSA.getText());
                    }

                    if (admin.f_txt_nombreCliente.getText().isEmpty()) {
                        dvo.setToClientes_nombre(" ");
                    } else {
                        dvo.setToClientes_nombre(admin.f_txt_nombreCliente.getText());
                    }

                    if (admin.f_txt_telefonoCliente.getText().isEmpty()) {
                        dvo.setToClientes_telefono(" ");
                    } else {
                        dvo.setToClientes_telefono(admin.f_txt_telefonoCliente.getText());
                    }

                    if (admin.f_txt_estadoResidencia.getText().isEmpty()) {
                        dvo.setToClientes_EstadoResidencia(" ");
                    } else {
                        dvo.setToClientes_EstadoResidencia(admin.f_txt_estadoResidencia.getText());
                    }

                    admin.progressUser.setValue(10);
                    Thread.sleep(1000);

                    if (admin.f_txt_estadoCivil.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_id_EstadoCivil(5);
                    } else {
                        String estadoCivil = (String) admin.f_txt_estadoCivil.getSelectedItem();
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

                    if (admin.f_txt_correoCliente.getText().isEmpty()) {
                        dvo.setToClientes_correo(" ");
                    } else {
                        dvo.setToClientes_correo(admin.f_txt_correoCliente.getText());
                    }

                    if (admin.f_txt_estadoMigratorio.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_id_migratorio(4);
                    } else {
                        String estadoMigratorio = (String) admin.f_txt_estadoMigratorio.getSelectedItem();
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

                    if (admin.f_txt_profesion.getText().isEmpty()) {
                        dvo.setToClientes_profesion(" ");
                    } else {
                        dvo.setToClientes_profesion(admin.f_txt_profesion.getText());
                    }

                    if (admin.f_cb_dpi.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_dpi("Seleccionar");
                    } else {
                        String DPI = (String) admin.f_cb_dpi.getSelectedItem();
                        dvo.setToClientes_dpi(DPI);
                    }

                    if (admin.f_cb_nit.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_nit("Seleccionar");
                    } else {
                        String Nit = (String) admin.f_cb_nit.getSelectedItem();
                        dvo.setToClientes_nit(Nit);
                    }

                    if (admin.f_cb_id.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_UsaId("Seleccionar");
                    } else {
                        String UsID = (String) admin.f_cb_id.getSelectedItem();
                        dvo.setToClientes_UsaId(UsID);
                    }

                    admin.progressUser.setValue(20);
                    Thread.sleep(1000);

                    if (admin.f_txt_repNombre.getText().isEmpty()) {
                        dvo.setToRepresentante_nombre(" ");
                    } else {
                        dvo.setToRepresentante_nombre(admin.f_txt_repNombre.getText());
                    }

                    if (admin.f_txt_repDireccion.getText().isEmpty()) {
                        dvo.setToRepresentante_direccion(" ");
                    } else {
                        dvo.setToRepresentante_direccion(admin.f_txt_repDireccion.getText());
                    }

                    if (admin.f_txt_repTelefono.getText().isEmpty()) {
                        dvo.setToRepresentante_telefono(" ");
                    } else {
                        dvo.setToRepresentante_telefono(admin.f_txt_repTelefono.getText());
                    }

                    if (admin.f_txt_repParentezco.getText().isEmpty()) {
                        dvo.setToRepresentante_parentezco(" ");
                    } else {
                        dvo.setToRepresentante_parentezco(admin.f_txt_repParentezco.getText());
                    }

                    if (admin.f_txt_repBanco.getText().isEmpty()) {
                        dvo.setToRepresentante_banco(" ");
                    } else {
                        dvo.setToRepresentante_banco(admin.f_txt_repBanco.getText());
                    }

                    admin.progressUser.setValue(40);
                    Thread.sleep(1000);

                    if (admin.f_txt_honorarios.getText().isEmpty()) {
                        dvo.setToCasos_honorarios(0.00);
                    } else {
                        dvo.setToCasos_honorarios(Double.parseDouble(admin.f_txt_honorarios.getText()));
                    }

                    if (admin.f_txt_salario.getText().isEmpty()) {
                        dvo.setToCasos_salario(0.00);
                    } else {
                        dvo.setToCasos_salario(Double.parseDouble(admin.f_txt_salario.getText()));
                    }

                    if (admin.f_txt_notas.getText().isEmpty()) {
                        dvo.setToCasos_notas(" ");
                    } else {
                        dvo.setToCasos_notas(admin.f_txt_notas.getText());
                    }

                    if (admin.f_txt_tipoPropiedad.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToCasos_idPropiedad(5);
                    } else {
                        String tipoPropiedad = (String) admin.f_txt_tipoPropiedad.getSelectedItem();
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

                    admin.progressUser.setValue(60);
                    Thread.sleep(1000);

                    if (admin.rd_txt_informacion.getText().isEmpty()) {
                        dvo.setToRegistros_notas(" ");
                    } else {
                        dvo.setToRegistros_notas(admin.rd_txt_informacion.getText());
                    }
                    try {

                        ddao.modificar_datos_vendedor(dvo);
                        ddao.modificar_datos_representante(dvo);
                        ddao.modificar_datos_clientes(dvo);
                        ddao.idCliente(dvo);
                        ddao.modificar_datos_casos(dvo);
                        if (!admin.rd_txt_informacion.getText().isEmpty()) {
                            ddao.idCaso(dvo);
                            ddao.insertar_datos_registro(dvo);
                        }
                        login.mensaje.showMessageDialog(null, "Datos modificados exitosamente");

                        admin.f_cb_editar.setSelected(false);
                        admin.f_btn_guardar.setEnabled(false);
                        admin.rd_txt_informacion.setText("");
                    } catch (Exception e) {
                        System.out.println("----- Error " + e.getMessage());
                        login.mensaje.showMessageDialog(null, "A ocurrido un error Contacte a su administrador de Servicio");
                    }

                    admin.progressUser.setValue(80);
                    Thread.sleep(1000);

                    if (!dvo.getBuscar_nombre().isEmpty()) {
                        buscarNombre();
                    } else if (!dvo.getBuscar_telefono().isEmpty()) {
                        buscarTelefono();
                    } else if (!dvo.getBuscar_correo().isEmpty()) {
                        buscarCorreo();
                    } else {

                    }

                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage());
                }
            }
        });

        th.start();

    } // pendiente cargar ayuda visual progressBar

    private void nuevoCaso() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                cleanDVO();
                admin.progressUser.setValue(0);
                admin.progressUser.setVisible(true);
                try {
                    if (admin.f_txt_vendedorNombre.getText().isEmpty()) {
                        dvo.setToVendedor_nombre("");
                    } else {
                        dvo.setToVendedor_nombre(admin.f_txt_vendedorNombre.getText());
                    }

                    if (admin.f_txt_vendedorTelefono.getText().isEmpty()) {
                        dvo.setToVendedor_telefono(" ");
                    } else {
                        dvo.setToVendedor_telefono(admin.f_txt_vendedorTelefono.getText());
                    }

                    if (admin.f_txt_vendedorContructora.getText().isEmpty()) {
                        dvo.setToVendedor_constructora(" ");
                    } else {
                        dvo.setToVendedor_constructora(admin.f_txt_vendedorContructora.getText());
                    }

                    if (admin.f_txt_vendedorCorreo.getText().isEmpty()) {
                        dvo.setToVendedor_correo(" ");
                    } else {
                        dvo.setToVendedor_correo(admin.f_txt_vendedorCorreo.getText());
                    }

                    if (admin.f_txt_tramite.getText().isEmpty()) {
                        dvo.setToClientes_ClaseTraite(" ");
                    } else {
                        dvo.setToClientes_ClaseTraite(admin.f_txt_tramite.getText());
                    }

                    if (admin.f_txt_direccionUSA.getText().isEmpty()) {
                        dvo.setToClientes_direccion(" ");
                    } else {
                        dvo.setToClientes_direccion(admin.f_txt_direccionUSA.getText());
                    }

                    if (admin.f_txt_nombreCliente.getText().isEmpty()) {
                        dvo.setToClientes_nombre(" ");
                    } else {
                        dvo.setToClientes_nombre(admin.f_txt_nombreCliente.getText());
                    }

                    if (admin.f_txt_telefonoCliente.getText().isEmpty()) {
                        dvo.setToClientes_telefono(" ");
                    } else {
                        dvo.setToClientes_telefono(admin.f_txt_telefonoCliente.getText());
                    }

                    if (admin.f_txt_estadoResidencia.getText().isEmpty()) {
                        dvo.setToClientes_EstadoResidencia(" ");
                    } else {
                        dvo.setToClientes_EstadoResidencia(admin.f_txt_estadoResidencia.getText());
                    }

                    admin.progressUser.setValue(10);
                    Thread.sleep(1000);

                    if (admin.f_txt_estadoCivil.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_id_EstadoCivil(5);
                    } else {
                        String estadoCivil = (String) admin.f_txt_estadoCivil.getSelectedItem();
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

                    if (admin.f_txt_correoCliente.getText().isEmpty()) {
                        dvo.setToClientes_correo(" ");
                    } else {
                        dvo.setToClientes_correo(admin.f_txt_correoCliente.getText());
                    }

                    if (admin.f_txt_estadoMigratorio.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_id_migratorio(4);
                    } else {
                        String estadoMigratorio = (String) admin.f_txt_estadoMigratorio.getSelectedItem();
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

                    if (admin.f_txt_profesion.getText().isEmpty()) {
                        dvo.setToClientes_profesion(" ");
                    } else {
                        dvo.setToClientes_profesion(admin.f_txt_profesion.getText());
                    }

                    if (admin.f_cb_dpi.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_dpi("Seleccionar");
                    } else {
                        String DPI = (String) admin.f_cb_dpi.getSelectedItem();
                        dvo.setToClientes_dpi(DPI);
                    }

                    if (admin.f_cb_nit.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_nit("Seleccionar");
                    } else {
                        String Nit = (String) admin.f_cb_nit.getSelectedItem();
                        dvo.setToClientes_nit(Nit);
                    }

                    if (admin.f_cb_id.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToClientes_UsaId("Seleccionar");
                    } else {
                        String UsID = (String) admin.f_cb_id.getSelectedItem();
                        dvo.setToClientes_UsaId(UsID);
                    }

                    admin.progressUser.setValue(20);
                    Thread.sleep(1000);

                    if (admin.f_txt_repNombre.getText().isEmpty()) {
                        dvo.setToRepresentante_nombre(" ");
                    } else {
                        dvo.setToRepresentante_nombre(admin.f_txt_repNombre.getText());
                    }

                    if (admin.f_txt_repDireccion.getText().isEmpty()) {
                        dvo.setToRepresentante_direccion(" ");
                    } else {
                        dvo.setToRepresentante_direccion(admin.f_txt_repDireccion.getText());
                    }

                    if (admin.f_txt_repTelefono.getText().isEmpty()) {
                        dvo.setToRepresentante_telefono(" ");
                    } else {
                        dvo.setToRepresentante_telefono(admin.f_txt_repTelefono.getText());
                    }

                    if (admin.f_txt_repParentezco.getText().isEmpty()) {
                        dvo.setToRepresentante_parentezco(" ");
                    } else {
                        dvo.setToRepresentante_parentezco(admin.f_txt_repParentezco.getText());
                    }

                    if (admin.f_txt_repBanco.getText().isEmpty()) {
                        dvo.setToRepresentante_banco(" ");
                    } else {
                        dvo.setToRepresentante_banco(admin.f_txt_repBanco.getText());
                    }

                    admin.progressUser.setValue(40);
                    Thread.sleep(1000);

                    if (admin.f_txt_honorarios.getText().isEmpty()) {
                        dvo.setToCasos_honorarios(0.00);
                    } else {
                        dvo.setToCasos_honorarios(Double.parseDouble(admin.f_txt_honorarios.getText()));
                    }

                    if (admin.f_txt_salario.getText().isEmpty()) {
                        dvo.setToCasos_salario(0.00);
                    } else {
                        dvo.setToCasos_salario(Double.parseDouble(admin.f_txt_salario.getText()));
                    }

                    if (admin.f_txt_notas.getText().isEmpty()) {
                        dvo.setToCasos_notas(" ");
                    } else {
                        dvo.setToCasos_notas(admin.f_txt_notas.getText());
                    }

                    if (admin.f_txt_tipoPropiedad.getSelectedItem().equals("Seleccionar")) {
                        dvo.setToCasos_idPropiedad(5);
                    } else {
                        String tipoPropiedad = (String) admin.f_txt_tipoPropiedad.getSelectedItem();
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

                    admin.progressUser.setValue(60);
                    Thread.sleep(1000);

                    if (admin.rd_txt_informacion.getText().isEmpty()) {
                        dvo.setToRegistros_notas(" ");
                    } else {
                        dvo.setToRegistros_notas(admin.rd_txt_informacion.getText());
                    }
                    try {
                        //metodos para crear un nuevo caso

                        ddao.buscar_id_vendedor(dvo);
                        if (dvo.getId_vendedor().equals("0")) {
                            ddao.insertar_datos_vendedor(dvo);
                            ddao.buscar_id_vendedor(dvo);
                        }
                        ddao.insertar_datos_representante(dvo);
                        ddao.buscar_id_representante(dvo);
                        ddao.insertar_datos_clientes(dvo);
                        ddao.idCliente2(dvo);
                        //asignacion de ID's
                        dvo.setToCasos_idCliente(Integer.parseInt(dvo.getId_cliente()));
                        dvo.setToCasos_idVendedor(Integer.parseInt(dvo.getId_vendedor()));
                        dvo.setToCasos_idRepresentante(Integer.parseInt(dvo.getId_representante()));
                        dvo.setToCasos_idUsuario(dvo.getLogin_id());
                        dvo.setToCasos_idEstado(1);
                        //pendiente creacion caso                        
                        ddao.insertar_datos_casos(dvo);
                        if (!admin.rd_txt_informacion.getText().isEmpty()) {
                            ddao.idCaso(dvo);
                            ddao.insertar_datos_registro(dvo);
                        }
                        login.mensaje.showMessageDialog(null, "Nuevo Caso creado exitosamente");

                        admin.f_cb_editar.setSelected(false);
                        admin.f_btn_guardar.setEnabled(false);
                        admin.rd_txt_informacion.setText("");
                    } catch (Exception e) {
                        System.out.println("----- Error " + e.getMessage());
                        login.mensaje.showMessageDialog(null, "A ocurrido un error Contacte a su administrador de Servicio");
                    }

                    admin.progressUser.setValue(80);
                    Thread.sleep(1000);
                    cleanText();

                    dvo.setBuscar_nombre(dvo.getToClientes_nombre());
                    buscarNombre();

                    admin.progressUser.setValue(100);
                    Thread.sleep(1000);
                    admin.progressUser.setVisible(false);

                } catch (Exception e) {
                    login.mensaje.showMessageDialog(null, e.getMessage());
                }
            }
        });

        th.start();

    }

    //-------------------------------Limpiar y activar
    private void enableText() {
//Asignacion de datos Clase Tramite
        admin.f_txt_tramite.setEditable(true);
//Asignacino de datos del Asesor/Vendedor
        admin.f_txt_vendedorNombre.setEditable(true);
        admin.f_txt_vendedorTelefono.setEditable(true);
        admin.f_txt_vendedorContructora.setEditable(true);
        admin.f_txt_vendedorCorreo.setEditable(true);
//Asignacion de datos Financieros
        admin.f_txt_honorarios.setEditable(true);
        admin.f_txt_salario.setEditable(true);
        admin.f_txt_direccionUSA.setEditable(true);
//Asignacion de datos Negociacion
        admin.f_txt_nombreCliente.setEditable(true);
        admin.f_txt_telefonoCliente.setEditable(true);
        admin.f_txt_estadoResidencia.setEditable(true);
        admin.f_txt_estadoMigratorio.setEditable(true);
        admin.f_txt_tipoPropiedad.setEditable(true);
        admin.f_txt_correoCliente.setEditable(true);
        admin.f_txt_estadoCivil.setEditable(true);
        admin.f_txt_profesion.setEditable(true);
        admin.f_cb_dpi.setEditable(true);
        admin.f_cb_nit.setEditable(true);
        admin.f_cb_id.setEditable(true);
//Asignacion de datos Representante Legal
        admin.f_txt_repNombre.setEditable(true);
        admin.f_txt_repDireccion.setEditable(true);
        admin.f_txt_repTelefono.setEditable(true);
        admin.f_txt_repParentezco.setEditable(true);
        admin.f_txt_repBanco.setEditable(true);
//Asignacion de datos Notas
        admin.f_txt_notas.setEditable(true);

        admin.if_RegistroDetallado.setVisible(true);
    }

    private void disableText() {
        //Asignacion de datos Clase Tramite
        admin.f_txt_tramite.setEditable(false);
//Asignacino de datos del Asesor/Vendedor
        admin.f_txt_vendedorNombre.setEditable(false);
        admin.f_txt_vendedorTelefono.setEditable(false);
        admin.f_txt_vendedorContructora.setEditable(false);
        admin.f_txt_vendedorCorreo.setEditable(false);
//Asignacion de datos Financieros
        admin.f_txt_honorarios.setEditable(false);
        admin.f_txt_salario.setEditable(false);
        admin.f_txt_direccionUSA.setEditable(false);
//Asignacion de datos Negociacion
        admin.f_txt_nombreCliente.setEditable(false);
        admin.f_txt_telefonoCliente.setEditable(false);
        admin.f_txt_estadoResidencia.setEditable(false);
        admin.f_txt_estadoMigratorio.setEditable(false);
        admin.f_txt_tipoPropiedad.setEditable(false);
        admin.f_txt_correoCliente.setEditable(false);
        admin.f_txt_estadoCivil.setEditable(false);
        admin.f_txt_profesion.setEditable(false);
        admin.f_cb_dpi.setEditable(false);
        admin.f_cb_nit.setEditable(false);
        admin.f_cb_id.setEditable(false);
//Asignacion de datos Representante Legal
        admin.f_txt_repNombre.setEditable(false);
        admin.f_txt_repDireccion.setEditable(false);
        admin.f_txt_repTelefono.setEditable(false);
        admin.f_txt_repParentezco.setEditable(false);
        admin.f_txt_repBanco.setEditable(false);
//Asignacion de datos Notas
        admin.f_txt_notas.setEditable(false);

        admin.if_RegistroDetallado.setVisible(false);
    }

    private void cleanText() {
        //Asignacion de datos Clase Tramite
        admin.f_txt_tramite.setText("");
//Asignacino de datos del Asesor/Vendedor
        admin.f_txt_vendedorNombre.setText("");
        admin.f_txt_vendedorTelefono.setText("");
        admin.f_txt_vendedorContructora.setText("");
        admin.f_txt_vendedorCorreo.setText("");
//Asignacion de datos Financieros
        admin.f_txt_honorarios.setText("");
        admin.f_txt_salario.setText("");
        admin.f_txt_direccionUSA.setText("");
//Asignacion de datos Negociacion
        admin.f_txt_nombreCliente.setText("");
        admin.f_txt_telefonoCliente.setText("");
        admin.f_txt_estadoResidencia.setText("");
        admin.f_txt_estadoMigratorio.setSelectedItem("Seleccionar");
        admin.f_txt_tipoPropiedad.setSelectedItem("Seleccionar");
        admin.f_txt_correoCliente.setText("");
        admin.f_txt_estadoCivil.setSelectedItem("Seleccionar");
        admin.f_txt_profesion.setText("");
        admin.f_cb_dpi.setSelectedItem("Seleccionar");
        admin.f_cb_nit.setSelectedItem("Seleccionar");
        admin.f_cb_id.setSelectedItem("Seleccionar");
//Asignacion de datos Representante Legal
        admin.f_txt_repNombre.setText("");
        admin.f_txt_repDireccion.setText("");
        admin.f_txt_repTelefono.setText("");
        admin.f_txt_repParentezco.setText("");
        admin.f_txt_repBanco.setText("");
//Asignacion de datos Notas
        admin.f_txt_notas.setText("");

        admin.f_cb_editar.setSelected(false);
        admin.f_cb_nuevo.setSelected(false);

        DefaultTableModel tMOdel = (DefaultTableModel) admin.f_tbl_seguimiento.getModel();
        tMOdel.setRowCount(0);

    }

    private void cleanDVO() {
        dvo.setClaseTramite_cliente("");
//Asignacino de datos del Asesor/Vendedor
        dvo.setNombre_vendedor("");
        dvo.setTelefono_vendedor("");
        dvo.setConstructora_vendedor("");
        dvo.setCorreo_vendedor("");
//Asignacion de datos Financieros
        dvo.setHonorarios_casos(0.00f);
        dvo.setSalario_casos(0.00f);
        dvo.setDireccion_cliente("");
//Asignacion de datos Negociacion
        dvo.setNombre_cliente("");
        dvo.setTelefono_cliente("");
        dvo.setEstadoResidencia_cliente("");
        dvo.setEstadoMigratorio_cliente("");
        dvo.setTipo_propiedad("Seleccionar");
        dvo.setCorreo_cliente("");
        dvo.setEstadoCivil_cliente("Seleccionar");
        dvo.setProfecion_cliente("");
        dvo.setDpi_cliente("Seleccionar");
        dvo.setNit_cliente("Seleccionar");
        dvo.setUsaId_cliente("Seleccionar");
//Asignacion de datos Representante Legal
        dvo.setNombre_representante("");
        dvo.setDireccion_representante("");
        dvo.setTelefono_representante("");
        dvo.setParentezco_representante("");
        dvo.setBanco_representante("");
//Asignacion de datos Notas
        dvo.setNotas_casos("");
    }

    //----------------------------Metodos de implementacion 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.f_btn_buscarCliente) {
            cleanDVO();
            buscarCliente();
        }

        if (e.getSource() == admin.f_btn_guardar) {
            if (admin.f_cb_editar.isSelected() == true) {
                //cleanDVO();
                editarCaso();
            }

            if (admin.f_cb_nuevo.isSelected() == true) {
                nuevoCaso();
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (admin.f_cb_editar.isSelected() == true) {
            enableText();
            admin.f_btn_guardar.setEnabled(true);
            admin.f_cb_nuevo.setEnabled(false);

            dvo.setNombre_representante(admin.f_txt_repNombre.getText());

            if (admin.rd_txt_fecha.getText().isEmpty()) {
                GregorianCalendar c = new GregorianCalendar();
                int year, month, day;
                String date;
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;
                admin.rd_txt_fecha.setText(date);
                dvo.setToRegistros_fecha(date);
            }

            if (admin.rd_txt_usuario.getText().isEmpty()) {
                admin.rd_txt_usuario.setText(dvo.getUser_login());
                switch (admin.rd_txt_usuario.getText()) {
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

        } else if (admin.f_cb_nuevo.isSelected() == true) {
            enableText();
            admin.f_btn_guardar.setEnabled(true);
            admin.f_cb_editar.setEnabled(false);
            if (admin.rd_txt_fecha.getText().isEmpty()) {
                GregorianCalendar c = new GregorianCalendar();
                int year, month, day;
                String date;
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                date = year + "-" + month + "-" + day;
                admin.rd_txt_fecha.setText(date);
                dvo.setToRegistros_fecha(date);
            }

            if (admin.rd_txt_usuario.getText().isEmpty()) {
                admin.rd_txt_usuario.setText(dvo.getUser_login());
                switch (admin.rd_txt_usuario.getText()) {
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
            admin.f_btn_guardar.setEnabled(false);
            admin.f_cb_nuevo.setEnabled(true);
            admin.f_cb_editar.setEnabled(true);
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
