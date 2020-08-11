/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import Modelo.TablasBaseDatos;
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
public class ControllerBuscarCliente implements KeyListener {

    Usuario usuario = new Usuario();
    Login login = new Login();
    StringsBaseDatos sbd = new StringsBaseDatos();
    TablasBaseDatos tbd = new TablasBaseDatos();
    DatosVO dvo = new DatosVO();
    String estadoCivil, estadoMigratorio;

    public ControllerBuscarCliente(Usuario usuario, Login login, StringsBaseDatos sbd, TablasBaseDatos tbd, DatosVO dvo) {
        this.usuario = usuario;
        this.login = login;
        this.sbd = sbd;
        this.tbd = tbd;
        this.dvo = dvo;

        usuario.bc_txt_valorBuscado.addKeyListener(this);
    }

    private void buscarCliente() {

        try {
            //validarEstdoCivil();
            //validarEStdoMigratorio();
            sbd.setNombre_cliente_buscador_sbd(usuario.bc_txt_valorBuscado.getText());
            DefaultTableModel m = new DefaultTableModel();
            m.setColumnCount(0);
            m.addColumn("Nombe");
            m.addColumn("Telefono");
            m.addColumn("Correo");
            m.addColumn("EStatus Caso");
            m.addColumn("Direccion USA");
            m.addColumn("Estado Civil");
            m.addColumn("Estado Migratorio");
            m.addColumn("Profesion");
            m.addColumn("Estado Residencia");
            m.addColumn("DPI");
            m.addColumn("NIT");
            m.addColumn("ID USA");

            for (StringsBaseDatos sbd : this.tbd.TablaClientes(sbd)) {
                m.addRow(new Object[]{sbd.getNombre_clientes_sbd(), sbd.getTelefono_clientes_sbd(), sbd.getCorreo_clientes_sbd(), sbd.getEstatus_clientes_sbd(),
                    sbd.getDireccion_clientes_sbd(), estadoCivil, estadoMigratorio, sbd.getProfecion_clientes_sbd(), sbd.getEstadoResidencia_clientes_sbd(),
                    sbd.getDpi_clientes_sbd(), sbd.getNit_clientes_sbd(), sbd.getUsaId_clientes_sbd()});
            }

            usuario.bc_tbl_datos.setModel(m);
        } catch (Exception e) {
            login.mensaje.showMessageDialog(null, "No se puede conectar con la base de datos Contacte con su Administrador", "Problemas de Conexion", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void validarEstdoCivil() {
        System.out.println("Entrada Validar EstadoCivil");
        
        StringsBaseDatos sbd = new StringsBaseDatos();
        try {
            
            System.out.println(sbd.getId_EstadoCivil_clientes_sbd());
            
            this.tbd.TablaEstadoCivil(sbd);
            
            switch (sbd.getId_EstadoCivil_clientes_sbd()) {

                case 1:
                    estadoCivil = sbd.getDescripcion_EstadoCivil_sbd();
                    break;

                case 2:
                    estadoCivil = sbd.getDescripcion_EstadoCivil_sbd();
                    break;

                case 3:
                    estadoCivil = sbd.getDescripcion_EstadoCivil_sbd();
                    break;
                case 4:
                    estadoCivil = sbd.getDescripcion_EstadoCivil_sbd();
                    break;

                default:
                    login.mensaje.showMessageDialog(null, "Error al validar informacion", "Error EC", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } catch (Exception e) {
            login.mensaje.showMessageDialog(null, "No se puede conectar con la base de datos Contacte con su Administrador", "Problemas de Conexion", JOptionPane.ERROR_MESSAGE);
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
        buscarCliente();
    }

}
