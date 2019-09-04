package com.dev.rj3.fantasma.model.children.all_awardings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Awards {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("icon_url")
    @Expose
    private String icon_url;
}
