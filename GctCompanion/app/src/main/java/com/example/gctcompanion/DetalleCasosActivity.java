package com.example.gctcompanion;

import android.content.Intent;
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



    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ActualizarCasoActivity.class);
        intent.putExtra("id",         casos.getId());
        intent.putExtra("honorarios", casos.getHonorarios());
        intent.putExtra("salarios",   casos.getSalarios());
        intent.putExtra("notas",      casos.getNotas());
        startActivity(intent);

    }


}