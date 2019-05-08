package com.slackolos.kaumamusic.inventario;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Artista;
import com.slackolos.kaumamusic.listas.Cancion;
import com.slackolos.kaumamusic.listas.Fiesta;
import com.slackolos.kaumamusic.listas.Playlist;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public static List<Playlist> getPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist(1, "Fiesta", R.drawable.cover));
        playlists.add(new Playlist(2,"Estudiar", R.drawable.cover));
        return playlists;
    }

    public static List<Artista> getArtistas() {
        List<Artista> artistas = new ArrayList<>();
        artistas.add(new Artista(1,"Sech", R.drawable.cover));
        artistas.add(new Artista(2,"Darell", R.drawable.cover));
        return artistas;
    }

    public static ArrayList<Fiesta> getFiestas() {
        ArrayList<Fiesta> fiestas = new ArrayList<>();
        fiestas.add(new Fiesta(R.drawable.loto,"LOTO"));
        fiestas.add(new Fiesta(R.drawable.legend,"LEGEND"));
        fiestas.add(new Fiesta(R.drawable.beyond,"BEYOND"));
        fiestas.add(new Fiesta(R.drawable.kanuma,"KAÑUMA BAR"));
        return fiestas;
    }

    public static List<Cancion> Fiesta() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(2,"Si Se Da","Myke Towers", R.drawable.cover,""));
        canciones.add(new Cancion(3,"Que Le De","Rauw Alejandro", R.drawable.cover,"http://youtubemp33.net/@download/320-5cd183c57491f-8920000/mp3/8JnfIa84TnU/Clean%2BBandit%2B-%2BSolo%2B%2528feat.%2BDemi%2BLovato%2529%2B%255BOfficial%2BVideo%255D.mp3"));
        return canciones;
    }

    public static List<Cancion> Estudiar() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(2,"Si Se Da","Myke Towers", R.drawable.cover,""));
        return canciones;
    }

    public static List<Cancion> Darell() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(2,"Si Se Da","Myke Towers", R.drawable.cover,""));
        return canciones;
    }

    public static List<Cancion> Sech() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(3,"Que Le De","Rauw Alejandro", R.drawable.cover,"http://youtubemp33.net/@download/320-5cd183c57491f-8920000/mp3/8JnfIa84TnU/Clean%2BBandit%2B-%2BSolo%2B%2528feat.%2BDemi%2BLovato%2529%2B%255BOfficial%2BVideo%255D.mp3"));
        return canciones;
    }

    public static List<Cancion> Todas() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(3,"Que Le De","Rauw Alejandro", R.drawable.cover,"http://youtubemp33.net/@download/320-5cd183c57491f-8920000/mp3/8JnfIa84TnU/Clean%2BBandit%2B-%2BSolo%2B%2528feat.%2BDemi%2BLovato%2529%2B%255BOfficial%2BVideo%255D.mp3"));
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(2,"Si Se Da","Myke Towers", R.drawable.cover,""));
        return canciones;
    }
}
