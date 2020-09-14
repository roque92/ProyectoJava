/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.StringsBaseDatos;
import Modelo.TablasBaseDatos;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import proyecto.Vista.Administrador;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class ControllerAdmin implements WindowListener, ActionListener, ChangeListener {

    Administrador admin = new Administrador();
    Login login = new Login();
    Usuario usuario = new Usuario();
    StringsBaseDatos sbd = new StringsBaseDatos();
    TablasBaseDatos tbd = new TablasBaseDatos();

    public ControllerAdmin(Login login, Administrador admin, Usuario usuario, StringsBaseDatos sbd, TablasBaseDatos tbd) {
        this.admin = admin;
        this.login = login;
        this.usuario = usuario;
        this.sbd = sbd;
        this.tbd = tbd;

        admin.o_salir.addActionListener(this);
        admin.m_baseGeneralClientes.addActionListener(this);
        admin.m_baseGeneralAsesores.addActionListener(this);
        admin.m_NuevoFormulario.addActionListener(this);
        admin.cb_edit.addChangeListener(this);
        admin.bc_btnGuardar_reasignar.addActionListener(this);

        admin.cd_txtNombre.setEditable(false);
        admin.cd_txtCorreo.setEditable(false);
        admin.cd_txtTelefono.setEditable(false);
        admin.cd_txtTramite.setEditable(false);
        admin.dc_cb_asignarUsuario.setEnabled(false);

        admin.addWindowListener(this);

        admin.tbl_Clientes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccion = admin.tbl_Clientes.rowAtPoint(e.getPoint());
                sbd.setValidacion_toCasos(Integer.parseInt(String.valueOf(admin.tbl_Clientes.getValueAt(seleccion, 0))));
                admin.cd_txtNombre.setText(String.valueOf(admin.tbl_Clientes.getValueAt(seleccion, 1)));
                admin.cd_txtTelefono.setText(String.valueOf(admin.tbl_Clientes.getValueAt(seleccion, 2)));
                admin.cd_txtCorreo.setText(String.valueOf(admin.tbl_Clientes.getValueAt(seleccion, 3)));
                admin.cd_txtTramite.setText(String.valueOf(admin.tbl_Clientes.getValueAt(seleccion, 4)));
                admin.dc_cb_asignarUsuario.setSelectedItem(String.valueOf(admin.tbl_Clientes.getValueAt(seleccion, 5)));
                
                System.out.println(sbd.getValidacion_toCasos());
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
        });
    }

    private void closeWindows() {
        int seleccion = login.mensaje.showConfirmDialog(null, "Desea cerrar sesion", "Cerrar Sesion", login.mensaje.YES_NO_OPTION);

        if (seleccion == login.mensaje.YES_OPTION) {
            admin.setVisible(false);
            login.setVisible(true);
        }
    }

    private void baseClientes() {
        try {
            DefaultTableModel m = new DefaultTableModel();
            m.setColumnCount(0);
            m.addColumn("ID");
            m.addColumn("Nombe");
            m.addColumn("Telefono");
            m.addColumn("Correo");
            m.addColumn("Tramite");
            m.addColumn("Asignado A");
            m.addColumn("Direccion USA");
            m.addColumn("Estado Civil");
            m.addColumn("Estado Migratorio");
            m.addColumn("Profesion");
            m.addColumn("Estado Residencia");
            m.addColumn("DPI");
            m.addColumn("NIT");
            m.addColumn("ID USA");

            for (StringsBaseDatos sbd : this.tbd.mostrarClientes(sbd)) {
                m.addRow(new Object[]{sbd.getId_clientes_sbd(), sbd.getNombre_clientes_sbd(), sbd.getTelefono_clientes_sbd(), sbd.getCorreo_clientes_sbd(), sbd.getTramite_clientes_sbd(),
                    sbd.getUsuario_clientes_sbd(),
                    sbd.getDireccion_clientes_sbd(), sbd.getDescripcion_EstadoCivil_sbd(), sbd.getDescripcion_migratorio_sbd(), sbd.getProfecion_clientes_sbd(),
                    sbd.getEstadoResidencia_clientes_sbd(), sbd.getDpi_clientes_sbd(), sbd.getNit_clientes_sbd(), sbd.getUsaId_clientes_sbd()});
            }
            admin.tbl_Clientes.setModel(m);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(admin, "Error en la muestra de datos");
        }
    }

    private void baseAsesores() {
        try {
            DefaultTableModel m = new DefaultTableModel();
            m.setColumnCount(0);
            m.addColumn("Nombe");
            m.addColumn("Telefono");
            m.addColumn("Correo");
            m.addColumn("Constructora");

            for (StringsBaseDatos sbd : this.tbd.mostrarAsesores(sbd)) {

                m.addRow(new Object[]{sbd.getNombre_vendedor_sbd(), sbd.getTelefono_vendedor_sbd(), sbd.getConstructora_vendedor_sbd(),
                    sbd.getCorreo_vendedor_sbd()});
            }
            admin.tbl_Asesores.setModel(m);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(admin, "Error en la muestra de datos");
        }
    }

    private void actualizarAsignacion() {

        String newUser = (String) admin.dc_cb_asignarUsuario.getSelectedItem();

        switch (newUser) {
            case "Gabriela Sandoval":
                sbd.setToCasos_idUser(2);
                break;
            case "Stephanie Soto":
                sbd.setToCasos_idUser(3);
                break;
            case "Rosalba Iriarte":
                sbd.setToCasos_idUser(4);
                break;

        }
        
        tbd.modificarAsignado(sbd);
        baseClientes();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin.o_salir) {
            closeWindows();
        }
        if (e.getSource() == admin.m_baseGeneralClientes) {
            admin.if_Clientes.setVisible(true);
            baseClientes();
        }
        if (e.getSource() == admin.m_baseGeneralAsesores) {
            admin.if_Asesores.setVisible(true);
            baseAsesores();
        }
        if (e.getSource() == admin.m_NuevoFormulario) {
            admin.if_formulario.setVisible(true);
        }
        if (e.getSource() == admin.bc_btnGuardar_reasignar) {
            actualizarAsignacion();
            admin.cb_edit.setSelected(false);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (admin.cb_edit.isSelected() == true) {
            admin.dc_cb_asignarUsuario.setEnabled(true);
        } else {

            admin.dc_cb_asignarUsuario.setEnabled(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeWindows();
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
