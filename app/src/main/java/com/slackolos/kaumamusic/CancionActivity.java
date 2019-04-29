package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.listas.Cancion;


public class CancionActivity extends AppCompatActivity {

    private Context context;
    private ImageView imagenCancion;
    private TextView nombreCancion;
    private TextView cancionArtista;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion);
        context = this;

        initViews();
        recieveData();
    }

    private void initViews(){
        imagenCancion = findViewById(R.id.imagenCancion);
        nombreCancion = findViewById(R.id.nombreCancion);
        cancionArtista = findViewById(R.id.cancionArtista);
    }

    private void recieveData(){
        Intent intent = getIntent();
        String json = intent.getStringExtra(Constantes.CANCION);
        Cancion cancion = new Gson().fromJson(json, Cancion.class);
        nombreCancion.setText(cancion.getNombreCancion());
        cancionArtista.setText(cancion.getCancionArtsta());
        imagenCancion.setImageResource(cancion.getImagenCancion());
    }
}
