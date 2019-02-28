package com.morya.gpi.presentation.mvvm.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.morya.gpi.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView(); // Would be good to add some checks

        searchView.setOnQueryTextListener(null);

        return super.onCreateOptionsMenu(menu);
    }
}
