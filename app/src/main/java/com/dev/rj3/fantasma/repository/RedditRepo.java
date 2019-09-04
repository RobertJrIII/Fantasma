package com.dev.rj3.fantasma.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dev.rj3.fantasma.model.Feed;
import com.dev.rj3.fantasma.model.children.Children;
import com.dev.rj3.fantasma.model.children.Entry;
import com.dev.rj3.fantasma.posts.Post;
import com.dev.rj3.fantasma.retrofit.RedditAPI;
import com.dev.rj3.fantasma.retrofit.RetrofitRequest;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RedditRepo {

    private RedditAPI redditAPI;


    public RedditRepo() {
        redditAPI = RetrofitRequest.getRetrofitInstance().create(RedditAPI.class);
    }

    public LiveData<ArrayList<Post>> getRedditPosts() {
        final MutableLiveData<ArrayList<Post>> postData = new MutableLiveData<>();

        Call<Feed> feed = redditAPI.getData();
        feed.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                if (!response.isSuccessful()) {
                    postData.setValue(null);
                    return;
                }
                ArrayList<Children> childrenArrayList = response.body().getData().getChildren();
                ArrayList<Post> posts = new ArrayList<>();
                for (Children children : childrenArrayList) {
                    Entry entry = children.getEntry();

                    posts.add(new Post(entry.getTitle(), entry.getSubreddit_name_prefixed(), entry.getThumbnail()));
                }

                postData.setValue(posts);
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                postData.setValue(null);
            }
        });
        return postData;
    }
}
