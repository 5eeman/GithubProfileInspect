package com.morya.gpi.data.net.api;

import com.morya.gpi.data.entity.Repository;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.response.UserSearchResponse;
import com.morya.gpi.data.net.retrofit.RetrofitUserApi;

import java.util.List;

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

    public Single<List<Repository>> getAllUserRepo(String userName) {
        return api.getAllRepo(userName);
    }

}
