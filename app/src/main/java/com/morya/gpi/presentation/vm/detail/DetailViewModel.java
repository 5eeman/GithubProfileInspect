package com.morya.gpi.presentation.vm.detail;

import android.app.Application;

import com.morya.gpi.data.App;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.domain.repo.GetUserRepoUseCase;
import com.morya.gpi.domain.user.GetUserUseCase;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DetailViewModel extends AndroidViewModel {

    private User user;

    GetUserUseCase useCase;

    GetUserRepoUseCase repoUseCase;


    public DetailViewModel(@NonNull Application application) {
        super(application);

        App app = getApplication();
        app.getViewModelComponent()
                .inject(this);
    }

    public void setUser(User user) {
        useCase.getUserFullInfo(user)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(fullUser -> this.user = fullUser)
                .flatMap(fullUser -> repoUseCase.getAllUserRepo(fullUser))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(fullUser -> {

                });
    }
}
