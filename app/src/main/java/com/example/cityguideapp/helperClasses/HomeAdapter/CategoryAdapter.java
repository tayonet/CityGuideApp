package com.example.cityguideapp.helperClasses.HomeAdapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguideapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<CategoryHelperClass> categoryList;


    public CategoryAdapter(ArrayList<CategoryHelperClass> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_template,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryHelperClass  categoryHelperClass = categoryList.get(position);
        holder.image.setImageResource(categoryHelperClass.getImage());
        holder.title.setText(categoryHelperClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return  categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cat_image);
            title = itemView.findViewById(R.id.cat_title);
        }
    }
}
