/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexr
 */
public class ModelAsesores extends Models{
    private static ModelAsesores model = new ModelAsesores();
    private String columna1 = "nombre";
    private String columna2 = "telefono";
    private String columna3 = "constructora";
    private String columna4 = "correo";
    
    public static void dataServer(Map<String,String> map){
        model.DataServer(map);
    }

    public void DataServer(Map<String,String> map){
        
    }
    
    public static void loadTable(JTable table){
        model.LoadTable(table);
    }
    
    public void LoadTable(JTable table){
        String consultaSQL = "SELECT * FROM tbl_vendedor";
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        ResultSet resultSet;
        resultSet = conector.obtener_datos(consultaSQL);
        
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
