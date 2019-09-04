package com.dev.rj3.fantasma.retrofit;

import com.dev.rj3.fantasma.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditAPI {

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<Feed> getData();


    @Headers("Content-Type: application/json")
    @GET("{subName}/.json")
    Call<Feed> getData(@Path("subName") String subName);

    @Headers("Content-Type: application/json")
    @GET("search.json")
    Call<Feed> getSearchResults(@Query("q") String query);

}
