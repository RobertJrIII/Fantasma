package com.dev.rj3.fantasma.model.children.images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {


    @SerializedName("source")
    @Expose
    private Source source;


    public Source getSource() {
        return source;
    }
}
