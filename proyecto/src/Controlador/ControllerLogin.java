/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosVO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyecto.Vista.Administrador;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author Jreyes
 */
public class ControllerLogin implements ActionListener{
    
    Login login = new Login();
    DatosVO dvo = new DatosVO();
    Administrador admin = new Administrador();
    Usuario user = new Usuario();

    public ControllerLogin(Login login, DatosVO dvo, Administrador admin, Usuario user) {
        this.login = login;
        this.dvo = dvo;
        this.admin = admin;
        this.user = user;
        
        //boton
        login.btn_ingresar.addActionListener(this);
    }
    
    //Metodo Limpieza Text
    public void clean (){
        login.txt_password.setText("");
        login.txt_username.setText("");
    }
    
    //Metodo del login, validacion
    public void login (){
        if(login.txt_username.getText().isEmpty() || login.txt_password.getText().isEmpty()){
            clean();
            login.mensaje.showMessageDialog(null, "Usuario y/o Contraseña invalidos");
        } else {
            dvo.setUsuario(login.txt_username.getText());
            dvo.setContraseña(String.valueOf(login.txt_password.getPassword()));
            
            //pendiente metodo de base de datos
            
            if(!dvo.getUsuario().equals(dvo.getCf_username()) && !dvo.getContraseña().equals(dvo.getCf_password())){
                login.mensaje.showMessageDialog(null, "Usuarion y/o Contraseña incorrectos");
            }else {
                if(dvo.getCf_rol() == 1){
                    admin.setVisible(true);
                    login.setVisible(false);
                    clean();
                } else {
                    user.setVisible(true);
                    login.setVisible(false);
                    clean();
                }
            }
        }
    }

    
    //Evento boton
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login.btn_ingresar){
            login();
        }
    }
    
    
    
}
