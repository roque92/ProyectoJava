/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosDAO;
import Modelo.DatosVO;
import Modelo.ModelAsesores;
import Modelo.ModelClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerUsuario extends Controllers implements ActionListener, WindowListener {
    private ModelAsesores modelAsesores = new ModelAsesores();
    private ModelClientes modelClientes = new ModelClientes();
    private JTable jTableAsesores, jTableClientes;
    private JTextField jTextFieldAsesor, jTextFieldCliente;
    private JButton jButtonBuscarCliente;
    
    Usuario usuario = new Usuario();
    Login login = new Login();

    public ControllerUsuario(Usuario usuario, Login login) {
        this.usuario = usuario;
        this.login = login;
        
        usuario.o_Salir.addActionListener(this);
        usuario.a_baseGeneral.addActionListener(this);
        usuario.c_baseGeneral.addActionListener(this);
        usuario.c_buscarCliente.addActionListener(this);
        usuario.a_buscarAsesores.addActionListener(this);
        usuario.f_AbrirFormulario.addActionListener(this);
        usuario.f_btn_buscarCliente.addActionListener(this);
        jTableAsesores = usuario.tbl_baseGeneralAsesores;
        jTableClientes = usuario.tbl_baseGeneralClientes;
        jTextFieldAsesor = usuario.ba_txt_valorBuscado;
        jTextFieldCliente = usuario.bc_txt_valorBuscado;
        
        usuario.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == usuario.c_buscarCliente){
            usuario.if_buscarCliente.setVisible(true);
        }
        
        if(e.getSource() == usuario.c_baseGeneral){
            usuario.if_baseClientes.setVisible(true);
            modelClientes.loadTable(jTableClientes, "");
        }
        
        if(e.getSource() == usuario.a_buscarAsesores){
            usuario.if_buscarAsesor.setVisible(true);
        }
        
        if(e.getSource() == usuario.a_baseGeneral){
            usuario.if_baseAsores.setVisible(true);
            modelAsesores.loadTable(jTableAsesores, "");
        }
        
        if(e.getSource() == usuario.f_AbrirFormulario){
            usuario.if_formulario.setVisible(true);
        }
        
        if(e.getSource() == usuario.o_Salir){
            closeWindows();
        }
        
        if(e.getSource() == usuario.f_btn_buscarCliente){
            searchClienteForm();
        }
    }
    
    private void closeWindows(){
        int seleccion = login.mensaje.showConfirmDialog(null, "Desea cerrar sesion", "Cerrar Sesion", login.mensaje.YES_NO_OPTION);
        
        if(seleccion == login.mensaje.YES_OPTION){
            usuario.setVisible(false);
            login.setVisible(true);
        } 
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeWindows();
    }

    @Override
    public void windowClosed(WindowEvent e) {
       
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
    private void searchAsesor(){
        boolean result = modelAsesores.searchServer(jTableAsesores, jTextFieldAsesor);
        if(!result){
            JOptionPane.showMessageDialog(null, "No ha rellenado el campo correctamente");
        }
    }
    
    private void searchCliente(){
        boolean result = modelClientes.searchServer(jTableAsesores, jTextFieldCliente);
        if(!result){
            JOptionPane.showMessageDialog(null, "No ha rellenado el campo correctamente");
        }
    }
    
    private void searchClienteForm(){
        JComboBox jComboBox = usuario.f_valor_buscado;
        String selectedItem = (String) jComboBox.getSelectedItem().toString();
        DatosDAO datosDAO = new DatosDAO();
        DatosVO datosVO = new DatosVO();
        
        if (selectedItem.equals("Nombre")) {
            datosVO.setBuscar_nombre(selectedItem);
            datosDAO.mostrar_datos_nombre(datosVO);
        }else if (selectedItem.equals("Telefono")) {
            datosVO.setBuscar_telefono(selectedItem);
            datosDAO.mostrar_datos_telefono(datosVO);
        }else if (selectedItem.equals("Correo")) {
            datosVO.setBuscar_correo(selectedItem);
            datosDAO.mostrar_datos_correo(datosVO);
        }
        
        
        usuario.f_txt_tramite.setText("");
        
        //Informacion.Asesor
        usuario.f_txt_asesorNombre.setText("");
        usuario.f_txt_asesorTelefono.setText("");
        usuario.f_txt_asesorContructora.setText("");
        usuario.f_txt_asesorCorreo.setText("");
        
        //Informacion.Financiera
        usuario.f_txt_honorarios.setText("");
        usuario.f_txt_valorPropiedad.setText("");
        usuario.f_txt_valorPropiedad.setText("");
        
        
        /*
        
        
        */
        
        
        
    } 
}
