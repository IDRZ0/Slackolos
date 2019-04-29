package com.slackolos.kaumamusic.inventario;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Cancion;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public static List<Cancion> getCanciones() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"m","n", R.drawable.cover));
        canciones.add(new Cancion(2,"m","n", R.drawable.cover));
        canciones.add(new Cancion(3,"m","n", R.drawable.cover));
        return canciones;
    }
}
