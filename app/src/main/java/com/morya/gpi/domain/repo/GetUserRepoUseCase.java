package com.morya.gpi.domain.repo;

import com.morya.gpi.data.entity.Repository;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.api.GithubUserApi;

import java.util.List;

import io.reactivex.Single;

public class GetUserRepoUseCase {

    private GithubUserApi githubRepositoryApi;

    public GetUserRepoUseCase(GithubUserApi api) {
        this.githubRepositoryApi = api;
    }

    public Single<List<Repository>> getAllUserRepo(User user) {
        return githubRepositoryApi.getAllUserRepo(user.getLogin());
    }
}
