package com.morya.gpi.presentation.view.splash;

import android.content.Intent;
import android.os.Bundle;

import com.morya.gpi.R;
import com.morya.gpi.presentation.view.main.MainActivity;
import com.morya.gpi.presentation.vm.splash.SplashViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class SplashActivity extends AppCompatActivity {

    private SplashViewModel splashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        splashViewModel.getStartMainActivityEvent().observe(this, ignore -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
