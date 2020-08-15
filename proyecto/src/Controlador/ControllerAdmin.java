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
import proyecto.Vista.Administrador;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerAdmin implements WindowListener, ActionListener {

    Administrador admin = new Administrador();
    Login login = new Login();
    Usuario usuario = new Usuario();

    public ControllerAdmin(Login login, Administrador admin, Usuario usuario) {
        this.admin = admin;
        this.login = login;
        this.usuario = usuario;

        admin.o_salir.addActionListener(this);
        admin.m_baseGeneralClientes.addActionListener(this);
        admin.m_baseGeneralAsesores.addActionListener(this);
        admin.m_NuevoFormulario.addActionListener(this);
        admin.addWindowListener(this);
    }

    private void closeWindows() {
        int seleccion = login.mensaje.showConfirmDialog(null, "Desea cerrar sesion", "Cerrar Sesion", login.mensaje.YES_NO_OPTION);

        if (seleccion == login.mensaje.YES_OPTION) {
            admin.setVisible(false);
            login.setVisible(true);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == admin.o_salir){
          closeWindows();
      }
      if(e.getSource() == admin.m_baseGeneralClientes){
          admin.if_Clientes.setVisible(true);
      }
      if(e.getSource() == admin.m_baseGeneralAsesores){
          admin.if_Asesores.setVisible(true);
      }
      if(e.getSource() == admin.m_NuevoFormulario){
          admin.if_formulario.setVisible(true);
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


}
