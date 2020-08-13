/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import Modelo.TablasBaseDatos;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import proyecto.Vista.Login;
import proyecto.Vista.Usuario;

/**
 *
 * @author Jose Roque
 */
public class ControllerCasosAsignados implements InternalFrameListener{
    
    Usuario usuario = new Usuario();
    Login login = new Login();
    StringsBaseDatos sbd = new StringsBaseDatos();
    TablasBaseDatos tbd = new TablasBaseDatos();
    DatosVO dvo = new DatosVO();

    public ControllerCasosAsignados(Usuario usuario, Login login, StringsBaseDatos sbd, TablasBaseDatos tbd, DatosVO dvo) {
        this.usuario = usuario;
        this.login = login;
        this.sbd = sbd;
        this.tbd = tbd;
        this.dvo = dvo;
        
        usuario.if_casosAsignados.addInternalFrameListener(this);
    }
    
    private void casosAsignados(){
        try {
            DefaultTableModel m = new DefaultTableModel();
            m.setColumnCount(0);
            m.addColumn("Nombe Cliente");
            m.addColumn("Nombre Vendedor");
            m.addColumn("Usuario Asignado");
            m.addColumn("Honorarios");
            m.addColumn("Salario");
            m.addColumn("Notas");
            m.addColumn("Estatus Caso");
            m.addColumn("Tipo Propiedad");
            m.addColumn("Nomre Representante Legal");
            
            for (StringsBaseDatos sbd : this.tbd.CasosAsignados(sbd)) {
                m.addRow(new Object[]{sbd.getNombre_clientes_sbd(), sbd.getNombre_vendedor_sbd(), sbd.getUsername_usuario_sbd(), 
                    sbd.getHonorario_casos_sbd(), sbd.getSalario_casos_sbd(), sbd.getNotas_casos_sbd(), sbd.getDescripcion_estdo_sbd(),
                sbd.getDescripcion_propiedad_sbd(), sbd.getNombre_representante_sbd()});
            }
            
            usuario.ca_tbl_datos.setModel(m);
        } catch (Exception e) {
            login.mensaje.showMessageDialog(null, "No se puede conectar con la base de datos Contacte con su Administrador", "Problemas de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        casosAsignados();
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }
    
    
    
    
}
