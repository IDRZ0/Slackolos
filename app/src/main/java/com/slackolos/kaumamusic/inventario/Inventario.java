package com.slackolos.kaumamusic.inventario;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Cancion;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public static List<Cancion> getCanciones() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.otro));
        canciones.add(new Cancion(2,"Si Se Da","Myke Towers", R.drawable.sise));
        canciones.add(new Cancion(3,"Que Le De","Rauw Alejandro", R.drawable.quelede));
        return canciones;
    }
}
