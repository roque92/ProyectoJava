/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DatosVO;
import proyecto.Vista.Usuario;

/**
 *
 * @author jroque
 */
public class RepNot {
    
    Usuario usuario = new Usuario();
    DatosVO dvo = new DatosVO();

    public RepNot(Usuario usuario, DatosVO dvo) {
        this.usuario = usuario;
        this.dvo = dvo;        
    }
    
    
    
    
}
