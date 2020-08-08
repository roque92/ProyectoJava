/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerUsuario implements ActionListener, WindowListener{
    
    Usuario usuario = new Usuario();
    Login login = new Login();

    public ControllerUsuario(Usuario usuario, Login login) {
        this.usuario = usuario;
        this.login = login;
        
        usuario.c_buscarCliente.addActionListener(this);
        usuario.c_baseGeneral.addActionListener(this);
        usuario.a_buscarAsesores.addActionListener(this);
        usuario.a_baseGeneral.addActionListener(this);
        
        usuario.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == usuario.c_buscarCliente){
            usuario.if_buscarCliente.setVisible(true);
        }
        
        if(e.getSource() == usuario.c_baseGeneral){
            usuario.if_baseClientes.setVisible(true);
        }
        
        if(e.getSource() == usuario.a_buscarAsesores){
            usuario.if_buscarAsesor.setVisible(true);
        }
        
        if(e.getSource() == usuario.a_baseGeneral){
            usuario.if_baseAsores.setVisible(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int seleccion = login.mensaje.showConfirmDialog(null, "Desea cerrar sesion", "Cerrar Sesion", login.mensaje.YES_NO_OPTION);
        
        if(seleccion == login.mensaje.YES_OPTION){
            usuario.setVisible(false);
            login.setVisible(true);
        } 
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
    
    
    
}