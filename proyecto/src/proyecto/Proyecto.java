/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Controlador.ControllerAdmin;
import Controlador.ControllerBuscarAsesor;
import Controlador.ControllerForgot;
import Controlador.ControllerLogin;
import Controlador.ControllerUsuario;
import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import Modelo.TablasBaseDatos;
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
        StringsBaseDatos sbd = new StringsBaseDatos();
        TablasBaseDatos tbd = new TablasBaseDatos();
        DatosVO dvo = new DatosVO();
        
        ControllerLogin controllerLogin = new ControllerLogin(login, usuario, admin, forgot);
        ControllerForgot controllerForgot = new ControllerForgot(login, forgot);
        ControllerUsuario controllerUsuario = new ControllerUsuario(usuario, login);
        ControllerAdmin controllerAdmin = new ControllerAdmin(login, admin);
        ControllerBuscarAsesor controllerBuscarAsesor = new ControllerBuscarAsesor(usuario, login, sbd, tbd, dvo);
        
        //login.setVisible(true);
        //usuario.setVisible(true);
        admin.setVisible(true);
    }
    
}
