package com.dev.rj3.fantasma.posts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class Post {

    private String title;
    private String subreddit, thumbnail_url;
    private String name;

    public Post(String title, String subreddit, String thumbnail_url) {
        this.title = title;
        this.subreddit = subreddit;
        //this.author = author;
        this.thumbnail_url = thumbnail_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubreddit() {
        return subreddit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final DiffUtil.ItemCallback<Post> CALLBACK = new DiffUtil.ItemCallback<Post>() {
        @Override
        public boolean areItemsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
            return oldItem.name == newItem.name;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
            return true;
        }
    };

}
