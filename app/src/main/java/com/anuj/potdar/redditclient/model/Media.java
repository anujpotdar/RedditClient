
package com.anuj.potdar.redditclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("oembed")
    @Expose
    private Oembed_ oembed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Oembed_ getOembed() {
        return oembed;
    }

    public void setOembed(Oembed_ oembed) {
        this.oembed = oembed;
    }

}
