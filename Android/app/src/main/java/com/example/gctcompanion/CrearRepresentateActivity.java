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

public class CrearRepresentateActivity extends ActivityDefault {
    private EditText nombreRepresentante, parentescoRepresentante, direccionRepresentante, telefonoRepresentante, bancoRepresentante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_representante);
        nombreRepresentante = findViewById(R.id.nombreRepresentante);
        parentescoRepresentante = findViewById(R.id.parentescoRepresentante);
        direccionRepresentante = findViewById(R.id.direccionRepresentante);
        telefonoRepresentante = findViewById(R.id.telefonoRepresentante);
        bancoRepresentante = findViewById(R.id.bancoRepresentante);
    }

    public void onClick(View view) {
        if(validationEditText(nombreRepresentante) && validationEditText(parentescoRepresentante) && validationEditText(direccionRepresentante)
                && validationEditText(telefonoRepresentante) && validationEditText(bancoRepresentante)) {

            String[][] parametros = {
                    {"method", "insert"},
                    {"table", "tbl_representante"},
                    {"nombre", setUrlFornat(nombreRepresentante.getText().toString().trim())},
                    {"parentezco", setUrlFornat(parentescoRepresentante.getText().toString().trim())},
                    {"direccion", setUrlFornat(direccionRepresentante.getText().toString().trim())},
                    {"telefono", setUrlFornat(telefonoRepresentante.getText().toString().trim())},
                    {"banco", setUrlFornat(bancoRepresentante.getText().toString().trim())},
            };
            String url = URL + getParams(parametros);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            boolean responseBoolean = Boolean.parseBoolean(response);
                            if (responseBoolean) {
                                Toast.makeText(getApplicationContext(), "Nuevo Representante creado correctamente", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error al nuevo Representante, intente de nuevo", Toast.LENGTH_SHORT).show();
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