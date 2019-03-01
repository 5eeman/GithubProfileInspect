package com.morya.gpi.data.net.response;

import com.morya.gpi.data.entity.Repository;

import java.util.List;

public class RepositoryListResponse {

    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
