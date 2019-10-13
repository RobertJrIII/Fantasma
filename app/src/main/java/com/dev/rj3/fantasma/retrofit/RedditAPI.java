package com.dev.rj3.fantasma.retrofit;

import com.dev.rj3.fantasma.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditAPI {


    @Headers("Content-Type: application/json")
    @GET()
    Call<Feed> getSubRedditData();

    @Headers("Content-Type: application/json")
    @GET("{subName}/")
    Call<Feed> getSubRedditData(@Path("subName") String subName, @Query("after") String after);

    @Headers("Content-Type: application/json")
    @GET("search")
    Call<Feed> getSearchResults(@Query("q") String query);


    @Headers("Content-Type: application/json")
    @GET()
    Call<Feed> getFrontPageData(@Query("after") String after);


}
