package com.dev.rj3.fantasma.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.dev.rj3.fantasma.model.PostDataSourceFactory;
import com.dev.rj3.fantasma.model.children.Entry;
import com.dev.rj3.fantasma.retrofit.RedditAPI;
import com.dev.rj3.fantasma.retrofit.RetrofitInstance;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class PostViewModel extends AndroidViewModel {

    private LiveData<PagedList<Entry>> pagedListLiveData;
    private PostDataSourceFactory postDataSourceFactory;

    @SuppressWarnings("unchecked")
    public PostViewModel(@NonNull Application application) {
        super(application);


        RedditAPI redditAPI = RetrofitInstance.getRetrofitInstance();
        postDataSourceFactory = new PostDataSourceFactory(redditAPI, application);

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(25)
                .build();


        pagedListLiveData = (new LivePagedListBuilder(postDataSourceFactory, config)).build();

    }

    public LiveData<PagedList<Entry>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    public PostDataSourceFactory getPostDataSourceFactory() {
        return postDataSourceFactory;
    }
}
