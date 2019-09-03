package com.mobile.modules.list;

/**
 * Created by Alex Michenko
 */
public interface ListDependency {

    ListFragment fragment();

    interface Parent {
        OnItemClickListner listener();
    }
}
