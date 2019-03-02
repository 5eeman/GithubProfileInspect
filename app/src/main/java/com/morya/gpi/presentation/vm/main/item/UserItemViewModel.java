package com.morya.gpi.presentation.vm.main.item;

import android.view.View;

import com.morya.gpi.data.entity.User;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;

public class UserItemViewModel extends BaseObservable {


    private final MutableLiveData<User> selectAction;
    private User user;

    public UserItemViewModel(MutableLiveData<User> selectAction) {
        this.selectAction = selectAction;
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }

    public void onItemSelected(View view) {
        selectAction.setValue(user);
    }

    @Bindable
    public String getImageUrl() {
        return user.getAvatarUrl();
    }

    @Bindable
    public String getTitle() {
        return user.getLogin();
    }

    @Bindable
    public String getScore() {
        return Double.toString(user.getScore());
    }

}
