package com.slackolos.kaumamusic.inventario;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Artista;
import com.slackolos.kaumamusic.listas.Cancion;
import com.slackolos.kaumamusic.listas.Fiesta;
import com.slackolos.kaumamusic.listas.Playlist;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public static List<Cancion> getCanciones() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.cover));
        canciones.add(new Cancion(2,"Si Se Da","Myke Towers", R.drawable.cover));
        canciones.add(new Cancion(3,"Que Le De","Rauw Alejandro", R.drawable.cover));
        return canciones;
    }

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

}
