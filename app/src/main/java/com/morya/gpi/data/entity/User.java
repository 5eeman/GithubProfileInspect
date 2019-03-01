package com.morya.gpi.data.entity;

import java.io.Serializable;
import java.util.Objects;



public class User implements Serializable { // Parcelable would be better, but obviously not needed

    private Integer id;
    private String avatarUrl;
    private String login;
    private Double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(avatarUrl, user.avatarUrl) &&
                Objects.equals(login, user.login) &&
                Objects.equals(score, user.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl, login, score);
    }

}
