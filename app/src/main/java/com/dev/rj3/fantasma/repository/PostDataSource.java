package com.dev.rj3.fantasma.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.dev.rj3.fantasma.model.Feed;
import com.dev.rj3.fantasma.model.children.Children;
import com.dev.rj3.fantasma.model.children.Entry;
import com.dev.rj3.fantasma.retrofit.RedditAPI;
import com.dev.rj3.fantasma.retrofit.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDataSource extends PageKeyedDataSource<String, Entry> {

    private RedditAPI redditAPI;
    private Application application;
    private String SubName = "";

    public PostDataSource(RedditAPI redditAPI, Application application) {
        this.redditAPI = redditAPI;
        this.application = application;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull final LoadInitialCallback<String, Entry> callback) {
        redditAPI = RetrofitInstance.getRetrofitInstance();

        Call<Feed> call = redditAPI.getSubRedditData(getSubName(), null);


        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                ArrayList<Entry> posts = new ArrayList<>();
                ArrayList<Children> childrenArrayList = response.body().getData().getChildren();

                if (response.body() != null && childrenArrayList != null) {


                    for (Children children : childrenArrayList) {
                        Entry entry = children.getEntry();

                        posts.add(entry);
                    }
                    callback.onResult(posts, null, posts.get(posts.size() - 1).getName());


                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Entry> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<String> params, @NonNull final LoadCallback<String, Entry> callback) {
        redditAPI = RetrofitInstance.getRetrofitInstance();

        Call<Feed> call = redditAPI.getSubRedditData(getSubName(), params.key);


        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {


                ArrayList<Children> childrenArrayList = response.body().getData().getChildren();
                ArrayList<Entry> posts = new ArrayList<>();


                if (response.body() != null && childrenArrayList != null) {
                    for (Children children : childrenArrayList) {
                        Entry entry = children.getEntry();

                        posts.add(entry);
                    }
                    callback.onResult(posts, posts.get(posts.size() - 1).getName());
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });
    }




}
