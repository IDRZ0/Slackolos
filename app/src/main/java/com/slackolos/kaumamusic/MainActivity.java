package com.slackolos.kaumamusic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

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

            this.toolbar.setTitle(R.string.app_name);
            this.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.colorAccent));

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

        Toast.makeText(this, "Bienvenid@ "+usuario, Toast.LENGTH_SHORT).show();
    }

}