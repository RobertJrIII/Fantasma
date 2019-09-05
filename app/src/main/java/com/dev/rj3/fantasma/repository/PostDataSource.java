package com.dev.rj3.fantasma.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.dev.rj3.fantasma.model.Feed;
import com.dev.rj3.fantasma.model.children.Children;
import com.dev.rj3.fantasma.model.children.Entry;
import com.dev.rj3.fantasma.posts.Post;
import com.dev.rj3.fantasma.retrofit.RedditAPI;
import com.dev.rj3.fantasma.retrofit.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDataSource extends PageKeyedDataSource<String, Post> {

    private RedditAPI redditAPI;
    private Application application;

    public PostDataSource(RedditAPI redditAPI, Application application) {
        this.redditAPI = redditAPI;
        this.application = application;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull final LoadInitialCallback<String, Post> callback) {
        redditAPI = RetrofitInstance.getRetrofitInstance().create(RedditAPI.class);

        Call<Feed> call = redditAPI.getRedditData("");


        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                if (!response.isSuccessful()) {

                    return;
                }

                ArrayList<Post> posts = new ArrayList<>();
                ArrayList<Children> childrenArrayList = response.body().getData().getChildren();

                if (response.body() != null && childrenArrayList != null) {


                    for (Children children : childrenArrayList) {
                        Entry entry = children.getEntry();
                        Post post = new Post(entry.getTitle(), entry.getSubreddit_name_prefixed(), entry.getThumbnail());
                        post.setName(entry.getName());
                        posts.add(post);
                    }
                    callback.onResult(posts, null, posts.get(posts.size() - 1).getName());
                    //  postData.setValue(posts);


                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Post> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<String> params, @NonNull final LoadCallback<String, Post> callback) {
        redditAPI = RetrofitInstance.getRetrofitInstance().create(RedditAPI.class);

        Call<Feed> call = redditAPI.getRedditData(params.key);


        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                if (!response.isSuccessful()) {
                    //  postData.setValue(null);
                    return;
                }
                ArrayList<Children> childrenArrayList = response.body().getData().getChildren();
                ArrayList<Post> posts = new ArrayList<>();


                if (response.body() != null && childrenArrayList != null) {
                    for (Children children : childrenArrayList) {
                        Entry entry = children.getEntry();
                        Post post = new Post(entry.getTitle(), entry.getSubreddit_name_prefixed(), entry.getThumbnail());
                        post.setName(entry.getName());
                        posts.add(post);
                    }
                    callback.onResult(posts, params.key);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });
    }
}
