package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import static android.content.Context.*;

public class MainActivity extends AppCompatActivity {

    private Context mcontext;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext = this;
        initViews();
        recibirDatos();

        if (this.toolbar != null) {

         //   this.toolbar.setTitle(R.string.app_name);
         //   this.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorAccent));

            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
            drawerToggle.setDrawerIndicatorEnabled(false);
            drawerToggle.setHomeAsUpIndicator(R.drawable.icon_hamburger);
            drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });

        }

    }

    public void initViews() {
        this.toolbar = findViewById(R.id.toolbar);
        this.drawerLayout = findViewById(R.id.navigationDrawer);
    }


    public void recibirDatos() {
        Intent intent = getIntent();
        String usuario = intent.getStringExtra("usuario");
        String contraseña = intent.getStringExtra("password");
        TextView tUser = findViewById(R.id.tUser);
        tUser.setText(usuario);

        //Toast.makeText(this, "Bienvenid@ " + usuario, Toast.LENGTH_SHORT).show();
    }

    public void listaCancion(View view) {
        Intent intent = new Intent(mcontext, ListaCancionActivity.class);
        startActivity(intent);
    }

    public void listaPlaylist(View view) {
        Intent intent = new Intent(mcontext, PlaylistActivity.class);
        startActivity(intent);
    }

    public void listaArtista(View view) {
        Intent intent = new Intent(mcontext, ArtistaActivity.class);
        startActivity(intent);
    }

    public void listaFiesta(View view) {
        Intent intent = new Intent(mcontext, FiestasActivity.class);
        startActivity(intent);
    }

    public void cerrarSesion(View view) {
        LoginActivity.chageEstadoButton(mcontext,false);
        Intent intent = new Intent(mcontext, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}