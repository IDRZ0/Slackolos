package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.slackolos.kaumamusic.adapters.PlaylistAdapter;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.inventario.Inventario;
import com.slackolos.kaumamusic.listas.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    private Context mContext;

    private PlaylistAdapter playlistAdapter;
    private ListView playlists;
    private List<Playlist> playlistArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        mContext = this;

        playlists = findViewById(R.id.canciones);
        playlistArray = Inventario.getPlaylists();
        playlistAdapter = new PlaylistAdapter(mContext, playlistArray);
        playlists.setAdapter(playlistAdapter);

        actionBar();
        addEvents();
    }

    public void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void addEvents() {
        playlists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Playlist playlist = playlistArray.get(position);
                    Intent intent = new Intent(mContext, ListaCancionActivity.class);
                    intent.putExtra(Constantes.PLAYLIST_1, new Gson().toJson(playlist));
                    startActivity(intent);
            }
        });
    }
}
