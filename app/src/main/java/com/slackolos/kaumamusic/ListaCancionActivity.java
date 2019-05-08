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
import com.slackolos.kaumamusic.listas.Artista;
import com.slackolos.kaumamusic.listas.Cancion;
import com.slackolos.kaumamusic.listas.Playlist;

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

        Intent intent = getIntent();
        String string = intent.getStringExtra(Constantes.PLAYLIST_1);
        String string1 = intent.getStringExtra(Constantes.ARTISTA);

        Playlist playlist = new Gson().fromJson(string, Playlist.class);
        Artista artista = new  Gson().fromJson(string1, Artista.class);

        canciones = findViewById(R.id.canciones);

        if(playlist != null){
            if(playlist.getNombrePlaylist().equals("Fiesta")){
                cancionArray = Inventario.Fiesta();
            } else if(playlist.getNombrePlaylist().equals("Estudiar")){
                cancionArray = Inventario.Estudiar();
            }
        } else if(artista != null) {
            if (artista.getNombreArtista().equals("Darell")) {
                cancionArray = Inventario.Darell();
            } else if (artista.getNombreArtista().equals("Sech")) {
                cancionArray = Inventario.Sech();
            }
        } else {
            cancionArray = Inventario.Todas();
        }

        addEvents();
    }

    public void addEvents(){
        cancionAdapter = new CancionAdapter(mContext, cancionArray);
        canciones.setAdapter(cancionAdapter);

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
