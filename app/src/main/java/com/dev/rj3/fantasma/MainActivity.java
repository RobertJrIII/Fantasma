package com.dev.rj3.fantasma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.dev.rj3.fantasma.reddit_api.RedditAPI;
import com.dev.rj3.fantasma.reddit_api.model.Feed;
import com.dev.rj3.fantasma.reddit_api.model.children.Children;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://www.reddit.com/";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

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
