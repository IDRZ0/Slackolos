package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.slackolos.kaumamusic.adapters.ArtistaAdapter;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.inventario.Inventario;
import com.slackolos.kaumamusic.listas.Artista;

import java.util.ArrayList;
import java.util.List;

public class ArtistaActivity extends AppCompatActivity {

    private Context mContext;

    private ListView artistas;
    private ArtistaAdapter artistaAdapter;
    private List<Artista> artistaArray = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        mContext = this;
        actionBar();

        artistas = findViewById(R.id.canciones);
        artistaArray = Inventario.getArtistas();
        artistaAdapter = new ArtistaAdapter(mContext,artistaArray);
        artistas.setAdapter(artistaAdapter);

        artistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artista artista = artistaArray.get(position);
                Intent intent = new Intent(mContext, ListaCancionActivity.class);
                intent.putExtra(Constantes.ARTISTA, new Gson().toJson(artista));
                startActivity(intent);
            }
        });
    }

    public void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
