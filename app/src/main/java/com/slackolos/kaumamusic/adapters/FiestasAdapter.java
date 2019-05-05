package com.slackolos.kaumamusic.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Fiesta;

import java.util.ArrayList;

public class FiestasAdapter extends RecyclerView.Adapter<FiestasAdapter.ViewHolderFiestas>
    implements View.OnClickListener{

    private ArrayList<Fiesta> listaFiestas;
    private View.OnClickListener listener;

    public FiestasAdapter(ArrayList<Fiesta> listaFiestas) {
        this.listaFiestas = listaFiestas;
    }

    @NonNull
    @Override
    public ViewHolderFiestas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_fiestas,null,false);
        view.setOnClickListener(this);
        return new ViewHolderFiestas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFiestas viewHolderFiestas, int i) {
        viewHolderFiestas.imagen.setImageResource(listaFiestas.get(i).getImagen());
        viewHolderFiestas.nombre.setText(listaFiestas.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaFiestas.size();
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderFiestas extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre;

        public ViewHolderFiestas(@NonNull View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imageFiesta);
            nombre = (TextView) itemView.findViewById(R.id.nameFiesta);

        }
    }
}
