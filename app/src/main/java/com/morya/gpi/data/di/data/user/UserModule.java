package com.morya.gpi.data.di.data.user;

import com.morya.gpi.data.di.data.network.NetworkModule;
import com.morya.gpi.data.net.api.GithubUserApi;
import com.morya.gpi.domain.user.GetUserUseCase;
import com.morya.gpi.domain.user.SearchUserUseCase;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class})
public class UserModule {

    @Provides
    public GetUserUseCase provideGetUserUseCase(GithubUserApi userApi) {
        return new GetUserUseCase(userApi);
    }

    @Provides
    public SearchUserUseCase provideSearchUseCase(GithubUserApi userApi) {
        return new SearchUserUseCase(userApi);
    }
}
