package com.dev.rj3.fantasma.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.posts.Post;
import com.dev.rj3.fantasma.adapter.PostAdapter;
import com.dev.rj3.fantasma.viewmodel.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends Fragment {


    private RecyclerView mRecycleView;
    public PostAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private PagedList<Post> postsList;
    PostViewModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.posts_fragment, container, false);
        mRecycleView = view.findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new PostAdapter(PostsFragment.this.getActivity());

        mRecycleView.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(PostViewModel.class);
        getRedditPosts();

    }


    private void getRedditPosts() {

        model.getPagedListLiveData().observe(getViewLifecycleOwner(), new Observer<PagedList<Post>>() {
            @Override
            public void onChanged(PagedList<Post> postLiveData) {
                postsList = postLiveData;
                mAdapter.submitList(postsList);

            }
        });
    }


}
