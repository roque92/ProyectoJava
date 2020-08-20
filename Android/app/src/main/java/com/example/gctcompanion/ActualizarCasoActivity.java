package com.example.gctcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gctcompanion.modelos.Casos;

public class ActualizarCasoActivity extends ActivityDefault {
    private Casos casos = new Casos();
    private EditText editTextHonorarios, editTextSalarios, editTextNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_caso);
        editTextHonorarios = findViewById(R.id.editTextHonorarios);
        editTextSalarios = findViewById(R.id.editTextSalarios);
        editTextNotas = findViewById(R.id.editTextNotas);
        cargarDatos();
    }

    public void onClick(View view) {
        actualizar();
    }

    private void cargarDatos(){
        Bundle datos = this.getIntent().getExtras();
        casos.setId(datos.getInt("id"));
        casos.setHonorarios((int) datos.getDouble("honorarios"));
        casos.setSalarios((int) datos.getDouble("salarios"));
        casos.setNotas(datos.getString("notas"));

        editTextHonorarios.setText(datos.getDouble("honorarios")+"");
        editTextSalarios.setText(datos.getDouble("salarios")+"");
        editTextNotas.setText(datos.getString("notas"));
    }


    private void actualizar(){
        if(verificarEditText(editTextHonorarios) && verificarEditText(editTextSalarios) && verificarEditText(editTextNotas)){
            String[][] parametros = {
                    {"method","update"},
                    {"table","tbl_casos"},
                    {"id", String.valueOf(casos.getId())},
                    {"honorarios",setUrlFornat(editTextHonorarios.getText().toString())},
                    {"salarios",setUrlFornat(editTextSalarios.getText().toString())},
                    {"notas",setUrlFornat(editTextNotas.getText().toString())},
            };
            String url = URL  + getParams(parametros);
            System.out.println(url);
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(),"Caso Actualizado con exito",Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError e) {
                    Log.e("Connect Error", e.getMessage());
                }
            });
            queue.add(stringRequest);
        }else{
            Toast.makeText(getApplicationContext(),"Campos incompletos, rellene toda la informacion",Toast.LENGTH_SHORT).show();
        }
    }
}