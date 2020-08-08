/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Controlador.ControllerForgot;
import Controlador.ControllerLogin;
import proyecto.Vista.Administrador;
import proyecto.Vista.Forgot;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author Jreyes
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Administrador admin = new Administrador();
        Usuario usuario = new Usuario();
        Login login = new Login();
        Forgot forgot = new Forgot();
        
        ControllerLogin controllerLogin = new ControllerLogin(login, usuario, admin, forgot);
        ControllerForgot controllerForgot = new ControllerForgot(login, forgot);
        
        login.setVisible(true);
    }
    
}
