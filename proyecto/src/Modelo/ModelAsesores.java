/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexr
 */
public class ModelAsesores extends Models{
    private String columna1 = "nombre";
    private String columna2 = "telefono";
    private String columna3 = "constructora";
    private String columna4 = "correo";
    
    public void LoadTable(JTable table){
        String consultaSQL = "SELECT * FROM tbl_vendedor";
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        ResultSet resultSet = conector.obtener_datos(consultaSQL);
        
        defaultTableModel.setColumnIdentifiers(new Object[]{columna1, columna2, columna3, columna4});
        try{
            while(resultSet.next()){
                defaultTableModel.addRow(new Object[]{
                    resultSet.getString(columna1),
                    resultSet.getString(columna2),
                    resultSet.getString(columna3),
                    resultSet.getString(columna4),
                });
            }
            table.setModel(defaultTableModel);
        }catch(Exception exception){
            System.err.println(exception.getMessage());
        }
    }
    
    
    
}
