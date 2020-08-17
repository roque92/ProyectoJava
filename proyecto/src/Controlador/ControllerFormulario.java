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
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author Jose Roque
 */
public class ControllerFormulario implements ActionListener, ChangeListener {

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
    }

    private void buscarCliente() {

        String valorBuscado = (String) usuario.f_valor_buscado.getSelectedItem();

        switch (valorBuscado) {
            case "Nombre":
                buscarNombre();
                registroDetallado();
                break;
            case "Telefono":
                buscarTelefono();
                registroDetallado();
                break;
            case "Correo":
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
        dvo.setBuscar_nombre(usuario.f_txt_buscarCliente.getText().trim());
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
        usuario.f_txt_honorarios.setText("$/Q " + String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText("$ " + String.valueOf(dvo.getSalario_casos()));
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
        dvo.setBuscar_telefono(usuario.f_txt_buscarCliente.getText());
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
        usuario.f_txt_honorarios.setText("$/Q " + String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText("$ " + String.valueOf(dvo.getSalario_casos()));
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
        dvo.setBuscar_correo(usuario.f_txt_buscarCliente.getText().trim());
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
        usuario.f_txt_honorarios.setText("$/Q " + String.valueOf(dvo.getHonorarios_casos()));
        usuario.f_txt_salario.setText("$ " + String.valueOf(dvo.getSalario_casos()));
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
    
    private void enableText(){
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
    
    private void disableText(){
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
    
    private void editarCaso(){
        login.mensaje.showMessageDialog(null, "Editar Caso");
    }
    
    private void nuevoCaso(){
         login.mensaje.showMessageDialog(null, "Nuevo Caso");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuario.f_btn_buscarCliente) {
            buscarCliente();
        } 
        
        if(e.getSource() == usuario.f_btn_guardar){
            if(usuario.f_cb_editar.isSelected() == true){
                editarCaso();
            } 
            
            if(usuario.f_cb_nuevo.isSelected() == true){
                nuevoCaso();
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(usuario.f_cb_editar.isSelected() == true){
            enableText();
            usuario.f_btn_guardar.setEnabled(true);
            usuario.f_cb_nuevo.setEnabled(false);
        } else if(usuario.f_cb_nuevo.isSelected() == true){
            enableText();
            usuario.f_btn_guardar.setEnabled(true);
            usuario.f_cb_editar.setEnabled(false);
        } else {
            disableText();
            usuario.f_btn_guardar.setEnabled(false);
            usuario.f_cb_nuevo.setEnabled(true);
            usuario.f_cb_editar.setEnabled(true);
        }
    }

}
