package com.mobile.modules.list;

import dagger.BindsInstance;
import dagger.Component;
import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;

/**
 * Created by Alex Michenko
 */
@Component(modules = {ListComponent.ListComponentModule.class, ListContract.ListModule.class}, dependencies = {ListDependency.Parent.class})
public interface ListComponent extends ListDependency {

    @Component.Builder
    interface Builder {
//        @BindsInstance
//        Builder view(ListFragment fragment);
        Builder dependency(ListDependency.Parent dependency);
        ListComponent build();
    }

    @Module
    class ListComponentModule {

        @Provides
        public ListFragment listFragment() {
            return new ListFragment();
        }
    }
}
