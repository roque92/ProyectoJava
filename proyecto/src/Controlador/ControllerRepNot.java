/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosDAO;
import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerRepNot implements ActionListener, ItemListener {

    //Vista
    Usuario usuario = new Usuario();
    //Modelo
    DatosVO dvo = new DatosVO();
    DatosDAO ddao = new DatosDAO();
    StringsBaseDatos sbd = new StringsBaseDatos();

    public ControllerRepNot(Usuario usuario, DatosVO dvo, DatosDAO ddao) {
        this.usuario = usuario;
        this.dvo = dvo;
        this.ddao = ddao;

        usuario.f_btn_buscarCliente.addActionListener(this);
        usuario.f_btn_guardar.addActionListener(this);
        usuario.f_btn_guardar.setEnabled(false);
        usuario.f_cb_nuevo.addItemListener(this);
        usuario.f_cb_editar.addItemListener(this);
        usuario.f_txt_repNombre.setEditable(false);
        usuario.f_txt_repParentezco.setEditable(false);
        usuario.f_txt_repDireccion.setEditable(false);
        usuario.f_txt_repTelefono.setEditable(false);
        usuario.f_txt_repBanco.setEditable(false);
        usuario.f_txt_notas.setEditable(false);
    }

    private void enableEdit() {
        usuario.f_txt_repParentezco.setEditable(true);
        usuario.f_txt_repDireccion.setEditable(true);
        usuario.f_txt_repTelefono.setEditable(true);
        usuario.f_txt_repBanco.setEditable(true);
        usuario.f_txt_notas.setEditable(true);
    }

    private void disableEdit() {
        usuario.f_txt_repParentezco.setEditable(false);
        usuario.f_txt_repDireccion.setEditable(false);
        usuario.f_txt_repTelefono.setEditable(false);
        usuario.f_txt_repBanco.setEditable(false);
        usuario.f_txt_notas.setEditable(false);
    }

    private void obtenerDatos() {
        String combo = (String) usuario.f_valor_buscado.getSelectedItem();

        if (combo.equals("Nombre")) {
            buscarNombre();
        } else if (combo.equals("Telefono")) {
            buscarTelefono();
        } else {
            buscarCorreo();
        }
    }

    private void buscarNombre() {
        
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());

        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }

    private void buscarTelefono() {

        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());

        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }

    private void buscarCorreo() {
        
        usuario.f_txt_repNombre.setText(dvo.getNombre_representante());
        usuario.f_txt_repParentezco.setText(dvo.getParentezco_representante());
        usuario.f_txt_repDireccion.setText(dvo.getDireccion_representante());
        usuario.f_txt_repTelefono.setText(dvo.getTelefono_representante());
        usuario.f_txt_repBanco.setText(dvo.getBanco_representante());

        usuario.f_txt_notas.setText(dvo.getNotas_casos());
    }

    private void guardarDatos() {
        if (usuario.f_cb_nuevo.isSelected()) {
            guardarNuevo();
        }

        if (usuario.f_cb_editar.isSelected()) {
            guardarEditar();
        }
    }

    private void guardarNuevo() {

        if (usuario.f_txt_repNombre.getText().isEmpty() || usuario.f_txt_repParentezco.getText().isEmpty() || usuario.f_txt_repDireccion.getText().isEmpty()
                || usuario.f_txt_repTelefono.getText().isEmpty() || usuario.f_txt_repBanco.getText().isEmpty()) {

            dvo.setToRepresentante_nombre("pendiente");
            dvo.setToRepresentante_parentezco("pendiente");
            dvo.setToRepresentante_direccion("pendiente");
            dvo.setToRepresentante_telefono("pendiente");
            dvo.setToRepresentante_banco("pendiente");

        } else {
            dvo.setToRepresentante_nombre(usuario.f_txt_repNombre.getText().toLowerCase().trim());
            dvo.setToRepresentante_parentezco(usuario.f_txt_repParentezco.getText().toLowerCase().trim());
            dvo.setToRepresentante_direccion(usuario.f_txt_repDireccion.getText().toLowerCase().trim());
            dvo.setToRepresentante_telefono(usuario.f_txt_repTelefono.getText().toLowerCase().trim());
            dvo.setToRepresentante_banco(usuario.f_txt_repBanco.getText().toLowerCase().trim());
        }

        ddao.insertar_datos_representante(dvo);

    }

    private void guardarEditar() {

        dvo.setToRepresentante_nombre(usuario.f_txt_repNombre.getText().toLowerCase().trim());
        dvo.setToRepresentante_parentezco(usuario.f_txt_repParentezco.getText().toLowerCase().trim());
        dvo.setToRepresentante_direccion(usuario.f_txt_repDireccion.getText().toLowerCase().trim());
        dvo.setToRepresentante_telefono(usuario.f_txt_repTelefono.getText().toLowerCase().trim());
        dvo.setToRepresentante_banco(usuario.f_txt_repBanco.getText().toLowerCase().trim());

        ddao.modificar_datos_representante(dvo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuario.f_btn_buscarCliente) {
            obtenerDatos();
        }

        if (e.getSource() == usuario.f_btn_guardar) {
            guardarDatos();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (usuario.f_cb_nuevo.isSelected()) {
            enableEdit();
            usuario.f_btn_guardar.setEnabled(true);
        } else {
            disableEdit();
            usuario.f_btn_guardar.setEnabled(false);
        }

        if (usuario.f_cb_editar.isSelected()) {
            enableEdit();
            usuario.f_btn_guardar.setEnabled(true);
        } else {
            disableEdit();
            usuario.f_btn_guardar.setEnabled(false);
        }

    }

}
