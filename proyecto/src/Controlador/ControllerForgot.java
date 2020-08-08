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
import javax.swing.JOptionPane;
import proyecto.Vista.Forgot;
import proyecto.Vista.Login;

/**
 *
 * @author jroque
 */
public class ControllerForgot implements ActionListener, WindowListener{
    Login login = new Login();
    Forgot forgot = new Forgot();

    public ControllerForgot(Login login, Forgot forgot) {
        this.login = login;
        this.forgot = forgot;
        
        forgot.f_cambiar.addActionListener(this);
        
        forgot.addWindowListener(this);
    }
    
    private void validarCambioContra() {
        String usuario = forgot.f_username.getText();
        String telefono = forgot.f_telefono.getText();
        String frase = (String) forgot.f_cb_frase.getSelectedItem();
        
        if(usuario.equals("usuario") && telefono.equals("1234567890") && frase.equals("Item 2")){
            cleanText();
            login.mensaje.showMessageDialog(null, "Tu contraseña es: usuario", "Contraseña", JOptionPane.INFORMATION_MESSAGE);
            forgot.setVisible(false);
            login.setVisible(true);
        } else if(usuario.equals("administrador") && telefono.equals("0987654321") && frase.equals("Item 4")){
            cleanText();
            login.mensaje.showMessageDialog(null, "Tu contraseña es: administrador", "Contraseña", JOptionPane.INFORMATION_MESSAGE);
            forgot.setVisible(false);
            login.setVisible(true);
        } else {
            cleanText();
            login.mensaje.showMessageDialog(null, "Datos Incorrectos", "Contraseña", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void cleanText(){
        forgot.f_username.setText("");
        forgot.f_telefono.setText("");
        forgot.f_cb_frase.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == forgot.f_cambiar){
            validarCambioContra();
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int seleccion = login.mensaje.showConfirmDialog(null, "Desea regresar?", "Regresar", login.mensaje.YES_NO_OPTION);
        
        if(seleccion == login.mensaje.YES_OPTION){
            forgot.setVisible(false);
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
