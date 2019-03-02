package com.morya.gpi.data.entity;

import com.google.gson.annotations.SerializedName;

public class Repository {

    private String name;
    private String description;
    @SerializedName("stargazers_count")
    private Integer starsCount;
    @SerializedName("forks_count")
    private Integer forksCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(Integer starsCount) {
        this.starsCount = starsCount;
    }

    public Integer getForksCount() {
        return forksCount;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }
}
