package com.morya.gpi.presentation.view.detail.repo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.morya.gpi.data.entity.Repository;
import com.morya.gpi.databinding.ItemRepoBinding;
import com.morya.gpi.presentation.utils.BindableAdapter;
import com.morya.gpi.presentation.vm.detail.repo.RepoViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> implements BindableAdapter<List<Repository>> {

    private List<Repository> repositories;

    @Override
    public void setData(List<Repository> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRepoBinding binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        RepoViewModel repoViewModel = new RepoViewModel(parent.getResources());
        binding.setViewModel(repoViewModel);
        return new RepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.binding.getViewModel().setRepository(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {

        final ItemRepoBinding binding;

        public RepoViewHolder(@NonNull ItemRepoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
