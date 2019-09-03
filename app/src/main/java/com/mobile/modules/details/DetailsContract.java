package com.mobile.modules.details;

import com.mobile.modules.base.BasePresenter;
import com.mobile.modules.base.BaseView;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 */
public interface DetailsContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter {
        void subscribe();
    }

    class Model {

        @Inject
        public Model() {
        }
    }
}
