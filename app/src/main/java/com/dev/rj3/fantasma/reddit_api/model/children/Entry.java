package com.dev.rj3.fantasma.reddit_api.model.children;

import com.dev.rj3.fantasma.reddit_api.model.children.all_awardings.Awards;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Entry {

    @SerializedName("saved")
    @Expose
    private boolean saved;

    @SerializedName("hidden")
    @Expose
    private boolean hidden;

    @SerializedName("clicked")
    @Expose
    private boolean clicked;

    @SerializedName("hide_score")
    @Expose
    private boolean hide_score;

    @SerializedName("archieved")
    @Expose
    private boolean archieved;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("spoiler")
    @Expose
    private boolean spoiler;

    @SerializedName("locked")
    @Expose
    private boolean locked;

    @SerializedName("num_comments")
    @Expose
    private int num_comments;

    @SerializedName("all_awardings")
    @Expose
    private ArrayList<Awards> awards;

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

    @SerializedName("url")
    @Expose
    private String url;

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

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isHide_score() {
        return hide_score;
    }

    public void setHide_score(boolean hide_score) {
        this.hide_score = hide_score;
    }

    public boolean isArchieved() {
        return archieved;
    }

    public void setArchieved(boolean archieved) {
        this.archieved = archieved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public void setSpoiler(boolean spoiler) {
        this.spoiler = spoiler;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public ArrayList<Awards> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<Awards> awards) {
        this.awards = awards;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
