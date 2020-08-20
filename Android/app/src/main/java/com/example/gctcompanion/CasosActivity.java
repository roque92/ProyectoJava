package com.example.gctcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gctcompanion.modelos.Casos;

import org.json.JSONObject;

import java.util.ArrayList;

public class CasosActivity extends ActivityDefault {
    private ListView listView;
    private EditText editText;
    private ArrayList<String> arrayList;
    private ArrayList<Casos> arrayListCasos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casos);
        listView = findViewById(R.id.listViewData);
        editText = findViewById(R.id.editTextBusqueda);
        buscar("");
        editText.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                buscar(editText.getText().toString().trim());
                return false;
            }
        });
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), DetalleCasosActivity.class);
                        intent.putExtra("id",           arrayListCasos.get(position).getId() );
                        intent.putExtra("cliente",      arrayListCasos.get(position).getCliente() );
                        intent.putExtra("vendedor",     arrayListCasos.get(position).getVendedor() );
                        intent.putExtra("usuario",      arrayListCasos.get(position).getUsuario() );
                        intent.putExtra("honorarios",   arrayListCasos.get(position).getHonorarios() );
                        intent.putExtra("salarios",     arrayListCasos.get(position).getSalarios() );
                        intent.putExtra("notas",        arrayListCasos.get(position).getNotas() );
                        intent.putExtra("estado",       arrayListCasos.get(position).getEstado() );
                        intent.putExtra("propiedad",    arrayListCasos.get(position).getPropiedad() );
                        intent.putExtra("representante",arrayListCasos.get(position).getRepresentante() );
                        startActivity(intent);
                    }
                }
        );
    }

    private void buscar(String texto){
        texto = texto.replace(" ","+");
        String[][] parametros = {
                {"method","show"},
                {"table","tbl_casos"},
                {"busqueda",texto}
        };
        String url = URL  + getParams(parametros);
        System.out.println(url);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        setJson(response);
                        if(!jsonString.equals("[]")){
                            Casos casos = null;
                            arrayListCasos = new ArrayList<>();
                            try{
                                for (int i=0; i< jsonArray.length(); i++){
                                    casos = new Casos();
                                    JSONObject jsonObject = null;
                                    jsonObject = jsonArray.getJSONObject(i);
                                    casos.setId(jsonObject.optInt("id"));
                                    casos.setCliente(jsonObject.optString("cliente"));
                                    casos.setVendedor(jsonObject.optString("vendedor"));
                                    casos.setUsuario(jsonObject.optString("usuario"));
                                    casos.setHonorarios(jsonObject.optDouble("honorarios"));
                                    casos.setSalarios(jsonObject.optDouble("salarios"));
                                    casos.setNotas(jsonObject.optString("notas"));
                                    casos.setEstado(jsonObject.optString("estado"));
                                    casos.setPropiedad(jsonObject.optString("propiedad"));
                                    casos.setRepresentante(jsonObject.optString("representante"));
                                    arrayListCasos.add(casos);
                                }
                                arrayList = new ArrayList<>();
                                for (int i =0; i< arrayListCasos.size(); i++){
                                    arrayList.add(arrayListCasos.get(i).getCliente());
                                }
                                ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                                listView.setAdapter(arrayAdapter);

                            }catch (Exception e){
                                System.err.println(e.getMessage());
                            }
                        }
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
        buscar(editText.getText().toString().trim());
    }
}