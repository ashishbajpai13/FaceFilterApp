package com.google.android.gms.samples.vision.face.facetracker.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.samples.vision.face.facetracker.FaceTrackerActivity;
import com.google.android.gms.samples.vision.face.facetracker.R;

import java.util.List;

public class FiltersAdapter  extends RecyclerView.Adapter<FiltersAdapter.FilterViewHolder>{
    private List<Integer> drawableList;
    private Context context;

    public FiltersAdapter(List<Integer> drawableList, Context context) {
        this.drawableList = drawableList;
        this.context = context;
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FilterViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.filter_item, parent, false));
    }

    @Override
    public void onBindViewHolder(FilterViewHolder holder, int position) {
        holder.filterImage.setImageDrawable(context.getResources().getDrawable(drawableList.get(position)));
    }

    @Override
    public int getItemCount() {
        return drawableList.size();
    }

    class FilterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView filterImage;
        public FilterViewHolder(View itemView) {
            super(itemView);
            filterImage = itemView.findViewById(R.id.filter_image);
            filterImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.filter_image:
                    FaceTrackerActivity.addId(drawableList.get(getAdapterPosition()));
            }
        }
    }
}
