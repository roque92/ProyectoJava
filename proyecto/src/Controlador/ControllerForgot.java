/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyecto.Vista.Forgot;
import proyecto.Vista.Login;

/**
 *
 * @author jroque
 */
public class ControllerForgot implements ActionListener{
    Login login = new Login();
    Forgot forgot = new Forgot();

    public ControllerForgot(Login login, Forgot forgot) {
        this.login = login;
        this.forgot = forgot;
        
        forgot.f_cambiar.addActionListener(this);
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

    
    
    
}
