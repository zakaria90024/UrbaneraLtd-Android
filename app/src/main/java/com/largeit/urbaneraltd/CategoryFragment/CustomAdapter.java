package com.largeit.urbaneraltd.CategoryFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.largeit.urbaneraltd.HomeFragment.ViewHolder;
import com.largeit.urbaneraltd.ProductActivity.ProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.model.Category;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    //HomeFragment homeFragment;
    ProductActivity productActivity;

    CategoryActivity homeActivity;
    public List<Category> posts;

    public CustomAdapter(CategoryActivity homeActivity, List<Category> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.homeActivity = homeActivity;
        this.mContext = mContext;
    }

    public void setData(List<Category> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                Integer categoryID = posts.get(position).getCategoryID();
                //Intent to start activity
                String id = String.valueOf(categoryID);

                String categoryName = posts.get(position).getCategoryName();


                Intent intent = new Intent(homeActivity, ProductActivity.class);
                //put data in intent
                intent.putExtra("category_id", id);
                //start activity
                intent.putExtra("category_name", categoryName);


                homeActivity.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category post = posts.get(position);
        String dress_name = post.getCategoryName();
        String dress_image_url = post.getImage();

        //holder.productname.setText(dress_name);
        //holder.monako_detils.setText(monako_details);


        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/category/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(homeActivity)
                .load(imageUrl)
                .override(350, 350)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(holder.category_thum);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
