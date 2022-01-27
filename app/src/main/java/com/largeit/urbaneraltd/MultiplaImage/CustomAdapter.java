package com.largeit.urbaneraltd.MultiplaImage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.ProductActivity.ProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.model.MultipleImageModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    ProductActivity productActivity;
    MultipleImageFragment multipleImageFragment;
    //HomeActivity homeActivity;
    public List<MultipleImageModel> posts;

    public CustomAdapter(MultipleImageFragment multipleImageFragment, List<MultipleImageModel> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.multipleImageFragment = multipleImageFragment;
        this.mContext = mContext;
    }

    public void setData(List<MultipleImageModel> posts){
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

//
//                Integer categoryID = posts.get(position).getCategoryID();
//                //Intent to start activity
//                String id = String.valueOf(categoryID);
//
//                String categoryName = posts.get(position).getCategoryName();
//
//
//                Intent intent = new Intent(mContext, ProductActivity.class);
//                //put data in intent
//                intent.putExtra("category_id", id);
//                //start activity
//                intent.putExtra("category_name", categoryName);
//
//                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MultipleImageModel post = posts.get(position);

        String dress_image_url = post.getImage();

        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/multipleImage/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(mContext)
                .load(imageUrl)
                .override(350, 350)
                .centerCrop()
                //.placeholder(R.drawable.ic_spinner)
                .into(holder.category_thum);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
