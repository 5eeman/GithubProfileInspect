package com.morya.gpi.data.net.response;

import com.morya.gpi.data.entity.User;

import java.util.List;

public class UserSearchResponse {

    private List<User> users;
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
