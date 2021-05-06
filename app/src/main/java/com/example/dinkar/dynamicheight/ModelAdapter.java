package com.example.dinkar.dynamicheight;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        for (Model m : modelList) {
            currentItemHeight = getHeightOfLargestDescription(context, m.description, myViewHolder.description);
            if (currentItemHeight > highestHeight) {
                highestHeight = currentItemHeight;
            }
        }
        return myViewHolder;

    }


    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        Model data = modelList.get(i);
        viewHolder.title.setText(data.title);
        viewHolder.description.setText(data.description);
        viewHolder.description.setHeight(highestHeight);
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

    public static int getHeightOfLargestDescription(final Context context, final CharSequence text, TextView textView) {
        final WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final Point displaySize = new Point();
        wm.getDefaultDisplay().getSize(displaySize);
        final int deviceWidth = displaySize.x;
        textView.setTypeface(Typeface.DEFAULT);
        textView.setText(text, TextView.BufferType.SPANNABLE);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(deviceWidth, View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        textView.measure(widthMeasureSpec, heightMeasureSpec);
        return textView.getMeasuredHeight();
    }

}
