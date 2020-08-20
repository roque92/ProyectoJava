package com.example.gctcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends ActivityDefault {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCasos:
                Intent casos = new Intent(getApplicationContext(),CasosActivity.class);
                startActivity(casos);
                break;
            case R.id.buttonCrearCaso:
                Intent casosC = new Intent(getApplicationContext(), CrearCasoActivity.class);
                startActivity(casosC);
                break;
            case R.id.buttonCrearCliente:
                Intent clientes = new Intent(getApplicationContext(),CrearClienteActivity.class);
                startActivity(clientes);
                break;
            case R.id.buttonCrearVendedor:
                Intent vendedores = new Intent(getApplicationContext(),CrearVendedorActivity.class);
                startActivity(vendedores);
                break;
            case R.id.buttonCrearRepresentante:
                Intent representante = new Intent(getApplicationContext(),CrearRepresentateActivity.class);
                startActivity(representante);
                break;
        }
    }
}