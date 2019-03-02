package com.morya.gpi.data.di;

import com.morya.gpi.data.di.data.repo.RepoModule;
import com.morya.gpi.data.di.data.user.UserModule;

import dagger.Module;

@Module(includes = {UserModule.class, RepoModule.class})
public class AppModule {


}
