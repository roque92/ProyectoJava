package com.example.gctcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends ActivityDefault {
    private EditText editTextUsername, editTextPassword;
    private TextView textViewOlvido;
    private Button buttonIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadComponents();
    }

    private void loadComponents(){
        textViewOlvido = findViewById(R.id.textViewOlvido);
        buttonIngresar = findViewById(R.id.buttonIngresar);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    private void limpiar(){
        setJson("[]");
        editTextPassword.setText("");
        editTextUsername.setText("");
    }

    private void validarUsuario() {
        String[][] parametros = {
                {"method","show"},
                {"table","tbl_usuarios"},
                {"wh_username",editTextUsername.getText().toString().trim()},
                {"wh_password",editTextPassword.getText().toString().trim()}
        };
        String url = URL  + getParams(parametros);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    setJson(response);
                    if(!jsonString.equals("[]")){
                        startActivity( new Intent(getApplicationContext(), PrincipalActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta, intente de nuevo",Toast.LENGTH_SHORT).show();
                    }
                    limpiar();
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                Log.e("Connect Error", e.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonIngresar:
                if(validationEditText(editTextUsername) && validationEditText(editTextUsername)){
                    validarUsuario();
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incompletos",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.textViewOlvido:
                startActivity( new Intent(getApplicationContext(), RecuperarPasswordActivity.class));
                break;
        }
    }
}