package com.dev.rj3.fantasma.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.posts.Post;
import com.dev.rj3.fantasma.adapter.PostAdapter;
import com.dev.rj3.fantasma.retrofit.RedditAPI;
import com.dev.rj3.fantasma.model.Feed;
import com.dev.rj3.fantasma.model.children.Children;
import com.dev.rj3.fantasma.model.children.Entry;
import com.dev.rj3.fantasma.retrofit.RetrofitRequest;
import com.dev.rj3.fantasma.viewmodel.PostViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsFragment extends Fragment {

//    private static final String front_BASE_URL = "https://www.reddit.com/";
//    private static final String BASE_URL = "https://www.reddit.com/r/";

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Post> postsList = new ArrayList<>();
    PostViewModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.posts_fragment, container, false);
        mRecycleView = view.findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);



        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new PostAdapter(PostsFragment.this.getActivity(), postsList);

        mRecycleView.setAdapter(mAdapter);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(PostViewModel.class);
        //  init();
        getRedditPosts();

    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecycleView.setLayoutManager(mLayoutManager);
//
//        mAdapter = new PostAdapter(PostsFragment.this.getActivity(), posts);
//
//        mRecycleView.setAdapter(mAdapter);
//
//        model = ViewModelProviders.of(getActivity()).get(PostViewModel.class);
//        //  init();
//        getRedditPosts();
//
//    }

    private void getRedditPosts() {
        model.getPostLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Post>>() {
            @Override
            public void onChanged(ArrayList<Post> posts) {
                List<Post> data = posts;
                postsList.addAll(data);
                mAdapter.notifyDataSetChanged();


            }
        });

    }

//    private void init() {
//
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitRequest.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
//        Call<Feed> call = redditAPI.getData("funny");
//
//        call.enqueue(new Callback<Feed>() {
//            @Override
//            public void onResponse(Call<Feed> call, Response<Feed> response) {
//
//                if (!response.isSuccessful()) {
//                    //  textView.setText("Code: " + response.code());
//                    return;
//                }
//
//                ArrayList<Children> postContent = response.body().getData().getChildren();
//                ArrayList<Post> posts = new ArrayList<>();
//                for (Children children : postContent) {
//                    Entry entry = children.getEntry();
//
//                    posts.add(new Post(entry.getTitle(), entry.getSubreddit_name_prefixed(), entry.getThumbnail()));
//
//
//                }
//
//                mAdapter = new PostAdapter(getActivity(), posts);
//                mLayoutManager = new LinearLayoutManager(getActivity());
//                mRecycleView.setLayoutManager(mLayoutManager);
//                mRecycleView.setAdapter(mAdapter);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Feed> call, Throwable t) {
//                Toast.makeText(getActivity(), "Something happened.", Toast.LENGTH_SHORT).show();
//            }
//        });
    // }

//    private void pagination(){
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RedditAPI redditAPI = retrofit.create(RedditAPI.class);
//        Call<Feed> call = redditAPI.getData();
//
//        call.enqueue(new Callback<Feed>() {
//            @Override
//            public void onResponse(Call<Feed> call, Response<Feed> response) {
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Feed> call, Throwable t) {
//                Toast.makeText(getActivity(),"Something happened.",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
