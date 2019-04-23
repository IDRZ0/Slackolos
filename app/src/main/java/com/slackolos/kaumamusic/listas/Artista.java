package com.slackolos.kaumamusic.listas;

import com.google.gson.annotations.Expose;

public class Artista {

    @Expose
    private int idArtista;

    @Expose
    private String nombreArtista;

    @Expose
    private int imagenArtista;

    public Artista(int idArtista, String nombreArtista, int imagenArtista) {
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.imagenArtista = imagenArtista;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public int getImagenArtista() {
        return imagenArtista;
    }

    public void setImagenArtista(int imagenArtista) {
        this.imagenArtista = imagenArtista;
    }
}
