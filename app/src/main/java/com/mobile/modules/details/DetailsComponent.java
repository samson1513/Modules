package com.mobile.modules.details;

import com.mobile.modules.list.ListFragment;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by Alex Michenko
 */
@Component(dependencies = {DetailsDependency.Parent.class}, modules = {DetailsModule.class})
public interface DetailsComponent extends AndroidInjector<DetailsFragment> {

    @Component.Builder
    interface Builder {
        Builder dependency(DetailsDependency.Parent dependency);
        DetailsComponent build();
    }
}
