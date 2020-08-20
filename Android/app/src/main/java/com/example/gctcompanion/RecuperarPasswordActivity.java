package com.example.gctcompanion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RecuperarPasswordActivity extends ActivityDefault {
    private EditText editTextUsernameRecuperar, editTextEmailRecuperar;
    private TextView textViewPasswordRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);
        editTextEmailRecuperar = findViewById(R.id.editTextEmailRecuperar);
        editTextUsernameRecuperar = findViewById(R.id.editTextUsernameRecuperar);
        textViewPasswordRecuperar = findViewById(R.id.textViewPasswordRecuperar);
    }
    private void limpiar(){
        setJson("[]");
        editTextEmailRecuperar.setText("");
        editTextUsernameRecuperar.setText("");
    }

    public void onClick(View view) {
        if(validationEditText(editTextEmailRecuperar) && validationEditText(editTextUsernameRecuperar)){
            String[][] parametros = {
                    {"method","show"},
                    {"table","tbl_usuarios"},
                    {"wh_correo",editTextEmailRecuperar.getText().toString().trim()},
                    {"wh_username",editTextUsernameRecuperar.getText().toString().trim()}
            };
            String url = URL + getParams(parametros);
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        setJson(response);
                        System.out.println(jsonString);
                        if(!jsonString.equals("[]")){
                            String password = jsonObject.optString("pass");
                            Toast.makeText(getApplicationContext(), "Su contraseña es: "+password,Toast.LENGTH_LONG).show();
                            textViewPasswordRecuperar.setText("Tu contrasema es: "+password);
                        }else{
                            Toast.makeText(getApplicationContext(), "Usuario o correo incorrecto, intente de nuevo",Toast.LENGTH_SHORT).show();
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
        }else{
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incompletos",Toast.LENGTH_SHORT).show();
        }
    }
}