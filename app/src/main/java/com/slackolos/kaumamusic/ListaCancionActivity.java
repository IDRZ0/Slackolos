package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.slackolos.kaumamusic.adapters.CancionAdapter;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.inventario.Inventario;
import com.slackolos.kaumamusic.listas.Cancion;

import java.util.ArrayList;
import java.util.List;

public class ListaCancionActivity extends AppCompatActivity {

    private Context mContext;

    private ListView canciones;
    private CancionAdapter cancionAdapter;
    private List<Cancion> cancionArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        mContext = this;

        initViews();
        addEvents();
    }

    private void initViews(){
        canciones = findViewById(R.id.canciones);
        cancionArray = Inventario.getCanciones();
        cancionAdapter = new CancionAdapter(mContext, cancionArray);
        canciones.setAdapter(cancionAdapter);
    }

    private void addEvents(){
        canciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cancion cancion = cancionArray.get(position);
                Intent intent = new Intent(mContext, CancionActivity.class);
                intent.putExtra(Constantes.CANCION, new Gson().toJson(cancion));
                startActivity(intent);
            }
        });
    }
}
