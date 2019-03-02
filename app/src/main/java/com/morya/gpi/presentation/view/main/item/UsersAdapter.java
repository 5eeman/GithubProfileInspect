package com.morya.gpi.presentation.view.main.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.morya.gpi.data.entity.User;
import com.morya.gpi.databinding.ItemUserBinding;
import com.morya.gpi.presentation.utils.BindableAdapter;
import com.morya.gpi.presentation.vm.main.item.UserItemViewModel;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> implements BindableAdapter<List<User>> {

    private List<User> data = Collections.emptyList();
    private MutableLiveData<User> selectAction;

    public UsersAdapter(MutableLiveData<User> selectAction) {
        this.selectAction = selectAction;
    }

    @Override
    public void setData(List<User> newData) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return data.size();
            }

            @Override
            public int getNewListSize() {
                return newData.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return data.get(oldItemPosition).equals(newData.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return data.get(oldItemPosition).equals(newData.get(newItemPosition));
            }
        });
        this.data = newData;
        diffResult.dispatchUpdatesTo(this); // Better would be some other way, but it is not the worst one for sure
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        UserItemViewModel viewModel = new UserItemViewModel(selectAction);
        binding.setViewModel(viewModel);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserItemViewModel viewModel = holder.binding.getViewModel();

        User user = data.get(position);
        viewModel.setUser(user);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        ItemUserBinding binding;

        public UserViewHolder(@NonNull ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
