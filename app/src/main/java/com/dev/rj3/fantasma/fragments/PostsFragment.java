package com.dev.rj3.fantasma.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.fragments.posts.Post;
import com.dev.rj3.fantasma.fragments.posts.PostAdapter;
import com.dev.rj3.fantasma.reddit_api.RedditAPI;
import com.dev.rj3.fantasma.reddit_api.model.Feed;
import com.dev.rj3.fantasma.reddit_api.model.children.Children;
import com.dev.rj3.fantasma.reddit_api.model.children.Entry;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsFragment extends Fragment {

    private static final String BASE_URL = "https://www.reddit.com/";
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.posts_fragment, container, false);
        mRecycleView = view.findViewById(R.id.recycleView);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
        Call<Feed> call = redditAPI.getData();

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                if (!response.isSuccessful()) {
                    //  textView.setText("Code: " + response.code());
                    return;
                }

                ArrayList<Children> postContent = response.body().getData().getChildren();
                ArrayList<Post> posts = new ArrayList<>();
                for (Children children : postContent) {
                    Entry entry = children.getEntry();
                    posts.add(new Post(entry.getTitle(), entry.getSubreddit_name_prefixed()));

                }


                mLayoutManager = new LinearLayoutManager(getActivity());
                mAdapter = new PostAdapter(posts);

                mRecycleView.setLayoutManager(mLayoutManager);
                mRecycleView.setAdapter(mAdapter);


            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });


    }
}
