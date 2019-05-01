package com.slackolos.kaumamusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Playlist;

public class PlaylistAdapter extends BaseAdapter{

    private Context context;
    private List<Playlist> playlists;

    public PlaylistAdapter(Context context, List<Playlist> playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    @Override
    public int getCount() {
        return playlists.size();
    }

    @Override
    public Object getItem(int position) {
        return playlists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return playlists.get(position).getIdPlaylist();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.playlist_layout, null);

            viewHolder.imagenPlaylist = vista.findViewById(R.id.imagenPlaylist);
            viewHolder.nombrePlaylist = vista.findViewById(R.id.nombrePlaylist);
            vista.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vista.getTag();
        }

        Playlist playlistActual = playlists.get(position);
        viewHolder.imagenPlaylist.setImageResource(playlistActual.getImagenPlaylist());
        viewHolder.nombrePlaylist.setText(playlistActual.getNombrePlaylist());
        return vista;
    }

    static class ViewHolder {
        ImageView imagenPlaylist;
        TextView nombrePlaylist;
    }
}
