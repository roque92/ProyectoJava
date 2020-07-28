/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jroque
 */
public class DatosDAO implements InterfaceMetodos{

    @Override
    public ArrayList<DatosVO> validar_login(DatosVO dvo) {
        Conector c = new Conector();
        ArrayList <DatosVO> datos = new ArrayList ();
        
        try {
            c.connect();
            ResultSet rs = c.obtener_datos("SELECT u.username, u.pass, u.telefono, u.correo, r.tipo\n"
                    + " FROM tbl_usuarios AS u INNER JOIN tbl_roles AS r ON u.id_roles = r.id WHERE username = '" + dvo.getUser_login()+ "'");
            
            while (rs.next()) {
                dvo.setLogin_user(rs.getString(1));
                dvo.setLogin_pass(rs.getString(2));
                dvo.setLogin_telefono(rs.getString(3));
                dvo.setLogin_correo(rs.getString(4));
                dvo.setLogin_tipo(rs.getString(5));
                
                datos.add(dvo);                
            }
            
            c.desconectar();
            
        } catch (SQLException e) {
            dvo.setError(e.getMessage());
        }
        
        return datos;
    }

    @Override
    public void insertar_datos(DatosVO dvo) {
        Conector c = new Conector();
        //Tabla Vendedor
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_vendedor (nombre, telefono, constructora, correo)\n" 
                    +"VALUES ('"+ dvo.getNombre_vendedor() +"','"+ dvo.getTelefono_vendedor() +"','"+ dvo.getConstructora_vendedor() +"','"+ dvo.getCorreo_vendedor() +"')");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
        //Tabla Representante
        try {
            c.connect();
            c.consulta_general("INSERT INTO tbl_representante (nombre, parentezco, direccion, telefono, banco)\n" 
                    +"VALUES ('"+ dvo.getNombre_representante()+"','"+ dvo.getParentezco_representante()+"','"+ dvo.getDireccion_representante()+"','"+ dvo.getTelefono_representante()+"','"+ dvo.getBanco_representante() +"')");
            c.desconectar();
        } catch (Exception e) {
            dvo.setError(e.getMessage());
        }
    }

    @Override
    public void modificar_datos(DatosVO dvo) {
        
    }

    @Override
    public ArrayList<DatosVO> mostrar_datos(DatosVO dvo) {
        
    }

    @Override
    public void borrar_datos(DatosVO dvo) {
        
    }
    
}
