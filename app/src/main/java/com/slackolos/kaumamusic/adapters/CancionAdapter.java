package com.slackolos.kaumamusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.slackolos.kaumamusic.ListaCancionActivity;
import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Cancion;

import java.util.List;

public class CancionAdapter extends BaseAdapter {

    private Context context;
    private List<Cancion> songs;

    public CancionAdapter(Context context, List<Cancion> songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return songs.get(position).getIdCancion();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.cancion_layout, null);

            viewHolder.imagenCancion = vista.findViewById(R.id.imagenCancion);
            viewHolder.nombreCancion = vista.findViewById(R.id.nombreCancion);
            viewHolder.cancionArtista = vista.findViewById(R.id.cancionArtista);
            vista.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vista.getTag();
        }

        Cancion cancionActual = songs.get(position);
        viewHolder.imagenCancion.setImageResource(cancionActual.getImagenCancion());
        viewHolder.nombreCancion.setText(cancionActual.getNombreCancion());
        viewHolder.cancionArtista.setText(cancionActual.getCancionArtsta());
        return vista;
    }

    static class ViewHolder {
        ImageView imagenCancion;
        TextView nombreCancion;
        TextView cancionArtista;
    }
}
