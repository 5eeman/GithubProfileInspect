package com.morya.gpi.presentation.view.detail;

import android.os.Bundle;

import com.morya.gpi.R;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.databinding.ActivityDetailBinding;
import com.morya.gpi.presentation.view.detail.repo.RepoAdapter;
import com.morya.gpi.presentation.vm.detail.DetailViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "EXTRA_USER";

    private DetailViewModel viewModel;
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        if (getIntent().hasExtra(EXTRA_USER)) {
            viewModel.setUser((User) getIntent().getSerializableExtra(EXTRA_USER));
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel(viewModel);

        initAdapter();
    }

    private void initAdapter() {
        RepoAdapter repoAdapter = new RepoAdapter();
        binding.repositoriesList.setAdapter(repoAdapter);
    }
}
