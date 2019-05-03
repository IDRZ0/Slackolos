package com.slackolos.kaumamusic.fiestas;

import android.widget.ImageView;
import android.widget.TextView;

public class Fiesta {

    private int imagen;
    private String nombre;

    public Fiesta(){

    }
    public Fiesta(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
