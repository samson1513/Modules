package com.mobile.modules.list;

import com.mobile.modules.base.BasePresenter;
import com.mobile.modules.base.BaseView;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Michenko
 */
public interface ListContract {

    interface View extends BaseView {
        void setAdapter(ListAdapter adapter);
    }

    interface Presenter extends BasePresenter {
        void subscribe();
    }

    class Model {

        ArrayList<SomeItem> items;
        @Inject
        OnItemClickListner listner;

        @Inject
        public Model() {
            items = new ArrayList<>();
            items.add(new SomeItem(1, "One"));
            items.add(new SomeItem(2, "Two"));
            items.add(new SomeItem(3, "Three"));
            items.add(new SomeItem(4, "Four"));
        }

    }

    @Module
    interface ListModule {

        @Binds
        ListContract.View view(ListFragment fragment);

        @Binds
        ListContract.Presenter presenter(ListPresenter presenter);
    }
}
