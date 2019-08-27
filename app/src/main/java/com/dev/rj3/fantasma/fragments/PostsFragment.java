package com.dev.rj3.fantasma.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dev.rj3.fantasma.R;
import com.dev.rj3.fantasma.reddit_api.RedditAPI;
import com.dev.rj3.fantasma.reddit_api.model.Feed;
import com.dev.rj3.fantasma.reddit_api.model.children.Children;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsFragment extends Fragment {

    private static final String BASE_URL = "https://www.reddit.com/r/FantasmaTesting/";
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.posts_fragment, container, false);
        textView = view.findViewById(R.id.textView);
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
                    textView.setText("Code: " + response.code());
                    return;
                }

                ArrayList<Children> childrenList = response.body().getData().getChildren();
                for (Children children : childrenList) {
                    String content = "";
                    content += " " + children.getEntry().getTitle() + "\n";
                    content += " " + children.getEntry().getSubreddit_name_prefixed() + "\n";
                    content += " " + children.getEntry().getAuthor() + "\n";
                    content += " " + children.getEntry().getScore() + "\n\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }
}
