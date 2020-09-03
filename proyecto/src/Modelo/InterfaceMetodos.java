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
    public void insertar_datos_vendedor(DatosVO dvo);
    public void insertar_datos_representante(DatosVO dvo);
    public void insertar_datos_clientes(DatosVO dvo);
    public void insertar_datos_casos(DatosVO dvo);
    public void insertar_datos_registro(DatosVO dvo);

    //Modificar
    public void modificar_datos_vendedor(DatosVO dvo);
    public void modificar_datos_representante(DatosVO dvo);
    public void modificar_datos_clientes(DatosVO dvo);
    public void modificar_datos_casos(DatosVO dvo);

    //Mostrar
    public ArrayList<DatosVO> mostrar_datos_nombre(DatosVO dvo);
    public ArrayList<DatosVO> mostrar_datos_telefono(DatosVO dvo);
    public ArrayList<DatosVO> mostrar_datos_correo(DatosVO dvo);
    public ArrayList<DatosVO> idCliente(DatosVO dvo);
    public ArrayList<DatosVO> idCaso(DatosVO dvo);

    //Eliminar
    public void borrar_datos(DatosVO dvo); 
    
    //Para craear Casos
    //vendedor
    public ArrayList<DatosVO> buscar_id_vendedor(DatosVO dvo);
    
    //representante
    public ArrayList<DatosVO> buscar_id_representante(DatosVO dvo);

    
}
