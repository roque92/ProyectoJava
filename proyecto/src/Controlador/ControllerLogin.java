/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import proyecto.Vista.Administrador;
import proyecto.Vista.Forgot;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerLogin implements ActionListener, MouseListener {

    Login login = new Login();
    Usuario usuario = new Usuario();
    Administrador admin = new Administrador();
    Forgot forgot = new Forgot();

    public ControllerLogin(Login login, Usuario usuario, Administrador admin, Forgot forgot) {
        this.login = login;
        this.usuario = usuario;
        this.admin = admin;
        this.forgot = forgot;

        login.btn_ingresar.addActionListener(this);
        login.jl_forgot.addMouseListener(this);
        }

    private void validarLogin() {
        String username = login.txt_username.getText();
        String password = "";
        char[] pass = login.txt_password.getPassword();

        for (int i = 0; i < pass.length; i++) {
            password += pass[i];
        }

        if (login.txt_username.getText().isEmpty() || password.equals("")) {
            login.mensaje.showMessageDialog(null, "Por favor ingresar usuario y/o contraseña", "Atencion", JOptionPane.WARNING_MESSAGE);
        } else if (username.equals("usuario") && password.equals("usuario") || username.equals("usuario2") && password.equals("usuario2")){
            login.setVisible(false);
            usuario.setVisible(true);
            clearText();
            
        } else if (username.equals("administrador") && password.equals("administrador") || username.equals("administrador2") && password.equals("administrador2")){
            login.setVisible(false);
            admin.setVisible(true);
            clearText();
            
        } else {
            login.mensaje.showMessageDialog(null, "Usuario y/o contraseña no existen", "Error", JOptionPane.ERROR_MESSAGE);
            clearText();
                   
        }
    }
    
    private void clearText(){
        login.txt_username.setText("");
        login.txt_password.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.btn_ingresar) {
            validarLogin();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == login.jl_forgot){
            login.setVisible(false);
            forgot.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
