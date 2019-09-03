package com.mobile.modules.details;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Alex Michenko
 */
@Module
public interface DetailsModule {

    @Binds
    DetailsContract.View view(DetailsFragment fragment);

    @Binds
    DetailsContract.Presenter presenter(DetailsPresenter presenter);
}
