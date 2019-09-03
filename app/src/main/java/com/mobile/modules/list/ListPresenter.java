package com.mobile.modules.list;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 */
public class ListPresenter implements ListContract.Presenter {

    private final ListContract.Model model;
    private final ListContract.View view;
    private final ListAdapter adapter;

    @Inject
    public ListPresenter(final ListContract.Model model, ListContract.View view) {
        this.model = model;
        this.view = view;
        this.adapter = new ListAdapter();
        adapter.setListner(new OnItemClickListner() {
            @Override
            public void onClick(SomeItem item) {
                model.listner.onClick(item);
            }
        });
    }

    @Override
    public void subscribe() {
        view.setAdapter(adapter);
        adapter.setList(model.items);
    }
}
