package com.morya.gpi.data.net.retrofit;

import com.morya.gpi.data.entity.Repository;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.data.net.response.UserSearchResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitUserApi {

    @GET("search/users")
    Single<UserSearchResponse> getUsers(@Query("q") String query, @Query("sort") String sort);

    @GET("users/{username}")
    Single<User> getUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Single<List<Repository>> getAllRepo(@Path("username") String userName);
}
