package com.dev.rj3.fantasma.model.children;

import androidx.annotation.Nullable;

import com.dev.rj3.fantasma.model.children.all_awardings.Awards;
import com.dev.rj3.fantasma.model.children.images.Images;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Entry {

    @SerializedName("saved")
    private boolean saved;

    @SerializedName("hidden")
    private boolean hidden;

    @SerializedName("clicked")
    private boolean clicked;

    @SerializedName("hide_score")
    private boolean hide_score;

    @SerializedName("archived")
    private boolean archived;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private ArrayList<Images> images;

    @SerializedName("title")
    private String title;

    @SerializedName("spoiler")
    private boolean spoiler;

    @SerializedName("locked")
    private boolean locked;

    @SerializedName("num_comments")
    private int num_comments;

    @SerializedName("all_awardings")
    private ArrayList<Awards> awards;

    @SerializedName("subreddit_name_prefixed")
    private String subreddit_name_prefixed;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("stickied")
    private boolean stickied;


    @SerializedName("score")
    private int score;


    @SerializedName("author")
    private String author;

    @SerializedName("url")
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

    @Nullable
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
        return archived;
    }

    public void setArchieved(boolean archived) {
        this.archived = archived;
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

    public ArrayList<Images> getImages() {
        return images;
    }

    public void setImages(ArrayList<Images> images) {
        this.images = images;
    }
}
