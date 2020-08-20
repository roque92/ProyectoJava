package com.example.gctcompanion;

import android.app.Activity;
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
import com.example.gctcompanion.modelos.Casos;
import com.example.gctcompanion.modelos.Clientes;
import com.example.gctcompanion.modelos.Estados;
import com.example.gctcompanion.modelos.Propiedades;
import com.example.gctcompanion.modelos.Representantes;
import com.example.gctcompanion.modelos.Usuarios;
import com.example.gctcompanion.modelos.Vendedores;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityDefault extends Activity {
    //    protected final String URL = "http://192.168.5.106/intecap";
    protected final String URL = "http://prueba.divisagt.com/";
    protected JSONObject jsonObject = null;
    protected JSONArray jsonArray = null;
    protected String jsonString = "[]";

    protected Casos casos = new Casos();
    protected Estados estados = new Estados();
    protected Clientes clientes = new Clientes();
    protected Usuarios usuarios = new Usuarios();
    protected Vendedores vendedores = new Vendedores();
    protected Propiedades propiedades = new Propiedades();
    protected Representantes representantes = new Representantes();

    protected String setUrlFornat(String texto){
        texto.toUpperCase();
        return  texto.replace(' ','+');
    }

    protected String getParams(String[][] parametros) {
        try {
            String cadena = "?";
            for (int i = 0; i < parametros.length; i++) {
                cadena += parametros[i][0] + "=" + parametros[i][1] + "&";
            }
            String retorno = cadena.substring(0, cadena.length() - 1);
            Log.e("URL string server", URL + retorno);
            return retorno;
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

    protected void llenarSpinner(Spinner spinner, String campo, List<Integer> modelo){

        try {
            List<String> valores = new ArrayList<String>();
            valores.add("Seleccione: ");
            modelo.add(0);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = null;
                jsonObject = jsonArray.getJSONObject(i);
                valores.add(jsonObject.optString(campo));
                modelo.add(jsonObject.optInt("id"));
            }
            spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valores));
        }catch (Exception e){
            Log.e("Llenar Spinner",e.getMessage());
        }
    }


    protected void cargarSpinner(String table, final Spinner spinner, final String campo, final List<Integer> modelo){
        String[][] parametros = {
                {"method","show"},
                {"id",""},
                {campo,""},
                {"table",table},
        };
        String url = URL  + getParams(parametros);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        setJson(response);
                        llenarSpinner(spinner,campo,modelo);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("Connect Error", e.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }
}