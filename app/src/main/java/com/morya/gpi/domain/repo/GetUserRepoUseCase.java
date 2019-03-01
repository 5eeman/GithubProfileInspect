package com.morya.gpi.domain.repo;

import com.morya.gpi.data.entity.Repository;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.GithubRepositoryApi;

import java.util.List;

import io.reactivex.Single;

public class GetUserRepoUseCase {

    private GithubRepositoryApi githubRepositoryApi;

    public GetUserRepoUseCase(GithubRepositoryApi api) {
        this.githubRepositoryApi = api;
    }

    public Single<List<Repository>> getAllUserRepo(User user) {
        return null; // TODO: 3/1/19
    }
}
