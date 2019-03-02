package com.morya.gpi.data.di.data.repo;

import com.morya.gpi.data.di.data.network.NetworkModule;
import com.morya.gpi.data.net.api.GithubUserApi;
import com.morya.gpi.domain.repo.GetUserRepoUseCase;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class})
public class RepoModule {

    @Provides
    GetUserRepoUseCase provideGetUserRepoUseCase(GithubUserApi api) {
        return new GetUserRepoUseCase(api);
    }

}
