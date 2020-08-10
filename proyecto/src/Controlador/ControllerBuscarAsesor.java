/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosDAO;
import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import Modelo.TablasBaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerBuscarAsesor implements ActionListener, KeyListener {

    Usuario usuario = new Usuario();
    Login login = new Login();
    StringsBaseDatos sbd = new StringsBaseDatos();
    TablasBaseDatos tbd = new TablasBaseDatos();
    DatosVO dvo = new DatosVO();

    public ControllerBuscarAsesor(Usuario usuario, Login login, StringsBaseDatos sbd, TablasBaseDatos tbd, DatosVO dvo) {
        this.usuario = usuario;
        this.login = login;
        this.sbd = sbd;
        this.tbd = tbd;
        this.dvo = dvo;

        usuario.ba_btn_buscar.addActionListener(this);
        usuario.ba_txt_valorBuscado.addKeyListener(this);
    }

    private void buscarAsesor() {
        if (usuario.ba_txt_valorBuscado.getText().isEmpty()) {
            login.mensaje.showMessageDialog(null, "No se ha ingresado un valor a buscar", "Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
        } else {
            sbd.setNombre_vendedor_buscador_sbd(usuario.ba_txt_valorBuscado.getText());

            DefaultTableModel m = new DefaultTableModel();
            m.setColumnCount(0);
            m.addColumn("Nombe");
            m.addColumn("Telefono");
            m.addColumn("Constructora");
            m.addColumn("Correo Electronico");

            for (StringsBaseDatos sbd : this.tbd.TablaVendedor(sbd)) {
                System.out.println("Dentro del for Each");
                m.addRow(new Object[]{sbd.getNombre_vendedor_sbd(), sbd.getTelefono_vendedor_sbd(), sbd.getConstructora_vendedor_sbd(), sbd.getCorreo_vendedor_sbd()});
            }

            usuario.ba_tbl_datos.setModel(m);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuario.ba_btn_buscar) {
            buscarAsesor();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        buscarAsesor();
    }

}
