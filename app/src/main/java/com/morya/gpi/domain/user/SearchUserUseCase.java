package com.morya.gpi.domain.user;

import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.response.UserSearchResponse;
import com.morya.gpi.data.net.api.GithubUserApi;

import java.util.List;

import io.reactivex.Observable;

public class SearchUserUseCase {

    private GithubUserApi githubUserApi;

    public SearchUserUseCase(GithubUserApi userApi) {
        this.githubUserApi = userApi;
    }

    // Observable because we can also add pagination or some other things
    public Observable<List<User>> findUsersByQuery(String query) {
        return githubUserApi.getUsersByQuery(query)
                .map(UserSearchResponse::getUsers)
                .toObservable();
    }
}
