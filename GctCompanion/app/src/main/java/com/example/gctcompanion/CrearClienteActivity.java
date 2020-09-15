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

public class CrearClienteActivity extends ActivityDefault {
    private EditText nombreCliente, telefonoCliente, correoCliente, estatusCliente, direccionCliente;
    private Spinner estadoCivilCliente, migratorioCliente;

    private List<Integer> estadoCivil =  new ArrayList<>();
    private List<Integer> migratorio =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);
        nombreCliente = findViewById(R.id.nombreCliente);
        telefonoCliente = findViewById(R.id.telefonoCliente);
        correoCliente = findViewById(R.id.correoCliente);
        estatusCliente = findViewById(R.id.estatusCliente);
        direccionCliente = findViewById(R.id.direccionCliente);
        estadoCivilCliente = findViewById(R.id.estadoCivilCliente);
        migratorioCliente   = findViewById(R.id.migratorioCliente);
        cargarSpinner("tbl_estado_civil", estadoCivilCliente,"descripcion", estadoCivil);
        cargarSpinner("tbl_migratorio"  , migratorioCliente, "descripcion", migratorio);
        estadoCivilCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Estado",estadoCivil.get(position).toString());
                clientes.setIdEstadoCivil(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        migratorioCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Spinner Estado",migratorio.get(position).toString());
                clientes.setIdMigratorio(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }

    public void onClick(View view) {
        if(validationEditText(nombreCliente) && validationEditText(telefonoCliente) && validationEditText(correoCliente) && validationEditText(estatusCliente) && validationEditText(direccionCliente)) {
            String[][] parametros = {
                    {"method", "insert"},
                    {"table", "tbl_clientes"},
                    {"nombre", setUrlFornat(nombreCliente.getText().toString().trim())},
                    {"telefono", telefonoCliente.getText().toString().trim()},
                    {"correo", correoCliente.getText().toString().trim()},
                    {"estatus", setUrlFornat(estatusCliente.getText().toString().trim())},
                    {"direccion", setUrlFornat(direccionCliente.getText().toString().trim())},
                    {"id_estado_civil", String.valueOf(clientes.getIdEstadoCivil())},
                    {"id_migratorio", String.valueOf(clientes.getIdMigratorio())},
                    {"clase_tramite", "pendiente"}
            };
            String url = URL + getParams(parametros);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            boolean responseBoolean = Boolean.parseBoolean(response);
                            if (responseBoolean) {
                                Toast.makeText(getApplicationContext(), "Nuevo cliente creado correctamente", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error al nuevo cliente, intente de nuevo", Toast.LENGTH_SHORT).show();
                            }
                            startActivity(new Intent(getApplicationContext(), PrincipalActivity.class));
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