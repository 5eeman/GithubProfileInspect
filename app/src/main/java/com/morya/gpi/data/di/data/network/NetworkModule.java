package com.morya.gpi.data.di.data.network;

import com.morya.gpi.data.net.api.GithubRepositoryApi;
import com.morya.gpi.data.net.api.GithubUserApi;
import com.morya.gpi.data.utils.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static final String API_URL = "API_URL";

    @Provides
    GithubUserApi provideUserApi(Retrofit retrofit) {
        return new GithubUserApi(retrofit);
    }

    @Provides
    GithubRepositoryApi provideRepoApi(Retrofit retrofit) {
        return new GithubRepositoryApi(retrofit);
    }

    @Provides
    Retrofit provideRetrofit(@Named(API_URL) String apiUrl, CallAdapter.Factory callAdapterFactory,
                             Converter.Factory converterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Named(API_URL)
    String provideApiUrl() {
        return Constants.GITHUB_URL;
    }

    @Provides
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    OkHttpClient provideHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
}
