package com.example.dinkar.dynamicheight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
    List<Model> modelList;
    Context context;
    int highestHeight = 0;
    int currentItemHeight = 0;

    public ModelAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);

        return new MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        Model data = modelList.get(i);
        viewHolder.title.setText(data.title);
        viewHolder.description.setText(data.description);
        viewHolder.description.post(new Runnable() {
            @Override
            public void run() {
                currentItemHeight = viewHolder.description.getMeasuredHeight();
                if (currentItemHeight > highestHeight) {
                    highestHeight = currentItemHeight;
                    /** this is needed to make sure already inflated view with small description also get resized to largest view till now
                     *and this be called only if the new view is of larger size then all of the view inflated till now
                     */
                    notifyDataSetChanged();
                }
                viewHolder.description.setHeight(highestHeight);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        LinearLayout parent;


        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            title = itemView.findViewById(R.id.title_tv);
            description = itemView.findViewById(R.id.description);

        }
    }


}
