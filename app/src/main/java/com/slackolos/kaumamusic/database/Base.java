package com.slackolos.kaumamusic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.slackolos.kaumamusic.constantes.Constantes;

public class Base extends SQLiteOpenHelper {

    public Base(Context context) {
        super(context, Constantes.N_BASE,null, Constantes.V_BASE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (usuario VARCHAR NOT NULL, password VARCHAR NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
