package com.dev.rj3.fantasma.posts;


public class Post {

    private String title;
    private String subreddit;
    private String author;
    private String thumbnail_url;
    private String name;

    public Post(String title, String subreddit, String author, String thumbnail_url) {
        this.title = title;
        this.subreddit = subreddit;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
        //TODO have access to Images Class


}
