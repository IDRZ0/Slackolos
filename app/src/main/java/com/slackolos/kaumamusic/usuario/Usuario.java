package com.slackolos.kaumamusic.usuario;

import com.google.gson.annotations.Expose;

public class Usuario {

    @Expose
    private String nombre;

    @Expose
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
