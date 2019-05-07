package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.slackolos.kaumamusic.constantes.Constantes;
import com.slackolos.kaumamusic.listas.Cancion;

import java.io.IOException;


public class CancionActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {

    private Context context;
    private ImageView imagenCancion;
    private TextView nombreCancion;
    private TextView cancionArtista;
    private String url;
    private Button playButton;
    private Button pauseButton;

    private MediaPlayer mediaPlayer;

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


        Intent intent = getIntent();
        String json = intent.getStringExtra(Constantes.CANCION);
        Cancion cancion = new Gson().fromJson(json, Cancion.class);
        nombreCancion.setText(cancion.getNombreCancion());
        cancionArtista.setText(cancion.getCancionArtsta());
        imagenCancion.setImageResource(cancion.getImagenCancion());
        url = cancion.getUrl();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton.setBackgroundResource(R.drawable.pause);
                playMp3(url);
                if(playButton.getBackground().equals(R.drawable.pause)){
                    playButton.setBackgroundResource(R.drawable.play);
                    mediaPlayer.pause();
                } //else if(playButton.getBackground().equals(R.drawable.pause)){ }
            }
        });
    }

   // public void play(View view) { playMp3("http://youtubemp33.net/@download/320-5cd183c57491f-8920000/mp3/8JnfIa84TnU/Clean%2BBandit%2B-%2BSolo%2B%2528feat.%2BDemi%2BLovato%2529%2B%255BOfficial%2BVideo%255D.mp3"); }

    public void pause(View view) {
        mediaPlayer.pause();
    }

    public void playMp3(String _link){

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
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }
}
