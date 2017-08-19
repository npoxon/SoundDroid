package uk.co.peartree_productions.sounddroid.soundcloud;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface SoundCloudService {

    static final String CLIENT_ID = "3befb35ea60591f17ec8e049e428b801";

    @GET("/tracks?client_id=" +CLIENT_ID)
    public void searchSongs(@Query("q") String query, Callback<List<Track>> cb);

    @GET("/tracks?client_id=" +CLIENT_ID)
    public void getMostRecent(@Query("created_at[from]") String date, Callback<List<Track>> cb);

}


