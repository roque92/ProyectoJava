/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import proyecto.Vista.Administrador;
import proyecto.Vista.Login;

/**
 *
 * @author jroque
 */
public class ControllerAdmin implements WindowListener {

    Administrador admin = new Administrador();
    Login login = new Login();

    public ControllerAdmin(Login login, Administrador admin) {
        this.admin = admin;
        this.login = login;
        
        admin.addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
int seleccion = login.mensaje.showConfirmDialog(null, "Desea cerrar sesion", "Cerrar Sesion", login.mensaje.YES_NO_OPTION);
        
        if(seleccion == login.mensaje.YES_OPTION){
            admin.setVisible(false);
            login.setVisible(true);
        } 
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
