package com.dev.rj3.fantasma.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.model.children.Entry;
import com.dev.rj3.fantasma.adapter.PostAdapter;
import com.dev.rj3.fantasma.viewmodel.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends Fragment {


    private RecyclerView mRecycleView;
    private PostAdapter mAdapter;

    private PagedList<Entry> postsList;
    private PostViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.posts_fragment, container, false);
        mRecycleView = view.findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new PostAdapter(PostsFragment.this.getActivity());




        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sharedViewModel = ViewModelProviders.of(getActivity()).get(PostViewModel.class);
        getRedditPosts();
        mRecycleView.setAdapter(mAdapter);


    }


    private void getRedditPosts() {

        sharedViewModel.getPagedListLiveData().observe(getViewLifecycleOwner(), postLiveData -> {
            postsList = postLiveData;
            mAdapter.submitList(postsList);

        });


    }


}
