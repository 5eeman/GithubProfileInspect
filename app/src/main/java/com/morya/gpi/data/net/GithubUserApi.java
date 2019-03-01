package com.morya.gpi.data.net;

import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.response.UserSearchResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class GithubUserApi {

    private RetrofitUserApi api;

    public GithubUserApi(Retrofit retrofit) {
        api = retrofit.create(RetrofitUserApi.class);
    }

    public Single<UserSearchResponse> getUsersByQuery(String query) {
        return api.getUsers(query, null);
    }

    public Single<User> getUserByName(String name) {
        return api.getUser(name);
    }

}
