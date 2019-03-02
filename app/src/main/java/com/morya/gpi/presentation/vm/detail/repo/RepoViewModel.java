package com.morya.gpi.presentation.vm.detail.repo;

import android.content.res.Resources;

import com.morya.gpi.R;
import com.morya.gpi.data.entity.Repository;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class RepoViewModel extends BaseObservable {

    private final Resources resources;
    private Repository repository;

    public RepoViewModel(Resources resources) {
        this.resources = resources;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
        notifyChange();
    }

    @Bindable
    public String getRepositoryName() {
        return repository.getName();
    }

    @Bindable
    public String getRepositoryDescription() {
        return repository.getDescription();
    }

    @Bindable
    public String getStars() {
        return resources.getQuantityString(R.plurals.stars, repository.getStarsCount(), repository.getStarsCount());
    }

    @Bindable
    public String getForks() {
        return resources.getQuantityString(R.plurals.stars, repository.getForksCount(), repository.getForksCount());
    }

}
