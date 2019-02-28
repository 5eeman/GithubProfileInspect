package com.morya.gpi.presentation.mvvm.splash;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Completable;


public class SplashViewModel extends AndroidViewModel {

    private MutableLiveData startMainActivityEvent = new MutableLiveData();


    public SplashViewModel(@NonNull Application application) {
        super(application);

        Completable.complete()
                .delay(3, TimeUnit.SECONDS)
                .subscribe(() -> startMainActivityEvent.postValue(null)); // Or we can switch to main thread instead of postValue
    }

    public MutableLiveData getStartMainActivityEvent() {
        return startMainActivityEvent;
    }

}
