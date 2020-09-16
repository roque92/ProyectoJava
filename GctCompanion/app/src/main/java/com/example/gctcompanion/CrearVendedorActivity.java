package com.example.gctcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class CrearVendedorActivity extends ActivityDefault {
    private EditText nombreVendedor, telefonoVendedor, constructoraVendedor, correoVendedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_vendedor);

        nombreVendedor = findViewById(R.id.nombreVendedor);
        telefonoVendedor = findViewById(R.id.telefonoVendedor);
        constructoraVendedor = findViewById(R.id.constructoraVendedor);
        correoVendedor = findViewById(R.id.correoVendedor);
    }

    public void onClick(View view) {
        if(validationEditText(nombreVendedor) && validationEditText(telefonoVendedor)
                && validationEditText(constructoraVendedor) && validationEditText(correoVendedor)) {

            String[][] parametros = {
                    {"method", "insert"},
                    {"table", "tbl_vendedor"},
                    {"nombre", setUrlFornat(nombreVendedor.getText().toString().trim())},
                    {"telefono", setUrlFornat(telefonoVendedor.getText().toString().trim())},
                    {"constructora", setUrlFornat(constructoraVendedor.getText().toString().trim())},
                    {"correo", setUrlFornat(correoVendedor.getText().toString().trim())}
            };
            String url = URL + getParams(parametros);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            boolean responseBoolean = Boolean.parseBoolean(response);
                            if (responseBoolean) {
                                Toast.makeText(getApplicationContext(), "Nuevo Vendedor creado correctamente", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error al nuevo Vendedor, intente de nuevo", Toast.LENGTH_SHORT).show();
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