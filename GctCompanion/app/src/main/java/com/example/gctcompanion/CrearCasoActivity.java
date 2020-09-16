package com.example.gctcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class CrearCasoActivity extends ActivityDefault {
    private Spinner spinner, spinnerCliente, spinnerVendedor, spinnerUsuario, spinnerEstado, spinnerPropiedad, spinnerRepresentante;
    private EditText editTextHonorarios, editTextSalarios, editTextNotas;
    private String campo;


    private List<Integer> estados = new ArrayList();
    private List<Integer> clientes = new ArrayList();
    private List<Integer> usuarios = new ArrayList();
    private List<Integer> vendedores = new ArrayList();
    private List<Integer> propiedades = new ArrayList();
    private List<Integer> representantes = new ArrayList();

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

        //Metodos heredados
        cargarSpinner("tbl_estado"        , spinnerEstado,        "tipo",        estados);
        cargarSpinner("tbl_clientes"      , spinnerCliente,       "nombre",      clientes);
        cargarSpinner("tbl_usuarios"      , spinnerUsuario,       "nombre",      usuarios);
        cargarSpinner("tbl_vendedor"      , spinnerVendedor,      "nombre",      vendedores);
        cargarSpinner("tbl_tipo_propiedad", spinnerPropiedad,     "descripcion", propiedades);
        cargarSpinner("tbl_representante" , spinnerRepresentante, "nombre",      representantes);

        //Item Select Spinners
        loadItemSelected();

    }

    private void loadItemSelected(){
        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Estado",estados.get(position).toString());
                casos.setEstadoId(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Clientes",clientes.get(position).toString());
                casos.setClienteId(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner usuario",usuarios.get(position).toString());
                casos.setUsuarioId(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerVendedor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Vendedor",vendedores.get(position).toString());
                casos.setVendedorId(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerPropiedad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Propiedad",propiedades.get(position).toString());
                casos.setPropiedadId(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerRepresentante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Representante",representantes.get(position).toString());
                casos.setRepresentateId(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }


    public void onClick(View view){
        if(validationEditText(editTextSalarios) && validationEditText(editTextHonorarios) && validationEditText(editTextNotas)) {
            casos.setSalarios(Double.parseDouble(editTextSalarios.getText().toString().trim()));
            casos.setHonorarios(Double.parseDouble(editTextHonorarios.getText().toString().trim()));
            casos.setNotas(editTextNotas.getText().toString().trim());
            String[][] parametros = {
                    {"method","insert"},
                    {"table","tbl_casos"},
                    {"id_cliente",String.valueOf(casos.getClienteId())},
                    {"id_vendedor",String.valueOf(casos.getVendedorId())},
                    {"id_usuario",String.valueOf(casos.getUsuarioId())},
                    {"honorarios",String.valueOf(casos.getHonorarios())},
                    {"salarios",String.valueOf(casos.getSalarios())},
                    {"notas",setUrlFornat(String.valueOf(casos.getNotas()))},
                    {"id_estado",String.valueOf(casos.getEstadoId())},
                    {"id_tipo_propiedad",String.valueOf(casos.getPropiedadId())},
                    {"id_representante",String.valueOf(casos.getRepresentateId())},
            };
            String url = URL  + getParams(parametros);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            boolean responseBoolean = Boolean.parseBoolean(response);
                            if (responseBoolean){
                                Toast.makeText(getApplicationContext(), "Nuevo caso creado correctamente",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(), "Error al crear caso, intente de nuevo",Toast.LENGTH_SHORT).show();
                            }
                            startActivity(new Intent(getApplicationContext(),PrincipalActivity.class));
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError e) {
                    Log.e("Connect Error", e.getMessage());
                }
            });
            requestQueue.add(stringRequest);
        }else{
            Toast.makeText(getApplicationContext(), "Error ingrese todos los datos solicitados", Toast.LENGTH_SHORT).show();
        }
    }
}