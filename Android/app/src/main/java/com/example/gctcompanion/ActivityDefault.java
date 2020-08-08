package com.example.gctcompanion;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gctcompanion.modelos.Clientes;
import com.example.gctcompanion.modelos.Estados;
import com.example.gctcompanion.modelos.Propiedades;
import com.example.gctcompanion.modelos.Representantes;
import com.example.gctcompanion.modelos.Usuarios;
import com.example.gctcompanion.modelos.Vendedores;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.invoke.MethodHandle;
import java.util.ArrayList;
import java.util.List;

public class ActivityDefault extends Activity {
    protected final String URL = "http://192.168.0.28/intecap";
    protected JSONObject jsonObject = null;
    protected JSONArray jsonArray = null;
    protected String jsonString = "[]";
    private Estados estados = new Estados();
    private Clientes clientes = new Clientes();
    private Usuarios usuarios = new Usuarios();
    private Vendedores vendedores = new Vendedores();
    private Propiedades propiedades = new Propiedades();
    private Representantes representantes = new Representantes();



    protected String getParams(String[][] parametros) {
        try {
            String cadena = "?";
            for (int i = 0; i < parametros.length; i++) {
                cadena += parametros[i][0] + "=" + parametros[i][1] + "&";
            }
            return cadena.substring(0, cadena.length() - 1);
        } catch (Exception e) {
            return "";
        }
    }

    protected void setJson(String json) {
        if (json.equals("[]")) {
            jsonObject = null;
            jsonArray = null;
            jsonString = json;
        } else {
            try {
                jsonString = json.substring(1, json.length() - 1);
                jsonObject = new JSONObject(jsonString);
                jsonArray = new JSONArray(json);
                jsonString = json;
            } catch (Exception e) {
                Log.e("Json Create Error", e.getMessage());
            }
        }
    }

    protected boolean validationEditText(EditText editText) {
        if (editText.getText().toString().isEmpty())
            return false;
        return true;
    }

    protected boolean verificarEditText(EditText editText) {
        if (editText.getText().toString().isEmpty())
            return false;
        return true;
    }

    protected void desbloquear(EditText editText, boolean mode) {
        editText.setFocusable(mode);
        editText.setEnabled(mode);
        editText.setCursorVisible(mode);
        editText.setFocusableInTouchMode(mode);
    }



    protected void llenarSpinner(Spinner spinner, String campo, List<String> modelo){

        try {
            List<String> valores = new ArrayList<String>();
            valores.add("Seleccione");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = null;
                jsonObject = jsonArray.getJSONObject(i);
                valores.add(jsonObject.optString(campo));
                modelo.add(jsonObject.optString("id"));
            }
            System.out.println(campo + modelo.size());
            spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valores));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}