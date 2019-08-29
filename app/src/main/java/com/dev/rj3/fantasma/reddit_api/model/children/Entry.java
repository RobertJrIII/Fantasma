package com.dev.rj3.fantasma.reddit_api.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("title")
    @Expose
    private String title;


    @SerializedName("subreddit_name_prefixed")
    @Expose
    private String subreddit_name_prefixed;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("stickied")
    @Expose
    private boolean stickied;


    @SerializedName("score")
    @Expose
    private int score;


    @SerializedName("author")
    @Expose
    private String author;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubreddit_name_prefixed() {
        return subreddit_name_prefixed;
    }

    public void setSubreddit_name_prefixed(String subreddit_name_prefixed) {
        this.subreddit_name_prefixed = subreddit_name_prefixed;
    }

    public boolean isStickied() {
        return stickied;
    }

    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", subreddit_name_prefixed='" + subreddit_name_prefixed + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                '}';
    }
}
