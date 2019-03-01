package com.morya.gpi.data.net;

import com.morya.gpi.data.net.response.RepositoryListResponse;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class GithubRepositoryApi {


    public GithubRepositoryApi(Retrofit retrofit) {

    }

    public Single<RepositoryListResponse> getAllUserRepo() {
        return null;
    }
}
