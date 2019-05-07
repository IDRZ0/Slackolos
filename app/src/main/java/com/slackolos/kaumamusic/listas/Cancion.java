package com.slackolos.kaumamusic.listas;

import com.google.gson.annotations.Expose;

public class Cancion {

    @Expose
    private int idCancion;

    @Expose
    private String nombreCancion;

    @Expose
    private String cancionArtsta;

    @Expose
    private int imagenCancion;

    @Expose
    private String url;

   public Cancion (int idCancion, String nombreCancion, String cancionArtsta, int imagenCancion, String url) {
       this.idCancion = idCancion;
       this.nombreCancion = nombreCancion;
       this.cancionArtsta = cancionArtsta;
       this.imagenCancion = imagenCancion;
       this.url = url;
   }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getCancionArtsta() {
        return cancionArtsta;
    }

    public void setCancionArtsta(String cancionArtsta) {
        this.cancionArtsta = cancionArtsta;
    }

    public int getImagenCancion() {
        return imagenCancion;
    }

    public void setImagenCancion(int imagenCancion) {
        this.imagenCancion = imagenCancion;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }
}
