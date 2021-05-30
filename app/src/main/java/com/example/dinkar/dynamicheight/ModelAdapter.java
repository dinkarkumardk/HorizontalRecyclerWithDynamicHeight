package com.example.dinkar.dynamicheight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
    static final int TYPE_ONE = 1;
    static final int TYPE_TWO = 2;
    static final int TYPE_THREE = 3;
    static final int TYPE_FOUR = 4;
    static final int TYPE_FIVE = 5;
    //List<Model> modelList;
    Products products;
    Context context;
    ItemOnClickListener itemOnClickListener;

    public ModelAdapter(Products products, Context context, ItemOnClickListener itemOnClickListener) {
        this.products = products;
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE_TWO:
                return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.list_item2, viewGroup, false));
            case TYPE_THREE:
                return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.list_item3, viewGroup, false));
            case TYPE_FOUR:
                return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.list_item4, viewGroup, false));
            case TYPE_FIVE:
                return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.list_item5, viewGroup, false));
            default:
                return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.list_item, viewGroup, false));
        }

    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        Model data = products.getModels().get(i);
        viewHolder.title.setText(data.title);
        viewHolder.description.setText(data.description);
        viewHolder.position.setText("CurrentPositionInList : " + i);
        viewHolder.button.setOnClickListener(v -> itemOnClickListener.onItemClick(data));
    }

    @Override
    public int getItemCount() {
        return products.getModels().size();
    }

    @Override
    public int getItemViewType(int position) {
        return products.getModels().get(position).viewType;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, position;
        Button button;
        LinearLayout parent;

        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            title = itemView.findViewById(R.id.title_tv);
            description = itemView.findViewById(R.id.description);
            position = itemView.findViewById(R.id.position_tv);
            button = itemView.findViewById(R.id.button);
        }
    }


    interface ItemOnClickListener {
        void onItemClick(Model model);
    }
}
