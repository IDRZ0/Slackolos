package com.slackolos.kaumamusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Artista;

import java.util.List;

public class ArtistaAdapter extends BaseAdapter {

    private Context context;
    private List<Artista> artist;

    public ArtistaAdapter(Context context, List<Artista> artist) {
        this.context = context;
        this.artist = artist;
    }

    @Override
    public int getCount() {
        return artist.size();
    }

    @Override
    public Object getItem(int position) {
        return artist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return artist.get(position).getIdArtista();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.artista_layout, null);

            viewHolder.imagenArtista = vista.findViewById(R.id.imagenArtista);
            viewHolder.nombreArtista = vista.findViewById(R.id.nombreArtista);
            vista.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vista.getTag();
        }

        Artista artistaActual = artist.get(position);
        viewHolder.imagenArtista.setImageResource(artistaActual.getImagenArtista());
        viewHolder.nombreArtista.setText(artistaActual.getNombreArtista());
        return vista;
    }

    static class ViewHolder {
        ImageView imagenArtista;
        TextView nombreArtista;
    }
}
