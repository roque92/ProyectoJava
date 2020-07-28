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
public interface InterfaceMetodos {

    //Metodo para poder hacer la consulta y validacion de login
    public ArrayList<DatosVO> validar_login(DatosVO dvo);

//--------------------CRUD
    //Insertar
    public void insertar_datos(DatosVO dvo);

    //Modificar
    public void modificar_datos(DatosVO dvo);

    //Mostrar
    public ArrayList<DatosVO> mostrar_datos_nombre(DatosVO dvo);
    public ArrayList<DatosVO> mostrar_datos_telefono(DatosVO dvo);
    public ArrayList<DatosVO> mostrar_datos_correo(DatosVO dvo);

    //Eliminar
    public void borrar_datos(DatosVO dvo);
}
