package com.dev.rj3.fantasma.retrofit;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String front_BASE_URL = "https://api.reddit.com/";
    public static final String BASE_URL = "https://api.reddit.com/r/";

    public static RedditAPI getRetrofitInstance() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RedditAPI.class);
    }
}
