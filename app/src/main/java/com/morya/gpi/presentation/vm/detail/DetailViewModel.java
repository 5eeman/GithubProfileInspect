package com.morya.gpi.presentation.vm.detail;

import android.app.Application;
import android.util.Log;

import com.morya.gpi.data.App;
import com.morya.gpi.data.entity.Repository;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.domain.repo.GetUserRepoUseCase;
import com.morya.gpi.domain.user.GetUserUseCase;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DetailViewModel extends AndroidViewModel {

    @Inject
    GetUserUseCase useCase;

    @Inject
    GetUserRepoUseCase repoUseCase;

    private ObservableField<List<Repository>> repositories = new ObservableField<>(Collections.emptyList());

    private ObservableField<String> imageUrl = new ObservableField<>();
    private ObservableField<String> login = new ObservableField<>();
    private ObservableField<String> reposCount = new ObservableField<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);

        App app = getApplication();
        app.getViewModelComponent()
                .inject(this);
    }

    public void setUser(User user) {
        useCase.getUserFullInfo(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(fullUser -> setFullUserInfo(fullUser),
                        throwable -> Log.e("Error", "error", throwable)); // handle disposable
        repoUseCase.getAllUserRepo(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repositories -> this.repositories.set(repositories),
                        throwable -> Log.e("Error", "error", throwable)); // same
    }

    private void setFullUserInfo(User user) {
        imageUrl.set(user.getAvatarUrl());
        login.set(user.getLogin());
        reposCount.set(Integer.toString(user.getRepoCount()));
    }

    public ObservableField<List<Repository>> getRepositories() {
        return repositories;
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;
    }

    public ObservableField<String> getLogin() {
        return login;
    }

    public ObservableField<String> getReposCount() {
        return reposCount;
    }
}
