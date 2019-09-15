package com.dev.rj3.fantasma.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dev.rj3.fantasma.model.PostDataSourceFactory;
import com.dev.rj3.fantasma.posts.Post;
import com.dev.rj3.fantasma.retrofit.RedditAPI;
import com.dev.rj3.fantasma.retrofit.RetrofitInstance;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class PostViewModel extends AndroidViewModel {

    private Executor executor;
    private LiveData<PagedList<Post>> pagedListLiveData;
    private PostDataSourceFactory postDataSourceFactory;

    @SuppressWarnings("unchecked")
    public PostViewModel(@NonNull Application application) {
        super(application);


        RedditAPI redditAPI = RetrofitInstance.getRetrofitInstance();
        postDataSourceFactory = new PostDataSourceFactory(redditAPI, application);


        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                //.setInitialLoadSizeHint(10)
                .setPageSize(25)
                .setPrefetchDistance(4)
                .build();

        executor = Executors.newFixedThreadPool(5);


        pagedListLiveData = (new LivePagedListBuilder<String, Post>(postDataSourceFactory, config))
                .setFetchExecutor(executor).build();


    }

    public LiveData<PagedList<Post>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    public PostDataSourceFactory getPostDataSourceFactory() {
        return postDataSourceFactory;
    }
}
