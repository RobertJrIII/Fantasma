package com.dev.rj3.fantasma.fragments.posts;

public class Post {

    private String title;
    private String subreddit, author;


    public Post(String title, String subreddit) {
        this.title = title;
        this.subreddit = subreddit;
        //this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSubreddit() {
        return subreddit;
    }
}
