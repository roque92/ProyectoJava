package com.example.gctcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends ActivityDefault {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Principal);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCasos:
                Intent casos = new Intent(getApplicationContext(),CasosActivity.class);
                startActivity(casos);
                break;
            case R.id.buttonCrearCaso:
                Intent clientes = new Intent(getApplicationContext(), CrearCasoActivity.class);
                startActivity(clientes);
                break;
            case R.id.buttonCrearCliente:
                Intent vendedores = new Intent(getApplicationContext(),CrearClienteActivity.class);
                startActivity(vendedores);
                break;
        }
    }
}