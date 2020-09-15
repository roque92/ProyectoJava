/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jroque
 */
public interface InterfaceTablasBase {
    
    //--------------------CRUD
    
     public ArrayList<StringsBaseDatos> TablaVendedor(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaClientes(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> CasosAsignados(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> RegistroDetallado(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> mostrarClientes (StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> mostrarAsesores (StringsBaseDatos sbd);
     public void modificarAsignado(StringsBaseDatos sbd);
    
}
