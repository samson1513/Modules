package com.mobile.modules.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobile.modules.R;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Alex Michenko
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.VH> {

    ArrayList<SomeItem> list = new ArrayList<>();
    OnItemClickListner listner;

    public ListAdapter() {
    }

    public void setList(ArrayList<SomeItem> items) {
        list.clear();
        list.addAll(items);
        notifyDataSetChanged();
    }

    public void setListner(OnItemClickListner listner) {
        this.listner = listner;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull final VH holder) {
        super.onViewAttachedToWindow(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull VH holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.setOnClickListener(null);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        private TextView name;

        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
        }

        public void bind(SomeItem item) {
            name.setText(item.name);
        }
    }
}
