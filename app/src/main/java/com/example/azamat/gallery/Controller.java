package com.example.azamat.gallery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Controller {

    @GET ("services/rest/?method=flickr.photos.search&api_key=d255e1cdb3e92e0d797ff45497e9f45c&per_page=80&page=1&format=json&nojsoncallback=1")
    Call<Pojo> getData(@Query("text")String searcher);

}
