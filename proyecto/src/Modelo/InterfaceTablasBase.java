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
     public ArrayList<StringsBaseDatos> TablaUsuario(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaPropiedad(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaRepresentante(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaRegistros(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaEstado(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaClientes(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> TablaCasos(StringsBaseDatos sbd);
     public ArrayList<StringsBaseDatos> CasosAsignados(StringsBaseDatos sbd);
    
}
