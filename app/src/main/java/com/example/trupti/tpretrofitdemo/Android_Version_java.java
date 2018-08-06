package com.example.trupti.tpretrofitdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 30-07-2018.
 */

public class Android_Version_java {

    private String name;

    @SerializedName("image")
    private String image;
    private String link;


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
}


