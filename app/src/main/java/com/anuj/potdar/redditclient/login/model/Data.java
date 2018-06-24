package com.anuj.potdar.redditclient.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by potda on 6/23/2018.
 */

public class Data {

    @SerializedName("modhash")
    @Expose
    private String modhash;

    @SerializedName("cookie")
    @Expose
    private String cookie;


    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

}
