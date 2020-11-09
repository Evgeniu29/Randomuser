package com.paad.randomuser.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("seed")
    @Expose
    public String seed;
    @SerializedName("results")
    @Expose
    public Integer results;
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("version")
    @Expose
    public String version;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
