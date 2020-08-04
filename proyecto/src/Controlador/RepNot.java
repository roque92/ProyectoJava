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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class RepNot implements ActionListener, ItemListener{
   
    //Vista
    Usuario usuario = new Usuario();
    //Modelo
    DatosVO dvo = new DatosVO();
    DatosDAO ddao = new DatosDAO();
    StringsBaseDatos sbd = new StringsBaseDatos();

    public RepNot(Usuario usuario, DatosVO dvo) {
        this.usuario = usuario;
        this.dvo = dvo;   
        
        usuario.f_btn_buscarCliente.addActionListener(this);
        usuario.f_cb_nuevo.addItemListener(this);
        usuario.f_txt_repNombre.setEditable(false);
        usuario.f_txt_repParentezco.setEditable(false);
        usuario.f_txt_repDireccion.setEditable(false);
        usuario.f_txt_repTelefono.setEditable(false);
        usuario.f_txt_repBanco.setEditable(false);
        usuario.f_txt_notas.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
    
    
    
    
}
