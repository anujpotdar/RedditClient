
package com.anuj.potdar.redditclient.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gif implements Serializable{

    @SerializedName("source")
    @Expose
    private Source_ source;
    @SerializedName("resolutions")
    @Expose
    private List<Resolution_> resolutions = null;

    public Source_ getSource() {
        return source;
    }

    public void setSource(Source_ source) {
        this.source = source;
    }

    public List<Resolution_> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolution_> resolutions) {
        this.resolutions = resolutions;
    }

}
