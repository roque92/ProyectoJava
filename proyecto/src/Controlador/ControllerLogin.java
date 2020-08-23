/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosDAO;
import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import proyecto.Vista.Administrador;
import proyecto.Vista.Forgot;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerLogin implements ActionListener, MouseListener, WindowListener {

    Login login = new Login();
    Usuario usuario = new Usuario();
    Administrador admin = new Administrador();
    Forgot forgot = new Forgot();
    DatosVO dvo = new DatosVO();
    StringsBaseDatos sbd = new StringsBaseDatos();
    DatosDAO ddao = new DatosDAO();

    private Timer timer;
    private int cont = -1;

    public ControllerLogin(Login login, Usuario usuario, Administrador admin, Forgot forgot, DatosVO dvo, StringsBaseDatos sbd, DatosDAO ddao) {
        this.login = login;
        this.usuario = usuario;
        this.admin = admin;
        this.forgot = forgot;
        this.dvo = dvo;
        this.sbd = sbd;
        this.ddao = ddao;

        login.btn_ingresar.addActionListener(this);
        login.jl_forgot.addMouseListener(this);

        login.addWindowListener(this);
    }

    private void validarLogin() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                login.btn_ingresar.setEnabled(false);
                login.progressLogin.setVisible(true);
                login.progressLogin.setValue(0);

                try {
                    String username = login.txt_username.getText();
                    String password = "";
                    char[] pass = login.txt_password.getPassword();

                    dvo.setUser_login(username);
                    sbd.setUsername_login_sbd(username);

                    for (int i = 0; i < pass.length; i++) {
                        password += pass[i];
                    }

                    ddao.validar_login(dvo);
                    login.progressLogin.setValue(50);
                    
                    Thread.sleep(1000);
                    
                    if (login.txt_username.getText().isEmpty() || password.equals("")) {
                        Thread.sleep(1000);
                        login.mensaje.showMessageDialog(null, "Por favor ingresar usuario y/o contraseña", "Atencion", JOptionPane.WARNING_MESSAGE);
                        login.progressLogin.setValue(0);
                        login.progressLogin.setVisible(false);
                        login.btn_ingresar.setEnabled(true);
                    } else if (dvo.getUser_login().equals(dvo.getLogin_user()) && dvo.getLogin_tipo().equals("administrador")) {
                        login.progressLogin.setValue(100);
                        Thread.sleep(1000);
                        login.setVisible(false);
                        admin.setVisible(true);
                        login.progressLogin.setValue(0);
                        login.progressLogin.setVisible(false);
                        login.btn_ingresar.setEnabled(true);
                        clearText();

                    } else if (dvo.getUser_login().equals(dvo.getLogin_user()) && dvo.getLogin_tipo().equals("usuario")) {
                        login.progressLogin.setValue(100);
                        Thread.sleep(1000);
                        login.setVisible(false);
                        usuario.setVisible(true);
                        login.progressLogin.setValue(0);
                        login.progressLogin.setVisible(false);
                        login.btn_ingresar.setEnabled(true);
                        clearText();

                    } else {
                        Thread.sleep(1000);
                        login.progressLogin.setValue(0);
                        login.progressLogin.setVisible(false);
                        login.mensaje.showMessageDialog(null, "Usuario y/o contraseña no existen " + dvo.getError(), "Error", JOptionPane.ERROR_MESSAGE);
                        clearText();
                        login.btn_ingresar.setEnabled(true);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        th.start();
    }

    private void clearText() {
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
        if (e.getSource() == login.jl_forgot) {
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

    @Override
    public void windowClosing(WindowEvent e) {
        int seleccion = login.mensaje.showConfirmDialog(null, "Desea salir", "Salir", login.mensaje.YES_NO_OPTION);

        if (seleccion == login.mensaje.YES_OPTION) {
            System.exit(0);
        } else {
            login.mensaje.remove(login.mensaje);
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

}
