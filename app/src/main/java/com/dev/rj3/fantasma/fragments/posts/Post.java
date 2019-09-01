package com.dev.rj3.fantasma.fragments.posts;

public class Post {

    private String title;
    private String subreddit, thumbnail_url;


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
}
