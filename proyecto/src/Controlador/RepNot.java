/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosVO;
import Modelo.StringsBaseDatos;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class RepNot {
    //Vista
    Usuario usuario = new Usuario();
    //Modelo
    DatosVO dvo = new DatosVO();
    StringsBaseDatos sbd = new StringsBaseDatos();

    public RepNot(Usuario usuario, DatosVO dvo) {
        this.usuario = usuario;
        this.dvo = dvo;        
    }
    
    
    
    
}
