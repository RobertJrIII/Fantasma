package com.dev.rj3.fantasma.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.dev.rj3.fantasma.repository.PostDataSource;
import com.dev.rj3.fantasma.retrofit.RedditAPI;

public class PostDataSourceFactory extends DataSource.Factory {

    private PostDataSource postDataSource;
    private RedditAPI redditAPI;
    private Application application;
    private MutableLiveData<PostDataSource> mutableLiveData;

    public PostDataSourceFactory(RedditAPI redditAPI, Application application) {

        this.redditAPI = redditAPI;
        this.application = application;

        mutableLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource create() {

        postDataSource = new PostDataSource(redditAPI, application);
        mutableLiveData.postValue(postDataSource);
        return postDataSource;
    }

    public PostDataSource getPostDataSource() {
        return postDataSource;
    }

    public MutableLiveData<PostDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
