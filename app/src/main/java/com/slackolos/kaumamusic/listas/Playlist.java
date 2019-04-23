package com.slackolos.kaumamusic.listas;

import com.google.gson.annotations.Expose;

public class Playlist {

    @Expose
    private int idPlaylist;

    @Expose
    private String nombrePlaylist;

    @Expose
    private int imagenPlaylist;

    public Playlist(int idPlaylist, String nombrePlaylist, int imagenPlaylist) {
        this.idPlaylist = idPlaylist;
        this.nombrePlaylist = nombrePlaylist;
        this.imagenPlaylist = imagenPlaylist;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public int getImagenPlaylist() {
        return imagenPlaylist;
    }

    public void setImagenPlaylist(int imagenPlaylist) {
        this.imagenPlaylist = imagenPlaylist;
    }
}
