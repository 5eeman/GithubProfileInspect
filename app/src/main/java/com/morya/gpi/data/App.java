package com.morya.gpi.data;

import android.app.Application;

import com.morya.gpi.data.di.AppComponent;
import com.morya.gpi.data.di.DaggerAppComponent;
import com.morya.gpi.data.di.ViewModelSubComponent;


public class App extends Application {

    private AppComponent appComponent;
    private ViewModelSubComponent viewModelSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        viewModelSubComponent = appComponent
                .viewmodelSubComponentBuilder()
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ViewModelSubComponent getViewModelComponent() {
        return viewModelSubComponent;
    }
}
