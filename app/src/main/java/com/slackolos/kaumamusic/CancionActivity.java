package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.listas.Cancion;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CancionActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {

    private Context context;
    private ImageView imagenCancion;
    private TextView nombreCancion;
    private TextView cancionArtista;
    private String url;
    private Button playButton;
    private Button nextButton;
    private Button prevButton;

    private MediaPlayer mediaPlayer;
    private List<Cancion> canciones = new ArrayList<>();
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion);
        context = this;
        mediaPlayer = new MediaPlayer();

        imagenCancion = findViewById(R.id.imagenCancion);
        nombreCancion = findViewById(R.id.nombreCancion);
        cancionArtista = findViewById(R.id.cancionArtista);
        playButton = findViewById(R.id.play);
        nextButton = findViewById(R.id.next);
        prevButton = findViewById(R.id.previous);

        Intent intent = getIntent();
        String json = intent.getStringExtra(Constantes.CANCION);
        String json1 = intent.getStringExtra(Constantes.LISTA_CANCION);

        try {
            Type listType = new TypeToken<ArrayList<Cancion>>() {
            }.getType();
            canciones = gson.fromJson(json1, listType);
        } catch (Exception e) {
        }

        final Cancion cancion = gson.fromJson(json, Cancion.class);
        nombreCancion.setText(cancion.getNombreCancion());
        cancionArtista.setText(cancion.getCancionArtsta());
        imagenCancion.setImageResource(cancion.getImagenCancion());
        url = cancion.getUrl();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    playButton.setBackgroundResource(R.drawable.pauseu);
                    playMp3(url);
                } else {
                    playButton.setBackgroundResource(R.drawable.playu);
                    mediaPlayer.pause();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canciones.size() > 1) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        goToNext(cancion);
                    } else {
                        goToNext(cancion);
                    }
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canciones.size() > 1) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        goToPrev(cancion);
                    } else {
                        goToPrev(cancion);
                    }
                }
            }
        });

        actionBar();
    }

    @Override
    protected void onStop() {
        mediaPlayer.stop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    public void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void playMp3(String _link) {

        mediaPlayer.reset();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(_link);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnPreparedListener(this);
            //mediaPlayer.prepare(); // might take long! (for buffering, etc)   //@@
            mediaPlayer.prepareAsync();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void goToNext(Cancion actual) {
        if (canciones.size() > 1) {
            if (actual.getIdCancion() + 1 < canciones.size()) {
                Cancion siguiente = canciones.get(actual.getIdCancion() + 1);
                Intent intent = new Intent(context, CancionActivity.class);
                intent.putExtra(Constantes.CANCION, gson.toJson(siguiente));
                intent.putExtra(Constantes.LISTA_CANCION, gson.toJson(canciones));
                startActivity(intent);
            } else {
                Cancion siguiente = canciones.get(0);
                Intent intent = new Intent(context, CancionActivity.class);
                intent.putExtra(Constantes.CANCION, gson.toJson(siguiente));
                intent.putExtra(Constantes.LISTA_CANCION, gson.toJson(canciones));
                startActivity(intent);
            }
        }
    }

    private void goToPrev(Cancion actual) {
        if (canciones.size() > 1) {
            if (actual.getIdCancion() > 0) {
                Cancion anterior = canciones.get(actual.getIdCancion() - 1);
                Intent intent = new Intent(context, CancionActivity.class);
                intent.putExtra(Constantes.CANCION, gson.toJson(anterior));
                intent.putExtra(Constantes.LISTA_CANCION, gson.toJson(canciones));
                startActivity(intent);
            } else {
                Cancion anterior = canciones.get(canciones.size() - 1);
                Intent intent = new Intent(context, CancionActivity.class);
                intent.putExtra(Constantes.CANCION, gson.toJson(anterior));
                intent.putExtra(Constantes.LISTA_CANCION, gson.toJson(canciones));
                startActivity(intent);
            }
        }
    }

}
