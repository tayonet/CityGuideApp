package com.example.cityguideapp.helperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {

    ArrayList<MostViewedClass> mostViewedClassList;

    public MostViewedAdapter(ArrayList<MostViewedClass> mostViewedClassList) {
        this.mostViewedClassList = mostViewedClassList;
    }

    @NonNull
    @Override
    public MostViewedAdapter.MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_template,parent,false);
        MostViewedAdapter.MostViewedViewHolder mostViewedViewHolder = new MostViewedAdapter.MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedAdapter.MostViewedViewHolder holder, int position) {
        MostViewedClass mostViewedClass = mostViewedClassList.get(position);
        holder.image.setImageResource(mostViewedClass.getImage());
        holder.title.setText(mostViewedClass.getTitle());
        holder.desc.setText(mostViewedClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostViewedClassList.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,desc;
        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            // create hooks
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);
        }



    }

}
