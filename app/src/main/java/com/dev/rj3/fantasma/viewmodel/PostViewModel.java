package com.dev.rj3.fantasma.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dev.rj3.fantasma.posts.Post;
import com.dev.rj3.fantasma.repository.RedditRepo;


import java.util.ArrayList;


public class PostViewModel extends AndroidViewModel {
    private RedditRepo redditRepo;
    private LiveData<ArrayList<Post>> listLiveData;

    public PostViewModel(@NonNull Application application) {
        super(application);

        redditRepo = new RedditRepo();
        listLiveData = redditRepo.getRedditPosts();
    }


    public LiveData<ArrayList<Post>> getPostLiveData() {
        return listLiveData;
    }
}
