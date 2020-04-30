/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.DatosVO;
import java.util.ArrayList;

/**
 *
 * @author Jreyes
 */
public interface InterfaceDAO {
    
    //login
    public ArrayList<DatosVO> validar_login(DatosVO dvo);
    
}
