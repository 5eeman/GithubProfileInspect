package com.morya.gpi.domain.user;

import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.GithubUserApi;

import io.reactivex.Single;

public class GetUserUseCase {

    GithubUserApi githubUserApi;

    public GetUserUseCase(GithubUserApi userApi) {
        this.githubUserApi = userApi;
    }

    public Single<User> getUserFullInfo(User user) {
        return githubUserApi.getUserByName(user.getLogin());
    }

}
