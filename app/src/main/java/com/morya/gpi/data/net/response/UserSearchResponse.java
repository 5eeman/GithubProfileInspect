package com.morya.gpi.data.net.response;

import com.google.gson.annotations.SerializedName;
import com.morya.gpi.data.entity.User;

import java.util.List;

public class UserSearchResponse {

    @SerializedName("items")
    private List<User> users;
    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }
}
