package com.slackolos.kaumamusic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.slackolos.kaumamusic.adapters.FiestasAdapter;
import com.slackolos.kaumamusic.inventario.Inventario;
import com.slackolos.kaumamusic.listas.Fiesta;

import java.util.ArrayList;

public class FiestasActivity extends AppCompatActivity {

        ArrayList<Fiesta> listaFiestas;
        RecyclerView recyclerFiestas;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lis_fiestas);

            listaFiestas = new ArrayList<>();
            recyclerFiestas = (RecyclerView) findViewById(R.id.recycler_fiestas);
            recyclerFiestas.setLayoutManager(new GridLayoutManager(this,2));

            listaFiestas = Inventario.getFiestas();

            FiestasAdapter adapter = new FiestasAdapter(listaFiestas);

            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), ""+listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
                    String nombre = listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre();
                    if(listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre() == "LOTO"){
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=-16.540776, -68.070361 (" + nombre + ")"));
                        startActivity(intent);
                    } else if(listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre() == "BEYOND"){
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=-16.531849, -68.073612 (" + nombre + ")"));
                        startActivity(intent);
                    }
                    else if(listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre() == "KAÑUMA BAR"){
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=-16.577840, -68.163113 (" + nombre + ")"));
                        startActivity(intent);
                    }
                    else if(listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre() == "LEGEND"){
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=-16.505185, -68.128834 (" + nombre + ")"));
                        startActivity(intent);
                    }
                }
            });
            recyclerFiestas.setAdapter(adapter);

            actionBar();
        }

    public void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

}
