package com.slackolos.kaumamusic.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.slackolos.kaumamusic.usuario.Usuario;

public class BaseHelper {

    private SQLiteDatabase base;

    public BaseHelper(Context context) {
        Base instancia = new Base(context);
        this.base = instancia.getWritableDatabase();
    }

    public void insertar(Usuario usuario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("usuario", usuario.getNombre());
        contentValues.put("password", usuario.getPassword());

        this.base.insert("usuarios", null, contentValues);
        this.base.close();
    }

    public boolean login(String usuario, String password){
        String[] params = new String[2];
        params[0] = usuario;
        params[1] = password;

        Cursor cursor = this.base.rawQuery("SELECT usuario, password FROM usuarios WHERE usuario=? AND password=?", params);
        if(cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }

}
