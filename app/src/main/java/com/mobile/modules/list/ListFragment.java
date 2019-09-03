package com.mobile.modules.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.modules.App;
import com.mobile.modules.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

/**
 * Created by Alex Michenko
 */
public class ListFragment extends Fragment implements ListContract.View {

    @Inject
    ListContract.Presenter presenter;

    RecyclerView listItems;

    public static ListFragment newInstance(ListDependency.Parent dependency) {
        return DaggerListComponent.builder()
                .dependency(dependency)
                .build()
                .fragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listItems = view.findViewById(R.id.list_items);
        listItems.setLayoutManager(new LinearLayoutManager(view.getContext()));
        listItems.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));
        presenter.subscribe();
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        listItems.setAdapter(adapter);
    }
}
