package com.example.gctcompanion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gctcompanion.modelos.Casos;

public class DetalleCasosActivity extends ActivityDefault {
    private Casos casos = new Casos();
    private Button buttonEditar;
    private EditText editTextCliente, editTextVendedor, editTextUsuario, editTextHonorarios, editTextSalarios, editTextNotas, editTextEstado, editTextPropiedad, editTextRepresentante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_casos);
        editTextCliente = findViewById(R.id.editTextCliente);
        editTextVendedor = findViewById(R.id.editTextVendedor);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextHonorarios = findViewById(R.id.editTextHonorarios);
        editTextSalarios = findViewById(R.id.editTextSalarios);
        editTextNotas = findViewById(R.id.editTextNotas);
        editTextEstado = findViewById(R.id.editTextEstado);
        editTextPropiedad = findViewById(R.id.editTextPropiedad);
        editTextRepresentante = findViewById(R.id.editTextRepresentante);
        cargarDatos();
    }

    private void cargarDatos(){
        Bundle datos = this.getIntent().getExtras();
        casos.setId(datos.getInt("id"));
        casos.setCliente(datos.getString("cliente"));
        casos.setVendedor(datos.getString("vendedor"));
        casos.setUsuario(datos.getString("usuario"));
        casos.setHonorarios((int) datos.getDouble("honorarios"));
        casos.setSalarios((int) datos.getDouble("salarios"));
        casos.setNotas(datos.getString("notas"));
        casos.setEstado(datos.getString("estado"));
        casos.setPropiedad(datos.getString("propiedad"));
        casos.setRepresentante(datos.getString("representante"));

        editTextCliente.setText(datos.getString("cliente"));
        editTextVendedor.setText(datos.getString("vendedor"));
        editTextUsuario.setText(datos.getString("usuario"));
        editTextHonorarios.setText(datos.getDouble("honorarios")+"");
        editTextSalarios.setText(datos.getDouble("salarios")+"");
        editTextNotas.setText(datos.getString("notas"));
        editTextEstado.setText(datos.getString("estado"));
        editTextPropiedad.setText(datos.getString("propiedad"));
        editTextRepresentante.setText(datos.getString("representante"));
    }

    private void actualizar(){
        if(verificarEditText(editTextCliente) && verificarEditText(editTextVendedor) && verificarEditText(editTextUsuario) && verificarEditText(editTextHonorarios) && verificarEditText(editTextSalarios)
                && verificarEditText(editTextNotas) && verificarEditText(editTextEstado) && verificarEditText(editTextPropiedad) && verificarEditText(editTextRepresentante)){
            String[][] parametros = {
                    {"method","update"},
                    {"table","tbl_casos"},
                    {"id", String.valueOf(casos.getId())},
                    {"cliente",editTextCliente.getText().toString()},
                    {"vendedor",editTextVendedor.getText().toString()},
                    {"usuario",editTextUsuario.getText().toString()},
                    {"honorarios",editTextHonorarios.getText().toString()},
                    {"salarios",editTextSalarios.getText().toString()},
                    {"notas",editTextNotas.getText().toString()},
                    {"estado",editTextEstado.getText().toString()},
                    {"propiedad",editTextPropiedad.getText().toString()},
                    {"representante",editTextRepresentante.getText().toString()}
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

    public void onClick(View view) {
        String texto = buttonEditar.getText().toString().trim();
        if (texto.equals("Editar")){
            desbloquear(editTextCliente,true);
            desbloquear(editTextVendedor,true);
            desbloquear(editTextUsuario,true);
            desbloquear(editTextHonorarios,true);
            desbloquear(editTextSalarios,true);
            desbloquear(editTextNotas,true);
            desbloquear(editTextEstado,true);
            desbloquear(editTextPropiedad,true);
            desbloquear(editTextRepresentante,true);
        }else{
            buttonEditar.setText("Guardar");
            actualizar();
        }
    }


}