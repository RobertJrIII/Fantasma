package com.dev.rj3.fantasma.fragments.posts;

public class Post {

    private String title;
    private String subreddit;


    public Post(String title, String subreddit) {
        this.title = title;
        this.subreddit = subreddit;
    }


    public String getTitle() {
        return title;
    }

    public String getSubreddit() {
        return subreddit;
    }
}
