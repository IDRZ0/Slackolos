package com.slackolos.kaumamusic;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.slackolos.kaumamusic.adapters.ArtistaAdapter;
import com.slackolos.kaumamusic.adapters.FiestasAdapter;
import com.slackolos.kaumamusic.fiestas.Fiesta;
import com.slackolos.kaumamusic.listas.Artista;

import java.util.ArrayList;
import java.util.List;

    public class FiestasActivity extends AppCompatActivity {

        ArrayList<Fiesta> listaFiestas;
        RecyclerView recyclerFiestas;

        @Override
        protected void onCreate(@Nullable final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lis_fiestas);

            listaFiestas = new ArrayList<>();
            recyclerFiestas = (RecyclerView) findViewById(R.id.recycler_fiestas);
            //recyclerFiestas.setLayoutManager(new LinearLayoutManager(this));
            recyclerFiestas.setLayoutManager(new GridLayoutManager(this,2));

            llenar();
            FiestasAdapter adapter = new FiestasAdapter(listaFiestas);

            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), ""+listaFiestas.get(recyclerFiestas.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
            recyclerFiestas.setAdapter(adapter);
        }

        private void llenar() {
            listaFiestas.add(new Fiesta(R.drawable.loto,"LOTO"));
            listaFiestas.add(new Fiesta(R.drawable.loki,"LOKI"));
            listaFiestas.add(new Fiesta(R.drawable.beyond,"BEYOND"));
        }

    }
