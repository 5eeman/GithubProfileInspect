package com.morya.gpi.data.di;

import com.morya.gpi.presentation.vm.detail.DetailViewModel;
import com.morya.gpi.presentation.vm.main.MainViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {

        ViewModelSubComponent build();
    }

    void inject(MainViewModel productViewModel);

    void inject(DetailViewModel detailViewModel);

}
