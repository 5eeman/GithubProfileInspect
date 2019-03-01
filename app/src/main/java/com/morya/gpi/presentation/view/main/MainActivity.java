package com.morya.gpi.presentation.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.morya.gpi.R;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.databinding.ActivityMainBinding;
import com.morya.gpi.presentation.view.detail.DetailActivity;
import com.morya.gpi.presentation.view.main.item.UsersAdapter;
import com.morya.gpi.presentation.vm.main.MainViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();
        initAdapter();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getOpenUserDetailEvent().observe(this, user -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_USER, user);
            startActivity(intent);
        });

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
    }

    private void initAdapter() {
        MutableLiveData<User> selectedUserData = new MutableLiveData<>();
        selectedUserData.observe(this, user -> viewModel.userSelected(user));
        UsersAdapter usersAdapter = new UsersAdapter(selectedUserData);
        binding.recyclerView.setAdapter(usersAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView(); // Would be good to add some checks

        searchView.setOnQueryTextListener(viewModel.getSearchListener());

        return super.onCreateOptionsMenu(menu);
    }
}
