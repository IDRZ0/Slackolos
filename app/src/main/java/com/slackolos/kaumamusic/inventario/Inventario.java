package com.slackolos.kaumamusic.inventario;

import com.slackolos.kaumamusic.R;
import com.slackolos.kaumamusic.listas.Artista;
import com.slackolos.kaumamusic.listas.Cancion;
import com.slackolos.kaumamusic.listas.Fiesta;
import com.slackolos.kaumamusic.listas.Playlist;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    public static List<Playlist> getPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist(0, "Fiesta", R.drawable.party));
        playlists.add(new Playlist(1,"Estudiar", R.drawable.study));
        return playlists;
    }

    public static List<Artista> getArtistas() {
        List<Artista> artistas = new ArrayList<>();
        artistas.add(new Artista(0,"Sech", R.drawable.sech));
        artistas.add(new Artista(1,"Paulo Londra", R.drawable.paulo));
        return artistas;
    }

    public static ArrayList<Fiesta> getFiestas() {
        ArrayList<Fiesta> fiestas = new ArrayList<>();
        fiestas.add(new Fiesta(R.drawable.loto,"LOTO"));
        fiestas.add(new Fiesta(R.drawable.legend,"LEGEND"));
        fiestas.add(new Fiesta(R.drawable.beyond,"BEYOND"));
        fiestas.add(new Fiesta(R.drawable.kanuma,"KAÑUMA BAR"));
        return fiestas;
    }

    public static List<Cancion> Fiesta() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(0,"La Resaka","Supermerk2", R.drawable.la_resaka,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/la%20resaka-supermerk2.mp3?alt=media&token=da46df14-8a51-4f86-a3f2-e60531905fe7"));
        canciones.add(new Cancion(1,"Otro Trago","Sech", R.drawable.otro_trago,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(2,"Calma","Pedro Capo", R.drawable.calma,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Pedro%20Cap%C3%B3%20Farruko%20-%20Calma%20(Remix%20-%20Official%20Video).mp3?alt=media&token=7440426f-a60d-45de-b943-2e18aa9de1b5"));
        return canciones;
    }

    public static List<Cancion> Estudiar() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(0,"Calma","Pedro Capo", R.drawable.calma,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Pedro%20Cap%C3%B3%20Farruko%20-%20Calma%20(Remix%20-%20Official%20Video).mp3?alt=media&token=7440426f-a60d-45de-b943-2e18aa9de1b5"));
        canciones.add(new Cancion(1,"Sunflower","Post Malone", R.drawable.sunflower,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Post%20Malone%20Swae%20Lee%20-%20Sunflower.mp3?alt=media&token=feab98f3-c1b9-48da-a944-50bd881b83ae"));
        return canciones;
    }

    public static List<Cancion> Paulo() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(0,"Tal Vez","Paulo Londra", R.drawable.tal_vez,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Paulo%20Londra%20-%20Tal%20Vez.mp3?alt=media&token=1d0ace0f-e345-42ef-b39c-d69e6f4127b4"));
        return canciones;
    }

    public static List<Cancion> Sech() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(0,"Otro Trago","Sech", R.drawable.otro_trago,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        return canciones;
    }

    public static List<Cancion> Todas() {
        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion(0,"Otro Trago","Sech", R.drawable.otro_trago,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/sech_song.mp3?alt=media&token=397b6750-863b-424d-8db2-e94483cb9e4b"));
        canciones.add(new Cancion(1,"Caraluna","Bacilos", R.drawable.caraluna,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Bacilos%20-%20Caraluna.mp3?alt=media&token=31260099-4501-4062-a808-d10e951b03dc"));
        canciones.add(new Cancion(2,"Mientes","Camila", R.drawable.mientes,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Camila%20-%20Mientes.mp3?alt=media&token=4717edb3-4fa6-4894-bc31-37c68b0b1817"));
        canciones.add(new Cancion(3,"La Flaca","Jarabe De Palo", R.drawable.la_flaca,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Jarabe%20De%20Palo%20-%20La%20Flaca.mp3?alt=media&token=e0b69114-d2ce-4447-a4d4-0dcdd6b39fd6"));
        canciones.add(new Cancion(4,"I'm Yours","Jason Mraz", R.drawable.im_yours,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Jason%20Mraz%20-%20Im%20Yours.mp3?alt=media&token=c201120b-1ff4-429d-8a79-4368baf4a7c9"));
        canciones.add(new Cancion(5,"Pursuit Of Happiness","Kid Cudi", R.drawable.pursuit_of_happiness,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Kid%20Cudi%20-%20Pursuit%20Of%20Happiness.mp3?alt=media&token=a66ab343-3c5d-4ab9-ae22-17fa930da404"));
        canciones.add(new Cancion(6,"La Resaka","Supermerk2", R.drawable.la_resaka,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/la%20resaka-supermerk2.mp3?alt=media&token=da46df14-8a51-4f86-a3f2-e60531905fe7"));
        canciones.add(new Cancion(7,"She Will Be Loved","Maroon 5", R.drawable.she_will_be_loved,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/maroon5_song.mp3?alt=media&token=ec6462fd-ba8a-4560-a5d0-c9a701bcf610"));
        canciones.add(new Cancion(8,"Pasarela","Dalmata", R.drawable.pasarela,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Pasarela%20%20Dalmata%20-%20Video%20Oficial.mp3?alt=media&token=5f3a3acd-0576-4b2f-adc1-15d381afce55"));
        canciones.add(new Cancion(9,"Tal Vez","Paulo Londra", R.drawable.tal_vez,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Paulo%20Londra%20-%20Tal%20Vez.mp3?alt=media&token=1d0ace0f-e345-42ef-b39c-d69e6f4127b4"));
        canciones.add(new Cancion(10,"Calma","Pedro Capo", R.drawable.calma,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Pedro%20Cap%C3%B3%20Farruko%20-%20Calma%20(Remix%20-%20Official%20Video).mp3?alt=media&token=7440426f-a60d-45de-b943-2e18aa9de1b5"));
        canciones.add(new Cancion(11,"Sunflower","Post Malone", R.drawable.sunflower,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Post%20Malone%20Swae%20Lee%20-%20Sunflower.mp3?alt=media&token=feab98f3-c1b9-48da-a944-50bd881b83ae"));
        canciones.add(new Cancion(12,"Pumped Up Kicks","Foster The People", R.drawable.pumped_up_kicks,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Pumped%20Up%20Kicks.mp3?alt=media&token=4ebbfe73-34aa-4e3a-aac5-c9834cbcab7e"));
        canciones.add(new Cancion(13,"The Scientist","Coldplay", R.drawable.the_scientist,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/The%20Scientist%20-Coldplay.mp3?alt=media&token=fad6a354-ab9f-45d2-b2b2-eb7fc5312238"));
        canciones.add(new Cancion(14,"See You Again","Wiz Khalifa", R.drawable.see_you_again,"https://firebasestorage.googleapis.com/v0/b/canciones-mp3.appspot.com/o/Wiz%20Khalifa%20-%20See%20You%20Again%20ft.%20Charlie%20Puth.mp3?alt=media&token=799e0388-1e2c-447e-8169-5e4f5e441a31"));

        return canciones;
    }
}
