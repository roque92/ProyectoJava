package com.example.gctcompanion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CrearCasoActivity extends ActivityDefault {
    private Spinner spinner, spinnerCliente, spinnerVendedor, spinnerUsuario, spinnerEstado, spinnerPropiedad, spinnerRepresentante;
    private EditText editTextHonorarios, editTextSalarios, editTextNotas;
    private String campo;
    private List<String> estados = new ArrayList();
    private List<String> clientes = new ArrayList();
    private List<String> usuarios = new ArrayList();
    private List<String> vendedores = new ArrayList();
    private List<String> propiedades = new ArrayList();
    private List<String> representantes = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_caso);

        spinnerCliente = findViewById(R.id.spinnerCliente);
        spinnerVendedor = findViewById(R.id.spinnerVendedor);
        spinnerUsuario = findViewById(R.id.spinnerUsuario);
        spinnerEstado = findViewById(R.id.spinnerEstado);
        spinnerPropiedad = findViewById(R.id.spinnerPropiedad);
        spinnerRepresentante = findViewById(R.id.spinnerRepresentante);

        editTextHonorarios   = findViewById(R.id.editTextHonorarios);
        editTextSalarios     = findViewById(R.id.editTextSalarios);
        editTextNotas        = findViewById(R.id.editTextNotas);

        cargarSpinner("tbl_clientes"      , spinnerCliente,       "nombre",      clientes);
        cargarSpinner("tbl_vendedor"      , spinnerVendedor,      "nombre",      vendedores);
        cargarSpinner("tbl_usuarios"      , spinnerUsuario,       "nombre",      usuarios);
        cargarSpinner("tbl_estado"        , spinnerEstado,        "tipo",        estados);
        cargarSpinner("tbl_tipo_propiedad", spinnerPropiedad,     "descripcion", propiedades);
        cargarSpinner("tbl_representante" , spinnerRepresentante, "nombre",      representantes);

        Log.e("tamaño de la lista = ",usuarios.size()+"");
        for (int i= 0; i < usuarios.size(); i++){
            System.out.println(usuarios.get(i).toString());
        }
    }

    private void cargarSpinner(String table, final Spinner spinner, final String campo, final List<String> modelo ){
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

    public void onClick(View view){

    }
}