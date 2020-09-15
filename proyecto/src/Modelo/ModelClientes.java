/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexr
 */
public class ModelClientes extends Models{
    private String columna1 = "nombre";
    private String columna2 = "telefono";
    private String columna3 = "correo";
    //private String columna4 = "estatus";
    private String columna5 = "direccion";
    private String columna6 = "estado";
    private String columna7 = "migratorio";
    private String columna8 = "profesion";
    private String columna9 = "residencia";
    private String columna10 = "dpi";
    private String columna11 = "nit";
    private String columna12 = "usa";
    
    public boolean searchServer(JTable table, JTextField textField){
        String string = textField.getText().toString().trim();
        if (string.equals("")) {
            return false;
        }
        this.loadTable(table, "WHERE " + columna1 + " LIKE%'" + string + "'%");
        return true;
    }

    
    public void loadTable(JTable table, String string){
        String consultaSQL = "SELECT "
        + " tbl_clientes.id                  AS id, "
        + " tbl_clientes.nombre              AS nombre, "
        + " tbl_clientes.telefono            AS telefono, "
        + " tbl_clientes.correo              AS correo, "
        //+ " tbl_clientes.estatus             AS estatus, "
        + " tbl_clientes.direccion           AS direccion, "
        + " tbl_estado_civil.descripcion     AS estado, "
        + " tbl_migratorio.descripcion       AS migratorio, "
        + " tbl_clientes.profesion           AS profesion, "
        + " tbl_clientes.estado_residencia   AS residencia, "
        + " tbl_clientes.dpi                 AS dpi, "
        + " tbl_clientes.nit                 AS nit, "
        + " tbl_clientes.usa_id              AS usa "
        + " FROM tbl_clientes "
        + " INNER JOIN tbl_estado_civil      ON tbl_clientes.id_estado_civil = tbl_estado_civil.id "
        + " INNER JOIN tbl_migratorio ON tbl_clientes.id_migratorio   = tbl_migratorio.id";
        if(string.equals("")){
            consultaSQL += string;
        }
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        ResultSet resultSet = conector.obtener_datos(consultaSQL);
        
        defaultTableModel.setColumnIdentifiers(new Object[]{
            columna1, 
            columna2, 
            columna3, 
            //columna4, 
            columna5, 
            columna6, 
            columna7, 
            columna8, 
            columna9, 
            columna10, 
            columna11, 
            columna12
        });
        try{
            while(resultSet.next()){
                defaultTableModel.addRow(new Object[]{
                    resultSet.getString(columna1),
                    resultSet.getString(columna2),
                    resultSet.getString(columna3),
                    //resultSet.getString(columna4),
                    resultSet.getString(columna5),
                    resultSet.getString(columna6),
                    resultSet.getString(columna7),
                    resultSet.getString(columna8),
                    resultSet.getString(columna9),
                    resultSet.getString(columna10),
                    resultSet.getString(columna11),
                    resultSet.getString(columna12)
                });
            }
            table.setModel(defaultTableModel);
        }catch(Exception exception){
            System.err.println(exception.getMessage());
        }


    }
    
    public void searhCampos(String string, JTextField jTextField) {
        
    }
    
    
}
