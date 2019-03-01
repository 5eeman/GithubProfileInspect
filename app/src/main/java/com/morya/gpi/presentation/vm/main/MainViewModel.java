package com.morya.gpi.presentation.vm.main;

import android.app.Application;

import com.morya.gpi.data.App;
import com.morya.gpi.data.entity.User;
import com.morya.gpi.domain.user.SearchUserUseCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


public class MainViewModel extends AndroidViewModel {

    private Subject<String> searchQuerySubject = PublishSubject.create();
    private Disposable searchDisposable;

    private ObservableField<List<User>> users = new ObservableField<>();

    private MutableLiveData<User> openUserDetailEvent = new MutableLiveData<>();

    @Inject
    SearchUserUseCase useCase;


    public MainViewModel(@NonNull Application application) {
        super(application);

        App app = getApplication();
        app.getViewModelComponent()
                .inject(this);

        searchDisposable = searchQuerySubject
                .observeOn(Schedulers.io())
                .debounce(250, TimeUnit.MILLISECONDS)
                .map(query -> query.toLowerCase().trim())
                .filter(query -> !query.isEmpty())
                .distinct()
                .flatMap(query -> useCase.findUsersByQuery(query))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> users.set(results));
    }

    public SearchView.OnQueryTextListener getSearchListener() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchQuerySubject.onNext(newText);
                return true;
            }
        };
    }

    public ObservableField<List<User>> getUsers() {
        return users;
    }

    public MutableLiveData<User> getOpenUserDetailEvent() {
        return openUserDetailEvent;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        searchDisposable.dispose();
    }

    public void userSelected(User user) {
        openUserDetailEvent.postValue(user);
    }
}
